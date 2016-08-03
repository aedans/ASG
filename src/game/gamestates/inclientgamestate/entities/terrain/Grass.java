package game.gamestates.inclientgamestate.entities.terrain;

import game.gamestates.inclientgamestate.entities.Entity;
import game.renderer.Position;
import game.sprites.Textures;

/**
 * Created by Aedan Smith on 7/6/2016.
 */

public class Grass extends Entity implements Terrain {

    public Grass(int x, int y) {
        super(new Position(x, y), Textures.grassTextureID, 64, 64);
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
