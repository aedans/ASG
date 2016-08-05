package game;

import game.renderer.data.Renderable;
import game.renderer.math.MatrixMath;
import game.renderer.math.Position;
import game.renderer.math.Viewport;
import game.renderer.textures.TexturedModel;
import org.lwjgl.util.vector.Matrix4f;

/**
 * Created by Aedan Smith on 7/8/2016.
 * <p>
 * An abstract class that contains only the necessary functions for rendering.
 */

public abstract class Sprite implements Renderable {

    // TODO: Add elapsed time to update().
    // TODO: Resize to fit all 1:1 Display sizes

    /**
     * True if the Sprite is a light source. False unless assigned by subclass.
     */
    public boolean isLight = false;

    /**
     * The Sprite's TexturedModel.
     */
    private TexturedModel texturedModel;

    /**
     * The Position of the Sprite.
     */
    private Position position;

    /**
     * Default Sprite constructor
     *
     * @param position: The position of the Sprite.
     * @param texture:  The Texture of the Sprite.
     * @param width:    The width of the Sprite.
     * @param height:   The height of the Sprite.
     */
    public Sprite(Position position, int texture, int width, int height) {
        this(
                position,
                TexturedModel.getTexturedModel(width, height, texture)
        );
    }

    /**
     * Default Sprite constructor.
     *
     * @param position:      The position of the Sprite.
     * @param texturedModel: The TexturedModel of the Sprite.
     */
    public Sprite(Position position, TexturedModel texturedModel) {
        this.position = position;
        this.texturedModel = texturedModel;
    }

    /**
     * Removes the Sprite from the game.
     */
    @SuppressWarnings("WeakerAccess")
    public void destroy() {
        Game.getActiveGameState().findContainer(this).remove(this);
    }

    /**
     * Changes the Sprite's texture.
     *
     * @param newTextureID: The ID of the Texture to change to.
     */
    public void changeTexture(int newTextureID) {
        Game.getActiveGameState().findContainer(this).remove(this);
        texturedModel = new TexturedModel(
                texturedModel.getWidth(),
                texturedModel.getHeight(),
                texturedModel.getModelID(),
                newTextureID
        );
        Game.getActiveGameState().findContainer(this).add(this);
    }

    /**
     * Abstract function called every frame if the Sprite is in a EntityList.
     */
    public abstract void update();

    /**
     * Abstract function called before the Sprite is rendered.
     */
    public abstract void onRender();

    /**
     * Abstract function called on Sprite's destruction.
     */
    @SuppressWarnings("WeakerAccess")
    public abstract void onDestruction();

    @Override
    public Matrix4f getTransformationMatrix() {
        return MatrixMath.createTransformationMatrix(
                Viewport.getRelativePosition(getPosition())
        );
    }

    @Override
    public TexturedModel getTexturedModel() {
        return texturedModel;
    }

    @Override
    public Position getPosition() {
        return position;
    }

}
