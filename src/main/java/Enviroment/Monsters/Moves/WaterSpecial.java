package Enviroment.Monsters.Moves;

import Enviroment.Monsters.Monster;

/**
 * A water type move that wets the floor of the arena, increasing the accuracy of
 * the monster that uses it and lowering the accuracy of the enemy monster, if it
 * has type advantage.
 * @author Daniel Loader
 * @version 1.1 08/04/2022
 */
public class WaterSpecial implements Move{
    private Monster monster;

    public WaterSpecial() {}
    public WaterSpecial(Monster monster) { this.monster = monster; }
    //Daniel


    @Override
    public String toString() {
        String returnString = new String();
        try {
            returnString = String.format("%s uses Splash!", this.monster.getName());
        } catch (Exception e) {
            e.printStackTrace();
            returnString = "Unnamed monster splashes the ground with water!";
        } finally {
            return returnString;
        }
    }

}
