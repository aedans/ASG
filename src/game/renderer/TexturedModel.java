package game.renderer;

import game.sprites.Textures;

/**
 * Created by Aedan Smith on 7/5/2016.
 */

public class TexturedModel {

    private int modelID;
    private int textureID;

    private TexturedModel(int modelID, int textureID){
        this.modelID = modelID;
        this.textureID = textureID;
    }

    public int getGameTextureID(){
        if (textureID <= Textures.spriteTextures.size())
            return textureID;
        else
            return textureID-Textures.spriteTextures.size();
    }

    public int getTrueTextureID() {
        return textureID;
    }

    public int getModelID() {
        return modelID;
    }

    public static TexturedModel getTexturedModel(int textureID){
        return getTexturedModel(
                new float[]{
                        -1, 1,
                        -1, -1,
                        1, -1,
                        1, 1,
                },
                textureID
        );
    }

    public static TexturedModel getTexturedModel(int width, int height, int textureID) {
        return getTexturedModel(
                new int[]{
                        -width, -height,
                        -width, height,
                        width, height,
                        width, -height
                },
                textureID
        );
    }

    public static TexturedModel getTexturedModel(int[] vps, int textureID){
        return getTexturedModel(
                new float[]{
                        (float)vps[0]*DisplayManager.ppX,(float)vps[1]*DisplayManager.ppY,
                        (float)vps[2]*DisplayManager.ppX,(float)vps[3]*DisplayManager.ppY,
                        (float)vps[4]*DisplayManager.ppX,(float)vps[5]*DisplayManager.ppY,
                        (float)vps[6]*DisplayManager.ppX,(float)vps[7]*DisplayManager.ppY,
                },
                textureID
        );
    }

    public static TexturedModel getTexturedModel(float[] vps, int textureID){
        return new TexturedModel(
            Loader.loadToVAO(
                new float[]{
                        vps[0],vps[1],0,
                        vps[2],vps[3],0,
                        vps[4],vps[5],0,
                        vps[6],vps[7],0
                },
                new int[]{
                    0,1,3,
                    3,1,2
                }
            ), textureID
        );
    }

}
