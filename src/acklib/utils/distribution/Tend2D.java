package acklib.utils.distribution;

/**
 * Created by Aedan Smith on 5/15/2016.
 *
 * A 2-dimensional tend used to create a 2-dimensional integer distribution.
 */

public abstract class Tend2D {

    /**
     * Gets the weight of a 2-dimensional point given a tend[].
     *
     * @param x: The x value of the point.
     * @param y: The y value of the point.
     * @param max: The maximum weight of the point.
     * @param tends: A list of 2-dimensional tends.
     * @return double: Returns the weight of the point.
     */
    public static double getWeight(int x, int y, int max, Tend2D[] tends){
        double weight = 0;
        for (Tend2D tend : tends)
            weight += tend.getWeight(x, y, max);
        return weight/tends.length;
    }

    /**
     * Gets the weight of a 2-dimensional point within the tend.
     *
     * @param x: The x value of the point.
     * @param y: The y value of the point.
     * @param max: The maximum weight of the point.
     * @return double: Returns the weight of the point.
     */
    public abstract double getWeight(int x, int y, int max);

}
