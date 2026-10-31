#version 330

uniform sampler2D DiffuseSampler;

in vec2 texCoord;
in vec2 oneTexel;

uniform vec2 InSize;
uniform float Time;
uniform float AberrationAmount;
uniform float AberrationFalloff;
uniform vec2 MotionVelocity;
uniform float MotionAmount;
uniform float BloomThreshold;
uniform float BloomIntensity;
uniform float BloomRadius;
uniform float VignetteAmount;

out vec4 fragColor;

void main() {
    vec2 uv = texCoord;
    vec2 center = vec2(0.5, 0.5);
    vec2 toCenter = uv - center;
    float dist = length(toCenter);

    float aberrationStrength = AberrationAmount * pow(dist * 1.4142, AberrationFalloff);
    vec2 aberrationDir = (dist > 0.0001) ? (toCenter / dist) : vec2(0.0);

    vec2 motion = MotionVelocity * MotionAmount * 0.012;

    vec3 col;
    col.r = texture(DiffuseSampler, uv + aberrationDir * aberrationStrength + motion).r;
    col.g = texture(DiffuseSampler, uv + motion * 0.5).g;
    col.b = texture(DiffuseSampler, uv - aberrationDir * aberrationStrength - motion).b;

    if (BloomIntensity > 0.001) {
        vec3 bloom = vec3(0.0);
        float total = 0.0;
        for (float x = -2.0; x <= 2.0; x += 1.0) {
            for (float y = -2.0; y <= 2.0; y += 1.0) {
                vec2 off = vec2(x, y) * BloomRadius / InSize;
                vec3 s = texture(DiffuseSampler, uv + off).rgb;
                float lum = max(max(s.r, s.g), s.b);
                if (lum > BloomThreshold) {
                    float w = (lum - BloomThreshold) / (1.0 - BloomThreshold + 0.001);
                    bloom += s * w;
                }
                total += 1.0;
            }
        }
        bloom /= total;
        col += bloom * BloomIntensity;
    }

    if (VignetteAmount > 0.001) {
        float v = 1.0 - smoothstep(0.3, 0.85, dist) * VignetteAmount;
        col *= clamp(v, 0.0, 1.0);
    }

    fragColor = vec4(col, 1.0);
}
