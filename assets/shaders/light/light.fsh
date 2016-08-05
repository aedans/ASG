#version 150 core

in vec2 passTextureCoords;

out vec4 out_Color;

uniform sampler2D textureSampler;
uniform float brightness;

void main(void){

	out_Color = vec4(brightness, brightness, brightness, 1) * texture(textureSampler, passTextureCoords);

}