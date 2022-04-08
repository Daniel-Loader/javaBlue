package UI.CommandLineInterface;

import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

import Enviroment.WorldState;
import Enviroment.Player.PlayerCharacter;

public class CLIController {
    // main commandline interface class
    private static final Scanner input = new Scanner(System.in);
    private static WorldState world;
    private static PlayerCharacter player;


    public void name(){
        System.out.println("Please enter your name: ");
        String name = input.nextLine();
        if (!(Objects.equals(name, ""))) player.setPlayerName(name);
    }

    public void difficulty() {
        System.out.println("Please select difficulty (0: easy, 1: normal, 2: hard)");
        String userInput = input.nextLine();
        try {
            int difficulty = Integer.parseInt(userInput);
            if (Set.of(0, 1, 2).contains(difficulty)){world.setDifficulty(difficulty);}
            else {
                System.out.printf("\"%s\" is not a supported difficulty \nPlease try again.%n", userInput);
                this.difficulty();
            }
        } catch (Exception e) {
            System.out.printf("\"%s\" is not supported \nPlease try again.%n", userInput);
            this.difficulty();
        }
    }

    public void maxDays() {
        System.out.println("Please enter the desired game length (0 - 15) ");
        String userInput = input.nextLine();
        try {
            int numDays = Integer.parseInt(userInput);
            if (numDays <= 15 && numDays > 0){world.setMaxDays(numDays);}
            else {System.out.println("Not a supported number of days"); this.maxDays();}
        } catch (Exception e) {
            System.out.printf("\"%s\" is not a supported number of days\nPlease try again.%n", userInput);
            this.maxDays();
        }
    }

    public void choice(Command cmd){
        switch (cmd.getMenuChoice()) {
            case "Battle" -> new Battle();
            case "Shop" -> new Shop();
            case "Player" -> new PlayerOptions();
            case "Sleep" -> {world.incrementDay();
                System.out.println("You go to sleep.");
                if (world.getDay() < world.getMaxDays()) {
                    System.out.println("The new day is " + world.getDay() + " out of " + world.getMaxDays() +"\n");
                } else if (world.getDay() == world.getMaxDays()){
                    System.out.println("This is the final day!\n");
                }
            }
            case "Quit" -> {
                System.out.println("Goodbye");
                System.exit(0);
            }
        }
    }






    // Run the game
    public static void main(String[] args) {

        // Start game
        CLIController game = new CLIController();
        MainMenu menu = new MainMenu();
        player = new PlayerCharacter();
        System.out.println("Untitled Goo... Err Monster Game\n -----------------");


        // init
        world = new WorldState(1234);
        game.name();
        game.difficulty();
        game.maxDays();
        // TODO get first monster goes here
        System.out.println(
                "Your name is: " + player.getPlayerName() + "\n" +
                "The difficulty is: " + world.getDiffStr() + "\n" +
                "You have " + player.getMoney() + " coins." + "\n" +
                "You chose <placeholder monster>" + "\n"
        );

        // Main Loop
        while (world.getDay() <= world.getMaxDays()) {

            menu.morningMessage();
            game.choice(menu.getCommand());

        }
        System.out.println("End Screen");
    }
}
