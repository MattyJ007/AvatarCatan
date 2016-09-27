package com.catan.mycatan.BattleResources;

import android.view.View;

import com.catan.mycatan.Unit;

import java.util.ArrayList;

public class GetAttackUnitList {
    
    private static int countA1 = 1;
    private static int countW1 = 1;
    private static int countF1 = 1;
    private static int countE1 = 1;
    private static int countA = 1;
    private static int countW = 1;
    private static int countF = 1;
    private static int countE = 1;
    private static int countS = 1;

    public static ArrayList<String> getAttTeamNames(){
        return attTempListStorage.attTeamNames;
    }

    public static void resetAttTeam(){
        attTempListStorage.attTeamId.clear();
        attTempListStorage.attTeamNames.clear();
        attTempListStorage.attUnitMap.clear();
        attTempListStorage.attUnitList.clear();
    }

    public static void getAttackUnitList(Unit attUnit, View view){
        String attUname ="";
        String attUId="";
        if (attUnit.getUnitId().equals("apprentice1")){
            attUname = attUnit.getName()+" "+countA;
            countA+=1;
        } else if (attUnit.getUnitId().equals("apprentice2")){
            attUname = attUnit.getName()+" "+countW;
            countW+=1;
        } else if (attUnit.getUnitId().equals("apprentice3")){
            attUname = attUnit.getName()+" "+countF;
            countF+=1;
        }else if (attUnit.getUnitId().equals("apprentice4")){
            attUname = attUnit.getName()+" "+countE;
            countE+=1;
        }else if (attUnit.getUnitId().equals("master1")){
            attUname = attUnit.getName()+" "+countA1;
            countA1+=1;
        }else if (attUnit.getUnitId().equals("master2")){
            attUname = attUnit.getName()+" "+countW1;
            countW1+=1;
        }else if (attUnit.getUnitId().equals("master3")){
            attUname = attUnit.getName()+" "+countF1;
            countF1+=1;
        }else if (attUnit.getUnitId().equals("master4")){
            attUname = attUnit.getName()+" "+countE1;
            countE1+=1;
        }else if (attUnit.getUnitId().equals("spirit")){
            attUname = attUnit.getName()+" "+countS;
            countS+=1;
        }
        System.out.println(attUname);
        attTempListStorage.attTeamNames.add(attUname);
        attTempListStorage.attTeamId.add(attUId);
        attTempListStorage.addDefUnit(attUId, attUname, attUnit.getDescription(), attUnit.getTypeInt(), attUnit.getAttack1(), attUnit.getAttack2(), attUnit.getIntellect(), attUnit.getLife(), attUnit.getEvasion(), attUnit.getNumAtts(), attUnit.getPrice());
//        System.out.println(attTempListStorage.attUnitList);
    }
    
    
    
}
