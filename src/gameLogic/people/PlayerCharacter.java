package gameLogic.people;

import gameLogic.items.Item;
import gameLogic.monsters.Monster;

public class PlayerCharacter {
    private String name;

    /* TODO
     *  get money
     *  experience
     *  party management (eg apply items, rename, view monster stats, change order)
     *  item management (use item?)
     */
    private String playerName;
    private int money;
    private int experience;
    private CurrentParty party;
    private PlayerItems items;

    public PlayerCharacter() {
        this.playerName = "playerName";
        this.money = 500;
        this.experience = 0;
        this.party = new CurrentParty();
        this.items = new PlayerItems();
    }

    public CurrentParty getParty() {
        return party;
    }
    public void setParty(CurrentParty party) {
        this.party = party;
    }
    public void addMonster(Monster monster) {this.party.addMonster(monster);}

    public PlayerItems getItems() {
        return items;
    }
    public void setItems(PlayerItems items) {
        this.items = items;
    }
    public void addItem(Item item) {this.items.addItem(item);}


    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public void addMoney(int money) {this.money+= money;}

    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public void addExperience(int experience) {this.experience+= experience;}

    @Override
    public String toString() {
        return "PlayerCharacter{" +
                "playerName='" + playerName + '\'' +
                ", money=" + money +
                ", experience=" + experience +
                ", party=" + party +
                ", items=" + items +
                '}';
    }
}