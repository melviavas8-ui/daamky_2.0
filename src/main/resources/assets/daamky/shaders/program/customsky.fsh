#version 330

uniform sampler2D DiffuseSampler;
uniform sampler2D DepthSampler;

in vec2 texCoord;
in vec2 oneTexel;

uniform vec2 InSize;
uniform float Time;
uniform float SkyMix;
uniform vec3 SkyColor1;
uniform vec3 SkyColor2;
uniform float StarDensity;
uniform float StarBrightness;
uniform float NebulaDensity;
uniform float NebulaIntensity;
uniform vec3 NebulaColor;
uniform float CameraPitch;
uniform float CameraYaw;
uniform float Aurora;

out vec4 fragColor;

float hash(vec2 p) {
    return fract(sin(dot(p, vec2(127.1, 311.7))) * 43758.5453);
}

float hash3(vec3 p) {
    return fract(sin(dot(p, vec3(127.1, 311.7, 74.7))) * 43758.5453);
}

float noise(vec2 p) {
    vec2 i = floor(p);
    vec2 f = fract(p);
    f = f * f * (3.0 - 2.0 * f);
    return mix(
        mix(hash(i), hash(i + vec2(1.0, 0.0)), f.x),
        mix(hash(i + vec2(0.0, 1.0)), hash(i + vec2(1.0, 1.0)), f.x),
        f.y
    );
}

float fbm(vec2 p) {
    float v = 0.0;
    float a = 0.5;
    for (int i = 0; i < 5; i++) {
        v += a * noise(p);
        p *= 2.0;
        a *= 0.5;
    }
    return v;
}

float stars(vec2 uv, float density) {
    vec2 cell = floor(uv * density);
    vec2 sub = fract(uv * density);
    float h = hash(cell);
    if (h > 0.97) {
        vec2 center = vec2(hash(cell + 0.1), hash(cell + 0.2));
        float d = length(sub - center);
        float twinkle = 0.5 + 0.5 * sin(Time * (2.0 + h * 4.0) + h * 100.0);
        float brightness = smoothstep(0.05, 0.0, d) * twinkle;
        float colorShift = hash(cell + 0.5);
        return brightness * (0.7 + 0.3 * colorShift);
    }
    return 0.0;
}

vec3 nebula(vec2 uv, float density, float intensity) {
    vec2 p = uv * density;
    float n1 = fbm(p + Time * 0.02);
    float n2 = fbm(p * 1.5 + vec2(Time * 0.015, -Time * 0.01));
    float n3 = fbm(p * 0.8 - vec2(Time * 0.01, Time * 0.02));
    float shape = smoothstep(0.3, 0.7, n1) * smoothstep(0.2, 0.6, n2);
    vec3 col = NebulaColor * shape * intensity;
    col += vec3(0.1, 0.05, 0.2) * n3 * intensity * 0.5;
    return col;
}

vec3 aurora(vec2 uv) {
    float wave = 0.0;
    for (int i = 0; i < 3; i++) {
        float fi = float(i);
        float freq = 2.0 + fi * 1.5;
        float speed = 0.3 + fi * 0.1;
        wave += sin(uv.x * freq + Time * speed + fi * 1.7) * (0.02 / (1.0 + fi * 0.5));
    }
    float band = smoothstep(0.02, 0.0, abs(uv.y - 0.7 - wave));
    float shimmer = 0.7 + 0.3 * sin(uv.x * 10.0 + Time * 2.0);
    vec3 auroraColor = mix(vec3(0.1, 0.8, 0.4), vec3(0.2, 0.4, 0.9), sin(uv.x * 3.0 + Time * 0.5) * 0.5 + 0.5);
    return auroraColor * band * shimmer;
}

void main() {
    vec4 original = texture(DiffuseSampler, texCoord);
    float depth = texture(DepthSampler, texCoord).r;

    if (depth > 0.0001) {
        fragColor = original;
        return;
    }

    float pitchNorm = CameraPitch / 90.0;
    vec2 skyUV = texCoord;
    skyUV.x += CameraYaw / 360.0;
    skyUV.y -= pitchNorm * 0.3;

    vec3 gradient = mix(SkyColor1, SkyColor2, smoothstep(0.0, 0.8, skyUV.y));

    float starLayer1 = stars(skyUV, StarDensity);
    float starLayer2 = stars(skyUV + vec2(0.37, 0.71), StarDensity * 0.7);
    float starLayer3 = stars(skyUV * 1.5 + vec2(0.13, 0.53), StarDensity * 1.3);
    float totalStars = (starLayer1 + starLayer2 * 0.7 + starLayer3 * 0.5) * StarBrightness;

    vec3 nebulaCol = nebula(skyUV, NebulaDensity, NebulaIntensity);

    vec3 auroraCol = Aurora > 0.01 ? aurora(skyUV) * Aurora : vec3(0.0);

    vec3 sky = gradient + vec3(totalStars) + nebulaCol + auroraCol;

    vec3 result = mix(original.rgb, sky, SkyMix);
    fragColor = vec4(result, original.a);
}
