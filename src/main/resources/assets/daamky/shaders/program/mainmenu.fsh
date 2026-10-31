#version 330

uniform sampler2D DiffuseSampler;

in vec2 texCoord;
in vec2 oneTexel;

uniform vec2 InSize;
uniform float Time;

out vec4 fragColor;

#define DTR 0.01745329

#define rot(a) mat2(cos(a),sin(a),-sin(a),cos(a))

// Функция шума для фона
float hash(vec2 p) {
    return fract(sin(dot(p, vec2(127.1, 311.7))) * 43758.5453);
}

float noise(vec2 p) {
    vec2 i = floor(p);
    vec2 f = fract(p);
    f = f * f * (3.0 - 2.0 * f);
    
    float a = hash(i);
    float b = hash(i + vec2(1.0, 0.0));
    float c = hash(i + vec2(0.0, 1.0));
    float d = hash(i + vec2(1.0, 1.0));
    
    return mix(mix(a, b, f.x), mix(c, d, f.x), f.y);
}

float fbm(vec2 p) {
    float value = 0.0;
    float amplitude = 0.5;
    for(int i = 0; i < 4; i++) {
        value += amplitude * noise(p);
        p *= 2.0;
        amplitude *= 0.5;
    }
    return value;
}

vec2 uv;
vec3 cp,cn,cr,ro,rd,ss,oc,cc,gl,vb;
vec4 fc;
float tt,cd,sd,io,oa,td;
int es=0,ec;

float bx(vec3 p,vec3 s){vec3 q=abs(p)-s;return min(max(q.x,max(q.y,q.z)),0.)+length(max(q,0.));}
float smin(float a, float b, float k){float h=clamp(0.5+0.5*(b-a)/k,0.,1.);return mix(b,a,h)-k*h*(1.-h);}

vec3 lattice(vec3 p, int iter, float an)
{
    for(int i = 0; i < iter; i++)
    {
        p.xy *= rot(an*DTR);
        p.yz=abs(p.yz)-1.;
        p.xz *= rot(-an*DTR);
    }
    return p;
}

float mp(vec3 p)
{
    vec3 pp=p;
    
    p.xz*=rot(tt*0.1);
    p.xy*=rot(tt*0.1);
    p=lattice(p,9,45.+cos(tt*0.1)*5.);

    sd = bx(p,vec3(1)) - 0.01;

    sd = smin(sd, sd, 0.8);
    gl += exp(-sd*0.001) * vec3(0.33, 0.06, 0.70) * 0.005;

    sd=abs(sd)-0.001;
    if(sd<0.001)
    {
        oc=vec3(0.33, 0.06, 0.70);
        io=1.2;
        oa=0.0;
        ss=vec3(0);
        vb=vec3(0.,10,2.8);
        ec=2;	
    }
    return sd;
}

void tr(){vb.x=0.;cd=0.;for(float i=0.;i<256.;i++){mp(ro+rd*cd);cd+=sd;td+=sd;if(sd<0.0001||cd>128.)break;}}
void nm(){mat3 k=mat3(cp,cp,cp)-mat3(.001);cn=normalize(mp(cp)-vec3(mp(k[0]),mp(k[1]),mp(k[2])));}

void px()
{
    cc=vec3(0.08, 0.02, 0.12)+length(pow(abs(rd+vec3(0,0.5,0)),vec3(3)))*0.08+gl*1.5;
    vec3 l=vec3(0.5, 0.2, 0.8);
    
    if(cd>128.){
        float n = fbm(uv * 3.0 + tt * 0.02) * 0.06;
        float n2 = fbm(uv * 8.0 - tt * 0.01) * 0.03;
        cc += vec3(n + n2) * vec3(0.4, 0.15, 0.7);
        oa=1.;
        return;
    }
    
    float df=clamp(length(cn*l),0.,1.);
    vec3 fr=pow(1.-df,3.)*mix(cc,vec3(0.15, 0.05, 0.2),0.5);
    float sp=(1.-length(cross(cr,cn*l)))*0.15;
    float ao=min(mp(cp+cn*0.3)-0.3,0.3)*0.4;
    // Увеличенная яркость
    cc=mix((oc*1.3*(df+fr+ss)+fr*1.2+sp+ao+gl*2.0),oc*1.2,vb.x);
}

void main()
{
    // Reset globals
    gl = vec3(0);
    fc = vec4(0);
    es = 0;
    td = 0.;
    
    tt=mod(Time+25., 260.);
    uv = texCoord - 0.5;
    uv.x *= InSize.x / InSize.y;
    
    // Анимация приближения/отдаления (закомментировано)
    // float an = (sin(tt*0.3)*0.5+0.5);
    // an = 1.-pow(1.-pow(an, 5.),10.);
    // ro=vec3(0,0,-5. - an*15.);
    
    // Фиксированная позиция камеры
    ro=vec3(0,0,-8.);
    rd=normalize(vec3(uv,1));
  
    for(int i=0;i<25;i++)
    {
        tr();cp=ro+rd*cd;
        nm();ro=cp-cn*0.01;
        cr=refract(rd,cn,i%2==0?1./io:io);
        if(length(cr)==0.&&es<=0){cr=reflect(rd,cn);es=ec;}
        if(max(es,0)%3==0&&cd<128.)rd=cr;es--;
        if(vb.x>0.&&i%2==1)oa=pow(clamp(cd/vb.y,0.,1.),vb.z);
        px();fc=fc+vec4(cc*oa,oa)*(1.-fc.a);	
        if((fc.a>=1.||cd>128.))break;
    }
    
    fragColor = fc/fc.a;
}


