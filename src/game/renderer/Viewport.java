package game.renderer;

import game.gamestates.inclientgamestate.entities.Entity;

import java.awt.geom.Point2D;
import java.util.function.Function;

/**
 * Created by Aedan Smith on 7/6/2016.
 * <p>
 * The Viewport for the Game.
 */

public class Viewport {

    // TODO Migrate to OpenGL Viewport

    /**
     * The time the Viewport was last translated.
     */
    private static long lastTranslated = System.currentTimeMillis();

    /**
     * The position of the Viewport on the OpenGL Coordinate System
     */
    public static Point2D.Float position = new Point2D.Float(0, 0);

    /**
     * The x and y velocity of the Viewport.
     */
    @SuppressWarnings("WeakerAccess")
    public static float xVel = 0, yVel = 0;

    /**
     * The Function to be executed once every Game loop.
     *
     * @param Point2D.Float: The position of the Viewport.
     * @return boolean: If the Viewport should move.
     */
    private static Function<Point2D.Float, Boolean> onUpdate = vector2f -> false;

    /**
     * Gets the position of a given position as seen through the Viewport.
     *
     * @param position: The point to get on-screen in the OpenGL Coordinate System.
     * @return Point2D.Float: The on-screen position in the OpenGL Coordinate System.
     */
    public static Point2D.Float getRelativePosition(Point2D.Float position) {
        return new Point2D.Float(position.x - Viewport.position.x, position.y - Viewport.position.y);
    }

    /**
     * The Function to be executed once every Game loop.
     */
    public static void update() {
        if (onUpdate.apply(position)) {
            float m = (float) (lastTranslated - System.currentTimeMillis()) / 1000;
            position.x += xVel * m;
            position.y += yVel * m;
        }
        lastTranslated = System.currentTimeMillis();
    }

    /**
     * Sets the onUpdate Function to make the Viewport follow an Entity.
     *
     * @param entity: The Entity to follow.
     */
    public static void focusOn(Entity entity) {
        setOnUpdate(vector2f -> {
            position.setLocation(entity.getOpenGLPosition());
            return false;
        });
    }

    /**
     * Sets the onUpdate function to a given Function.
     *
     * @param Point2D.Float: The position of the Viewport.
     * @param onUpdate:      The Function to be executed once every Game loop.
     * @return boolean: If the Viewport should move.
     */
    @SuppressWarnings({"WeakerAccess", "JavadocReference", "JavaDoc"})
    public static void setOnUpdate(Function<Point2D.Float, Boolean> onUpdate) {
        Viewport.onUpdate = onUpdate;
    }

}
