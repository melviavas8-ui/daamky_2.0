#version 330

uniform sampler2D DiffuseSampler;

in vec2 texCoord;
in vec2 oneTexel;

uniform vec2 InSize;
uniform float GlassWidth;
uniform float GlassHeight;
uniform float Radius;
uniform float Refraction;
uniform float Sharpness;
uniform float Blur;
uniform vec2 Mouse;

out vec4 fragColor;

float _clamp(float a) {
    return clamp(a, 0.0, 1.0);
}

float box(in vec2 p, in vec2 b, in vec4 r) {
    r.xy = (p.x > 0.0) ? r.xy : r.zw;
    r.x  = (p.y > 0.0) ? r.x  : r.y;
    vec2 q = abs(p) - b + r.x;
    return min(max(q.x, q.y), 0.0) + length(max(q, 0.0)) - r.x;
}

void main() {
    fragColor = vec4(0.0);
    
    vec2 ir = InSize;
    vec2 wh = vec2(GlassWidth, GlassHeight) / 2.0 * ir.x / ir.y;
    vec4 vr = vec4(Radius) / 2.0 * ir.x / ir.y;
    
    vec2 uv = texCoord;
    vec2 mouse = Mouse;
    if (length(mouse) < 1.0) {
        mouse = ir / 2.0;
    }
    vec2 m2 = uv - mouse / ir;
    
    float rb1 = _clamp(-box(vec2(m2.x * ir.x / ir.y, m2.y), wh, vr) / Sharpness * 32.0);
    float rb2 = _clamp(-box(vec2(m2.x * ir.x / ir.y, m2.y), wh + 1.0 / ir.y, vr) / Sharpness * 16.0) 
              - _clamp(-box(vec2(m2.x * ir.x / ir.y, m2.y), wh, vr) / Sharpness * 16.0);
    float rb3 = _clamp(-box(vec2(m2.x * ir.x / ir.y, m2.y), wh + 4.0 / ir.y, vr) / Sharpness * 4.0) 
              - _clamp(-box(vec2(m2.x * ir.x / ir.y, m2.y), wh - 4.0 / ir.y, vr) / Sharpness * 4.0);
    
    float transition = smoothstep(0.0, 1.0, rb1);
    
    if (transition > 0.0) {
        vec2 lens = (uv - 0.5) * sin(pow(
            _clamp(-box(vec2(m2.x * ir.x / ir.y, m2.y), wh, vr) / Refraction),
        0.25) * 1.57) + 0.5;
        
        float total = 0.0;
        for (float x = -4.0; x <= 4.0; x++) {
            for (float y = -4.0; y <= 4.0; y++) {
                vec2 blurOffset = vec2(x, y) * Blur / ir;
                fragColor += texture(DiffuseSampler, lens + blurOffset);
                total += 1.0;
            }
        }
        fragColor /= total;
        
        float gradient = _clamp(clamp(m2.y, 0.0, 0.2) + 0.1) / 2.0 
                       + _clamp(clamp(-m2.y, -1.0, 0.2) * rb3 + 0.1) / 2.0;
        vec4 lighting = fragColor + 1.0 * vec4(rb2) + gradient * 1.0;
        
        fragColor = mix(texture(DiffuseSampler, uv), lighting, transition);
        
    } else {
        fragColor = texture(DiffuseSampler, uv);
    }
}

