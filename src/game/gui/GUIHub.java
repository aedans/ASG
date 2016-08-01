package game.gui;

import game.renderer.Renderable;
import game.renderer.TexturedModel;
import org.lwjgl.util.vector.Matrix4f;

import java.awt.geom.Point2D;

/**
 * Created by Aedan Smith on 7/30/2016.
 */

public abstract class GUIHub implements Renderable {

    protected GUIHub(){

    }

    @Override
    public TexturedModel getTexturedModel() {
        return null;
    }

    @Override
    public Matrix4f getTransformationMatrix() {
        return null;
    }

    @Override
    public Point2D.Float getOpenGLPosition() {
        return null;
    }

    @Override
    public Point2D.Float getPixelPosition(){
        return null;
    }

    @Override
    public void onRender() {

    }

    public abstract GUI[] getSubGUIs();

}
