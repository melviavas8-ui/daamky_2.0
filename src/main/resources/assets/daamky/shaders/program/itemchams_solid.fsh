#version 330

#define Width 1
#define MaxSample 3.0
#define Divider 2.5

uniform sampler2D DiffuseSampler;

in vec2 texCoord;
in vec2 oneTexel;

uniform int shapeMode;
uniform float fillOpacity;

uniform int glintEnabled;
uniform float glintSpeed;
uniform float glintScale;
uniform float glintStrength;
uniform int glintCount;
uniform float Time;

out vec4 color;

vec2 ridged(vec2 p, vec2 v) {
    float a = dot(p - vec2(1.0, -0.5), v) * glintScale;
    a = mod(a + 1.5707963, 3.1415927) - 1.5707963;
    // mod wraps a into (-pi/2, pi/2); clamp guards the thin band where
    // floating-point inexactness near the endpoints can still hit a tan asymptote.
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

void main() {
    vec4 originalCenter = texture(DiffuseSampler, texCoord);

    if (originalCenter.a != 0.0) {
        if (shapeMode == 1) discard;

        // Apply warp ONLY inside the original silhouette
        vec2 q = texCoord + computeGlintWarp(texCoord);
        vec4 center = texture(DiffuseSampler, q);

        // If warp pulled us off the silhouette, discard — creates wormy holes
        // within the silhouette but never lets the effect bleed onto screen
        if (center.a == 0.0) discard;

        color = vec4(center.rgb, center.a * fillOpacity);
    } else {
        // Outside silhouette: original rim logic with NO warp
        if (shapeMode == 0) discard;

        float alpha = 0.0;
        vec4 sampledColor = vec4(0.0);

        for (int x = -Width; x <= Width; ++x) {
            for (int y = -Width; y <= Width; ++y) {
                vec2 offset = vec2(x, y) * oneTexel;
                vec4 sample = texture(DiffuseSampler, texCoord + offset);

                if (sample.a != 0.0) {
                    sampledColor = sample;
                    float dist = distance(vec2(x, y), vec2(0));
                    alpha += max(0.0, (MaxSample - dist) / Divider);
                }
            }
        }

        alpha = pow(alpha, 1.1);
        color = vec4(sampledColor.rgb, alpha);
    }
}
