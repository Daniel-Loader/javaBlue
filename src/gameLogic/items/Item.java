package gameLogic.items;

// Item.java - Abstract class representing the base Item
public abstract class Item {
    private String name;
    private String description;
    private ItemType type;
    private int rarity;
    private int value;

    public Item(String name, String description, ItemType type, int rarity, int value) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.rarity = rarity;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ItemType getType() {
        return type;
    }

    public int getRarity() {
        return rarity;
    }

    public int getValue() {
        return value;
    }

    public abstract boolean isUsable();

    public abstract void applyEffect();

    // Other common methods and attributes for items...
}

// ItemType.java - Enum representing the types of items
public enum ItemType {
    BATTLE, PET, CONSUMABLE, WEARABLE, WIELDABLE;
}

// BattleItem.java - Interface for items used in battles
public interface BattleItem {
    // Methods specific to battle items
}

// PetItem.java - Interface for items used in pet interactions
public interface PetItem {
    // Methods specific to pet items
}

// Consumable.java - Interface for items that can be consumed
public interface Consumable {
    void consume();
    // Other methods specific to consumable items...
}

// Wearable.java - Interface for items that can be worn
public interface Wearable {
    void wear();
    // Other methods specific to wearable items...
}

// Wieldable.java - Interface for items that can be wielded
public interface Wieldable {
    void wield();
    // Other methods specific to wieldable items...
}