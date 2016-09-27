package com.catan.mycatan.BattleResources;

import com.catan.mycatan.Unit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class attTempListStorage {
    public static List<Unit> getAttUnitList() {
        return attUnitList;
    }

    public static ArrayList<String> getAttTeamNames() {
        return attTeamNames;
    }

    public static ArrayList<String> getAttTeamId() {
        return attTeamId;
    }

    public static List<Unit> attUnitList = new ArrayList<>();
    public static Map<String, Unit> attUnitMap = new HashMap<>();
    public static ArrayList<String> attTeamId = new ArrayList<>();
    public static ArrayList<String> attTeamNames = new ArrayList<>();

    public static void addDefUnit(String unitId, String name,String description, int type,float attack1, float attack2, int intellect,float life,double evasion,
                                  int numAtts, int price ) {
        Unit item = new Unit(unitId, name, description, type,attack1,attack2,intellect,life,evasion,numAtts,price);
        attUnitList.add(item);
        attUnitMap.put(unitId, item);
    }
}
