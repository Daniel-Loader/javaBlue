package gameLogic.monsters;

import java.util.*;

public abstract class Element {
    private final int healthClass;
    private final int damageClass;
    private final int accuracyClass;
    private final int speedClass;

    protected ArrayList<Move> typeMoveList;

    private final double[][] interactionMatrix = new double[][]{
                    //Fire  Earth Elec Water Wood
        /* Fire */     {1, 2, 2, 0.5, 0.5},
        /* Earth */    {0.5, 1, 2, 2, 0.5},
        /* Elec */     {0.5, 0.5, 1, 2, 2},
        /* Water */    {2, 0.5, 0.5, 1, 2},
        /* Wood */     {2, 2, 0.5, 0.5, 1},
    };

    public double getMatchUp(String typeAttacking, String typeDefending){
        Map<String, Integer> typeMap = new HashMap<>() {{
            put("Fire", 0);
            put("Earth", 1);
            put("Electricity", 2);
            put("Water", 3);
            put("Wood", 4);
        }};
        return interactionMatrix[typeMap.get(typeAttacking)][typeMap.get(typeDefending)];
    }

    public Element(){
        this.healthClass = 3;
        this.damageClass = 3;
        this.accuracyClass = 3;
        this.speedClass = 3;
    }
    public Element(int healthClass, int damageClass, int accuracyClass, int speedClass){
        this.healthClass = healthClass;
        this.damageClass = damageClass;
        this.accuracyClass = accuracyClass;
        this.speedClass = speedClass;
    }


    @Override
    public String toString() {
        return "Abstract type";
    }

    public int getHealthClass() {return healthClass;}
    public int getDamageClass() {return damageClass;}
    public int getAccuracyClass() {return accuracyClass;}
    public int getSpeedClass() {return speedClass;}

}

class Earth extends Element {
    public Earth() { super(5, 3, 4, 1); }
}

class Electric extends Element {

    Map<String, Move> typeMoveList = new TreeMap<>(){};
    /**
    public Electric(Move whichNormal){
        super(1,  5, 2, 5);
        this.typeMoveList.put("SpecialAttack", new ElectricAttack());
        this.typeMoveList.put("SpecialMove", new ElectricSpecial());
        this.typeMoveList.put("NormalAttack", whichNormal);
    }*/


    public Map<String, Move> getTypeMoveList() {
        return typeMoveList;
    }
    public Move getMove(String moveType) {
        try {
            if (Set.of("SpecialAttack", "SpecialMove", "NormalAttack").contains(moveType)) {
                return typeMoveList.get(moveType);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}

class Fire extends Element {
    public Fire(){ super(2,  5, 4, 2); }
}

class Water extends Element {
    public Water(){ super(2, 3, 4, 4); }
}

class Wood extends Element {
    private Wood(){ super(4, 4, 3, 2); }
}