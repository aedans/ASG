package acklib.utils.distribution.trends;

/**
 * @author hacke
 *
 * Abstract class to represent a trend in a distribution
 */
public abstract class AbstractTrend {
    private int[] position;
    private double max;

    /**
     * @param max maximum allowed value of trend
     * @param position position in the distribution
     */
    public AbstractTrend(double max, int... position) {
        this.position = position;
        this.max = max;
    }

    /**
     * Returns height of a trend at a location in a distribution
     *
     * @param at array representing position in array to find
     * @return height of graph according to trend
     */
    protected double getHeightAt(double... at){
        if(this.position == null || at == null)
            throw new IllegalArgumentException("null parameter");
        else if(this.position.length != at.length)
            throw new IllegalArgumentException("position dimension must be the same as dimension of distribution");
        //normalize vector
        double height = 0;
        for (int i = 0; i < at.length; i++) {
            height += Math.pow((at[i] - this.position[i]), 2);
        }
        height = this.max - Math.sqrt(height);
        return height < 0 ? 0 : height;
    }
}
