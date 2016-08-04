package game.sprites;

import game.Game;
import game.renderer.*;
import math.MatrixMath;
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
    protected boolean isLight = false;

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
     * @param texture: The Texture of the Sprite.
     * @param width: The width of the Sprite.
     * @param height: The height of the Sprite.
     */
    public Sprite(Position position, int texture, int width, int height){
        this(
                position,
                TexturedModel.getTexturedModel(width, height, texture)
        );
    }

    /**
     * Default Sprite constructor.
     *
     * @param position: The position of the Sprite.
     * @param texturedModel:  The TexturedModel of the Sprite.
     */
    public Sprite(Position position, TexturedModel texturedModel) {
        this.position = position;
        this.texturedModel = texturedModel;
    }

    /**
     * Removes the Sprite from the game.
     * <p>
     * TODO: Add support for other GameStates.
     */
    @SuppressWarnings("WeakerAccess")
    public void destroy() {
        Game.inClientGameState.sprites.remove(this);
    }

    /**
     * Abstract function called every frame if the Sprite is in a SpriteList.
     */
    public abstract void update();

    /**
     * Abstract function called before the Sprite is rendered.
     */
    public abstract void onRender();

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
