#version 150

in vec2 TexCoord;
in vec4 FragColor;

uniform sampler2D Sampler0;
uniform sampler2D Sampler1;
uniform float Range;
uniform float Thickness;
uniform float Smoothness;
uniform vec2 ScreenSize;
uniform float Refraction;
uniform float Blur;

out vec4 OutColor;

float median(vec3 color) {
    return max(min(color.r, color.g), min(max(color.r, color.g), color.b));
}

void main() {
    float dist = median(texture(Sampler0, TexCoord).rgb) - 0.5 + Thickness;
    vec2 h = vec2(dFdx(TexCoord.x), dFdy(TexCoord.y)) * vec2(textureSize(Sampler0, 0));
    float pixels = Range * inversesqrt(h.x * h.x + h.y * h.y);
    float alpha = smoothstep(-Smoothness, Smoothness, dist * pixels);
    
    if (alpha < 0.01) {
        discard;
    }
    
    vec2 fragcoord = gl_FragCoord.xy;
    vec2 uv = fragcoord / ScreenSize;
    uv.y = 1.0 - uv.y;
    
    vec2 center = vec2(0.5, 0.5);
    vec2 m2 = uv - center;
    
    float aspectratio = ScreenSize.x / ScreenSize.y;
    float roundedbox = pow(abs(m2.x * aspectratio), 8.0) + pow(abs(m2.y), 8.0);
    
    float rb1 = clamp((1.0 - roundedbox * 10000.0) * 8.0, 0.0, 1.0);
    float rb2 = clamp((0.95 - roundedbox * 9500.0) * 16.0, 0.0, 1.0) - clamp(pow(0.9 - roundedbox * 9500.0, 1.0) * 16.0, 0.0, 1.0);
    float rb3 = (clamp((1.5 - roundedbox * 11000.0) * 2.0, 0.0, 1.0) - clamp(pow(1.0 - roundedbox * 11000.0, 1.0) * 2.0, 0.0, 1.0));
    
    float transition = smoothstep(0.0, 1.0, rb1 + rb2);
    
    vec2 lens = ((uv - 0.5) * 1.0 * (1.0 - roundedbox * 5000.0 * Refraction) + 0.5);
    
    vec4 blurredcolor = vec4(0.0);
    float total = 0.0;
    float blursize = Blur * 0.5 / max(ScreenSize.x, ScreenSize.y);
    
    for (float x = -4.0; x <= 4.0; x++) {
        for (float y = -4.0; y <= 4.0; y++) {
            vec2 offset = vec2(x, y) * blursize;
            vec2 sampleuv = lens + offset;
            sampleuv.y = 1.0 - sampleuv.y;
            blurredcolor += texture(Sampler1, sampleuv);
            total += 1.0;
        }
    }
    blurredcolor /= total;
    
    float gradient = clamp((clamp(m2.y, 0.0, 0.2) + 0.1) / 2.0, 0.0, 1.0) + clamp((clamp(-m2.y, -1000.0, 0.2) * rb3 + 0.1) / 2.0, 0.0, 1.0);
    vec4 lighting = clamp(blurredcolor + vec4(rb1) * gradient + vec4(rb2) * 0.3, 0.0, 1.0);
    
    vec2 originalsampleuv = uv;
    originalsampleuv.y = 1.0 - originalsampleuv.y;
    vec4 originalcolor = texture(Sampler1, originalsampleuv);
    
    vec4 glasscolor = mix(originalcolor, lighting, transition);
    
    glasscolor.rgb *= 1.2;
    
    vec3 finalcolor = mix(glasscolor.rgb, FragColor.rgb, 0.02);
    
    OutColor = vec4(finalcolor, alpha * FragColor.a);
}
