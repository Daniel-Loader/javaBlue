package Enviroment.Monsters;

import Enviroment.Monsters.Moves.Normal1;
import Enviroment.Monsters.Moves.WaterAttack;
import Enviroment.Monsters.Moves.WaterSpecial;
import Enviroment.Monsters.Type.Water;
import Enviroment.Shop.Shop;

/**
 * The strongest of Water's original monsters, Leviaswims are reclusive and very aggressive when
 * intruded upon giving them an unearned reputation as ruthless killers, they possess extremely
 * high speed for a Water type, as well as Water's characteristic med-high accuracy, and med-low
 * health. Leviaswims are a loyal companion to those who manage to tame it.
 *
 * Wishlist; Give Leviaswim a radioactive decay shaped probability of leaving each night.
 * @author Daniel Loader
 * @version 1.1 08/04/2022
 */
public class WaterDaniel1 extends Monster{

    WaterDaniel1() {
        this.setName("Leviaswim");
        this.setSpecies("Leviaswim");
        this.setType(new Water());
        this.setRarity(2);
        this.setLevel(5);
        this.setPurchasePrice(Shop.getPurchasePrice(2, 5));
    }

    public WaterDaniel1(String name) {
        this.setName(name);
        this.setSpecies("Leviaswim");
        this.setType(new Water());
        this.setRarity(2);
        this.setLevel(5);
        this.setPurchasePrice(Shop.getPurchasePrice(2, 5));
        this.setNormalAttack(new Normal1(this));
        this.setSpecialAttack(new WaterAttack(this));
        this.setSpecialAbility(new WaterSpecial(this));


    }

    @Override
    public void setLevel(int level) {
        super.setLevel(level);
        this.setPurchasePrice(Shop.getPurchasePrice(2, level));
        this.setMaxHealth((int) level);
        this.setCurrentHealth(this.getMaxHealth());
        this.setDamageModifier((int) (1.5 * level));
        this.setSpeed((int) (2.5 * level) + 5);
        this.setAccuracyModifier((int) (0.1*level + 85));
    }

    public String toString() {
        String returnString = String.format("%s is a rare and elusive %s. ", this.getName(), this.getSpecies());
        returnString += super.toString();
        returnString += "\nTotal = " + (this.getMaxHealth() + this.getDamageModifier() + this.getSpeed() + this.getAccuracyModifier());
        return returnString;
    }

    public static void main(String[] args) {
        WaterDaniel1 kaa = new WaterDaniel1("Kaa");
        System.out.println(kaa);
        for (int i = 10; i < 101; i += 5) {
            kaa.setLevel(i);
            System.out.println(kaa);
        }
    }
}

