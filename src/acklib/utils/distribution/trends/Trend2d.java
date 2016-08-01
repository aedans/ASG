package acklib.utils.distribution.trends;

/**
 * @author hacke
 *
 * Trend in a two-dimensional space
 */
public class Trend2d extends AbstractTrend {
    /**
     * @param x x position in graph
     * @param y y position in graph
     * @param max maximum value of trend
     */
    public Trend2d(int x, int y, int max) {
        super(max, x, y);
    }

    /**
     * Returns the height of the graph according to this trend
     *
     * @param x x position in graph
     * @param y y position in graph
     * @return height at position in graph
     */
    public double getHeightAt(int x, int y){
        return super.getHeightAt(x, y);
    }
}
