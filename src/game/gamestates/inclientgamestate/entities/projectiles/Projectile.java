package game.gamestates.inclientgamestate.entities.projectiles;

import game.Game;
import game.gamestates.inclientgamestate.entities.MoveableEntity;
import game.renderer.math.Position;

/**
 * Created by Aedan Smith on 7/7/2016.
 */

public abstract class Projectile extends MoveableEntity {

    // TODO: Fix Projectile's world-edge destruction.

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
        if (getGridX() >= Game.inClientGameState.world.getTileWidth()) {
            destroy();
            return;
        }
        if (getGridY() >= Game.inClientGameState.world.getTileHeight()) {
            destroy();
            return;
        }
        try {
            if (Game.inClientGameState.world.getTileMap().getTileAt(getGridX(), getGridY()).isAirCollidable()) {
                destroy();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            destroy();
        }
    }

}
