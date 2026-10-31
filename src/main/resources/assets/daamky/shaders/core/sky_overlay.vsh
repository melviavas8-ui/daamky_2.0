#version 150

in vec3 Position;

uniform mat4 ModelViewMat;
uniform mat4 ProjMat;

out vec2 NdcCoord;

void main() {
    NdcCoord = Position.xy;
    // Position is already in NDC space ([-1..1]). Force depth to far plane so any world geometry overwrites the sky.
    gl_Position = vec4(Position.xy, 0.999, 1.0);
}
