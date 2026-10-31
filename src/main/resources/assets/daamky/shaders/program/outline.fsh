#version 330

#define Width 3

uniform sampler2D DiffuseSampler;

in vec2 texCoord;
in vec2 oneTexel;

uniform vec2 InSize;
uniform int RenderMode;
uniform vec4 MainColor;
uniform float GlintEnabled;
uniform float GlintSpeed;
uniform float GlintWidth;
uniform float GlintGrad;
uniform vec4 GlintColor;
uniform float NoiseEnabled;
uniform float NoiseSpeed;
uniform float NoiseAngle;
uniform float NoiseScale;
uniform vec4 NoiseColor;
uniform float CircuitEnabled;
uniform float CircuitSpeed;
uniform float CircuitIntensity;
uniform vec4 CircuitColor;
uniform float LiquidGlassEnabled;
uniform float LiquidGlassWidth;
uniform float LiquidGlassHeight;
uniform float LiquidGlassRadius;
uniform float LiquidGlassRefraction;
uniform float LiquidGlassSharpness;
uniform float LiquidGlassBlur;
uniform float Time;

out vec4 fragColor;

float quad(float x) {
    return x * x;
}

float Hash(vec2 p) {
    vec3 p2 = vec3(p.xy, 1.0);
    return fract(sin(dot(p2, vec3(37.1, 61.7, 12.4))) * 758.5453123);
}

float noise_func(in vec2 p) {
    vec2 i = floor(p);
    vec2 f = fract(p);
    f *= f * (3.0 - 2.0 * f);
    
    return mix(mix(Hash(i + vec2(0., 0.)), Hash(i + vec2(1., 0.)), f.x),
               mix(Hash(i + vec2(0., 1.)), Hash(i + vec2(1., 1.)), f.x),
               f.y);
}

float fbm(vec2 p) {
    float v = 0.0;
    v += noise_func(p * 1.) * .100;
    v += noise_func(p * 2.) * .025;
    v += noise_func(p * 4.) * .125;
    v += noise_func(p * 8.) * .0625;
    return v;
}

mat2 rotation2dX(float angle) {
    float s = sin(angle);
    float c = cos(angle);
    return mat2(c, s, -s, c);
}

vec2 rotate(vec2 p, float a) {
    return vec2(p.x * cos(a) - p.y * sin(a), p.x * sin(a) + p.y * cos(a));
}

#define ITS 8
vec2 circuit(vec3 p) {
    p = mod(p, 2.0) - 1.0;
    float w = 1e38;
    vec3 cut = vec3(1.0, 0.0, 0.0);
    vec3 e1 = vec3(-1.0);
    vec3 e2 = vec3(1.0);
    float rnd = 0.23;
    float pos, plane;
    float fact = 0.9;
    float j = 0.0;
    
    for(int i = 0; i < ITS; i++) {
        pos = mix(dot(e1, cut), dot(e2, cut), (rnd - 0.5) * fact + 0.5);
        plane = dot(p, cut) - pos;
        if(plane > 0.0) {
            e1 = mix(e1, vec3(pos), cut);
            rnd = fract(rnd * 9827.5719);
            cut = cut.yzx;
        } else {
            e2 = mix(e2, vec3(pos), cut);
            rnd = fract(rnd * 15827.5719);
            cut = cut.zxy;
        }
        j += step(rnd, 0.2);
        w = min(w, abs(plane));
    }
    return vec2(j / float(ITS - 1), w);
}

float circuitScene(vec3 p) {
    vec2 cir = circuit(p);
    return exp(-100.0 * cir.y) + pow(cir.x * 1.8 * (sin(p.z * 10.0 + Time * -5.0 + cir.x * 10.0) * 0.5 + 0.5), 8.0);
}

float nse(float x) {
    return fract(sin(x * 297.9712) * 90872.2961);
}

float nseI(float x) {
    float fl = floor(x);
    return mix(nse(fl), nse(fl + 1.0), smoothstep(0.0, 1.0, fract(x)));
}

float fbmCircuit(float x) {
    return nseI(x) * 0.5 + nseI(x * 2.0) * 0.25 + nseI(x * 4.0) * 0.125;
}

// LiquidGlass uniforms repurposed as voxel-edges parameters:
//   LiquidGlassWidth      -> cells horizontally
//   LiquidGlassHeight     -> cells vertically
//   LiquidGlassRadius     -> edge thickness (0..0.5 of cell)
//   LiquidGlassRefraction -> per-cell pulse speed
//   LiquidGlassSharpness  -> overall glow intensity
//   LiquidGlassBlur       -> corner brightness boost
float vox_hash(vec2 p) {
    return fract(sin(dot(p, vec2(127.1, 311.7))) * 43758.5453);
}

vec3 applyLiquidGlassToColor(vec2 uv, vec3 inputColor) {
    vec2 cells = vec2(max(LiquidGlassWidth, 1.0), max(LiquidGlassHeight, 1.0));
    vec2 grid  = uv * cells;
    vec2 cellID  = floor(grid);
    vec2 cellUV  = fract(grid);

    // distance to nearest edge (0 at edge, 0.5 at cell center)
    vec2 edgeDist = min(cellUV, 1.0 - cellUV);
    float minEdge = min(edgeDist.x, edgeDist.y);

    float edgeWidth = clamp(LiquidGlassRadius, 0.001, 0.49);
    float edge   = 1.0 - smoothstep(0.0, edgeWidth, minEdge);
    float corner = (1.0 - smoothstep(0.0, edgeWidth * 1.6, edgeDist.x))
                 * (1.0 - smoothstep(0.0, edgeWidth * 1.6, edgeDist.y));

    // per-cell brightness pulse (random phase per cell, time-driven)
    float phase = vox_hash(cellID) * 6.28318 + Time * LiquidGlassRefraction;
    float pulse = 0.6 + 0.4 * sin(phase);

    // subtle inward refraction so the cell face looks faceted
    vec2 toCenter = (0.5 - cellUV) / cells;
    vec2 refracted = uv + toCenter * edgeWidth * 0.6;
    vec3 base = texture(DiffuseSampler, refracted).rgb;

    // soft per-cell darken to make voxels read as solids
    float faceShade = 0.85 + 0.15 * pulse;
    base *= faceShade;

    // glow color = entity input color, brightened
    vec3 glowColor = inputColor + vec3(0.5) * pulse;

    float edgeGlow   = edge   * LiquidGlassSharpness;
    float cornerGlow = corner * LiquidGlassSharpness * (1.0 + LiquidGlassBlur);

    vec3 result = base + glowColor * edgeGlow + glowColor * cornerGlow;
    return clamp(result, 0.0, 1.5);
}

void main() {
    float divider = 5;
    float maxSample = 3;
    vec4 current = texture(DiffuseSampler, texCoord);

    if (current.a != 0) {
        if (RenderMode == 1) discard;
        
        vec3 fillColor = MainColor.rgb;
        float fillAlpha = MainColor.a;
        
        if (GlintEnabled > 0.5) {
            vec2 linepos = texCoord;
            linepos.x = linepos.x - mod(Time * GlintSpeed, 2.0) + 0.5;
            float y = linepos.x * GlintGrad;
            
            float s = smoothstep(y - GlintWidth, y, linepos.y) - smoothstep(y, y + GlintWidth, linepos.y);
            
            if (s > 0.0) {
                float glintStrength = s * GlintColor.a;
                fillColor = mix(fillColor, GlintColor.rgb, glintStrength);
            }
        }
        
        if (NoiseEnabled > 0.5) {
            vec2 uv = texCoord;
            float angleRad = radians(NoiseAngle);
            vec2 uvR = uv * rotation2dX(angleRad);
            
            vec2 v = vec2(uvR.x * NoiseScale + Time * NoiseSpeed);
            float k = clamp(fbm(v), .1, 1.) - .1;
            k = k * 3.0;
            
            if (k > 0.0) {
                float noiseStrength = k * NoiseColor.a;
                fillColor = mix(fillColor, NoiseColor.rgb, noiseStrength);
            }
        }
        
        if (CircuitEnabled > 0.5) {
            vec2 uv = texCoord * 2.0 - 1.0;
            uv.x *= InSize.x / InSize.y;
            
            vec3 ro = vec3(0.0, Time * CircuitSpeed * 0.2, 0.1);
            vec3 rd = normalize(vec3(uv, 0.9));
            ro.xz = rotate(ro.xz, Time * CircuitSpeed * 0.1);
            ro.xy = rotate(ro.xy, 0.2);
            rd.xz = rotate(rd.xz, Time * CircuitSpeed * 0.2);
            rd.xy = rotate(rd.xy, 0.2);
            
            float acc = 0.0;
            vec3 r = ro + rd * 0.5;
            for(int i = 0; i < 50; i++) {
                acc += circuitScene(r + nse(r.x) * 0.03);
                r += rd * 0.015;
            }
            
            vec3 circuitEffect = pow(vec3(acc * 0.04), vec3(0.2, 0.6, 2.0) * 8.0) * 2.0;
            circuitEffect = clamp(circuitEffect, vec3(0.0), vec3(1.0));
            circuitEffect *= fbmCircuit(Time * 6.0) * 2.0;
            circuitEffect = pow(circuitEffect, vec3(1.0 / 2.2));
            
            float circuitLuminance = dot(circuitEffect, vec3(0.333));
            if (circuitLuminance > 0.0) {
                float circuitStrength = circuitLuminance * CircuitIntensity * CircuitColor.a;
                fillColor = mix(fillColor, CircuitColor.rgb, circuitStrength);
            }
        }
        
        if (LiquidGlassEnabled > 0.5) {
            fillColor = applyLiquidGlassToColor(texCoord, fillColor);
        }
        
        fragColor = vec4(fillColor, fillAlpha);
    } else {
        if (RenderMode == 0) discard;
        float alpha = 0;

        for (float x = -Width; x < Width; x++) {
            for (float y = -Width; y < Width; y++) {
                vec4 texture = texture(DiffuseSampler, texCoord + vec2(x, y) * oneTexel);

                if (texture.a != 0) {
                    current = texture;
                    alpha += max(0, (maxSample - distance(vec2(x, y), vec2(0))) / divider);
                }
            }
        }

        float finalAlpha = quad(alpha);
        vec3 finalColor = MainColor.rgb;
        
        if (GlintEnabled > 0.5 && finalAlpha > 0.0) {
            vec2 linepos = texCoord;
            linepos.x = linepos.x - mod(Time * GlintSpeed, 2.0) + 0.5;
            float y = linepos.x * GlintGrad;
            
            float s = smoothstep(y - GlintWidth, y, linepos.y) - smoothstep(y, y + GlintWidth, linepos.y);
            
            if (s > 0.0) {
                float glintStrength = s * GlintColor.a;
                finalColor = mix(finalColor, GlintColor.rgb, glintStrength);
            }
        }
        
        if (NoiseEnabled > 0.5 && finalAlpha > 0.0) {
            vec2 uv = texCoord;
            float angleRad = radians(NoiseAngle);
            vec2 uvR = uv * rotation2dX(angleRad);
            
            vec2 v = vec2(uvR.x * NoiseScale + Time * NoiseSpeed);
            float k = clamp(fbm(v), .1, 1.) - .1;
            k = k * 3.0;
            
            if (k > 0.0) {
                float noiseStrength = k * NoiseColor.a;
                finalColor = mix(finalColor, NoiseColor.rgb, noiseStrength);
            }
        }
        
        if (CircuitEnabled > 0.5 && finalAlpha > 0.0) {
            vec2 uv = texCoord * 2.0 - 1.0;
            uv.x *= InSize.x / InSize.y;
            
            vec3 ro = vec3(0.0, Time * CircuitSpeed * 0.2, 0.1);
            vec3 rd = normalize(vec3(uv, 0.9));
            ro.xz = rotate(ro.xz, Time * CircuitSpeed * 0.1);
            ro.xy = rotate(ro.xy, 0.2);
            rd.xz = rotate(rd.xz, Time * CircuitSpeed * 0.2);
            rd.xy = rotate(rd.xy, 0.2);
            
            float acc = 0.0;
            vec3 r = ro + rd * 0.5;
            for(int i = 0; i < 50; i++) {
                acc += circuitScene(r + nse(r.x) * 0.03);
                r += rd * 0.015;
            }
            
            vec3 circuitEffect = pow(vec3(acc * 0.04), vec3(0.2, 0.6, 2.0) * 8.0) * 2.0;
            circuitEffect = clamp(circuitEffect, vec3(0.0), vec3(1.0));
            circuitEffect *= fbmCircuit(Time * 6.0) * 2.0;
            circuitEffect = pow(circuitEffect, vec3(1.0 / 2.2));
            
            float circuitLuminance = dot(circuitEffect, vec3(0.333));
            if (circuitLuminance > 0.0) {
                float circuitStrength = circuitLuminance * CircuitIntensity * CircuitColor.a;
                finalColor = mix(finalColor, CircuitColor.rgb, circuitStrength);
            }
        }
        
        if (LiquidGlassEnabled > 0.5 && finalAlpha > 0.0) {
            finalColor = applyLiquidGlassToColor(texCoord, finalColor);
        }
        
        fragColor = vec4(finalColor, finalAlpha * MainColor.a);
    }
}