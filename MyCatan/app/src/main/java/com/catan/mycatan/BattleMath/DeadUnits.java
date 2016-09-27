package com.catan.mycatan.BattleMath;

import android.content.Intent;

import com.catan.mycatan.BattleResources.attTempListStorage;
import com.catan.mycatan.BattleResources.defTempListStorage;
import com.catan.mycatan.Unit;
import com.catan.mycatan.Units;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.app.ActivityCompat.startActivity;

public class DeadUnits {

    public static ArrayList<Unit> deadList = new ArrayList<>();

    public static ArrayList<Unit> getDeadList() {
        return deadList;
    }

    public static void addToDeadList(Unit dead) {
        deadList.add(dead);
        if (WhoseTurnIsIt.getTurn() == "defender"){
            List<Unit> defending = attTempListStorage.getAttUnitList();
            int count =0;
            int numUnits =  defending.size();
            for (Unit unit: defending){
                if (deadList.contains(unit)){
                    count+=1;
                }
                else{
                    break;
                }
            }
            if (count == numUnits){
                Intent vIntent = new Intent(BattleGround.returnBattleContext(), Victory.class);
                vIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                BattleGround.returnBattleContext().startActivity(vIntent);
            }
        }
        else {
            List<Unit> attacking = defTempListStorage.getDefUnitList();
            int count =0;
            int numUnits =  attacking.size();
            for (Unit unit: attacking){
                if (deadList.contains(unit)){
                    count+=1;
                }
                else{
                    break;
                }
            }
            if (count == numUnits){
                Intent vIntent = new Intent(BattleGround.returnBattleContext(), Victory.class);
                vIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                BattleGround.returnBattleContext().startActivity(vIntent);
            }
        }
    }
    public static void resetDeadList(){
        deadList.clear();
    }

}
