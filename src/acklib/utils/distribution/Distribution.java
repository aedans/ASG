package acklib.utils.distribution;

import acklib.utils.distribution.trends.Trend;
import acklib.utils.distribution.trends.Trend2d;
import acklib.utils.distribution.trends.Trend3d;

/**
 * @author hacke
 *
 * Distribution utility class
 */
public final class Distribution {

    /* Utility class, do not instantiate */
    private Distribution(){}

    /**
     * Creates a one-dimensional distribution
     *
     * @param width width of the distribution
     * @param trends Trend objects, representing trends in data
     * @return an integer array representing the distribution
     */
    public static int[] createDistribution(int width, Trend... trends){
        int[] distribution = new int[width];
        for (int i = 0; i < distribution.length; i++) {
            /* Sum up all the heights of the trends,
            * as there may be multiple overlapping trends */
            double posHeight = 0;
            for (Trend trend : trends) {
                posHeight += trend.getHeightAt(i);
            }
            distribution[i] = (int)posHeight;
        }
        return distribution;
    }

    /**
     * Creates a two-dimensional distribution
     *
     * @param width width of the distribution
     * @param height height of the distribution
     * @param trends Trend2d objects, representing trends in data
     * @return an integer array representing the distribution
     */
    public static int[][] createDistribution(int width, int height, Trend2d... trends){
        int[][] distribution = new int[width][height];
        for (int i = 0; i < distribution.length; i++) {
            for (int j = 0; j < distribution[i].length; j++) {
                /* Sum up all the heights of the trends,
                * as there may be multiple overlapping trends */
                double posHeight = 0;
                for (Trend2d trend : trends) {
                    posHeight += trend.getHeightAt(j, i);
                }
                distribution[i][j] = (int)posHeight;
            }
        }
        return distribution;
    }

    /**
     * Creates a three-dimensional distribution
     *
     * @param width width of the distribution
     * @param height height of the distribution
     * @param depth depth of the distribution
     * @param trends Trend3d objects representing trends in data
     * @return an integer array representing the distribution
     */
    public static int[][][] createDistribution(int width, int height, int depth, Trend3d... trends){
        int[][][] distribution = new int[width][height][depth];
        for (int i = 0; i < distribution.length; i++) {
            for (int j = 0; j < distribution[i].length; j++) {
                for (int k = 0; k < distribution[i][j].length; k++) {
                    /* Sum up all the heights of the overlapping trends */
                    double posHeight = 0;
                    for(Trend3d trend : trends){
                        posHeight += trend.getHeightAt(j, i, k);
                    }
                    distribution[i][j][k] = (int)posHeight;
                }
            }
        }
        return distribution;
    }
}
