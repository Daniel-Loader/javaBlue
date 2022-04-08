package Enviroment.Monsters.Moves;

import Enviroment.Monsters.Monster;
import Enviroment.Monsters.Type.Normal;
import Enviroment.Monsters.Type.Type;

public class Normal2 implements Move{

    private static final Type type = new Normal();
    private Monster monster;

    public Normal2() {}
    public Normal2(Monster monster) { this.monster = monster; }

    public static Type getType() { return type; }

    @Override
    public String toString() {
        String returnString = new String();
        try {
            returnString = String.format("%s uses Scratch!", this.monster.getName());
        } catch (Exception e) {
            e.printStackTrace();
            returnString = "Unnamed monster Scratches!";
        } finally {
            return returnString;
        }
    }

}
