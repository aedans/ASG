package acklib.utils.random;

import java.util.Random;

/**
 * Created by Aedan Smith on 5/13/2016.
 * <p>
 * A static random class that has several functions to assist with weighted randomness.
 */

public class WeightedRandom {

    /*
       WeightedRandom is a static class. Do not construct it.
     */
    private WeightedRandom() {
    }

    /**
     * Resets the Random to reduce patterns in random generation.
     *
     * @return random: Returns the Random that random was set to.
     */
    public static Random resetRandom() {
        return SmartRandom.resetRandom();
    }

    /**
     * Sets the random to a given Random.
     *
     * @param random: The Random to set the random to.
     */
    public static void setRandom(Random random) {
        SmartRandom.setRandom(random);
    }

    /**
     * Sets the random's seed to the System's time in nanoseconds. Used to reduce
     * patterns in random generation.
     */
    public static void resetSeed() {
        SmartRandom.resetSeed();
    }

    /**
     * Sets the random's seed to a given seed. Used to reduce patterns in random
     * generation.
     *
     * @param seed: The long to set the random's seed to.
     */
    public static void setSeed(long seed) {
        SmartRandom.setSeed(seed);
    }

    /**
     * Returns a random element from an int[], where the chance of returning a given
     * int is (int/intsTotal). Ex: getWeightedRandom(new int[]{4, 5, 10}) will return
     * 1 4/19 times, 2 5/19 times, and 3 10/19 times.
     *
     * @param weights: An int[] of any size.
     * @return int: Returns the selected element.
     */
    public static int getWeightedRandom(int[] weights) {
        // Gets the total value of the weights
        int totalWeight = 0;
        for (int weight : weights)
            totalWeight += weight;

        // Selects a random int within the weight's bounds
        int randInt = SmartRandom.nextInt(totalWeight);

        // Gets the element that the random int lays in
        for (int i = 0; i < weights.length; i++) {
            randInt -= weights[i];
            if (randInt < 0)
                return i;
        }

        // Default case, should never execute.
        return -1;
    }

    /**
     * Returns either true or false given the weight of each, where the chance of
     * returning true is trueWeight/(trueWeight+falseWeight) and the chance of
     * returning false is falseWeight/(trueWeight+falseWeight).
     * Ex: getWeightedBoolean(9, 1) would return true 9/10 times and false 1/10 times.
     * <p>
     * Runs faster than getWeightedRandom(new int[]{trueWeight, falseWeight}).
     *
     * @param trueWeight:  Integer weight of any size.
     * @param falseWeight: Integer weight of any size.
     * @return boolean: Returns a random boolean given the true and false weights.
     */
    public static boolean getWeightedBoolean(int trueWeight, int falseWeight) {
        // Gets the total value of the weights
        int totalWeight = trueWeight + falseWeight;

        // Selects a random int within the weight's bounds
        int randInt = SmartRandom.nextInt(totalWeight);

        // Returns if the random int is within the true or false bounds
        return !(randInt >= trueWeight);
    }

}
