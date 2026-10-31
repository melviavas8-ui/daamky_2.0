#version 150

in vec2 uv;
out vec4 outColor;

uniform sampler2D BeforeColor;
uniform sampler2D AfterColor;
uniform sampler2D BeforeDepth;
uniform sampler2D AfterDepth;
uniform vec2 TexelSize;
uniform vec2 GlowSides;

float pixelMask(vec2 coord) {
    vec4 beforeColor = texture(BeforeColor, coord);
    vec4 afterColor = texture(AfterColor, coord);
    float colorDelta = length(afterColor.rgb - beforeColor.rgb);
    float alphaDelta = abs(afterColor.a - beforeColor.a);
    float beforeDepth = texture(BeforeDepth, coord).r;
    float afterDepth = texture(AfterDepth, coord).r;
    float depthDelta = abs(afterDepth - beforeDepth);

    float colorMask = smoothstep(0.012, 0.085, colorDelta + alphaDelta * 0.35);
    float depthMask = smoothstep(0.000001, 0.00012, depthDelta);
    return max(colorMask, depthMask);
}

float allowedSide(vec2 coord) {
    float left = 1.0 - smoothstep(0.54, 0.68, coord.x);
    float right = smoothstep(0.32, 0.46, coord.x);
    return clamp(GlowSides.x * left + GlowSides.y * right, 0.0, 1.0);
}

void main() {
    float center = pixelMask(uv);
    float axis = pixelMask(uv + vec2(TexelSize.x, 0.0));
    axis += pixelMask(uv - vec2(TexelSize.x, 0.0));
    axis += pixelMask(uv + vec2(0.0, TexelSize.y));
    axis += pixelMask(uv - vec2(0.0, TexelSize.y));
    float diagonal = pixelMask(uv + TexelSize);
    diagonal += pixelMask(uv - TexelSize);
    diagonal += pixelMask(uv + vec2(TexelSize.x, -TexelSize.y));
    diagonal += pixelMask(uv + vec2(-TexelSize.x, TexelSize.y));

    float mask = center * 0.58 + axis * 0.085 + diagonal * 0.025;
    mask = smoothstep(0.02, 0.72, mask);
    mask *= allowedSide(uv);

    vec3 color = texture(AfterColor, uv).rgb;
    outColor = vec4(color, clamp(mask, 0.0, 1.0));
}
