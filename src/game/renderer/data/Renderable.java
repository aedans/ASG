package game.renderer.data;

import game.renderer.math.Position;
import game.renderer.resources.TexturedModel;
import org.lwjgl.util.vector.Matrix4f;

/**
 * Created by Aedan Smith on 7/17/2016.
 * <p>
 * An interface containing the minimal functions for an object to be used by the Renderer.
 */

public interface Renderable {

    TexturedModel getTexturedModel();

    Matrix4f getTransformationMatrix();

    Position getPosition();

    float getScale();

    void onRender();

}
