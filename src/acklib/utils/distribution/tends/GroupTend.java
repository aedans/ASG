package acklib.utils.distribution.tends;

import acklib.utils.distribution.Tend;

/**
 * Created by Aedan Smith on 5/15/2016.
 *
 * A 1-dimensional tend used to create a 1-dimensional integer distribution
 * centered around a 1-dimensional point with influence lessening as distance
 * increases.
 */

public class GroupTend extends Tend {

    /**
     * The x position of the tend.
     */
    private int x;

    /**
     * The numTextures of the influence of the tend.
     */
    private int size;

    /**
     * Creates a group tend given the x position and the numTextures of influence of the
     * tend.
     *
     * @param x: The x position of the tend.
     * @param size: The numTextures of the influence of the tend.
     */
    public GroupTend(int x, int size) {
        this.x = x;
        this.size = size;
    }

    /**
     * Gets the weight of a 1-dimensional point within the tend.
     *
     * @param x: The x value of the point.
     * @param max: The maximum weight of the point.
     * @return double: Returns the weight of the point.
     */
    @Override
    public double getWeight(int x, int max) {
        double weight = Math.abs(max + (x - this.x) * (max / size));
        return weight <= 0 ? 0 : weight;
    }

}
