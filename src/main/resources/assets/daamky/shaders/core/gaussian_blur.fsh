#version 150

#moj_import <daamky:common.glsl>

in vec2 FragCoord; // normalized fragment coord relative to the primitive
in vec2 TexCoord;
in vec4 FragColor;

uniform sampler2D Sampler0;
uniform vec2 Size; // rectangle size
uniform vec4 Radius; // radius for each vertex
uniform float Smoothness; // edge smoothness
uniform float BlurRadius;

out vec4 OutColor;

// Gaussian blur parameters
const int samples = 35;
const int LOD = 2;         // gaussian done on MIPmap at scale LOD
const int sLOD = 1 << LOD; // tile size = 2^LOD

float gaussian(vec2 i) {
    float sigma = float(samples) * 0.25;
    return exp(-0.5 * dot(i / sigma, i / sigma)) / (6.28 * sigma * sigma);
}

vec4 gaussianBlur(sampler2D sp, vec2 U, vec2 scale) {
    vec4 O = vec4(0.0);
    int s = samples / sLOD;
    
    for (int i = 0; i < s * s; i++) {
        vec2 d = vec2(float(i % s), float(i / s)) * float(sLOD) - float(samples) / 2.0;
        O += gaussian(d) * textureLod(sp, U + scale * d * BlurRadius, float(LOD));
    }
    
    return O / O.a;
}

void main() {
    vec2 resolution = textureSize(Sampler0, 0);
    vec2 scale = 1.0 / resolution;
    
    vec4 blurred = gaussianBlur(Sampler0, TexCoord, scale);
    
    vec4 color = blurred * FragColor;
    color.a *= ralpha(Size, FragCoord, Radius, Smoothness);

    if (color.a == 0.0) { // alpha test
        discard;
    }

    OutColor = color;
}

