// Circular Rounded Rectangle (classic/original)
float rdist_circular(vec2 pos, vec2 size, vec4 radius) {
    radius.xy = (pos.x > 0.0) ? radius.xy : radius.wz;
    radius.x  = (pos.y > 0.0) ? radius.x : radius.y;
    
    vec2 v = abs(pos) - size + radius.x;
    return min(max(v.x, v.y), 0.0) + length(max(v, 0.0)) - radius.x;
}

float ralpha_circular(vec2 size, vec2 coord, vec4 radius, float smoothness) {
    vec2 center = size * 0.5;
    float dist = rdist_circular(center - (coord * size), center - 1.0, radius);
    return 1.0 - smoothstep(1.0 - smoothness, 1.0, dist);
}

// Quadratic Circle SDF by Inigo Quilez
// Creates a shape from 4 parabolic sections - smoother than circular rounding
// https://iquilezles.org/articles/distfunctions2d/
// https://www.shadertoy.com/view/Wltczj
float sdQuadraticCircle(vec2 p) {
    p = abs(p);
    if (p.y > p.x) p = p.yx;
    
    float a = p.x - p.y;
    float b = p.x + p.y;
    float c = (2.0 * b - 1.0) / 3.0;
    float h = a * a + c * c * c;
    float t;
    
    if (h >= 0.0) {
        h = sqrt(h);
        t = sign(h - a) * pow(abs(h - a), 1.0 / 3.0) - pow(h + a, 1.0 / 3.0);
    } else {
        float z = sqrt(-c);
        float v = acos(a / (c * z)) / 3.0;
        t = -z * (cos(v) + sin(v) * 1.732050808);
    }
    
    t *= 0.5;
    vec2 w = vec2(-t, t) + 0.75 - t * t - p;
    return length(w) * sign(a * a * 0.5 + b - 1.5);
}

// Quadratic Rounded Rectangle - box with quadratic circle corners
float rdist(vec2 pos, vec2 size, vec4 radius) {
    // Select radius based on quadrant (per-corner support)
    radius.xy = (pos.x > 0.0) ? radius.xy : radius.wz;
    float r = (pos.y > 0.0) ? radius.x : radius.y;
    
    vec2 absPos = abs(pos);
    
    if (r < 0.001) {
        // No rounding - simple box SDF
        vec2 d = absPos - size;
        return length(max(d, 0.0)) + min(max(d.x, d.y), 0.0);
    }
    
    // Clamp radius to half the smallest dimension
    r = min(r, min(size.x, size.y));
    
    // Inner rectangle (without corner regions)
    vec2 innerSize = size - vec2(r);
    
    // Determine which region we're in
    if (absPos.x <= innerSize.x) {
        // In vertical strip (top/bottom edges) - simple distance to edge
        return absPos.y - size.y;
    }
    
    if (absPos.y <= innerSize.y) {
        // In horizontal strip (left/right edges) - simple distance to edge
        return absPos.x - size.x;
    }
    
    // In corner region - use quadratic circle for smooth parabolic curve
    vec2 cornerPos = (absPos - innerSize) / r;
    return sdQuadraticCircle(cornerPos) * r;
}

float ralpha(vec2 size, vec2 coord, vec4 radius, float smoothness) {
    vec2 center = size * 0.5;
    float dist = rdist(center - (coord * size), center - 1.0, radius);
    return 1.0 - smoothstep(1.0 - smoothness, 1.0, dist);
}

const vec2[4] RECT_VERTICES_COORDS = vec2[] (
    vec2(0.0, 0.0), 
    vec2(0.0, 1.0), 
    vec2(1.0, 1.0),
    vec2(1.0, 0.0)
);

vec2 rvertexcoord(int id) {
    return RECT_VERTICES_COORDS[id % 4];
}