package CLI;

public class Command {
    private String menuChoice;

    /*
     * 1: Shop, 2: Battle, 3: Player, 4:Sleep, 5: Quit
     */
    public Command(int cmd){
        switch (cmd){
            case 0 -> this.menuChoice = "Shop";
            case 1 -> this.menuChoice = "Battle";
            case 2 -> this.menuChoice = "Player";
            case 3 -> this.menuChoice = "Sleep";
            case 4 -> this.menuChoice = "Quit";
            case 9 -> this.menuChoice = "TestMenu";
        }
    }
    public String getMenuChoice(){
        return menuChoice;
    }

}