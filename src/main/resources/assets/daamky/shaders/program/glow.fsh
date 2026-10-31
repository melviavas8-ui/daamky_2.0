#version 150

in vec2 oneTexel;
in vec2 texCoord;

uniform sampler2D DiffuseSampler;
uniform float radius;
uniform float quality;
uniform vec4 glowColor;

out vec4 fragColor;

void main() {
//    vec4 glowColor = vec4(1, 0, 0, 1);
//    float radius = 10;
//    float quality = 10;
    vec4 base = texture(DiffuseSampler, texCoord);
    if(base.a != 0) {
        fragColor = vec4(0);
        return;
    }
    float cnt = 0;

    for(float dx = -radius * quality; dx <= radius * quality; dx += quality) {
        for(float dy = -radius * quality; dy <= radius * quality; dy += quality) {
            if(dx == 0 && dy == 0) continue;
            cnt += int(texture(DiffuseSampler, texCoord + vec2(dx, dy) * oneTexel).a);
        }
    }

    float alpha = cnt / (radius * radius * 4);

    fragColor = vec4(glowColor.rgb, 2 * alpha);
    //    fragColor = base;
    //fragColor = vec4(vec3(0), sqrt(texCoord.x * texCoord.x + texCoord.y * texCoord.y));
}
