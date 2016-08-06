package game.renderer.resources;

import game.renderer.DisplayManager;
import game.renderer.data.Loader;

import java.awt.geom.Point2D;

/**
 * Created by Aedan Smith on 7/5/2016.
 * <p>
 * A Model and a Texture to be used by the Renderer.
 */

public class TexturedModel {

    /**
     * The ID of the Model. (Currently unnecessary)
     */
    private int modelID;

    /**
     * The ID of the Texture.
     */
    private int textureID;

    /**
     * The Width and Height of the Model on the OpenGL coordinate plane.
     */
    private float width, height;

    /**
     * Default TexturedModel constructor.
     *
     * @param modelID:   The ID of the Model.
     * @param textureID: The ID of the Texture. (See game.renderer.resources.Textures).
     */
    public TexturedModel(float width, float height, int modelID, int textureID) {
        this.width = width;
        this.height = height;
        this.modelID = modelID;
        this.textureID = textureID;
    }

    /**
     * Creates a TexturedModel that covers the screen with the given Texture ID
     *
     * @param textureID: The Texture ID.
     * @return TexturedModel: The created TexturedModel.
     */
    public static TexturedModel getTexturedModel(int textureID) {
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

    /**
     * Creates a TexturedModel with the given width, height, and Texture ID.
     *
     * @param width:     The Width of the TexturedModel.
     * @param height:    The Height of the TexturedModel.
     * @param textureID: The Texture ID.
     * @return TexturedModel: The created TexturedModel.
     */
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

    /**
     * Creates a TexturedModel with the given Vertices and Texture ID.
     *
     * @param vps:       The Vertices of the Model.
     * @param textureID: The Texture ID.
     * @return TexturedModel: The created TexturedModel.
     */
    @SuppressWarnings("WeakerAccess")
    public static TexturedModel getTexturedModel(int[] vps, int textureID) {
        return getTexturedModel(
                new float[]{
                        (float) vps[0] * DisplayManager.ppX, (float) vps[1] * DisplayManager.ppY,
                        (float) vps[2] * DisplayManager.ppX, (float) vps[3] * DisplayManager.ppY,
                        (float) vps[4] * DisplayManager.ppX, (float) vps[5] * DisplayManager.ppY,
                        (float) vps[6] * DisplayManager.ppX, (float) vps[7] * DisplayManager.ppY,
                },
                textureID
        );
    }

    /**
     * Creates a TexturedModel with the given Vertices and Texture ID.
     *
     * @param vps:       The Vertexes of the Model.
     * @param textureID: The Texture ID.
     * @return TexturedModel: The created TexturedModel.
     */
    @SuppressWarnings("WeakerAccess")
    public static TexturedModel getTexturedModel(float[] vps, int textureID) {
        // Width and Height detection possibly bugged for non-square Models, needs to be checked.
        Point2D.Float bottomLeft = new Point2D.Float(
                (vps[0] < vps[2]) ? vps[0] : vps[2],
                (vps[1] < vps[7]) ? vps[1] : vps[7]
        );
        Point2D.Float topRight = new Point2D.Float(
                (vps[4] > vps[6]) ? vps[4] : vps[6],
                (vps[3] > vps[5]) ? vps[3] : vps[5]
        );
        return new TexturedModel(
                (topRight.x - bottomLeft.x) / 2,
                (topRight.y - bottomLeft.y) / 2,
                Loader.loadToVAO(
                        new float[]{
                                vps[0], vps[1], 0,
                                vps[2], vps[3], 0,
                                vps[4], vps[5], 0,
                                vps[6], vps[7], 0
                        },
                        new int[]{
                                0, 1, 3,
                                3, 1, 2
                        }
                ), textureID
        );
    }

    /**
     * @return The Texture ID to be used by the Game.
     */
    @SuppressWarnings("WeakerAccess")
    public int getGameTextureID() {
        if (textureID <= Textures.entityTextures.size())
            return textureID;
        else
            return textureID - Textures.entityTextures.size();
    }

    /**
     * @return The Texture ID to be used by the Renderer.
     */
    @SuppressWarnings("WeakerAccess")
    public int getTrueTextureID() {
        return textureID;
    }

    @SuppressWarnings("WeakerAccess")
    public int getModelID() {
        return modelID;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "TexturedModel(ModelID: " + modelID + ", TexureID: " + textureID + ")";
    }

}
