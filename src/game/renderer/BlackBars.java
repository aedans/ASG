package game.renderer;

import game.renderer.annotations.ConstRender;
import game.renderer.data.RenderList;
import game.renderer.data.Renderable;
import game.renderer.math.MatrixMath;
import game.renderer.math.Position;
import game.renderer.textures.TexturedModel;
import game.renderer.textures.Textures;
import game.sprites.Sprite;
import org.lwjgl.util.vector.Matrix4f;

/**
 * Created by Aedan Smith on 8/4/2016.
 */

public class BlackBars extends RenderList<Renderable> {

    /**
     * Default BlackBars constructor
     */
    public BlackBars() {
        super(Textures.GUITextures.size());
        if (DisplayManager.xRes > DisplayManager.yRes) {
            add(new BlackBar(
                    new Position(-1f, 0f),
                    TexturedModel.getTexturedModel(DisplayManager.xRes-DisplayManager.yRes, DisplayManager.yRes, Textures.blackTextureID)
            ));
            add(new BlackBar(
                    new Position(1f, 0f),
                    TexturedModel.getTexturedModel(DisplayManager.xRes-DisplayManager.yRes, DisplayManager.yRes, Textures.blackTextureID)
            ));
        }

        if (DisplayManager.xRes < DisplayManager.yRes) {
            add(new BlackBar(
                    new Position(0f, -1f),
                    TexturedModel.getTexturedModel(DisplayManager.xRes, DisplayManager.yRes-DisplayManager.xRes, Textures.blackTextureID)
            ));
            add(new BlackBar(
                    new Position(0f, 1f),
                    TexturedModel.getTexturedModel(DisplayManager.xRes, DisplayManager.yRes-DisplayManager.xRes, Textures.blackTextureID)
            ));
        }
        update();
    }

    @Override
    protected void onAdd(Renderable renderable) {

    }

    @Override
    protected void onRemove(Renderable renderable) {

    }

    @Override
    protected void onUpdate() {

    }

    @ConstRender
    private class BlackBar extends Sprite {

        public BlackBar(Position position, TexturedModel texturedModel) {
            super(position, texturedModel);
        }

        @Override
        public void update() {

        }

        @Override
        public void onRender() {

        }

        @Override
        protected void onDestruction() {

        }

        @Override
        public Matrix4f getTransformationMatrix() {
            return MatrixMath.createTransformationMatrix(
                    getPosition()
            );
        }

    }

}
