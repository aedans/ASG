package game.gui;

import game.renderer.math.Position;
import game.renderer.data.Renderable;
import game.renderer.textures.TexturedModel;
import org.lwjgl.util.vector.Matrix4f;

/**
 * Created by Aedan Smith on 7/30/2016.
 */

public abstract class GUIHub implements Renderable {

    protected GUIHub() {

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
    public Position getPosition(){
        return null;
    }

    @Override
    public void onRender() {

    }

    public abstract GUI[] getSubGUIs();

}
