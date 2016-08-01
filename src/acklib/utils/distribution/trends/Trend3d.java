package acklib.utils.distribution.trends;

/**
 * @author hacke
 *
 * Trend for a 3 dimensional space
 */
public class Trend3d extends AbstractTrend {
    /**
     * @param x x position
     * @param y y position
     * @param z z position
     * @param max maximum value of trend
     */
    public Trend3d(int x, int y, int z, int max) {
        super(max, x, y, z);
    }

    /**
     * Returns the height of the graph according to the trend
     *
     * @param x x position
     * @param y y position
     * @param z z position
     * @return the height of the graph at position
     */
    public double getHeightAt(int x, int y, int z){
        return super.getHeightAt(x, y, z);
    }
}
