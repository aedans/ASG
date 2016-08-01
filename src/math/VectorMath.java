package math;

import org.lwjgl.util.vector.Vector2f;

/**
 * Created by Aedan Smith on 7/7/2016.
 */

public final class VectorMath {

    public static Vector2f getVector(float x, float y){
        return new Vector2f(
                x,y
        ).normalise(new Vector2f(1, 1));
    }

}
