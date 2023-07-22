package gameLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;

public class RandomGenerator {
    private static RandomGenerator rng = new RandomGenerator(0L)
    private Random random;

    private RandomGenerator(Long seed) {
        random = new Random(seed);
    }

    // TODO Write JavaDoc
    public static void setSeed(Long seed) {
        rng.random = new Random(seed);
    }

    /**  
     * returns a pseudo-random number 
     * between 0 and 1.
     * @return random double
     */
    public Double nextDouble() { return random.nextDouble(); }

    public int nextInt() {}

    /**
     * returns at random an element from the given list of elements.
     *
     * @param <T>      the type of elements in the list.
     * @param ts the list of elements to choose from.
     * @return a randomly selected element from the list, or null if the list is empty.
     */
    public static <T> T getRandom(List<T> ts) {
        if (ts.isEmpty()) {
            return null;
        }
        int randomIndex = rng.random.nextInt(complete.size());
        return ts.get(randomIndex);
    }
}