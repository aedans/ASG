package game.gamestates.inclientgamestate.entities;

import game.Sprite;
import game.gamestates.inclientgamestate.entities.terrain.Tile;
import game.renderer.math.Position;
import game.renderer.textures.TexturedModel;

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
        return (int) (((Tile.size/2) + getPosition().getPixelX()) / Tile.size);
    }

    @SuppressWarnings("WeakerAccess")
    public int getGridY() {
        return (int) (((Tile.size/2) + getPosition().getPixelY()) / Tile.size);
    }

}
