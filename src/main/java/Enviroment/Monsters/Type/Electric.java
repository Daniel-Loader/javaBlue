package Enviroment.Monsters.Type;

import Enviroment.Monsters.Moves.ElectricAttack;
import Enviroment.Monsters.Moves.ElectricSpecial;
import Enviroment.Monsters.Moves.Move;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Electric extends Type{

//    private ArrayList<Move> typeMoveList = new ArrayList<>(3);

    Map<String, Move> typeMoveList = new TreeMap<>(){};

    public Electric(Move whichNormal){
        super(1,  5, 2, 5);
        this.typeMoveList.put("SpecialAttack", new ElectricAttack());
        this.typeMoveList.put("SpecialMove", new ElectricSpecial());
        this.typeMoveList.put("NormalAttack", whichNormal);
    }


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
