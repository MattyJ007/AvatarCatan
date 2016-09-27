package com.catan.mycatan.BattleResources;

import android.view.View;

import com.catan.mycatan.Unit;

import java.util.ArrayList;

public class GetDefenseUnitList {
    
    private static int countA1 = 1;
    private static int countW1 = 1;
    private static int countF1 = 1;
    private static int countE1 = 1;
    private static int countA = 1;
    private static int countW = 1;
    private static int countF = 1;
    private static int countE = 1;
    private static int countS = 1;
    

    public static ArrayList<String> getDefTeamNames(){
        return defTempListStorage.defTeamNames;
    }


    public static void resetDefTeam(){
        defTempListStorage.defTeamId.clear();
        defTempListStorage.defTeamNames.clear();
        defTempListStorage.defUnitMap.clear();
        defTempListStorage.defUnitList.clear();
    }

    public static void getDefenseUnitList(Unit defUnit, View view){
        String defUname ="";
        String defUId="";
        double defEvasion =0;
        if (defUnit.getUnitId().equals("apprentice1")){
            defUname = defUnit.getName()+"_D_"+countA;
            defEvasion = defUnit.getEvasion() + InSettlement.getSettlement();
            countA+=1;
        } else if (defUnit.getUnitId().equals("apprentice2")){
            defUname = defUnit.getName()+"_D_"+countW;
            defEvasion = defUnit.getEvasion() + InSettlement.getSettlement();
            countW+=1;
        } else if (defUnit.getUnitId().equals("apprentice3")){
            defUname = defUnit.getName()+"_D_"+countF;
            defEvasion = defUnit.getEvasion() + InSettlement.getSettlement();
            countF+=1;
        }else if (defUnit.getUnitId().equals("apprentice4")){
            defUname = defUnit.getName()+"_D_"+countE;
            defEvasion = defUnit.getEvasion() + InSettlement.getSettlement();
            countE+=1;
        }else if (defUnit.getUnitId().equals("master1")){
            defUname = defUnit.getName()+"_D_"+countA1;
            defEvasion = defUnit.getEvasion() + InSettlement.getSettlement();
            countA1+=1;
        }else if (defUnit.getUnitId().equals("master2")){
            defUname = defUnit.getName()+"_D_"+countW1;
            defEvasion = defUnit.getEvasion() + InSettlement.getSettlement();
            countW1+=1;
        }else if (defUnit.getUnitId().equals("master3")){
            defUname = defUnit.getName()+"_D_"+countF1;
            defEvasion = defUnit.getEvasion() + InSettlement.getSettlement();
            countF1+=1;
        }else if (defUnit.getUnitId().equals("master4")){
            defUname = defUnit.getName()+"_D_"+countE1;
            defEvasion = defUnit.getEvasion() + InSettlement.getSettlement();
            countE1+=1;
        }else if (defUnit.getUnitId().equals("spirit")){
            defUname = defUnit.getName()+"_D_"+countS;
            defEvasion = defUnit.getEvasion() + InSettlement.getSettlement();
            countS+=1;
        }
        System.out.println(defUnit.getEvasion());
        System.out.println(InSettlement.getSettlement());
        System.out.println(defUname + " def " + defEvasion);
        defTempListStorage.defTeamNames.add(defUname);
        defTempListStorage.defTeamId.add(defUId);
        defTempListStorage.addDefUnit(defUnit.getUnitId(), defUname, defUnit.getDescription(), defUnit.getTypeInt(), defUnit.getAttack1(), defUnit.getAttack2(), defUnit.getIntellect(), defUnit.getLife(), defEvasion, defUnit.getNumAtts(), defUnit.getPrice());
//        System.out.println(defTempListStorage.defUnitList);
    }
    
    
    
}
