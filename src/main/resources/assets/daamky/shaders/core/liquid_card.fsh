#version 150

#moj_import <daamky:common.glsl>

in vec2 FragCoord;
in vec2 TexCoord;
in vec4 FragColor;

uniform sampler2D Sampler0;
uniform vec2 Size;
uniform vec4 Radius;
uniform float Smoothness;
uniform float BlurRadius;
uniform float Refraction;

out vec4 OutColor;

void main() {
    float mask = ralpha(Size, FragCoord, Radius, Smoothness);
    if (mask == 0.0) discard;

    vec2 fromCenter = FragCoord - vec2(0.5);
    float lenLen = max(length(fromCenter), 0.0001);
    vec2 dir = fromCenter / lenLen;
    float edgeT = clamp(lenLen * 2.0, 0.0, 1.0);
    edgeT = pow(edgeT, 2.0);

    vec2 refractUV = TexCoord - dir * edgeT * Refraction / textureSize(Sampler0, 0);

    vec2 multiplier = BlurRadius / textureSize(Sampler0, 0);
    vec3 average = texture(Sampler0, refractUV).rgb;
    float total = 1.0;
    for (float d = 0.0; d < 6.28318530718; d += 6.28318530718 / 8.0) {
        for (float i = 0.3; i <= 1.0; i += 0.35) {
            average += texture(Sampler0, refractUV + vec2(cos(d), sin(d)) * multiplier * i).rgb;
            total += 1.0;
        }
    }
    average /= total;

    vec3 finalColor = mix(average, FragColor.rgb, FragColor.a);

    OutColor = vec4(finalColor, mask);
}
