#version 150

in vec2 uv;
out vec4 outColor;

uniform sampler2D SceneTexture;
uniform sampler2D HandTexture;
uniform sampler2D GlowTexture;
uniform sampler2D TrailTexture;
uniform float GlowStrength;
uniform float TrailStrength;
uniform vec2 TexelSize;
// 0 = overlay (fire bloom around the masked geometry, geometry stays sharp),
// 1 = burn-through (fire also fills inside the mask so the geometry dissolves).
uniform float FillMode;

float sampleMask(vec2 coord) {
    return clamp(texture(HandTexture, coord).a, 0.0, 1.0);
}

void main() {
    vec4 scene = texture(SceneTexture, uv);
    vec4 hand = texture(HandTexture, uv);
    vec4 glow = texture(GlowTexture, uv);
    vec4 trail = texture(TrailTexture, uv);

    float handMask = clamp(hand.a, 0.0, 1.0);
    float outsideMask = 1.0 - smoothstep(0.015, 0.20, handMask);
    // In burn-through mode the gating goes away — fire applies uniformly over the
    // whole frame; in overlay mode we keep the edge-only behavior.
    float fireGate = mix(outsideMask, 1.0, clamp(FillMode, 0.0, 1.0));
    float neighborAlpha = 0.0;
    neighborAlpha = max(neighborAlpha, sampleMask(uv + vec2(TexelSize.x, 0.0)));
    neighborAlpha = max(neighborAlpha, sampleMask(uv - vec2(TexelSize.x, 0.0)));
    neighborAlpha = max(neighborAlpha, sampleMask(uv + vec2(0.0, TexelSize.y)));
    neighborAlpha = max(neighborAlpha, sampleMask(uv - vec2(0.0, TexelSize.y)));
    float objectEdge = clamp(max(glow.a * 1.12, neighborAlpha) * fireGate, 0.0, 1.0);

    vec3 color = scene.rgb;
    float trailVisibility = clamp(0.88 + objectEdge * 0.32, 0.0, 1.0) * fireGate;
    color += trail.rgb * trailVisibility * TrailStrength * 0.86;

    float glowAlpha = clamp(glow.a * (0.94 + objectEdge * 0.32) * fireGate, 0.0, 0.76);
    color += glow.rgb * glowAlpha * (0.72 + GlowStrength * 0.26);

    outColor = vec4(clamp(color, 0.0, 1.0), 1.0);
}
