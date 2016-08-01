package acklib.utils.random;

/**
 * Created by Aedan Smith on 5/15/2016.
 *
 * A static random class that has several functions to assist with randomizing
 * distributions.
 */

public class DistributionRandom {

    /**
     * Randomizes a 1-dimensional distribution.
     *
     * @param randoms: The 1-dimensional distribution to randomize.
     * @param variance: The amount that a given int will vary from the original.
     * @return int[]: The randomized distribution.
     */
    public static int[] randomize1dDistribution(int[] randoms, int variance) {
        for (int i = 0; i < randoms.length; i++) {
            randoms[i] = SmartRandom.nextInt(randoms[i] - variance, randoms[i] + variance);
        }
        return randoms;
    }

    /**
     * Randomizes a 2-dimensional distribution.
     *
     * @param randoms: The 2-dimensional distribution to randomize.
     * @param variance: The amount that a given int will vary from the original.
     * @return int[]: The randomized distribution.
     */
    public static int[][] randomize2dDistribution(int[][] randoms, int variance) {
        for (int i = 0; i < randoms.length; i++) {
            for (int j = 0; j < randoms[i].length; j++) {
                randoms[i][j] = SmartRandom.nextInt(randoms[i][j] - variance, randoms[i][j] + variance);
            }
        }
        return randoms;
    }

    /**
     * Randomizes a 3-dimensional distribution.
     *
     * @param randoms: The 3-dimensional distribution to randomize.
     * @param variance: The amount that a given int will vary from the original.
     * @return int[]: The randomized distribution.
     */
    public static int[][][] randomize3dDistribution(int[][][] randoms, int variance) {
        for (int i = 0; i < randoms.length; i++) {
            for (int j = 0; j < randoms[i].length; j++) {
                for (int k = 0; k < randoms[i][j].length; k++) {
                    randoms[i][j][k] = SmartRandom.nextInt(randoms[i][j][k] - variance,randoms[i][j][k] + variance);
                }
            }
        }
        return randoms;
    }

    /*
        DistributionRandom is a static class. Do not construct it.
     */
    private DistributionRandom(){}

}