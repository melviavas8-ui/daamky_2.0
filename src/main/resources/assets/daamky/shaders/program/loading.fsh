#version 330

uniform sampler2D DiffuseSampler;

in vec2 texCoord;
in vec2 oneTexel;

uniform vec2 InSize;
uniform float Time;

out vec4 fragColor;

#define PI 3.14159265

float circle(vec2 uv, float blur) {
    return smoothstep(0., blur, 1. - length(uv));
}

void main() {
    vec2 uv = (texCoord * InSize - 0.5 * InSize) / InSize.y;
    
    float circleWhite = circle(uv * 2.45, 1.);
    float circleBlack = circle(uv * 2.86, 0.7);
    float c = circleWhite - circleBlack;
    c *= 6.;
    
    float t = Time * 5.;
    c -= circle(vec2(uv.x - sin(t) * .85, 1.8 * uv.y - cos(t) * .65) * .8, 1.); 
    
    vec3 col = vec3(c) * vec3(1., 0., 0.5);
    col += vec3(smoothstep(0.2, 0.7, c)) * vec3(1., 1., 0.);
    col += vec3(smoothstep(0.4, 0.55, c));
    
    // Прозрачный фон - alpha зависит от яркости кружка
    float alpha = max(max(col.r, col.g), col.b);
    fragColor = vec4(col, alpha);
}

