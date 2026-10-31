#version 150

in vec2 NdcCoord;
out vec4 fragColor;

uniform mat4 ModelViewMat;
uniform mat4 ProjMat;
uniform float Time;
uniform float CloudIntensity;
uniform vec3 SkyColor1;
uniform vec3 SkyColor2;
uniform vec3 NebulaColor1;
uniform vec3 NebulaColor2;
uniform vec3 SunColor;
uniform float SunSize;

#define PI 3.14159265359

float hash21(vec2 p) {
    vec3 p3 = fract(vec3(p.xyx) * vec3(0.1031, 0.1030, 0.0973));
    p3 += dot(p3, p3.yzx + 33.33);
    return fract((p3.x + p3.y) * p3.z);
}

float noise2d(vec2 p) {
    vec2 i = floor(p);
    vec2 f = fract(p);
    f = f * f * (3.0 - 2.0 * f);
    float a = hash21(i);
    float b = hash21(i + vec2(1.0, 0.0));
    float c = hash21(i + vec2(0.0, 1.0));
    float d = hash21(i + vec2(1.0, 1.0));
    return mix(mix(a, b, f.x), mix(c, d, f.x), f.y);
}

float fbm(vec2 p) {
    float v = 0.0;
    float a = 0.5;
    float total = 0.0;
    for (int i = 0; i < 4; i++) {
        v += a * noise2d(p);
        total += a;
        a *= 0.5;
        p *= 2.0;
        p += vec2(3.14, 2.72);
    }
    return v / total;
}

vec3 auroraTint(float t) {
    vec3 a = NebulaColor1 * 0.6;
    vec3 b = NebulaColor2 * 0.6;
    vec3 c = vec3(0.8, 1.0, 1.0);
    vec3 d = vec3(0.0, 0.2, 0.3);
    return max(a + b * cos(2.0 * PI * (c * t + d)), vec3(0.1));
}

vec3 directionFromNdc(vec2 ndc) {
    mat4 invVP = inverse(ProjMat * ModelViewMat);
    vec4 wp = invVP * vec4(ndc.x, ndc.y, 1.0, 1.0);
    return normalize(wp.xyz / wp.w);
}

void main() {
    vec3 rd = directionFromNdc(NdcCoord);

    float skyT = smoothstep(-0.05, 0.55, rd.y);
    vec3 col = mix(SkyColor2, SkyColor1, skyT);

    float angle = atan(rd.z, rd.x);
    float v = rd.y;

    if (v > -0.05) {
        vec3 aurora = vec3(0.0);
        for (int i = 0; i < 4; i++) {
            float fi = float(i);
            float speed = 0.05 + fi * 0.02;
            float freq = 2.5 + fi * 0.75;
            float intensity = 0.5 / (fi + 1.0) + 0.2;

            float a = angle + Time * speed;
            vec2 noiseIn = vec2(cos(a) * freq, sin(a) * freq);
            float curtain = pow(fbm(noiseIn + vec2(0.0, Time * 0.15)), 1.1);

            float bandY = 0.15 + fi * 0.05;
            float vd = v - bandY - curtain * 0.18;
            float shape = pow(max(0.0, 1.0 - abs(vd) * 4.5), 1.5 + fi * 0.4);
            shape *= smoothstep(0.0, 0.2, curtain);
            shape *= smoothstep(-0.02, 0.05, v);

            vec3 ac = auroraTint(fi / 4.0 + curtain * 0.2 + Time * 0.05);
            aurora += shape * ac * intensity;
        }
        col += aurora * CloudIntensity * 1.4;

        vec3 horizonGlow = vec3(0.0);
        for (float gi = 1.0; gi < 3.0; gi++) {
            float gr = pow(max(0.0, 0.35 - abs(v - 0.05 * gi)), 2.2);
            horizonGlow += gr * auroraTint(Time * 0.1) * 0.5;
        }
        col += horizonGlow * CloudIntensity;
    }

    vec3 sundir = vec3(1.0, 0.4, 0.0);
    float sun = clamp(dot(sundir, rd), 0.0, 2.0);
    float horizonMask = 1.0 - smoothstep(0.0, 0.45, rd.y);
    float sunExp = max(1.0, 21.0 / max(SunSize, 0.1));
    col += 0.43 * SunColor * pow(sun, sunExp) * (0.4 + 0.6 * horizonMask);
    col += 0.30 * NebulaColor1 * sun * horizonMask * 0.5;

    const float CONTRAST = 1.1;
    const float SATURATION = 1.15;
    col = mix(vec3(0.5), mix(vec3(dot(vec3(0.2125, 0.7154, 0.0721), col)), col, SATURATION), CONTRAST);

    fragColor = vec4(max(col, vec3(0.0)), 1.0);
}
