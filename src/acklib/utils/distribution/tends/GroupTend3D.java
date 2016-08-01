package acklib.utils.distribution.tends;

import acklib.utils.distribution.Tend3D;

/**
 * Created by Aedan Smith on 5/15/2016.
 *
 * A 3-dimensional tend used to create a 3-dimensional integer distribution
 * centered around a 3-dimensional point with influence lessening as distance
 * increases.
 */

public class GroupTend3D extends Tend3D {

    /**
     * The x, y, and z positions of the tend.
     */
    private int x, y, z;

    /**
     * The depth of the influence of the tend.
     */
    private int size;

    /**
     * Creates a group tend given the x, y, and z positions and the depth of
     * influence of the tend.
     *
     * @param x: The x position of the tend.
     * @param y: The y position of the tend.
     * @param z: The z position of the tend.
     * @param size: The depth of the influence of the tend.
     */
    public GroupTend3D(int x, int y, int z, int size) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.size = size;
    }

    /**
     * Gets the weight of a 3-dimensional point within the tend.
     *
     * @param x: The x value of the point.
     * @param y: The y value of the point.
     * @param z: The z value of the point.
     * @param max: The maximum weight of the point.
     * @return double: Returns the weight of the point.
     */
    @Override
    public double getWeight(int x, int y, int z, int max) {
        double weight = max - (Math.abs(Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y) + (this.z - z) * (this.z - z))) * (max / size));
        return weight <= 0 ? 0 : weight;
    }

}
