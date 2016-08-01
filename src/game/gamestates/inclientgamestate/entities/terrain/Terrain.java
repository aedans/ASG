package game.gamestates.inclientgamestate.entities.terrain;

/**
 * Created by Aedan Smith on 7/6/2016.
 */

public interface Terrain {

    static Terrain get(int x, int y, int id) {
        if (id <= 90)
            return new Grass(x, y);
        else if (id <= 93)
            return new Mud(x, y);
        else
            return new Water(x, y);
    }

    boolean isGroundCollidable();

    boolean isAirCollidable();

}
