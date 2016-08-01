package acklib.utils.distribution;

/**
 * Created by Aedan Smith on 5/15/2016.
 * <p>
 * A static class that has several functions to assist with the generation of
 * integer distributions.
 */

public class Distributions {

    /**
     * Creates a 1-dimensional distribution given a distribution depth, the maximum
     * value, and a list of tends.
     *
     * @param size:  Size of the distribution.
     * @param max:   The maximum value of the distribution.
     * @param tends: A list of 1-dimensional tends.
     * @return int[]: Returns a 1-dimensional integer distribution.
     */
    public static int[] get1dDistribution(int size, int max, Tend[] tends) {
        int[] randoms = new int[size];
        for (int i = 0; i < size; i++)
            randoms[i] = (int) Tend.getWeight(i, max, tends);
        return randoms;
    }

    /**
     * Creates a 2-dimensional distribution given a distribution depth, the maximum
     * value, and a list of tends.
     *
     * @param xSize: Length of the distribution.
     * @param ySize: Width of the distribution.
     * @param max:   The maximum value of the distribution.
     * @param tends: A list of 2-dimensional tends.
     * @return int[][]: Returns a 2-dimensional integer distribution.
     */
    public static int[][] get2dDistribution(int xSize, int ySize, int max, Tend2D[] tends) {
        int[][] randoms = new int[xSize][ySize];
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                randoms[i][j] = (int) Tend2D.getWeight(i, j, max, tends);
            }
        }
        return randoms;
    }

    /**
     * Creates a 3-dimensional distribution given a distribution depth, the maximum
     * value, and a list of tends.
     *
     * @param xSize: Length of the distribution.
     * @param ySize: Width of the distribution.
     * @param zSize: Height of the distribution.
     * @param max:   The maximum value of the distribution.
     * @param tends: A list of 3-dimensional tends.
     * @return int[][]: Returns a 3-dimensional integer distribution.
     */
    public static int[][][] get3dDistribution(int xSize, int ySize, int zSize, int max, Tend3D[] tends) {
        int[][][] randoms = new int[xSize][ySize][zSize];
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                for (int k = 0; k < zSize; k++) {
                    randoms[i][j][k] = (int) Tend3D.getWeight(i, j, k, max, tends);
                }
            }
        }
        return randoms;
    }

    /*
        Distributions is a static class. Do not construct it.
     */
    private Distributions() {
    }

}
