#version 330

uniform sampler2D DiffuseSampler;

in vec2 texCoord;
in vec2 oneTexel;

uniform vec2 InSize;
uniform vec3 TintColor;
uniform float TintStrength;
uniform float Vignette;
uniform float Saturation;
uniform float Brightness;
uniform float Contrast;
uniform float BloomStrength;

out vec4 fragColor;

vec3 sampleBox(vec2 uv, float r) {
    vec3 acc = vec3(0.0);
    float total = 0.0;
    for (int x = -2; x <= 2; x++) {
        for (int y = -2; y <= 2; y++) {
            vec2 off = vec2(float(x), float(y)) * oneTexel * r;
            vec3 s = texture(DiffuseSampler, uv + off).rgb;
            float w = 1.0 - length(vec2(x, y)) * 0.2;
            w = max(w, 0.0);
            acc += s * w;
            total += w;
        }
    }
    return acc / max(total, 0.001);
}

void main() {
    vec3 col = texture(DiffuseSampler, texCoord).rgb;

    if (BloomStrength > 0.0) {
        vec3 blurred = sampleBox(texCoord, 3.5);
        vec3 highlights = max(blurred - vec3(0.55), vec3(0.0));
        col += highlights * BloomStrength * 1.4;
    }

    col *= Brightness;
    col = mix(vec3(0.5), col, Contrast);

    float luma = dot(col, vec3(0.2125, 0.7154, 0.0721));
    col = mix(vec3(luma), col, Saturation);

    col = mix(col, col * TintColor, TintStrength);

    vec2 c = texCoord - 0.5;
    float vdist = length(c);
    float vmask = 1.0 - smoothstep(0.35, 0.85, vdist) * Vignette;
    col *= vmask;

    fragColor = vec4(max(col, vec3(0.0)), 1.0);
}
