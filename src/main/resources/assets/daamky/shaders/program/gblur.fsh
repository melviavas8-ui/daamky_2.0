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
    vec2 uv = texCoord;
    vec4 original = texture(DiffuseSampler, uv);
    
    float blurHeight = Tilt;
    float blurStrength = FOV;
    float blurOpacity = PanSpeed;
    
    float progress = smoothstep(1.0 - blurHeight, 1.0, uv.y);
    
    vec4 blurred = original;
    if (progress > 0.01 && blurStrength > 0.0) {
        float radius = progress * blurStrength * 4.0;
        vec4 sum = vec4(0.0);
        float total = 0.0;
        for (float x = -2.0; x <= 2.0; x += 1.0) {
            for (float y = -2.0; y <= 2.0; y += 1.0) {
                vec2 offset = vec2(x, y) * radius / InSize;
                sum += texture(DiffuseSampler, uv + offset);
                total += 1.0;
            }
        }
        blurred = sum / total;
    }
    
    fragColor = mix(original, blurred, blurOpacity * progress);
}
