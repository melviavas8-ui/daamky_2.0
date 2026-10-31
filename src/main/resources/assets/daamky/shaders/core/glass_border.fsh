#version 150

#moj_import <daamky:common.glsl>

in vec2 FragCoord;
in vec4 FragColor;

uniform vec2 Size;
uniform vec4 Radius;
uniform float Thickness;
uniform float TintAlpha;

out vec4 OutColor;

void main() {
    vec2 center = Size * 0.5;
    float dist = rdist(center - (FragCoord * Size), center - 1.0, Radius);

    float aa = 1.0 - smoothstep(-0.5, 0.5, dist);
    if (aa <= 0.0) discard;
    if (dist < -Thickness) discard;

    float t = clamp(-dist / Thickness, 0.0, 1.0);
    float body = pow(1.0 - t, 1.5);
    float highlight = exp(-t * t * 100.0);

    vec3 glass = mix(FragColor.rgb, vec3(1.0), 0.7);
    float alpha = (body * 0.4 + highlight * 0.6) * TintAlpha * aa;

    OutColor = vec4(glass, alpha);
    if (OutColor.a < 0.005) discard;
}
