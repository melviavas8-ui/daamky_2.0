#version 330

uniform vec3 ThemeColor;
uniform float Progress;
uniform float Time;

in vec2 texCoord;
out vec4 fragColor;

const float PI = 3.14159265;

float circle(vec2 uv, float blur) {
    return smoothstep(0.0, blur, 1.0 - length(uv));
}

void main() {
    vec2 uv = (texCoord - 0.5) * 2.0;

    float ringOuter = circle(uv * 2.45, 1.0);
    float ringInner = circle(uv * 2.86, 0.7);
    float ring = clamp((ringOuter - ringInner) * 6.0, 0.0, 1.0);

    float angle = atan(uv.x, -uv.y);
    if (angle < 0.0) angle += 2.0 * PI;
    float maxAngle = Progress * 2.0 * PI;
    float arcMask = smoothstep(0.06, 0.0, angle - maxAngle);

    float t = Time * 3.0;
    float dot = circle(vec2(uv.x - sin(t) * 0.85, 1.8 * uv.y - cos(t) * 0.65) * 0.8, 1.0);

    vec3 dim = ThemeColor * 0.18;
    vec3 col = ring * mix(dim, ThemeColor, arcMask);
    col += dot * vec3(1.0);

    float alpha = clamp(max(max(col.r, col.g), col.b), 0.0, 1.0);
    fragColor = vec4(col, alpha);
}
