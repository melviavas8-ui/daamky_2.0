#version 150

// Adapted from "The Universe Within" by Martijn Steinrucken (BigWings) 2018.
// License: CC BY-NC-SA 3.0 Unported. https://www.shadertoy.com/
// Trimmed to GLSL 150 + masked composite (rendered only inside block bbox).
// NUM_LAYERS reduced + pulse softened to avoid frame-rate hit at close range.

in vec2 uv;
out vec4 outColor;

uniform sampler2D SceneTexture;
uniform sampler2D MaskTexture;
uniform vec2 InSize;
uniform float Time;
uniform float Intensity;
uniform vec3 TintColor;
uniform vec2 BlockCenter;

#define S(a, b, t) smoothstep(a, b, t)
#define NUM_LAYERS 2

float N21(vec2 p) {
    vec3 a = fract(vec3(p.xyx) * vec3(213.897, 653.453, 253.098));
    a += dot(a, a.yzx + 79.76);
    return fract((a.x + a.y) * a.z);
}

vec2 GetPos(vec2 id, vec2 offs, float t) {
    float n = N21(id + offs);
    float n1 = fract(n * 10.0);
    float n2 = fract(n * 100.0);
    float a = t + n;
    return offs + vec2(sin(a * n1), cos(a * n2)) * 0.4;
}

float dfLine(vec2 a, vec2 b, vec2 p) {
    vec2 pa = p - a;
    vec2 ba = b - a;
    float denom = max(dot(ba, ba), 1e-6);
    float h = clamp(dot(pa, ba) / denom, 0.0, 1.0);
    return length(pa - ba * h);
}

float lineSeg(vec2 a, vec2 b, vec2 p) {
    float d = dfLine(a, b, p);
    float d2 = length(a - b);
    float fade = S(1.5, 0.5, d2);
    fade += S(0.07, 0.02, abs(d2 - 0.75)) * 0.6;
    // Wide soft falloff instead of a sharp smoothstep edge — gives the line a glow.
    float core = exp(-d * 28.0);
    float halo = exp(-d * 9.0) * 0.45;
    return (core + halo) * fade;
}

float NetLayer(vec2 st, float n, float t) {
    vec2 id = floor(st) + n;
    st = fract(st) - 0.5;

    vec2 p[9];
    int idx = 0;
    for (int y = -1; y <= 1; y++) {
        for (int x = -1; x <= 1; x++) {
            p[idx] = GetPos(id, vec2(float(x), float(y)), t);
            idx++;
        }
    }

    float m = 0.0;
    float sparkle = 0.0;

    for (int i = 0; i < 9; i++) {
        m += lineSeg(p[4], p[i], st);
        float d = length(st - p[i]);
        // Gaussian-like falloff for nodes: soft glow instead of singular bright spots.
        float s = exp(-d * d * 60.0) * 0.45 + exp(-d * 6.0) * 0.18;
        s *= S(1.1, 0.6, d);
        float pulse = sin((fract(p[i].x) + fract(p[i].y) + t * 0.6) * 3.0) * 0.4 + 0.6;
        pulse = pulse * pulse;
        s *= pulse;
        sparkle += s;
    }

    m += lineSeg(p[1], p[3], st);
    m += lineSeg(p[1], p[5], st);
    m += lineSeg(p[7], p[5], st);
    m += lineSeg(p[7], p[3], st);

    float sPhase = (sin(t * 0.5 + n) + sin(t * 0.07)) * 0.2 + 0.5;
    m += sparkle * sPhase;

    return m;
}

void main() {
    vec4 scene = texture(SceneTexture, uv);
    float mask = texture(MaskTexture, uv).r;
    if (mask < 0.01) {
        outColor = scene;
        return;
    }

    // Outer "zoom" cycle and inner point motion use the same time scaling as the
    // original ShaderToy. Slowing inner time below that makes per-point motion so
    // small per frame that the eye perceives it as stutter instead of flow.
    float t = Time * 0.1;

    vec2 nuv = uv - BlockCenter;
    nuv.x *= InSize.x / max(InSize.y, 1.0);

    float sa = sin(t);
    float ca = cos(t);
    mat2 rot = mat2(ca, -sa, sa, ca);
    vec2 st = nuv * rot;

    float m = 0.0;
    float layers = float(NUM_LAYERS);
    for (int li = 0; li < NUM_LAYERS; li++) {
        float i = float(li) / layers;
        float z = fract(t + i);
        float size = mix(12.0, 1.5, z);
        float fade = S(0.0, 0.6, z) * S(1.0, 0.8, z);
        m += fade * NetLayer(st * size, i, Time);
    }

    float glow = -nuv.y * 1.2;

    vec3 baseCol = vec3(sa, cos(t * 0.4), -sin(t * 0.24)) * 0.3 + 0.65;
    baseCol = mix(baseCol, TintColor, 0.65);

    vec3 col = baseCol * m;
    col += baseCol * glow * 0.18;
    col *= 1.0 - dot(nuv, nuv) * 0.85;

    // Soft tonemap — saturates gracefully where lines cross instead of blowing out.
    vec3 effect = vec3(1.0) - exp(-col * Intensity * 0.55);
    float blend = clamp(mask * 0.92, 0.0, 1.0);
    vec3 mixed = mix(scene.rgb, scene.rgb + effect, blend);
    outColor = vec4(clamp(mixed, 0.0, 1.0), 1.0);
}
