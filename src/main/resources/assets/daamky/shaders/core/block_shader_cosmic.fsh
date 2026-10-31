#version 150

// Cosmic volsteps fractal + oil noise + star spiral + holes burst.
// Adapted from a ShaderToy collage; heavy per-pixel cost, mitigated by the bbox mask.

in vec2 uv;
out vec4 outColor;

uniform sampler2D SceneTexture;
uniform sampler2D MaskTexture;
uniform vec2 InSize;
uniform float Time;
uniform float Intensity;
uniform vec3 TintColor;
uniform vec2 BlockCenter;

#define iterations 13
#define formuparam 0.53
#define volsteps 20
#define stepsize 0.1
#define zoom 0.800
#define tile 0.850
#define brightness 0.0015
#define darkmatter 0.300
#define distfading 0.730
#define saturation 0.850

#define PI 3.141592
#define TWOPI 6.283184

mat2 rotMat(float r) {
    float c = cos(r);
    float s = sin(r);
    return mat2(c, -s, s, c);
}

float abs1d(float x) { return abs(fract(x) - 0.5); }
vec2 abs2d(vec2 v) { return abs(fract(v) - 0.5); }
float sin1d(float p) { return sin(p * TWOPI) * 0.25 + 0.25; }

#define OC 15
vec3 Oilnoise(vec2 pos, vec3 RGB) {
    vec2 q = vec2(0.0);
    float result = 0.0;
    float s = 2.2;
    float gain = 0.44;
    vec2 aPos = abs2d(pos) * 0.5;

    for (int i = 0; i < OC; i++) {
        pos *= rotMat(0.5236);
        float t = (sin(Time) * 0.5 + 0.5) * 0.2 + Time * 0.8;
        q = pos * s + aPos + t;
        q = vec2(cos(q));
        result += sin1d(dot(q, vec2(0.3))) * gain;
        s *= 1.07;
        aPos += cos(smoothstep(0.0, 0.15, q));
        aPos *= rotMat(0.0873);
        aPos *= 1.232;
    }

    result = pow(max(result, 1e-4), 4.504);
    float denom = max(abs1d(dot(q, vec2(-0.240, 0.000))), 1e-4);
    return clamp(RGB / denom * 0.5 / max(result, 1e-4), vec3(0.0), vec3(1.0));
}

float easeFade(float x) {
    float u = 2.0 * x - 1.0;
    return 1.0 - u * u * u * u;
}

float holeFade(float t, float life, float lo) {
    return easeFade(mod(t - lo, life) / life);
}

vec2 getPos(float t, float life, float offset, float lo) {
    return vec2(cos(offset + floor((t - lo) / life) * life) * InSize.x * 0.5,
                sin(2.0 * offset + floor((t - lo) / life) * life) * InSize.y * 0.5);
}

vec4 volstepsFractal(vec2 fragCoord, vec3 ro, vec3 rd) {
    vec3 dir = rd;
    vec3 from = ro;
    float s = 0.1;
    float fade = 1.0;
    vec3 v = vec3(0.0);
    for (int r = 0; r < volsteps; r++) {
        vec3 p = from + s * dir * 0.5;
        p = abs(vec3(tile) - mod(p, vec3(tile * 2.0)));
        float pa = 0.0;
        float a = 0.0;
        for (int i = 0; i < iterations; i++) {
            p = abs(p) / dot(p, p) - formuparam;
            float ct = cos(Time * 0.01);
            float st2 = sin(Time * 0.01);
            p.xy *= mat2(ct, st2, -st2, ct);
            a += abs(length(p) - pa);
            pa = length(p);
        }
        float dm = max(0.0, darkmatter - a * a * 0.001);
        a *= a * a;
        if (r > 6) fade *= 1.3 - dm;
        v += vec3(fade);
        v += vec3(s, s * s, s * s * s * s) * a * brightness * fade;
        fade *= distfading;
        s += stepsize;
    }
    v = mix(vec3(length(v)), v, saturation);
    return vec4(v * 0.01, 1.0);
}

void main() {
    vec4 scene = texture(SceneTexture, uv);
    float mask = texture(MaskTexture, uv).r;
    if (mask < 0.01) {
        outColor = scene;
        return;
    }

    vec2 fragCoord = uv * InSize;
    float aspect = InSize.x / max(InSize.y, 1.0);

    // Oil noise sample on aspect-corrected st coordinate
    vec2 st = uv;
    st.x = ((st.x - 0.5) * aspect) + 0.5;
    st *= 3.0;
    vec3 oilCol = Oilnoise(st, TintColor);

    // Centered, height-normalized uv for volsteps direction
    vec2 nuv = (fragCoord - InSize * BlockCenter) / max(InSize.y, 1.0);

    // Star spiral accumulator
    vec2 v = InSize;
    vec2 u = 0.2 * (fragCoord + fragCoord - v) / max(v.y, 1.0);
    vec2 k = u;
    vec2 w = u;
    vec4 o = vec4(1.0, 2.0, 3.0, 0.0);
    float t2 = Time * 0.21;
    float a = 0.5;
    for (int j = 1; j < 19; j++) {
        float fi = float(j);
        t2 += 1.0;
        a += 0.03;
        v = cos(t2 - 7.0 * u * pow(a, fi)) - 5.0 * u;
        vec4 trig = cos(vec4(fi + t2 * 0.02) - vec4(0.0, 11.0, 33.0, 0.0));
        u *= mat2(trig.x, trig.y, trig.z, trig.w);
        float dotOO = dot(o, o);
        u += 0.005 * tanh(40.0 * dot(u, u) * cos(100.0 * u.yx + t2))
           + 0.2 * a * u
           + 0.003 * vec2(cos(t2 + 4.0 * exp(-0.01 * dotOO)));
        w = u / (1.0 - 2.0 * dot(u, u));
        float lenArg = length((1.0 + fi * dot(v, v)) * sin(w * 3.0 - 9.0 * u.yx + t2));
        o += (1.0 + cos(vec4(0.0, 1.0, 3.0, 0.0) + t2)) / max(lenArg, 1e-4);
    }
    o = 1.0 - sqrt(exp(-o * o * o / 200.0));
    o = pow(max(o, vec4(0.0)), vec4(0.3));
    k -= u;
    o -= dot(k, k) / 250.0;

    // Hole burst layer
    vec2 coord = fragCoord * 2.0 - InSize;
    float holeSize = max(InSize.y / 10.0, 1.0);
    float holeLife = 2.0;
    vec3 finalCol = vec3(0.0);
    for (int i = 0; i < 45; i++) {
        float fi = float(i);
        vec3 holeCol = 0.5 + 0.5 * cos(Time + nuv.xyx + vec3(fi, 2.0 * fi + 4.0, 4.0 * fi + 16.0));
        float lifeOffset = fi * 0.5;
        vec2 pos = getPos(Time, holeLife, fi * 4.5, lifeOffset);
        float d = distance(coord, pos) / holeSize;
        d = 1.0 / max(d, 1e-3) - 0.1;
        finalCol += mix(vec3(0.0), holeCol, d) * holeFade(Time, holeLife, lifeOffset);
    }

    // Volsteps fractal as the dominant base
    vec3 dir = vec3(nuv * zoom, 1.0);
    vec3 ro = vec3(1.0, 0.5, 0.5);
    vec4 vrCol = volstepsFractal(fragCoord, ro, dir);

    vec4 combined = vrCol * vec4(finalCol * vec3(0.4, 1.0, 1.0) + o.xyz, 1.0);
    vec3 effect = combined.rgb + oilCol * 0.0; // oilCol intentionally muted; included so it's not stripped by optimizer
    effect = vec3(1.0) - exp(-effect * Intensity * 0.55);
    float blend = clamp(mask * 0.92, 0.0, 1.0);
    vec3 mixed = mix(scene.rgb, scene.rgb + effect * 1.4, blend);
    outColor = vec4(clamp(mixed, 0.0, 1.0), 1.0);
}
