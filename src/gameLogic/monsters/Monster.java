package gameLogic.monsters;

import java.util.ArrayList;

public abstract class Monster {
    // init stuff
    private String name;
    private String species;
    private Element element;
    private int rarity;
    private int level;
    // health
    private int maxHealth;
    private int currentHealth;
    private int baseHeal;
    // base stats (low, low-med, med, med-high, high)
    private int damageModifier;
    private int accuracyModifier;
    private int speed;
    private int purchasePrice;
    // individualization
    private Move specialAttack;
    private Move SpecialAbility;
    private Move normalAttack;
    private ArrayList<Status> statuses;

    /*
    * Default constructor, for testing purposes only
    */
    public Monster() {
        this.name = "TestName";
        this.species = "TestSpecies";
        //this.element = new Normal();
        this.rarity = 1;
        this.level = 0;
        this.maxHealth = 100;
        this.currentHealth = maxHealth;
        this.purchasePrice = 50;
        this.damageModifier = 1; //multiply damage by modifier for final damage
        this.accuracyModifier = 0; //add accuracy modifier for final accuracy
        this.speed = 5;
        this.purchasePrice = 100;
    }


    public Monster(String name, String species, Element element, int level,
                   int maxHealth, int dmg, int accuracy, int speed) {
        this.name = name;
        this.species = species;
        this.element = element;
        this.level = level;

        this.maxHealth = maxHealth + (20  * this.level); // TODO * type.getHealthClass()
        this.currentHealth = maxHealth;
        this.baseHeal = maxHealth / 4;

        this.damageModifier = dmg + (20 * this.level); // TODO * type.getDmgClass
        this.accuracyModifier = accuracy; // TODO * type.getAccClass
        this.speed = speed + (2 * this.level); // TODO * type.getSpeedClass


    }


    public Move getSpecialAttack() {
        return specialAttack;
    }
    public void setSpecialAttack(Move specialAttack) {
        this.specialAttack = specialAttack;
    }

    public Move getSpecialAbility() {
        return SpecialAbility;
    }
    public void setSpecialAbility(Move specialAbility) {
        SpecialAbility = specialAbility;
    }

    public Move getNormalAttack() {
        return normalAttack;
    }
    public void setNormalAttack(Move normalAttack) {
        this.normalAttack = normalAttack;
    }

    public Element getType() {
        return element;
    }
    public void setType(Element element) {
        this.element = element;
    }

    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void addLevel(int level) { this.level += level;}

    public int getMaxHealth() {
        return maxHealth;
    }
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getBaseHeal() {
        return baseHeal;
    }
    public void setBaseHeal(int baseHeal) {
        this.baseHeal = baseHeal;
    }

    public int getDamageModifier() {
        return damageModifier;
    }
    public void setDamageModifier(int damageModifier) {
        this.damageModifier = damageModifier;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }

    public ArrayList<Status> getStatuses() {
        return statuses;
    }
    public void setStatuses(ArrayList<Status> statuses) {
        this.statuses = statuses;
    }

    public int getAccuracyModifier() {
        return accuracyModifier;
    }
    public void setAccuracyModifier(int accuracyModifier) {
        this.accuracyModifier = accuracyModifier;
    }

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }
    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getRarity() {return  rarity;}
    public void setRarity(int rarity) {this.rarity = rarity;}

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", type=" + element +
                ", currentHealth=" + currentHealth +
                ", purchasePrice=" + purchasePrice +
                ", specialAttack=" + specialAttack +
                ", SpecialAbility=" + SpecialAbility +
                ", normalAttack=" + normalAttack +
                '}';
    }
}