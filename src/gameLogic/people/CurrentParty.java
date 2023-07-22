package gameLogic.people;

import gameLogic.monsters.Monster;

import java.util.ArrayList;

public class CurrentParty {
    private ArrayList<Monster> party = new ArrayList<>(4);


    public ArrayList<Monster> getParty() {
        return party;
    }
    public void addMonster(Monster monster) {
        try {
            this.party.add(monster);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void removeMonster(Monster monster){
        try {
            this.party.remove(monster);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "CurrentParty{" +
                "party=" + party +
                '}';
    }
}