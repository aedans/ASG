package game.sprites;

import game.Game;
import math.MatrixMath;
import game.renderer.DisplayManager;
import game.renderer.Renderable;
import game.renderer.TexturedModel;
import game.renderer.Viewport;
import org.lwjgl.util.vector.Matrix4f;

import java.awt.geom.Point2D;

/**
 * Created by Aedan Smith on 7/8/2016.
 * <p>
 * An abstract class that contains only the necessary functions for rendering.
 */

public abstract class Sprite implements Renderable {

    // TODO: Fix Coord System.
    // TODO: Fix scale.
    // TODO: Add elapsed time to update().

    /**
     * TODO: Implement Scale.
     */
    @SuppressWarnings("WeakerAccess")
    public float scale = 1;

    /**
     * True if the Sprite is a light source. False unless assigned by subclass.
     */
    protected boolean isLight = false;

    /**
     * The Sprite's TexturedModel.
     */
    private TexturedModel texturedModel;

    /**
     * The position of the Sprite on the OpenGL Coordinate plane.
     */
    private Point2D.Float openGLPosition;

    /**
     * The position of the Sprite in pixels from the bottom right.
     */
    private Point2D.Float pixelPosition;

    /**
     * Creates a Sprite at (0, 0).
     *
     * @param textureID: The ID of the texture (See game.sprites.Textures).
     * @param width:     The width of the sprite in pixels.
     * @param height:    The height of the sprite in pixels.
     */
    public Sprite(int textureID, int width, int height) {
        this(
                textureID,
                new Point2D.Float(0, 0),
                width,
                height
        );
    }

    /**
     * Default Sprite constructor.
     *
     * @param textureID: The ID of the texture (See game.sprites.Textures).
     * @param x:         The x-position of the Sprite on the OpenGL Coordinate Plane.
     * @param y:         The y-position of the Sprite on the OpenGL Coordinate Plane.
     * @param width:     The width of the sprite in pixels.
     * @param height:    The height of the sprite in pixels.
     */
    public Sprite(int textureID, float x, float y, int width, int height) {
        this(
                textureID,
                new Point2D.Float(
                        (float) (x * DisplayManager.targetResXRatio),
                        (float) (y * DisplayManager.targetResXRatio)
                ),
                (int) (width * DisplayManager.targetResXRatio),
                (int) (height * DisplayManager.targetResYRatio)
        );
    }

    /**
     * Private Sprite constructor.
     *
     * @param textureID:      The ID of the texture (See game.sprites.Textures).
     * @param openGLPosition: The position of the Sprite on the OpenGL Coordinate Plane.
     * @param width:          The width of the sprite in pixels.
     * @param height:         The height of the sprite in pixels.
     */
    private Sprite(int textureID, Point2D.Float openGLPosition, int width, int height) {
        this(
                openGLPosition,
                TexturedModel.getTexturedModel(width, height, textureID)
        );
    }

    /**
     * Private Sprite constructor.
     *
     * @param openGLPosition: The position of the Sprite on the OpenGL Coordinate Plane.
     * @param texturedModel:  The TexturedModel of the Sprite.
     */
    private Sprite(Point2D.Float openGLPosition, TexturedModel texturedModel) {
        this.texturedModel = texturedModel;
        this.openGLPosition = openGLPosition;
        this.pixelPosition = new Point2D.Float(
                (openGLPosition.x / DisplayManager.ppX) / 2,
                (openGLPosition.y / DisplayManager.ppY) / 2
        );
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
                Viewport.getRelativePosition(getOpenGLPosition()), getScale()
        );
    }

    public TexturedModel getTexturedModel() {
        return texturedModel;
    }

    public Point2D.Float getOpenGLPosition() {
        return openGLPosition;
    }

    public Point2D.Float getPixelPosition() {
        return pixelPosition;
    }

    public int getPixelX() {
        return (int) getPixelPosition().getX();
    }

    public int getPixelY() {
        return (int) getPixelPosition().getY();
    }

    @SuppressWarnings("WeakerAccess")
    public float getScale() {
        return scale;
    }

}
