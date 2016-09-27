package com.catan.mycatan.BattleMath;

import com.catan.mycatan.BattleResources.attTempListStorage;
import com.catan.mycatan.BattleResources.defTempListStorage;
import com.catan.mycatan.Unit;

import java.util.List;

public class WhoseTurnIsIt {

    private static String turn = "attacker";

    public static String getTurn() {
        return turn;
    }

    public static void switchTurns(){
        if (turn.equals("attacker")){
            turn = "defender";
        }
        else{
            turn = "attacker";
        }
    }

    public static boolean availableAttackers(){
        DeadUnits.getDeadList();
        FinishedAttacking.getFinished();
        if (getTurn() == "attacker"){
            int count = 0;
            List<Unit> attacking = attTempListStorage.getAttUnitList();
            for (Unit unit: attacking){
                if (DeadUnits.getDeadList().contains(unit) || FinishedAttacking.getFinished().contains(unit)){
                    count +=1;
                }
            }
            System.out.println("Count " + count + " Size of army " + attacking.size());
            if (count == attacking.size()){
                return false;
            }
            else {
                return true;
            }
        }
        else{
            List<Unit> attacking = defTempListStorage.getDefUnitList();
            int count = 0;
            for (Unit unit: attacking){
                if (DeadUnits.getDeadList().contains(unit) || FinishedAttacking.getFinished().contains(unit)){
                    count +=1;
                }
            }
            System.out.println("Count " + count + " Size of army " + attacking.size());
            if (count == attacking.size()){
                return false;
            }
            else {
                return true;
            }
        }
    }
}
