package game.gamestates.inclientgamestate.entities.player.controller;

import game.renderer.DisplayManager;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector2f;

/**
 * Created by Aedan Smith on 7/7/2016.
 */

public class HostController implements Controller {

    @Override
    public void update() {

    }

    @Override
    public boolean wantsToMoveUp() {
        return Keyboard.isKeyDown(Keyboard.KEY_W);
    }

    @Override
    public boolean wantsToMoveDown() {
        return Keyboard.isKeyDown(Keyboard.KEY_S);
    }

    @Override
    public boolean wantsToMoveLeft() {
        return Keyboard.isKeyDown(Keyboard.KEY_A);
    }

    @Override
    public boolean wantsToMoveRight() {
        return Keyboard.isKeyDown(Keyboard.KEY_D);
    }

    @Override
    public boolean wantsToShoot() {
        return Mouse.isButtonDown(0);
    }

    @Override
    public Vector2f getShotDirection() {
        return new Vector2f(
                Mouse.getX() - (DisplayManager.xRes / 2),
                Mouse.getY() - (DisplayManager.yRes / 2)
        ).normalise(new Vector2f(1, 1));
    }

}
