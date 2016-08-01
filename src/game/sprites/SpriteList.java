package game.sprites;

import game.gamestates.inclientgamestate.entities.lights.Light;
import game.gamestates.inclientgamestate.entities.lights.LightList;
import game.renderer.RenderList;

import java.util.ArrayList;

/**
 * Created by Aedan Smith on 7/4/2016.
 *
 * A list of Sprites to be used by the Renderer.
 */

public class SpriteList extends RenderList<Sprite> {

    /**
     * The LightList that affects the Sprites
     */
    private LightList lightList = new LightList();

    /**
     * Default SpriteList constructor.
     */
    public SpriteList(){
        super(Textures.spriteTextures.size());
    }

    /**
     * See game.sprites.RenderList documentation
     */
    @Override
    protected void onAdd(Sprite sprite) {
        if (sprite.isLight)
            lightList.addLight((Light) sprite);
    }

    /**
     * See game.sprites.RenderList documentation
     */
    @Override
    protected void onRemove(Sprite sprite) {
        if (sprite.isLight)
            lightList.removeLight((Light) sprite);
    }

    /**
     * See game.sprites.RenderList documentation
     */
    @Override
    protected void onUpdate() {
        for (ArrayList<Sprite> ss : renderables)
            ss.forEach(Sprite::update);
    }

    public LightList getLightList() {
        return lightList;
    }

}
