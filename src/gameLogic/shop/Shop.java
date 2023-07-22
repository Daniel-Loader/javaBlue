package gameLogic.shop;

import gameLogic.RandomGenerator;
import gameLogic.monsters.Monster;
import gameLogic.items.Item;

import static java.lang.Math.pow;

public class Shop {
    private Static List<Shop> instances = new ArrayList<Shop>();
    private Static List<Monster> allMonsters = Monster.getAll();
    private Static List<Item> items = Item.getAll();

    private final String[] description;
    private final RandomGenerator = RandomGenerator.getInstance()
    private final List<Monster> monsters = new ArrayList<Item>();
    private final List<Item> items = new ArrayList<Item>();

    public Shop(String inside, String outside);

    /**
     * 25% of the time adds a random number of items to shop.
     * 50% of the time adds a random number of items and Monsters.
     * Otherwise adds a random number of Monsters to the shop.
     * 
     * 
     */
    private void Initialize() {
        Double wares = RandomGenerator.getRandom();

    /**
     * returns the cost to buy a monster or item of the given level and rarity.
     *
     */
    private static int getPurchasePrice(int rarity, int level) {
        return (int) (10 * pow((level + 1), rarity));
    }


    /**
     * takes the monster the player chose out of monsters and 
     * gives it to the player if they have enough money
     * and subtracts the cost of the monster from their wealth.
     *
     */
    public void offerMonsters(Player p) {
        List<String> options = monsters.toStream().map(m -> m.toString()).toList();
        Function<int:void> actions = (i) -> {if(p.getWealth() < 0) {
            p.addMonster(copyOf(monsters.get(i)); monsters.remove(i)}}
    }

    public void offerItems(Player p) {}

    public String toString() { return description[1]; }

}