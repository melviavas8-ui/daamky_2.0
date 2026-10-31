#version 150

in vec3 Position;
in vec2 UV0;
in vec4 Color;

uniform mat4 ModelViewMat;
uniform mat4 ProjMat;

out vec2 texCoord;
out vec4 vertColor;
out float vertDist;

void main() {
    gl_Position = ProjMat * ModelViewMat * vec4(Position, 1.0);
    texCoord = UV0;
    vertColor = Color;
    // Distance from camera for fog/fade
    vec4 viewPos = ModelViewMat * vec4(Position, 1.0);
    vertDist = length(viewPos.xyz);
}
