package gameLogic.shop;

import gameLogic.monsters.Monster;
import gameLogic.items.Item;

import static java.lang.Math.pow;

public class Shop {
    private Static List<Shop> instances = new ArrayList<Shop>();
    private Static List<Monster> allMonsters = Monster.getAll();
    private Static List<Item> items = Item.getAll();

    private final String[] description;
    private final List<Monster> monsters = new ArrayList<Item>();
    private final List<Item> items = new ArrayList<Item>();

    /**
      *returns the cost to buy a monster or item of the given level and rarity.
      *
      * 
      *
      */
    private static int getPurchasePrice(int rarity, int level) {
        return (int) (10 * pow((level + 1), rarity));
    }

    public Shop(String inside, String outside);

    public void offerWares() {
        System.out.Println(description[2])
        
    }
    /* TODO
    *   purchasing
    *   selling
    *   monsters
    *   items
    *   shop rarity level
    *   generate monsters / items
    *   */
}