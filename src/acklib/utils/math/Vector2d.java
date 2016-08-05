package acklib.utils.math;

/**
 * Created by thomkad18 on 5/16/2016.
 */
public class Vector2d<T extends Number> implements Vector {
    private T x;
    private T y;

    public Vector2d(T x, T y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns length (magnitude, size) of the Vector2d
     *
     * @return length of the vector
     */
    @Override
    public double getLength() {
        return Vector.getLength(this.x.doubleValue(), this.y.doubleValue());
    }
}
