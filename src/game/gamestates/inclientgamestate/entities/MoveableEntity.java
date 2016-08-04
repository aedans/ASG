package game.gamestates.inclientgamestate.entities;

import game.renderer.math.Position;
import game.renderer.textures.TexturedModel;

/**
 * Created by Aedan Smith on 7/7/2016.
 */

public abstract class MoveableEntity extends Entity {

    private long lastTranslated = System.currentTimeMillis();
    public float xVel, yVel;

    public MoveableEntity(Position position, int texture, int width, int height) {
        super(position, texture, width, height);
    }

    public MoveableEntity(Position position, TexturedModel texturedModel) {
        super(position, texturedModel);
    }

    public void translate() {
        float m = (float) (System.currentTimeMillis() - lastTranslated) / 1000;
        getPosition().translate(xVel * m, yVel * m);
        this.lastTranslated = System.currentTimeMillis();
    }

}
