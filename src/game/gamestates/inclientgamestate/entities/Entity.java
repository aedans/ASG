package game.gamestates.inclientgamestate.entities;

import game.renderer.Position;
import game.renderer.TexturedModel;
import game.sprites.Sprite;

/**
 * Created by Aedan Smith on 7/4/2016.
 */

public abstract class Entity extends Sprite {

    public Entity(Position position, int texture, int width, int height) {
        super(position, texture, width, height);
    }

    public Entity(Position position, TexturedModel texturedModel) {
        super(position, texturedModel);
    }

    @SuppressWarnings("WeakerAccess")
    public int getGridX() {
        return ((32 + getPosition().getPixelX()) / 64);
    }

    @SuppressWarnings("WeakerAccess")
    public int getGridY() {
        return ((32 + getPosition().getPixelY()) / 64);
    }

}
