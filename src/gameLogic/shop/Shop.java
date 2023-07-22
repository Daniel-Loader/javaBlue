package gameLogic.shop;

import static java.lang.Math.pow;

public class Shop {
    public static int getPurchasePrice(int rarity, int level) {
        return (int) (10 * pow((rarity + 1), 2) * pow(level, 2));
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