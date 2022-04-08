package Enviroment.Monsters.Moves;

import Enviroment.Monsters.Monster;
import Enviroment.Monsters.Type.Normal;
import Enviroment.Monsters.Type.Type;

@SuppressWarnings("ReturnInsideFinallyBlock")
public class Normal1 implements Move{

    private static final Type type = new Normal();
    private Monster monster;

    public Normal1() {}
    public Normal1(Monster monster) { this.monster = monster; }

    public static Type getType() { return type; }

    @SuppressWarnings("finally")
    @Override
    public String toString() {
        String returnString = new String();
        try {
            returnString = String.format("%s uses Charge!", this.monster.getName());
        } catch (Exception e) {
            e.printStackTrace();
            returnString = "Unnamed monster Charges!";
        } finally {
            return returnString;
        }
    }

}
