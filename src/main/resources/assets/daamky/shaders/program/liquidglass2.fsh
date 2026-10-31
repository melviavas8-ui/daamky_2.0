#version 330

uniform sampler2D DiffuseSampler;

in vec2 texCoord;
in vec2 oneTexel;

uniform vec2 InSize;
uniform vec2 RectCenter;
uniform vec2 RectSize;
uniform float BorderWidth;
uniform float LensStrength;
uniform float BlurAmount;
uniform float LightingStrength;

out vec4 fragColor;

void main() {
    vec2 uv = texCoord;
    vec2 mouse = RectCenter;
    
    if (length(mouse) < 1.0) {
        mouse = InSize / 2.0;
    }
    
    vec2 m2 = (uv - mouse / InSize);
    
    float aspectRatio = InSize.x / InSize.y;
    float scaleX = RectSize.x > 0.0 ? (InSize.x / 2.0) / RectSize.x : 1.0;
    float scaleY = RectSize.y > 0.0 ? (InSize.y / 2.0) / RectSize.y : 1.0;
    
    float roundedBox = pow(abs(m2.x * aspectRatio * scaleX), 8.0) + pow(abs(m2.y * scaleY), 8.0);
    
    float rb1 = clamp((1.0 - roundedBox * 10000.0) * 8.0, 0.0, 1.0);
    float rb2 = clamp((0.95 - roundedBox * 9500.0) * 16.0, 0.0, 1.0) - clamp(pow(0.9 - roundedBox * 9500.0, 1.0) * 16.0, 0.0, 1.0);
    float rb3 = (clamp((1.5 - roundedBox * 11000.0) * 2.0, 0.0, 1.0) - clamp(pow(1.0 - roundedBox * 11000.0, 1.0) * 2.0, 0.0, 1.0));
    
    fragColor = vec4(0.0);
    
    float transition = smoothstep(0.0, 1.0, rb1 + rb2);
    
    if (transition > 0.0) {
        // Lens distortion
        vec2 lens = ((uv - 0.5) * 1.0 * (1.0 - roundedBox * 5000.0 * LensStrength) + 0.5);
        
        // Blur
        float total = 0.0;
        float blurSize = BlurAmount;
        
        for (float x = -4.0; x <= 4.0; x++) {
            for (float y = -4.0; y <= 4.0; y++) {
                vec2 offset = vec2(x, y) * blurSize / InSize;
                fragColor += texture(DiffuseSampler, offset + lens);
                total += 1.0;
            }
        }
        fragColor /= total;
        
        // Lighting
        float gradient = clamp((clamp(m2.y, 0.0, 0.2) + 0.1) / 2.0, 0.0, 1.0) + clamp((clamp(-m2.y, -1000.0, 0.2) * rb3 + 0.1) / 2.0, 0.0, 1.0);
        vec4 lighting = clamp(fragColor + vec4(rb1) * gradient * LightingStrength + vec4(rb2) * 0.3 * LightingStrength, 0.0, 1.0);
        
        // Antialiasing
        fragColor = mix(texture(DiffuseSampler, uv), lighting, transition);
    } else {
        fragColor = texture(DiffuseSampler, uv);
    }
}
