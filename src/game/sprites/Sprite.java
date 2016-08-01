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
 */

public abstract class Sprite implements Renderable {

    // TODO Fix Coord System
    // TODO Fix scale
    // TODO Add elapsed time to update()

    public float scale = 1;
    protected TexturedModel texturedModel;
    public boolean isLight = false;
    private Point2D.Float openGLPosition, pixelPosition;

    public Sprite(int textureID, int width, int height){
        this(textureID, new Point2D.Float(0, 0), width, height);
    }

    public Sprite(int textureID, float x, float y, int width, int height){
        this(textureID, new Point2D.Float(DisplayManager.ppX*x*2, DisplayManager.ppY*y*2), width, height);
    }

    public Sprite(int textureID, Point2D.Float position, int width, int height){
        this(position, TexturedModel.getTexturedModel(width, height, textureID));
    }

    public Sprite(Point2D.Float getOpenGLPosition, TexturedModel texturedModel){
        this.texturedModel = texturedModel;
        this.openGLPosition = getOpenGLPosition;
        this.pixelPosition = new Point2D.Float((getOpenGLPosition.x/DisplayManager.ppX)/2, (getOpenGLPosition.y/DisplayManager.ppY)/2);
    }

    public TexturedModel getTexturedModel() {
        return texturedModel;
    }

    public Point2D.Float getOpenGLPosition() {
        return openGLPosition;
    }

    public Point2D.Float getPixelPosition(){
        return pixelPosition;
    }

    public int getPixelX(){
        return (int) pixelPosition.getX();
    }

    public int getPixelY(){
        return (int) pixelPosition.getY();
    }

    public float getScale() {
        return scale;
    }

    public void destroy() {
        Game.inClientGameState.sprites.remove(this);
    }

    @Override
    public Matrix4f getTransformationMatrix(){
        return MatrixMath.createTransformationMatrix(Viewport.getRelativePosition(getOpenGLPosition()), 0, 0, getScale());
    }

    public abstract void update();

    public abstract void onRender();

}
