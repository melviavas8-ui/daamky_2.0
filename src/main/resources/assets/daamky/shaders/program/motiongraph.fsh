#version 330

uniform sampler2D DiffuseSampler;
uniform sampler2D GraphBuffer;

in vec2 texCoord;
in vec2 oneTexel;

uniform vec2 InSize;
uniform float PosX;
uniform float PosY;
uniform float GraphWidth;
uniform float GraphHeight;
uniform float Speed;
uniform float Points;
uniform float Intensity;
uniform float FadeR;
uniform float FadeG;
uniform float FadeB;
uniform float Motion;
uniform float Time;

out vec4 fragColor;

void main() {
    vec4 screenColor = texture(DiffuseSampler, texCoord);
    
    vec2 graphCenter = vec2(PosX, PosY);
    vec2 graphSize = vec2(GraphWidth, GraphHeight);
    
    vec2 toCenter = abs(texCoord - graphCenter);
    
    if (toCenter.x > graphSize.x / 2.0 || toCenter.y > graphSize.y / 2.0) {
        fragColor = screenColor;
        return;
    }
    
    vec2 graphMin = graphCenter - graphSize / 2.0;
    vec2 localUV = (texCoord - graphMin) / graphSize;
    
    vec3 prevGraph = texture(GraphBuffer, texCoord).rgb;
    vec3 col = prevGraph * vec3(FadeR, FadeG, FadeB);
    
    float xp = mod(Time * Speed, Speed) / Speed;
    
    int IP = int(Points);
    float SG = Speed;
    
    for (int i = 0; i < IP; i++) {
        xp += 1.0 / (SG * float(IP));
        
        float baseWave = sin(xp * 30.0) / max(3.0, 800.0 * pow(abs(0.5 - xp), 2.0));
        float yp = 0.5 + baseWave + Motion * 0.5;
        
        float dist = distance(localUV, vec2(xp, yp));
        col += vec3(1.0 / (dist * Intensity));
    }
    
    fragColor = vec4(mix(screenColor.rgb, col, clamp(length(col), 0.0, 1.0)), 1.0);
}

