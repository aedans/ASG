package game.gamestates.inclientgamestate.entities.lights;

import java.awt.geom.Point2D;

/**
 * Created by Aedan Smith on 7/29/2016.
 */

public interface Light {

    float getStrength();

    Point2D.Float getOpenGLPosition();

    Point2D.Float getPixelPosition();

}
