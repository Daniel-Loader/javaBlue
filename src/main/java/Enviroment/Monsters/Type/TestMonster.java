package Enviroment.Monsters.Type;

import Enviroment.Monsters.Monster;

public class TestMonster extends Monster {
    private static final Normal type = new Normal();

    public TestMonster() {
        super("bob", "animal", type, 1, 99);
        this.setAccuracyModifier(95);
    }
}
