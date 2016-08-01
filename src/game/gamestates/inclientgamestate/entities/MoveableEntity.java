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

    public void translate(){
        float m = (float)(System.currentTimeMillis()-lastTranslated)/1000;
        getOpenGLPosition().x += xVel*m;
        getOpenGLPosition().y += yVel*m;
        getPixelPosition().x += xVel*m/DisplayManager.ppX/2;
        getPixelPosition().y += yVel*m/DisplayManager.ppY/2;
        this.lastTranslated = System.currentTimeMillis();
    }

}
