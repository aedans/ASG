package acklib.utils.distribution;

/**
 * Created by Aedan Smith on 5/15/2016.
 *
 * A 1-dimensional tend used to create a 1-dimensional integer distribution.
 */

public abstract class Tend {

    /**
     * Gets the weight of a 1-dimensional point given a tend[].
     *
     * @param x: The x value of the point.
     * @param max: The maximum weight of the point.
     * @param tends: A list of 1-dimensional tends.
     * @return double: Returns the weight of the point.
     */
    public static double getWeight(int x, int max, Tend[] tends){
        double weight = 0;
        for (Tend tend : tends)
            weight += tend.getWeight(x, max);
        return weight/tends.length;
    }

    /**
     * Gets the weight of a 1-dimensional point within the tend.
     *
     * @param x: The x value of the point.
     * @param max: The maximum weight of the point.
     * @return double: Returns the weight of the point.
     */
    public abstract double getWeight(int x, int max);

}
