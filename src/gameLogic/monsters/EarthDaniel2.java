package gameLogic.monsters;



/**
 * The weakest of Earth's original monsters, this mole is durable, as one would expect from an earth type.
 * However, its poor eyesight and small size give it relatively low damage and accuracy and like all eath
 * types its speed leaves something to be desired
 * Earth's High health, low speed, med-high accuracy
 */
public class EarthDaniel2 extends Monster{

    EarthDaniel2() {
        super.setName("Terrole");
        super.setSpecies("Terrole");
        super.setType(new Earth());
        super.setRarity(2);
        this.setLevel(5);
        //this.setNormalAttack(new Normal2(this));
        //this.setSpecialAttack(new EarthAttack(this));
        //this.setSpecialAbility(new EarthSpecial(this));
    }

    public EarthDaniel2(String name) {
        super.setName(name);
        super.setSpecies("Terrole");
        super.setType(new Earth());
        super.setRarity(0);
        this.setLevel(5);
    }

    @Override
    public void setLevel(int level) {
        super.setLevel(level);
        this.setMaxHealth((int) ((0.6 * level) + 5));
        this.setCurrentHealth(this.getMaxHealth());
        this.setDamageModifier((int) (0.5 * level));
        this.setSpeed((int) (0.5 * level));
        this.setAccuracyModifier((int) (0.1*level + 85));
    }

    public String toString() {
        String returnString = String.format("%s is a common and frightened %s. ", this.getName(), this.getSpecies());
        returnString += super.toString();
        returnString += "\nTotal = " + (this.getMaxHealth() + this.getDamageModifier() + this.getSpeed() + this.getAccuracyModifier());
        return returnString;
    }

    public static void main(String[] args) {
        EarthDaniel2 fred = new EarthDaniel2("Fred");
        System.out.println(fred);
        for (int i = 10; i < 101; i += 5) {
            fred.setLevel(i);
            System.out.println(fred);
        }
    }
}