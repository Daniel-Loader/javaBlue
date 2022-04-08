package Enviroment.Monsters.Moves;

import Enviroment.Monsters.Type.Normal;
import Enviroment.Monsters.Type.Type;

public class TestAttack implements Move{
    private int damage;
    private Type type;
    private int accuracy;

    public TestAttack(){
        this.damage = 10;
        this.type = new Normal();
        this.accuracy = 90;
    }

    public int getDamage() {return damage;}
    public Type getType() {return type;}
    public int getAccuracy() {return accuracy;}
}
