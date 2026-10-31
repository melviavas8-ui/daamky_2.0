#version 330

uniform sampler2D DiffuseSampler;

in vec2 texCoord;
in vec2 oneTexel;

uniform vec2 InSize;
uniform float PanSpeed;
uniform float Tilt;
uniform float FOV;
uniform float Time;

out vec4 fragColor;

void main() {
    vec4 screenColor = texture(DiffuseSampler, texCoord);
    vec3 baseColor = screenColor.rgb;
    
    float blurOpacity = PanSpeed;
    float blurHeight = Tilt;
    float blurStrength = FOV;
    
    if (blurOpacity > 0.001) {
        float progress = smoothstep(1.0 - blurHeight, 1.0, texCoord.y);
        
        if (progress > 0.01) {
            float radius = progress * blurStrength * 8.0;
            vec4 sum = vec4(0.0);
            float total = 0.0;
            
            for (float x = -3.0; x <= 3.0; x += 1.0) {
                for (float y = -3.0; y <= 3.0; y += 1.0) {
                    vec2 offset = vec2(x, y) * radius / InSize;
                    sum += texture(DiffuseSampler, texCoord + offset);
                    total += 1.0;
                }
            }
            
            vec3 blurred = sum.rgb / total;
            baseColor = mix(baseColor, blurred, blurOpacity * progress);
        }
    }
    
    fragColor = vec4(baseColor, 1.0);
}
