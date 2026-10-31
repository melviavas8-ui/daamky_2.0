#version 150
#extension GL_ARB_explicit_attrib_location : enable

layout(location = 0) in vec3 Position;

uniform mat4 ModelViewMat;
uniform mat4 ProjMat;
uniform vec2 size;

out vec2 oneTexel;
out vec2 texCoord;

void main() {
    //    texCoord = Position.xy * 0.5 + 0.5;
    texCoord = Position.xy / size;
    oneTexel = vec2(1.0 / size.x, 1.0 / size.y);
    gl_Position = vec4(Position.xy / size * 2 - 1, 0, 1.0);
}
