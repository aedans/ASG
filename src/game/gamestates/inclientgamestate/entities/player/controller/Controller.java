package game.gamestates.inclientgamestate.entities.player.controller;

import org.lwjgl.util.vector.Vector2f;

/**
 * Created by Aedan Smith on 7/7/2016.
 */

public interface Controller {

    void update();

    boolean wantsToMoveUp();

    boolean wantsToMoveDown();

    boolean wantsToMoveLeft();

    boolean wantsToMoveRight();

    boolean wantsToShoot();

    Vector2f getShotDirection();

}
