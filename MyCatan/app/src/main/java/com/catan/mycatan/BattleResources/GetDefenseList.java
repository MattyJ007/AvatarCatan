package com.catan.mycatan.BattleResources;

import android.support.design.widget.Snackbar;
import android.view.View;

import com.catan.mycatan.Unit;

import java.util.ArrayList;


public class GetDefenseList {

    public static ArrayList<String> getDefTeamNames(){
        return defTempListStorage.defTeamNames;
    }

    public static void resetDefTeam(){
        defTempListStorage.defUnitList.clear();
        defTempListStorage.defUnitMap.clear();
        defTempListStorage.defTeamId.clear();
        defTempListStorage.defTeamNames.clear();
    }



    public static void getDefenseList(Unit defUnit, View view){
        if (defTempListStorage.defTeamId.contains(defUnit.getUnitId()) || attTempListStorage.attTeamId.contains(defUnit.getUnitId())){
            Snackbar.make(view,defUnit.getName()+" already selected...", Snackbar.LENGTH_LONG).setAction("Action",null).show();
        }
        else{
            defTempListStorage.addDefUnit(defUnit.getUnitId(), defUnit.getName(), defUnit.getDescription(), defUnit.getTypeInt(), defUnit.getAttack1(), defUnit.getAttack2(), defUnit.getIntellect(), defUnit.getLife(), (defUnit.getEvasion()+InSettlement.getSettlement()), defUnit.getNumAtts(), defUnit.getPrice());
            defTempListStorage.defTeamId.add(defUnit.getUnitId());
            defTempListStorage.defTeamNames.add(defUnit.getName());
            System.out.println(defTempListStorage.defTeamNames);
            System.out.println(defTempListStorage.defUnitList);
        }

    }
}
