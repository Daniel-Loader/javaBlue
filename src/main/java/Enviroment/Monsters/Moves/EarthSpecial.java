package Enviroment.Monsters.Moves;

import Enviroment.Monsters.Monster;
import Enviroment.Monsters.Type.Earth;

/** an earth type move that reduces the opponent's speed by 5%, or 10%
 * and may make them unable to attack opponents using ranged attacks.
 * @author Daniel Loader
 * @version 1.1 07/04/2022
 */
public class EarthSpecial implements Move{
    private static final Earth type = new Earth();
    private Monster monster;

    public EarthSpecial() {}
    public EarthSpecial(Monster monster) { this.monster = monster; }

    @Override
    public String toString() {
        String returnString = new String();
        try {
            returnString = String.format("%s uses Bury!", this.monster.getName());
        } catch (Exception e) {
            e.printStackTrace();
            returnString = "Unnamed monster covers you in dirt!";
        } finally {
            return returnString;
        }
    }
}
