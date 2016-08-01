package game.renderer;

import game.gamestates.inclientgamestate.entities.Entity;

import java.awt.geom.Point2D;
import java.util.function.Function;

/**
 * Created by Aedan Smith on 7/6/2016.
 */

public class Viewport {

    // TODO Migrate to OpenGL Viewport

    private static long lastTranslated = System.currentTimeMillis();
    public static Point2D.Float position = new Point2D.Float(0, 0);
    public static float xVel = 0, yVel = 0;
    private static Function<Point2D.Float, Boolean> onUpdate = vector2f -> false;

    public static Point2D.Float getRelativePosition(Point2D.Float position){
        return new Point2D.Float(position.x-Viewport.position.x, position.y-Viewport.position.y);
    }

    public static void update(){
        if (onUpdate.apply(position)) {
            float m = (float) (lastTranslated - System.currentTimeMillis()) / 1000;
            position.x += xVel * m;
            position.y += yVel * m;
        }
        lastTranslated = System.currentTimeMillis();
    }

    public static void focusOn(Entity e){
        setOnUpdate(vector2f -> {
            position.setLocation(e.getOpenGLPosition());
            return false;
        });
    }

    public static void setOnUpdate(Function<Point2D.Float, Boolean> onUpdate){
        Viewport.onUpdate = onUpdate;
    }

}
