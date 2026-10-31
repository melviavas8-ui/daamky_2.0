#version 150

in vec2 uv;
out vec4 outColor;

uniform sampler2D TrailTexture;
uniform sampler2D GlowTexture;
uniform sampler2D HandTexture;
uniform vec2 TexelSize;
uniform float Decay;
uniform float FlameHeight;
uniform float FlowSpeed;
uniform float Time;
uniform vec3 FireColor;
uniform float ColorMix;

float hash12(vec2 p) {
    vec3 p3 = fract(vec3(p.xyx) * 0.1031);
    p3 += dot(p3, p3.yzx + 33.33);
    return fract((p3.x + p3.y) * p3.z);
}

float noise(vec2 p) {
    vec2 i = floor(p);
    vec2 f = fract(p);
    vec2 u = f * f * (3.0 - 2.0 * f);
    return mix(
        mix(hash12(i), hash12(i + vec2(1.0, 0.0)), u.x),
        mix(hash12(i + vec2(0.0, 1.0)), hash12(i + vec2(1.0, 1.0)), u.x),
        u.y
    );
}

vec4 sampleTrail(vec2 coord) {
    return texture(TrailTexture, coord);
}

void main() {
    float flowTime = Time * FlowSpeed;
    float curlA = noise(uv * vec2(4.8, 7.2) + vec2(flowTime * 0.18, -flowTime * 0.28));
    float curlB = noise(uv * vec2(10.0, 13.0) + vec2(-flowTime * 0.22, flowTime * 0.16));
    float angle = (curlA * 2.0 - 1.0) * 2.15 + sin((uv.y + curlB) * 12.0 + flowTime * 1.7) * 0.74;
    float lift = mix(0.42, 1.28, clamp(FlameHeight / 56.0, 0.0, 1.0));
    vec2 flow = vec2(cos(angle) * 0.86, -lift + sin(angle) * 0.42) * TexelSize * FlowSpeed;

    vec4 previous = sampleTrail(uv + flow) * 0.58;
    previous += sampleTrail(uv + flow + vec2(TexelSize.x, 0.0) * 1.35) * 0.12;
    previous += sampleTrail(uv + flow - vec2(TexelSize.x, 0.0) * 1.35) * 0.12;
    previous += sampleTrail(uv + flow + vec2(0.0, TexelSize.y) * 1.15) * 0.09;
    previous += sampleTrail(uv + flow - vec2(0.0, TexelSize.y) * 1.15) * 0.09;
    previous.rgb *= Decay;
    previous.a *= Decay;

    vec4 glow = texture(GlowTexture, uv);
    vec4 hand = texture(HandTexture, uv);
    float handMask = clamp(hand.a, 0.0, 1.0);
    float outsideMask = 1.0 - smoothstep(0.02, 0.24, handMask);

    float broken = noise(uv * vec2(16.0, 25.0) + vec2(flowTime * 0.35, -flowTime * 0.82));
    float ribbon = sin((uv.x - uv.y * 0.34) * 34.0 + flowTime * 4.2 + curlA * 5.5) * 0.5 + 0.5;
    float curlCut = smoothstep(0.20, 0.90, broken) * 0.55 + smoothstep(0.34, 0.98, ribbon) * 0.45;
    float flameAlpha = glow.a * outsideMask * (0.28 + curlCut * 0.42);
    float textureAlpha = handMask * (0.42 + glow.a * 0.18);
    vec3 handTinted = mix(hand.rgb, FireColor, clamp(ColorMix, 0.0, 1.0));
    vec3 sourceRgb = handTinted * textureAlpha + glow.rgb * flameAlpha;
    float sourceAlpha = clamp(max(textureAlpha, flameAlpha), 0.0, 0.74);

    float outAlpha = 1.0 - (1.0 - previous.a) * (1.0 - clamp(sourceAlpha, 0.0, 0.68));
    vec3 outRgb = previous.rgb + sourceRgb * (1.0 - previous.a * 0.38);
    outColor = vec4(clamp(outRgb, 0.0, 1.0), clamp(outAlpha, 0.0, 0.88));
}
