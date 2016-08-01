package acklib.utils.distribution;

/**
 * Created by Aedan Smith on 5/15/2016.
 *
 * A 3-dimensional tend used to create a 3-dimensional integer distribution.
 */

public abstract class Tend3D {

    /**
     * Gets the weight of a 3-dimensional point given a tend[].
     *
     * @param x: The x value of the point.
     * @param y: The y value of the point.
     * @param z: The z value of the point.
     * @param max: The maximum weight of the point.
     * @param tends: A list of 3-dimensional tends.
     * @return double: Returns the weight of the point.
     */
    public static double getWeight(int x, int y, int z, int max, Tend3D[] tends){
        double weight = 0;
        for (Tend3D tend : tends)
            weight += tend.getWeight(x, y, z, max);
        return weight/tends.length;
    }

    /**
     * Gets the weight of a 2-dimensional point within the tend.
     *
     * @param x: The x value of the point.
     * @param y: The y value of the point.
     * @param z: The z value of the point.
     * @param max: The maximum weight of the point.
     * @return double: Returns the weight of the point.
     */
    public abstract double getWeight(int x, int y, int z, int max);

}
