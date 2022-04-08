package Enviroment.Monsters.Type;

import java.util.*;

public abstract class Type {

    private final int healthClass;
    private final int damageClass;
    private final int accuracyClass;
    private final int speedClass;


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

    public Type(){
        this.healthClass = 3;
        this.damageClass = 3;
        this.accuracyClass = 3;
        this.speedClass = 3;
    }
    public Type(int healthClass, int damageClass, int accuracyClass, int speedClass){
        this.healthClass = healthClass;
        this.damageClass = damageClass;
        this.accuracyClass = accuracyClass;
        this.speedClass = speedClass;
    }


    @Override
    public String toString() {
        return "Abstract Type";
    }

    public int getHealthClass() {return healthClass;}
    public int getDamageClass() {return damageClass;}
    public int getAccuracyClass() {return accuracyClass;}
    public int getSpeedClass() {return speedClass;}

}
