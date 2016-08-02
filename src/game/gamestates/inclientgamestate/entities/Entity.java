package game.gamestates.inclientgamestate.entities;

import game.renderer.DisplayManager;
import game.sprites.Sprite;

/**
 * Created by Aedan Smith on 7/4/2016.
 */

public abstract class Entity extends Sprite {

    public Entity(int textureID, int width, int height) {
        super(
                textureID,
                width,
                height
        );
    }

    public Entity(int textureID, float x, float y, int width, int height) {
        super(
                textureID,
                DisplayManager.ppX * x * 2,
                DisplayManager.ppY * y * 2,
                width,
                height
        );
    }

    @SuppressWarnings("WeakerAccess")
    public int getGridX() {
        return (int) ((32 + getPixelPosition().getX()) / 64);
    }

    @SuppressWarnings("WeakerAccess")
    public int getGridY() {
        return (int) ((32 + getPixelPosition().getY()) / 64);
    }

}
