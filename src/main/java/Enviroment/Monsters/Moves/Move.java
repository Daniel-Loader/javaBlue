package Enviroment.Monsters.Moves;

import Enviroment.Monsters.Type.Normal;
import Enviroment.Monsters.Type.Type;

public interface Move {

    /* TODO
     *  move type
     *  move name
     *  is special attack
     *  is special type move
     *  is normal move
     *  base damage
     *  base accuracy
     *  modifiers
     *
     */

    default int baseDmg(){return 0;}
    default int baseAcc(){return 75;}



}
