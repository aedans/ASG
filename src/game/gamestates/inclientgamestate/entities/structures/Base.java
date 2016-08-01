package game.gamestates.inclientgamestate.entities.structures;

import game.gamestates.inclientgamestate.entities.lights.Light;
import game.sprites.Textures;
import game.gamestates.inclientgamestate.entities.Entity;

/**
 * Created by Aedan Smith on 7/7/2016.
 */

public class Base extends Entity implements Light {

    public Base(boolean red, int x, int y) {
        super(red ? Textures.redBaseTextureID : Textures.blueBaseTextureID, x, y, 256, 256);
        this.isLight = true;
    }

    @Override
    public void update() {

    }

    @Override
    public void onRender() {

    }

    @Override
    public float getStrength() {
        return 5;
    }

}
