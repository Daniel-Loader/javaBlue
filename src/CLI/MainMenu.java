package CLI;


import java.util.Scanner;

/**
 * @author Daniel Loader
 * @ Version 1.1 04/04/2022
 * A command line application for the main menu of Monster Game
 * last editied by Ben Hogan
 */
public class MainMenu {
    private final Scanner sc = new Scanner(System.in);


    /**
     * The default constructor.
     * TODO Prohibit the player from sleeping if they haven't done anything else first.
     */
    public MainMenu() {}

    /**
     * Prints out a list of available commands.
     */
    public void morningMessage() {
        System.out.println("Welcome to the Main Menu.");
        System.out.println("The following commands are available:");
        System.out.println("0 - Open the shop");
        System.out.println("1 - Open the battle selector");
        System.out.println("2 - Open the player menu");
        System.out.println("3 - Sleep; resets the shop and battles.");
        System.out.println("4 - Quit the game");
        }


    public Command getCommand() {
        int cmd = 9; //testing default
        try {
            int cmdTemp = sc.nextInt();
            if (cmdTemp <=4) {cmd = cmdTemp;}
        } catch (Exception e) {
            System.out.printf("There isn't a command for %s yet. \nPlease try another command.%n", cmd);
            this.getCommand();
        }
        switch (cmd) {
            case 0 -> {return new Command(0);}
            case 1 -> {return new Command(1);}
            case 2 -> {return new Command(2);}
            case 3 -> {return new Command(3);}
            case 4 -> {return new Command(4);}
            default -> {System.out.println("How did you get here? Try again.");
                    this.getCommand();}
        }
        return new Command(9);
    }
}