package game.renderer;

import org.lwjgl.util.vector.Matrix4f;

import java.awt.geom.Point2D;

/**
 * Created by Aedan Smith on 7/17/2016.
 */

public interface Renderable {

    TexturedModel getTexturedModel();

    Matrix4f getTransformationMatrix();

    Point2D.Float getOpenGLPosition();

    Point2D.Float getPixelPosition();

    void onRender();

}
