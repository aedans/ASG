package game.sprites;

import game.gamestates.inclientgamestate.entities.lights.Light;
import game.gamestates.inclientgamestate.entities.lights.LightList;
import game.renderer.RenderList;

/**
 * Created by Aedan Smith on 7/4/2016.
 */

public class SpriteList extends RenderList<Sprite> {

    protected LightList lightList = new LightList();

    public SpriteList(){
        super(Textures.spriteTextures.size());
    }

    @Override
    protected void onAdd(Sprite sprite) {
        if (sprite.isLight)
            lightList.addLight((Light) sprite);
    }

    @Override
    protected void onRemove(Sprite sprite) {
        if (sprite.isLight)
            lightList.removeLight((Light) sprite);
    }

    public LightList getLightList() {
        return lightList;
    }

}
