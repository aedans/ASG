package game.gamestates.inclientgamestate.entities.terrain;

import game.gamestates.inclientgamestate.entities.Entity;
import game.renderer.Position;
import game.sprites.Textures;

/**
 * Created by Aedan Smith on 7/7/2016.
 */

public class Mud extends Entity implements Terrain {

    public Mud(int x, int y) {
        super(new Position(x, y), Textures.mudTextureID, 64, 64);
    }

    @Override
    public void update() {

    }

    @Override
    public void onRender() {

    }

    @Override
    public boolean isGroundCollidable() {
        return false;
    }

    @Override
    public boolean isAirCollidable() {
        return false;
    }

}
