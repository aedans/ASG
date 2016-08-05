#version 150 core

in vec3 position;
in vec2 textureCoords;

out vec2 passTextureCoords;

uniform mat4 transformationMatrix;
uniform float xBlackBars;

void main(void){

    gl_Position = transformationMatrix * vec4(position,1.0) + vec4(xBlackBars, 0.0, 0.0, 0.0);
	passTextureCoords = textureCoords;

}