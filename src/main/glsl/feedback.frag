#version 330 core

uniform sampler2D tex0;
uniform vec2 resolution;

out vec3 color;

void main() {
    vec2 uv = gl_FragCoord.xy / resolution;
    vec2 cartUv = (gl_FragCoord.xy - (resolution / 2)) / resolution.y;
    vec3 prevColor = texture(tex0, uv).rgb;
    color = vec3(uv.x, 0, uv.y);
}
