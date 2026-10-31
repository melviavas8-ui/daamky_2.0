#version 150

in vec3 Position;
in vec2 UV0;
in vec4 Color;

uniform mat4 ModelViewMat;
uniform mat4 ProjMat;

out vec2 TexCoord;
out vec4 FragColor;
out vec2 ScreenCoord;

void main() {
    TexCoord = UV0;
    FragColor = Color;
    
    vec4 screenPos = ProjMat * ModelViewMat * vec4(Position, 1.0);
    ScreenCoord = (screenPos.xy / screenPos.w) * 0.5 + 0.5;
    
    gl_Position = screenPos;
}


