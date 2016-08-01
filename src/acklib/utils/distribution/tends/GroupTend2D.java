package acklib.utils.distribution.tends;

import acklib.utils.distribution.Tend2D;

/**
 * Created by Aedan Smith on 5/15/2016.
 *
 * A 2-dimensional tend used to create a 2-dimensional integer distribution
 * centered around a 2-dimensional point with influence lessening as distance
 * increases.
 */

public class GroupTend2D extends Tend2D {

    /**
     * The x and y positions of the tend.
     */
    private int x, y;

    /**
     * The numTextures of the influence of the tend.
     */
    private int size;

    /**
     * Creates a group tend given the x and y positions and the numTextures of influence
     * of the tend.
     *
     * @param x: The x position of the tend.
     * @param y: The y position of the tend.
     * @param size: The numTextures of the influence of the tend.
     */
    public GroupTend2D(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    /**
     * Gets the weight of a 2-dimensional point within the tend.
     *
     * @param x: The x value of the point.
     * @param y: The y value of the point.
     * @param max: The maximum weight of the point.
     * @return double: Returns the weight of the point.
     */
    @Override
    public double getWeight(int x, int y, int max) {
        double weight = max - (Math.abs(Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y))) * ((float)max / size));
        return weight <= 0 ? 0 : weight;
    }

}
