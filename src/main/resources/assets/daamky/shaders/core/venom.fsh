#version 150

in vec2 texCoord;
in vec4 vertColor;
in float vertDist;

uniform float Time;
uniform float Intensity;

out vec4 fragColor;

// Simplex-like noise
float hash(vec2 p) {
    vec3 p3 = fract(vec3(p.xyx) * 0.1031);
    p3 += dot(p3, p3.yzx + 33.33);
    return fract((p3.x + p3.y) * p3.z);
}

float noise(vec2 p) {
    vec2 i = floor(p);
    vec2 f = fract(p);
    f = f * f * (3.0 - 2.0 * f);
    return mix(
        mix(hash(i), hash(i + vec2(1.0, 0.0)), f.x),
        mix(hash(i + vec2(0.0, 1.0)), hash(i + vec2(1.0, 1.0)), f.x),
        f.y
    );
}

float fbm(vec2 p) {
    float v = 0.0;
    float amp = 0.5;
    for (int i = 0; i < 4; i++) {
        v += amp * noise(p);
        p *= 2.1;
        amp *= 0.5;
    }
    return v;
}

void main() {
    vec4 base = vertColor;

    // UV along tentacle: x = across width (0-1), y = along length (0-1)
    float u = texCoord.x; // 0 at edge, 0.5 center, 1 other edge
    float v = texCoord.y; // 0 at base, 1 at tip

    // Organic vein noise - scrolls along tentacle
    vec2 noiseUV = vec2(u * 3.0, v * 8.0 - Time * 2.0);
    float veinNoise = fbm(noiseUV);
    float veins = smoothstep(0.35, 0.55, veinNoise);

    // Secondary smaller veins
    vec2 smallNoiseUV = vec2(u * 6.0, v * 16.0 - Time * 3.5);
    float smallVeins = fbm(smallNoiseUV) * 0.5;

    // Edge glow - brighter at the center of the strip
    float centerDist = abs(u - 0.5) * 2.0; // 0 at center, 1 at edge
    float edgeGlow = 1.0 - centerDist * centerDist;
    float coreBright = smoothstep(0.3, 0.0, centerDist);

    // Pulsing along the tentacle
    float pulse = 0.8 + 0.2 * sin(v * 12.0 - Time * 6.0);
    float pulse2 = 0.9 + 0.1 * sin(v * 20.0 - Time * 10.0 + 1.5);

    // Combine
    vec3 color = base.rgb;

    // Darken edges, brighten core
    color *= (0.6 + 0.4 * edgeGlow);

    // Add bright core glow
    vec3 glowColor = min(color * 1.8 + vec3(0.15), vec3(1.0));
    color = mix(color, glowColor, coreBright * 0.7 * Intensity);

    // Add vein patterns - slightly brighter vein areas
    vec3 veinColor = color * 1.3 + vec3(0.05);
    color = mix(color, veinColor, (veins * 0.4 + smallVeins * 0.2) * Intensity);

    // Apply pulse
    color *= pulse * pulse2;

    // Alpha: fade edges, keep core solid
    float alpha = base.a * edgeGlow * pulse;

    // Tip fade
    float tipFade = smoothstep(1.0, 0.85, v);
    alpha *= tipFade;

    // Base fade (subtle)
    float baseFade = smoothstep(0.0, 0.05, v);
    alpha *= baseFade;

    // Distance fade
    float distFade = clamp(1.0 - (vertDist - 20.0) / 30.0, 0.0, 1.0);
    alpha *= distFade;

    fragColor = vec4(color, alpha);
}
