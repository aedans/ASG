package game.gamestates.inclientgamestate.entities;

import game.renderer.DisplayManager;
import game.renderer.TexturedModel;

import java.awt.geom.Point2D;

/**
 * Created by Aedan Smith on 7/7/2016.
 */

public abstract class MoveableEntity extends Entity {

    // TODO Bind movement to Coord system

    private long lastTranslated = System.currentTimeMillis();
    public float xVel, yVel;

    public MoveableEntity(int textureID, int width, int height) {
        super(textureID, width, height);
    }

    public MoveableEntity(int textureID, float x, float y, int width, int height) {
        super(textureID, x, y, width, height);
    }

    public void translate() {
        float m = (float) (System.currentTimeMillis() - lastTranslated) / 1000;
        getPosition().translate(xVel * m, yVel * m);
        this.lastTranslated = System.currentTimeMillis();
    }

}
