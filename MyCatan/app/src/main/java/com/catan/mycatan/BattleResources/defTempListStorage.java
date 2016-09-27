package com.catan.mycatan.BattleResources;

import com.catan.mycatan.Unit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class defTempListStorage {
    public static List<Unit> defUnitList = new ArrayList<>();
    public static Map<String, Unit> defUnitMap = new HashMap<>();
    public static ArrayList<String> defTeamNames = new ArrayList<>();
    public static ArrayList<String> defTeamId = new ArrayList<>();

    public static List<Unit> getDefUnitList() {
        return defUnitList;
    }



    public static void addDefUnit(String unitId, String name,String description, int type,float attack1, float attack2, int intellect,float life,double evasion,
                                  int numAtts, int price ) {
        Unit item = new Unit(unitId, name, description, type,attack1,attack2,intellect,life,evasion,numAtts,price);
        defUnitList.add(item);
        defUnitMap.put(unitId, item);
    }
}
