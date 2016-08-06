package game.gamestates.inclientgamestate.entities.terrain;

import game.renderer.math.Position;
import game.renderer.resources.Textures;

/**
 * Created by Aedan Smith on 7/7/2016.
 */

public class Mud extends Tile {

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
