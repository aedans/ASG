package game.renderer;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class Loader {
	
	private static List<Integer> vaos = new ArrayList<>();
	private static List<Integer> vbos = new ArrayList<>();
	private static List<Integer> textures = new ArrayList<>();
	
	public static int loadToVAO(float[] positions, int[] indices){
        float[] textures = new float[]{
            0,0,0,1,1,1,1,0
        };
		int vaoID = createVAO();
		bindIndicesBuffer(indices);
		storeDataInAttributeList(0,3,positions);
        storeDataInAttributeList(1,2,textures);
		unbindVAO();
		return vaoID;
	}

    public static int loadPNGTexture(String fileName){
        try {
            Texture texture = TextureLoader.getTexture("PNG", new FileInputStream("C:\\Users\\Aedan Smith\\OneDrive\\jg\\iCode\\Consumables\\res\\"+fileName+".png"));
            int textureID = texture.getTextureID();
            textures.add(textureID);
            return textureID;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

	public static int loadJPGTexture(String fileName){
		try {
			Texture texture = TextureLoader.getTexture("JPG", new FileInputStream("C:\\Users\\Aedan Smith\\OneDrive\\jg\\iCode\\Consumables\\res\\"+fileName+".jpg"));
			int textureID = texture.getTextureID();
			textures.add(textureID);
            return textureID;
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static void cleanUp(){
        vaos.forEach(GL30::glDeleteVertexArrays);
        vbos.forEach(GL15::glDeleteBuffers);
        textures.forEach(GL11::glDeleteTextures);
	}
	
	private static int createVAO(){
		int vaoID = GL30.glGenVertexArrays();
		vaos.add(vaoID);
		GL30.glBindVertexArray(vaoID);
		return vaoID;
	}
	
	private static void storeDataInAttributeList(int attributeNumber, int coordsize, float[] data){
		int vboID = GL15.glGenBuffers();
		vbos.add(vboID);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboID);
		FloatBuffer buffer = storeDataInFloatBuffer(data);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
		GL20.glVertexAttribPointer(attributeNumber,coordsize,GL11.GL_FLOAT,false,0,0);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
	}
	
	private static void unbindVAO(){
		GL30.glBindVertexArray(0);
	}
	
	private static void bindIndicesBuffer(int[] indices){
		int vboID = GL15.glGenBuffers();
		vbos.add(vboID);
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, vboID);
		IntBuffer buffer = storeDataInIntBuffer(indices);
		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
	}
	
	private static IntBuffer storeDataInIntBuffer(int[] data){
		IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
		buffer.put(data);
		buffer.flip();
		return buffer;
	}
	
	private static FloatBuffer storeDataInFloatBuffer(float[] data){
		FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
		buffer.put(data);
		buffer.flip();
		return buffer;
	}

}
