#version 150

in vec2 FragCoord;
in vec4 FragColor;

uniform vec2 Size;
uniform float Smoothness;

out vec4 OutColor;

// Vesica SDF - exact (Inigo Quilez)
// https://www.shadertoy.com/view/XtVfRW
float sdVesica(vec2 p, float w, float h) {
    float d = 0.5 * (w * w - h * h) / h;
    p = abs(p);
    vec3 c = (w * p.y < d * (p.x - w)) ? vec3(0.0, w, 0.0) : vec3(-d, 0.0, d + h);
    return length(p - c.yx) - c.z;
}

void main() {
    // Map FragCoord (0-1) to centered pixel coords
    vec2 uv = (FragCoord - 0.5) * Size;

    // Rotate 90 degrees so the vesica points upward (swap x and y)
    uv = vec2(uv.y, uv.x);

    // w = half-height of the petal, h = half-width (w > h for wide petal shape)
    float w = Size.y * 0.48;
    float h = Size.x * 0.35;

    float d = sdVesica(uv, w, h);

    float alpha = 1.0 - smoothstep(-Smoothness, Smoothness, d);

    vec4 color = vec4(FragColor.rgb, FragColor.a * alpha);

    if (color.a < 0.001) {
        discard;
    }

    OutColor = color;
}
