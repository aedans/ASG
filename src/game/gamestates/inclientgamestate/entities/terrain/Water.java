package game.gamestates.inclientgamestate.entities.terrain;

import game.gamestates.inclientgamestate.entities.Entity;
import game.sprites.Textures;

/**
 * Created by Aedan Smith on 7/7/2016.
 */

public class Water extends Entity implements Terrain {

    public Water(int x, int y) {
        super(Textures.waterTextureID, x, y, 64, 64);
    }

    @Override
    public void update() {

    }

    @Override
    public void onRender() {

    }

    @Override
    public boolean isGroundCollidable() {
        return true;
    }

    @Override
    public boolean isAirCollidable() {
        return false;
    }

}
