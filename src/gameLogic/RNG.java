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
    public static Double GenerateNumber() {
        return rng.random.nextDouble();
    }

    /**
     * Handles player input by presenting a list of options to choose from.
     *
     * @param options A List of strings containing the options for the player to choose from.
     * @param actions A Function<Integer, Void> that carries out the player's chosen action.
     */
    public static void handleInput(List<String> options, Function<Integer, Void> actions) {

        Scanner scanner = new Scanner(System.in);

        // Display available options to the player
        System.out.println("Choose an option:");
        for (int i = 0; i < options.size(); i++) {
            System.out.println(i + " - " + options.get(i));
        }

        // Read player input
        int selectedOption;
        do {
            System.out.print("Enter the number corresponding to your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            selectedOption = scanner.nextInt();
        } while (selectedOption < 0 || selectedOption >= actions.size());

        // Call the corresponding action function based on the player's choice
        Function<Integer, Void> chosenAction = actions.get(selectedOption);
        chosenAction.apply(selectedOption);

        scanner.close();
    }

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