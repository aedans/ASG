package game.gamestates.inclientgamestate.entities.projectiles;

import game.gamestates.inclientgamestate.entities.MoveableEntity;
import game.Game;
import game.renderer.Position;

/**
 * Created by Aedan Smith on 7/7/2016.
 */

public abstract class Projectile extends MoveableEntity {

    // TODO: Fix Projectile's map-edge destruction.

    public Projectile(Position position, int texture, int width, int height) {
        super(position, texture, width, height);
    }

    public void doCollisions() {
        if (getPosition().getOpenGLX() < 0) {
            destroy();
            return;
        }
        if (getPosition().getOpenGLY() < 0) {
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
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            destroy();
        }
    }

}
