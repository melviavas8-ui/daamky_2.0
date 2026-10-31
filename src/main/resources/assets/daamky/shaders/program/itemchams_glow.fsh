#version 330 core

in vec2 texCoord;
in vec2 oneTexel;

uniform sampler2D DiffuseSampler;

uniform int shapeMode;
uniform int glowStrength;
uniform float glowMultiplier;
uniform int glowQuality;
uniform float fillOpacity;

uniform int glintEnabled;
uniform float glintSpeed;
uniform float glintScale;
uniform float glintStrength;
uniform int glintCount;
uniform int optimize;
uniform float Time;

out vec4 color;

struct BlurResult {
    float strength;
    vec3 color;
};

vec2 ridged(vec2 p, vec2 v) {
    float a = dot(p - vec2(1.0, -0.5), v) * glintScale;
    a = mod(a + 1.5707963, 3.1415927) - 1.5707963;
    return v * tan(clamp(a, -1.5, 1.5)) * glintStrength;
}

vec2 computeGlintWarp(vec2 p) {
    if (glintEnabled == 0) return vec2(0.0);
    int k = clamp(glintCount, 1, 5);
    vec2 s = vec2(0.0);
    float t = Time * glintSpeed / float(k);
    for (int i = 0; i < 5; i++) {
        if (i >= k) break;
        s += ridged(p, vec2(cos(t), sin(t)));
        t += 3.1415927 / float(k);
    }
    return clamp(s, vec2(-0.5), vec2(0.5));
}

// Coarse 5x5 proximity check — bails out before the heavy blur loop for pixels
// with no silhouette anywhere within the halo radius. 25 samples vs ~169 saves
// ~85% of the work for the typical case where most of the screen is empty.
bool hasSilhouetteNearby(vec2 q, float radius) {
    float step = radius * 0.5;
    for (float x = -radius; x <= radius; x += step) {
        for (float y = -radius; y <= radius; y += step) {
            if (texture(DiffuseSampler, q + oneTexel * vec2(x, y)).a > 0.0) {
                return true;
            }
        }
    }
    return false;
}

// 8-sample ring edge detection — replaces full blur for inside-silhouette
// pixels. The mix factor only needs to know "how close to the edge are we",
// which doesn't require per-pixel sampling of the entire halo region.
float cheapEdge(vec2 q, float radius) {
    float sum = 0.0;
    for (int i = 0; i < 8; i++) {
        float a = float(i) * 0.7853981;
        sum += texture(DiffuseSampler, q + oneTexel * vec2(cos(a), sin(a)) * radius).a;
    }
    return sum / 8.0;
}

BlurResult computeBlur(vec2 q) {
    int w = glowQuality * glowStrength;
    float alphaSum = 0.0;
    vec3 rgbSum = vec3(0.0);

    float stepSize = float(glowQuality);
    float wFloat = float(w);

    for (float x = -wFloat; x <= wFloat; x += stepSize) {
        for (float y = -wFloat; y <= wFloat; y += stepSize) {
            vec2 offset = oneTexel * vec2(x, y);
            vec4 sample = texture(DiffuseSampler, q + offset);
            float a = sample.a;

            alphaSum += a;
            rgbSum += sample.rgb * a;
        }
    }

    float normalization = float(((glowStrength * glowStrength) + glowStrength) * 4);
    float blurStrength = clamp(alphaSum / normalization, 0.0, 1.0) * glowMultiplier;

    vec3 blurColor = (alphaSum > 0.0) ? (rgbSum / alphaSum) : vec3(0.0);

    return BlurResult(blurStrength, blurColor);
}

void main() {
    vec4 originalCenter = texture(DiffuseSampler, texCoord);

    if (originalCenter.a > 0.0) {
        if (shapeMode == 1) discard;

        vec2 q = texCoord + computeGlintWarp(texCoord);
        vec4 center = texture(DiffuseSampler, q);

        if (center.a == 0.0) discard;

        vec4 finalColor = vec4(center.rgb, center.a * fillOpacity);

        if (glowStrength > 0 && glowMultiplier > 0.0) {
            float blurStrength;
            if (optimize == 1) {
                float edge = cheapEdge(q, float(glowStrength));
                blurStrength = clamp(edge, 0.0, 1.0) * glowMultiplier;
            } else {
                BlurResult blur = computeBlur(q);
                blurStrength = blur.strength;
            }
            finalColor = mix(finalColor, vec4(center.rgb, 1.0), glowMultiplier - blurStrength);
        }

        color = finalColor;
    } else {
        if (shapeMode == 0 || glowStrength == 0) discard;

        for (int dx = -1; dx <= 1; ++dx) {
            for (int dy = -1; dy <= 1; ++dy) {
                if (dx == 0 && dy == 0) continue;
                vec4 neighbor = texture(DiffuseSampler, texCoord + oneTexel * vec2(dx, dy));
                if (neighbor.a > 0.0) {
                    color = vec4(neighbor.rgb, 1.0);
                    return;
                }
            }
        }

        if (optimize == 1) {
            float wFloat = float(glowQuality * glowStrength);
            if (!hasSilhouetteNearby(texCoord, wFloat)) discard;
        }

        BlurResult blur = computeBlur(texCoord);
        if (blur.strength == 0.0) discard;

        color = vec4(blur.color, blur.strength);
    }
}
