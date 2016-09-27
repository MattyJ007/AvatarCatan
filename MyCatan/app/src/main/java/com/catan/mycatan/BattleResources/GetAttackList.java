package com.catan.mycatan.BattleResources;

import android.support.design.widget.Snackbar;
import android.view.View;

import com.catan.mycatan.Battle;
import com.catan.mycatan.Unit;

import java.util.ArrayList;


public class GetAttackList {

    public static ArrayList<String> getAttTeamNames(){
        return attTempListStorage.attTeamNames;
    }

    public static void resetAttTeam(){
        attTempListStorage.attUnitList.clear();
        attTempListStorage.attUnitMap.clear();
        attTempListStorage.attTeamId.clear();
        attTempListStorage.attTeamNames.clear();
    }



    public static void getAttackList(Unit attUnit, View view){
        if (attTempListStorage.attTeamId.contains(attUnit.getUnitId())){
            System.out.println("Hero already chosen");
            Snackbar.make(view,attUnit.getName()+" already selected.", Snackbar.LENGTH_SHORT).setAction("Action",null).show();
        }
        else{
            attTempListStorage.addDefUnit(attUnit.getUnitId(),attUnit.getName(), attUnit.getDescription(), attUnit.getTypeInt(), attUnit.getAttack1(), attUnit.getAttack2(), attUnit.getIntellect(), attUnit.getLife(), attUnit.getEvasion(), attUnit.getNumAtts(), attUnit.getPrice());
            attTempListStorage.attTeamId.add(attUnit.getUnitId());
            attTempListStorage.attTeamNames.add(attUnit.getName());
            System.out.println(attTempListStorage.attTeamNames);
            System.out.println(attTempListStorage.attUnitList);
        }

    }
}
