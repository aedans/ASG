package acklib.utils.random;

import java.util.Random;
import java.util.stream.Stream;

/**
 * @author hacke
 *         <p>
 *         class to deal with randoms that have a chance of occuring
 *         not a singleton, to discourage singleton usage
 */
public final class ProbabilityRandom {

    /*
     * Random generator for all future values
     */
    private final Random random = new Random(System.nanoTime());

    /**
     * Constructor for ProbabilityRandom, passing in the seed
     *
     * @param seed seed to be used in the generator
     */
    public ProbabilityRandom(final long seed) {
        random.setSeed(seed);
    }

    public ProbabilityRandom() {
    }

    /**
     * Sets the seed of the random generator
     *
     * @param seed seed for the random generator
     */
    public void setSeed(final long seed) {
        random.setSeed(seed);
    }

    /**
     * Returns a boolean where the chance of being true is
     * passed in, 0 being 0% and 1.0 being 100%
     *
     * @param chance value in range [0, 1.0] to represent chance of being true
     * @return a weighted boolean
     */
    public boolean nextWeightedBoolean(final double chance) {
        if (chance > 1 || chance < 0)
            throw new IllegalArgumentException("chance is invalid, must be in range [0, 1.0]");
        return random.nextDouble() <= chance;
    }

    /**
     * Returns a stream of booleans generated by the nextWeightedBoolean method
     * using chance to determine each boolean
     *
     * @param chance value in range [0, 1.0] to represent chance of being true
     * @return a weighted boolean
     */
    public Stream<Boolean> createStream(final double chance) {
        if (chance > 1 || chance < 0)
            throw new IllegalArgumentException("chance is invalid, must be in range [0, 1.0]");
        return Stream.generate(() -> nextWeightedBoolean(chance));
    }

    /**
     * Returns a stream of weighted booleans and limits it to size provided
     *
     * @param chance chance in range [0, 1] that the boolean will be true
     * @param size   resulting size of the stream
     * @return a stream of weighted booleans of size size
     */
    public Stream<Boolean> createStream(final double chance, final long size) {
        return createStream(chance).limit(size);
    }

    @Override
    public String toString() {
        return "ProbabilityRandom{}";
    }
}
