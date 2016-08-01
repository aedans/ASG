package acklib.utils.math;

/**
 * Created by thomkad18 on 5/16/2016.
 */
public class Vector2D<T extends Number> implements Vector {
    private T x;
    private T y;

    public Vector2D(T x, T y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns depth (magnitude, depth) of the Vector2D
     *
     * @return depth of the vector
     */
    @Override
    public double getLength() {
        double squaredComponents = x.doubleValue() * x.doubleValue() + y.doubleValue() * y.doubleValue();
        return Math.sqrt(squaredComponents);
    }
}
