package game.gamestates.inclientgamestate.entities.structures;

import game.gamestates.inclientgamestate.entities.Entity;
import game.renderer.DisplayManager;
import game.renderer.lights.Light;
import game.renderer.math.Position;
import game.renderer.resources.Textures;

/**
 * Created by Aedan Smith on 7/7/2016.
 */

public class Base extends Entity implements Light {

    public Base(boolean red, int x, int y) {
        super(new Position(x, y).multiply(DisplayManager.scale), red ? Textures.redBaseTextureID : Textures.blueBaseTextureID, 256, 256);
        this.isLight = true;
    }

    @Override
    public void update() {

    }

    @Override
    public void onRender() {

    }

    @Override
    public void onDestruction() {

    }

    @Override
    public float getStrength() {
        return 5;
    }

}
