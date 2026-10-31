#version 330

uniform sampler2D DiffuseSampler;
in vec2 texCoord;
out vec4 fragColor;

uniform vec2 InSize;
uniform float Time;

void main() {
    fragColor = texture(DiffuseSampler, texCoord);
}
