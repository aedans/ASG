package game.gamestates.inclientgamestate.entities.terrain;

import game.gamestates.inclientgamestate.entities.Entity;
import game.renderer.math.Position;
import game.renderer.textures.TexturedModel;

/**
 * Created by Aedan Smith on 7/6/2016.
 */

public abstract class Tile extends Entity {

    public Tile(Position position, int texture, int width, int height) {
        super(position, texture, width, height);
    }

    public Tile(Position position, TexturedModel texturedModel) {
        super(position, texturedModel);
    }

    public abstract boolean isGroundCollidable();

    public abstract boolean isAirCollidable();

    @Override
    public void onDestruction(){

    }

    public static Tile get(int x, int y, int id) {
        if (id <= 90)
            return new Grass(x, y);
        else if (id <= 93)
            return new Mud(x, y);
        else
            return new Water(x, y);
    }

}
