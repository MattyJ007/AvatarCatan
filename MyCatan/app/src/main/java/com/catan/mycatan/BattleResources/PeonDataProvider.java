package com.catan.mycatan.BattleResources;
import com.catan.mycatan.Unit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeonDataProvider {

    public static List<Unit> unitList = new ArrayList<>();
    public static Map<String, Unit> unitMap = new HashMap<>();
    static {
        addProduct("apprentice3",
                "A Fire", "Basic Fire Bender Unit. Minimum Requirement is an Fire Bender Village.",1, 1, 0, 2, 20, 1, 1,4 );
        addProduct("apprentice4", "A Earth",
                "Basic Earth Bender Unit. Minimum Requirement is an Earth Bender Village.",3, 1, 0, 2, 20, 1, 1,4 );
        addProduct("apprentice1",
                "A Air",
                "Basic Air Bender Unit. Minimum Requirement is an Air Bender Village.",4, 1, 0, 3, 20, 1, 1,4 );
        addProduct("apprentice2",
                "A Water",
                "Basic Water Bender Unit. Minimum Requirement is an Water Bender Village.",2, 1, 0, 3, 20, 1, 1,4 );
        addProduct("master1","M Air", "Advanced Air Bender Unit. Minimum Requirement is an Air Bender Town.",8, 3, 0, 4, 30, 5, 2, 9 );
        addProduct("master4","M Earth", "Advanced Earth Bender Unit. Minimum Requirement is an Earth Bender Town.",7, 3, 0, 3, 35, 2, 2, 9 );
        addProduct("master3","M Fire", "Advanced Fire Bender Unit. Minimum Requirement is an Fire Bender Town.",5, 1, 1, 5, 30, 2, 2, 9 );
        addProduct("master2","M Water", "Advanced Water Bender Unit. Minimum Requirement is an Water Bender Town.",6, 3, 0, 4, 30, 3, 3, 9 );
        addProduct("spirit", "Spirit", "Require Spirit defender card or the presence of a spirit portal in a settlement. \n\nSentient beings from the spirit world with powers far greater than regular benders",15, 4, 0, 8, 30, 4, 2, 0 );

    }

    public static void addProduct(String unitId, String name,String description, int type,float attack1, float attack2, int intellect,float life,float evasion,
                                     int numAtts, int price ) {
        Unit item = new Unit(unitId, name, description, type,attack1,attack2,intellect,life,evasion,numAtts,price);
        unitList.add(item);
        unitMap.put(unitId, item);
    }

    public static List<String> getUnitNames() {
        List<String> list = new ArrayList<>();
        for (Unit unit : unitList) {
            list.add(unit.getName());
        }
        return list;
    }

    public static List<Unit> getFilteredList(String searchString) {

        List<Unit> filteredList = new ArrayList<>();
        for (Unit product : unitList) {
            if (product.getUnitId().contains(searchString)) {
                filteredList.add(product);
            }
        }
        return filteredList;
    }
}