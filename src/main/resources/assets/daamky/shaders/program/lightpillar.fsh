#version 330

uniform sampler2D DiffuseSampler;

in vec2 texCoord;
in vec2 oneTexel;

uniform vec2 InSize;
uniform float Time;
uniform vec3 TopColor;
uniform vec3 BottomColor;
uniform float Intensity;
uniform float GlowAmount;
uniform float PillarWidth;
uniform float PillarHeight;
uniform float NoiseIntensity;
uniform float RotationSpeed;
uniform float Opacity;
uniform float PillarRotation;
uniform vec2 PillarOffset;

out vec4 fragColor;

const int maxiter = 80;
const int waveiter = 4;
const float stepmult = 1.0;

mat2 rot2d(float a) {
    float c = cos(a);
    float s = sin(a);
    return mat2(c, s, -s, c);
}

void main() {
    vec2 uv = (texCoord * 2.0 - 1.0) * vec2(InSize.x / InSize.y, 1.0);
    float pillarrotrad = PillarRotation * 0.01745329;
    uv = rot2d(pillarrotrad) * uv;
    uv += PillarOffset;

    vec3 ro = vec3(0.0, 0.0, -10.0);
    vec3 rd = normalize(vec3(uv, 1.0));

    float t = Time * RotationSpeed;
    float rotc = cos(t * 0.3);
    float rots = sin(t * 0.3);
    float wavec = cos(0.4);
    float waves = sin(0.4);

    vec3 col = vec3(0.0);
    float rayt = 0.1;

    for (int i = 0; i < maxiter; i++) {
        vec3 p = ro + rd * rayt;
        p.xz = vec2(rotc * p.x - rots * p.z, rots * p.x + rotc * p.z);

        vec3 q = p;
        q.y = p.y * PillarHeight + Time;

        float freq = 1.0;
        float amp = 1.0;
        for (int j = 0; j < waveiter; j++) {
            q.xz = vec2(wavec * q.x - waves * q.z, waves * q.x + wavec * q.z);
            q += cos(q.zxy * freq - Time * float(j) * 2.0) * amp;
            freq *= 2.0;
            amp *= 0.5;
        }

        float d = length(cos(q.xz)) - 0.2;
        float bound = length(p.xz) - PillarWidth;
        float k = 4.0;
        float h = max(k - abs(d - bound), 0.0);
        d = max(d, bound) + h * h * 0.0625 / k;
        d = abs(d) * 0.15 + 0.01;

        float grad = clamp((15.0 - p.y) / 30.0, 0.0, 1.0);
        col += mix(BottomColor, TopColor, grad) / d;

        rayt += d * stepmult;
        if (rayt > 50.0) break;
    }

    float widthnorm = PillarWidth / 3.0;
    col = tanh(col * GlowAmount / widthnorm);

    float noise = fract(sin(dot(gl_FragCoord.xy, vec2(12.9898, 78.233))) * 43758.5453);
    col -= noise / 15.0 * NoiseIntensity;

    col *= Intensity;

    vec4 original = texture(DiffuseSampler, texCoord);
    vec3 pillarcolor = max(col, vec3(0.0));

    vec3 blended = original.rgb + pillarcolor * Opacity;

    fragColor = vec4(blended, 1.0);
}
