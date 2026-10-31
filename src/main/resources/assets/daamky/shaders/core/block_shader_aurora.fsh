#version 150

// Adapted "Universe Within" remix — finer thin-line variant.
// Same author lineage as block_shader.fsh, different N21 / GetPos / fade parameters.

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
#define NUM_LAYERS 4

float N21(vec2 p) {
    vec3 a = fract(vec3(p.xyx) * vec3(613.897, 553.453, 80.098));
    a += dot(a, a.yzx + 88.76);
    return fract((a.x + a.y) * a.z);
}

vec2 GetPos(vec2 id, vec2 offs, float t) {
    float n = N21(id + offs);
    float n1 = fract(n * 0.7);
    float n2 = fract(n * 79.7);
    float a = t + n;
    return offs + vec2(sin(a * n1), cos(a * n2)) * 0.5;
}

float dfLine(vec2 a, vec2 b, vec2 p) {
    vec2 pa = p - a;
    vec2 ba = b - a;
    float denom = max(dot(ba, ba), 1e-6);
    float h = clamp(dot(pa, ba) / denom, 0.0, 1.0);
    return length(pa - ba * h);
}

float lineSeg(vec2 a, vec2 b, vec2 p) {
    float r1 = 0.005;
    float r2 = 0.0001;
    float d = dfLine(a, b, p);
    float d2 = length(a - b);
    float fade = S(0.005, 0.05, d2);
    fade += S(0.0005, 0.0002, abs(d2 - 0.025));
    return S(r1, r2, d) * fade;
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
        float s = 0.002 / max(d * d, 1e-6);
        s *= S(1.0, 0.1, d);
        float pulse = sin((fract(p[i].x) + fract(p[i].y) + t) * 5.0) * 0.4 + 0.6;
        pulse = pow(pulse, 20.0);
        s *= pulse;
        sparkle += s;
    }

    m += lineSeg(p[1], p[3], st);
    m += lineSeg(p[1], p[5], st);
    m += lineSeg(p[7], p[5], st);
    m += lineSeg(p[7], p[3], st);

    float sPhase = (sin(t + n) + sin(t * 0.1)) * 0.25 + 0.5;
    sPhase += pow(sin(t * 0.1) * 0.5 + 0.5, 50.0) * 5.0;
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

    vec2 nuv = uv - BlockCenter;
    nuv.x *= InSize.x / max(InSize.y, 1.0);

    float t = Time * 0.0005;
    float sa = sin(t);
    float ca = cos(t);
    mat2 rot = mat2(ca, -sa, sa, ca);
    vec2 st = nuv * rot;

    float m = 0.0;
    float layers = float(NUM_LAYERS);
    for (int li = 0; li < NUM_LAYERS; li++) {
        float i = float(li) / layers;
        float z = fract(t + i);
        float size = mix(15.0, 0.0, z);
        float fade = S(0.0, 0.006, z) * S(0.0, 0.08, z);
        m += fade * NetLayer(st * size, i, Time);
    }

    float glow = -nuv.y * 2.0;

    vec3 baseCol = vec3(sa, cos(t * 0.1), -sin(t * 0.14)) * 0.1 + 0.1;
    baseCol = mix(baseCol, TintColor, 0.6);

    vec3 col = baseCol * m;
    col += baseCol * glow * 0.3;
    col *= 1.0 - dot(nuv, nuv);

    vec3 effect = vec3(1.0) - exp(-col * Intensity * 0.7);
    float blend = clamp(mask * 0.92, 0.0, 1.0);
    vec3 mixed = mix(scene.rgb, scene.rgb + effect * 1.6, blend);
    outColor = vec4(clamp(mixed, 0.0, 1.0), 1.0);
}
