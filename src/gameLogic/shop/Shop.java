package gameLogic.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Shop {
    private static List<Shop> instances = new ArrayList<>();
    private static List<Monster> allMonsters = Monster.getAll();
    private static List<Item> items = Item.getAll();

    private final String[] description;
    private final RandomGenerator random = RandomGenerator.getInstance();
    private final List<Monster> monsters = new ArrayList<>();
    private final List<Item> shopItems = new ArrayList<>();
    
    /**
     * Constructor for creating a new Shop instance.
     *
     * @param inside  Description of the shop's interior.
     * @param outside Description of the shop's exterior.
     */
    public Shop(String inside, String outside) {
        // Initialize the shop with items, monsters, etc. based on provided parameters
        // You can use the inside and outside descriptions to set up the shop as needed
    }

    /**
     * Initializes the shop by adding items and monsters to the shop's inventory.
     * 25% of the time adds a random number of items to the shop.
     * 50% of the time adds a random number of items and monsters to the shop.
     * Otherwise, adds a random number of monsters to the shop.
     */
    public void initialize() {
        int maxStock = 10;
        int currentStock = (int) (maxStock * RandomGenerator.GenerateNumber());
        Double wares = RandomGenerator.GenerateNumber();
        if (wares < 0.25 && monsters.size() < currentStock) {
            int intial_i = monsters.size();
            for (int i = intial_i; i < currentStock; i++) {
                this.monsters.Add(RandomGenerator.getRandom(Shop.allMonsters))
            }
        } else if (wares < 0.25 && monsters.size() < currentStock || items().size() < currentStock) {
            int intial_i = min(monsters.size(), items.size);
            for (int i = intial_i; i < currentStock; i++) {
                if (monsters.size() < i) {this.monsters.Add(RandomGenerator.getRandom(Shop.allMonsters))}
                if (monsters.size() < i) {this.items.Add(RandomGenerator.getRandom(Shop.allItems))}
            }
        } else {
            int intial_i = items.size();
            for (int i = intial_i; i < currentStock; i++) {
                this.items.Add(RandomGenerator.getRandom(Shop.allItems))
        }
    }

    /**
     * Returns the cost to buy a monster or item of the given level and rarity.
     *
     * @param rarity The rarity level of the monster or item.
     * @param level  The level of the monster or item.
     * @return The cost to buy the monster or item.
     */
    private static int getPurchasePrice(int rarity, int level) {
        return (int) (10 * Math.pow((level + 1), rarity));
    }

    /**
     * Offers items or monsters to the player for purchase.
     *
     * @param p        The player who wants to buy the item or monster.
     * @param elements The list of items or monsters to choose from.
     * @param prices   The array of prices corresponding to the elements.
     * @param toString The function to get the string representation of each element.
     * @param buyItem  The function to buy the selected element and perform any additional actions.
     */
    public <T extends Sellable> void offerT(Player p, List<T> elements, Function<T, Void> buyItem) {
    int[]    prices  = elements.stream().map(t1 -> t1.getPrice()).toArray(int[]::new);
    String[] options = elements.stream().map(t2 -> t2.toString()).toArray(String[]::new);

        System.out.println("Choose an option:");
        for (int i = 0; i < options.length; i++) {
            System.out.println(i + " - " + options[i]);
        }

        int selectedOption;
        do {
            System.out.print("Enter the number corresponding to your choice: ");
            selectedOption = scanner.nextInt();
        } while (selectedOption < 0 || selectedOption >= options.length);

        if (p.getWealth() >= prices[selectedOption]) {
            p.setWealth(p.getWealth() - prices[selectedOption]);
            T selectedItem = elements.get(selectedOption);
            buyItem.apply(selectedItem);
            elements.remove(selectedOption);
        }
    }

    /**
     * Takes the monster the player chose out of monsters and 
     * gives it to the player if they have enough money
     * and subtracts the cost of the monster from their wealth.
     *
     * @param p The player who wants to buy the monster.
     */
    public void offerMonsters(Player p) {
        int[] monsterPrices = new int[monsters.size()];
        String[] monsterStrings = new String[monsters.size()];

        for (int i = 0; i < monsters.size(); i++) {
            Monster monster = monsters.get(i);
            monsterPrices[i] = monster.getPrice();
            monsterStrings[i] = monster.toString();
        }

        List<String> options = monsterStrings.toList()
        Function<int:void> actions = (i) -> {
            if (p.getWealth() >= prices[i]) {
                p.setWeath(()-prices[i]);
                p.addMonster(monsters.get(i)); 
                monsters.remove(i)
            }
    }

    /**
     * Offers items to the player for purchase.
     *
     * @param p The player who wants to buy items.
     */
    public void offerItems(Player p) {
        // Implement the offerItems method logic here
    }

    /**
     * Returns a string representation of the shop.
     *
     * @return The shop's description.
     */
    public String toString() {
        return description[1];
    }

    interface Sellable { int getPrice(); }
}