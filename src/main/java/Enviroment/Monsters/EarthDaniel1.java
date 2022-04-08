package Enviroment.Monsters;

import Enviroment.Monsters.Moves.EarthSpecial;
import Enviroment.Monsters.Moves.Normal1;
import Enviroment.Monsters.Moves.EarthAttack;
import Enviroment.Monsters.Type.Earth;
import Enviroment.Shop.Shop;

/**
 * The strongest of Earth's original monsters, the elephant is remarkable durable, even from a young age,
 * grows to enormous size; Its considerate nature and deliberate movements conceal a potential for devastation.
 * It is Earth to a tee with High health, low speed and relatively-high accuracy
 * @author Daniel Loader
 * @version 1.1 07/04/2022
 */
public class EarthDaniel1 extends Monster{

    EarthDaniel1() {
        this.setName("Loxodonta");
        this.setSpecies("Loxodonta");
        this.setType(new Earth());
        this.setRarity(2);
        this.setLevel(5);
        this.setPurchasePrice(Shop.getPurchasePrice(2, 5));
    }

    public EarthDaniel1(String name) {
        this.setName(name);
        this.setSpecies("Loxodonta");
        this.setType(new Earth());
        this.setRarity(2);
        this.setLevel(5);
        this.setPurchasePrice(Shop.getPurchasePrice(2, 5));
        this.setNormalAttack(new Normal1(this));
        this.setSpecialAttack(new EarthAttack(this));
        this.setSpecialAbility(new EarthSpecial(this));


    }

    @Override
    public void setLevel(int level) {
        super.setLevel(level);
        this.setPurchasePrice(Shop.getPurchasePrice(2, level));
        this.setMaxHealth((int) ((2.5 * level) + 5));
        this.setCurrentHealth(this.getMaxHealth());
        this.setDamageModifier((int) (1.5 * level));
        this.setSpeed((int) (0.5 * level));
        this.setAccuracyModifier((int) (0.1*level + 85));
    }

    public String toString() {
        String returnString = String.format("%s is a rare and challenging %s. ", this.getName(), this.getSpecies());
        returnString += super.toString();
        returnString += "\nTotal = " + (this.getMaxHealth() + this.getDamageModifier() + this.getSpeed() + this.getAccuracyModifier());
        return returnString;
    }

    public static void main(String[] args) {
        EarthDaniel1 henry = new EarthDaniel1("Henry");
        System.out.println(henry);
        for (int i = 10; i < 101; i += 5) {
            henry.setLevel(i);
            System.out.println(henry);
        }
    }


}
