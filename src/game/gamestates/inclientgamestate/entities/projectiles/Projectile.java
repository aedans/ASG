package game.gamestates.inclientgamestate.entities.projectiles;

import game.gamestates.inclientgamestate.entities.MoveableEntity;
import game.Game;

/**
 * Created by Aedan Smith on 7/7/2016.
 */

public abstract class Projectile extends MoveableEntity {

    public Projectile(int textureID, float x, float y, int width, int height) {
        super(textureID, x, y, width, height);
    }

    public void doCollisions() {
        if (getOpenGLPosition().x <= 0) {
            destroy();
            return;
        }
        if (getOpenGLPosition().y <= 0) {
            destroy();
            return;
        }
        if (getGridX() >= Game.inClientGameState.map.getWidth()) {
            destroy();
            return;
        }
        if (getGridY() >= Game.inClientGameState.map.getHeight()) {
            destroy();
            return;
        }
        try {
            if (Game.inClientGameState.map.getTileAt(getGridX(), getGridY()).isAirCollidable()) {
                destroy();
                return;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            destroy();
        }
    }

}
