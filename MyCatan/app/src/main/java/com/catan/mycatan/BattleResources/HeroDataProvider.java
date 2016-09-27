package com.catan.mycatan.BattleResources;
import com.catan.mycatan.Unit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeroDataProvider {

    public static List<Unit> unitList = new ArrayList<>();
    public static Map<String, Unit> unitMap = new HashMap<>();
    static {
        addProduct("fng", "Fire Nation Guy", "Minimum requirement: An Earth Town.\n\nAbout\n",3, 2, 0, 1, 25, 1, 2, 4);
        addProduct("asami", "Asami", "Minimum requirement: A Town.\n\nAbout:\n", 13, 0, 1, 6, 20, 3, 1, 6 );
        addProduct("hip", "The Hippo", "Minimum requirement: An EarthTown.\n" +
                "\nAbout:\nWrestler", 3, 2, 0, 1, 30, 1, 2, 6 );
        addProduct("theBoulder", "The Boulder", "Minimum requirement: An Earth Town.\n" +
                "\nAbout:\nWrestler", 3, 2, 0, 2, 30, 1, 2, 6 );
        addProduct("jun", "June", " ", 13, 3, 0, 6, 25, 3, 1, 6);
        addProduct("Jet", "Jet", "Minimum requirement: A Town (Except from fire nation towns or if you are are a fire bender).\n" +
                "\nAbout:\n", 13, 2, 0, 7, 25, 3, 2, 7 );
        addProduct("sokka", "Sokka", "Minimum requirement: A Water Village.\n", 13, 2, 0, 8, 25, 3, 2, 7 );
        addProduct("sparky", "Combustion Man", "Minimum requirement: a City.\n" +
                "\nAbout:\n", 9, 0, 3, 2, 5, 4, 1, 7 );
        addProduct("may", "Mai", "Minimum requirement: a City.\n" +
                "\nAbout:\n", 13, 3, 0, 7, 20, 3, 3, 7);
        addProduct("suk", "Suki", "Minimum requirement: A Town.\n" +
                "\nAbout:\n", 13, 3, 0, 7, 25, 4, 2, 8 );
        addProduct("swo", "Sword Master", "Minimum Reqirement: A Village", 13, 4,0, 7, 25, 5, 1,9);
        addProduct("pil", "P'Li", "Minimum requirement: 2 Cities.\nAbout:\n", 9, 0, 3, 3, 10, 3, 1, 9);
        addProduct("pat", "Guru Pathik", "Minimum requirement: An Air Temple.\n" +
                "\nAbout:\n", 13, 2, 0, 8, 25, 7, 2, 9 );
        addProduct("tyl", "Ty Lee", "Minimum requirement: a City.\n" +
                "\nAbout:\n", 16, 0, 2, 7, 15, 5, 1, 10 );
        addProduct("mako", "Mako", "Minimum requirement: a City.\n" +
                "\nAbout:\n" , 5, 1, 1, 5, 30, 3, 2, 10 );
        addProduct("zho", "Admiral Zhou", "Minimum requirement: Holder of 'Kill the Moon Spirit' card.\n" +
                "\nAbout:\nAdmiral in Ozi's army", 1, 0, 2, 4, 35, 1, 1, 10);
        addProduct("huu", "Swamp Monster Huu", "Minimum requirement: the Swamp Village.\n" +
                "\nAbout:\nSwamp dweller", 2, 3, 0, 6, 35, 2, 3, 10 );
        addProduct("lin", "Chief Lin Bei Fong", "Minimum requirement: An Earth City.\n" +
                "\nAbout:\n", 7, 3, 1, 6, 35, 2, 1, 11 );
        addProduct("bolin", "Bolin", "Minimum requirement: a City.\n" +
                "\nAbout:\n", 11, 1, 1, 4, 35, 3, 1, 12 );
        addProduct("katara", "Katara", "Minimum requirement: a Water Village.\n" +
                "\nAbout:\n", 10, 4, 0, 6, 20, 5, 4, 12 );
        addProduct("zuk", "Zuko", "Minimum requirement: A City.\n" +
                "\nAbout:\n", 1, 0, 2, 5, 40, 2, 2, 12);
        addProduct("ten", "Tenzin", "Minimum requirement: An Air Town.\n" +
                "\nAbout:\n", 8, 0, 2, 6, 40, 2, 2, 12);
        addProduct("azu", "Azula", "Minimum requirement: A Fire City.\n" +
                "\nAbout:\n", 5, 1, 2, 9, 30, 4, 1, 13 );
        addProduct("tar", "Tarrlock", "Minimum requirement: 2 Cities.\n" +
                "\nAbout:\nYounger brother of Amon", 17, 0, 3, 6, 20, 2, 1, 13);
        addProduct("top", "Toph", "Minimum requirement: An Earth City.\n" +
                "\nAbout:\n", 7, 0, 2, 7, 35, 3, 2, 13);
        addProduct("ghr", "Gharzan", "\nMinimum requirement: 2 cities\n", 11, 0 ,3,2,25,3,2,14);
        addProduct("jeo", "Master Jeong Jeong", "Minimum requirement: 3 Cities and you are not a fire bender.\n", 1, 4, 2, 8, 25, 3, 3, 14);
        addProduct("pak", "Master Paku", "Minimum requirement: The Northern Water Tribe.\n" +
                "\nAbout:\nAang's Water Bending teacher", 6, 6, 1, 8, 25, 2, 4, 14);
        addProduct("ozi", "Fire Lord Ozai", "Minimum requirement: Control Fire Nation Capital or Fire Lord's Summer Palace and a Fire City.\n" +
                "\nAbout:\n", 5, 0, 3, 5, 35, 2, 2, 15);
        addProduct("boo", "King Bumi", "Minimum requirement: Control Oma Shu.", 3, 2, 2, 8, 40, 3, 2, 15 );
        addProduct("kuv", "Kuvira", "Minimum requirement: 2 Earth Cities.\n" +
                "\nAbout:\n", 7, 0, 3, 9, 30, 4, 3, 16);
        addProduct("gya", "Monk Gyatso", "Minimum requirement: The Southern Air Temple.\n", 8, 10, 0, 8, 15, 4, 8,17);
        addProduct("iro", "Iroh", "Minimum requirement: 3 Cities.About:\n", 5, 2, 3, 9, 40, 3, 2, 19);
        addProduct("amo", "Amon", "Minimum requirement: 4 Cities.\n" +
                "\n" +
                "About:\n", 17, 0, 4, 8, 15, 7, 4, 20);
        addProduct("zah", "Zaheer", "Minimum requirement: Spirit portal open and a city.\n" +
                "\n" +
                "About:\n", 12, 2, 4, 9, 30, 3, 6, 22);
        addProduct("kor", "Korra", "Minimum requirement: All four elements and a city.\n" +
                "\n" +
                "About:\n", 14, 0, 4, 3, 35, 1, 2, 18);
        addProduct("una", "Unalaq", "Minimum requirement: NW Tribe with with Spirit portal cast on it.\n" +
                "\n" +
                "About:\n", 15, 0, 4, 7, 30, 3, 2, 18);
        addProduct("aan", "Aang", "Minimum requirement: Control settlements of all four elements and the Southern Air Temple.\n" +
                "\n" +
                "About:\n", 14, 0, 6, 6, 35, 6, 4, 28);
        addProduct("roku1", "Roku", "Minimum requirement: Control all 4 elements and the Fire Nation Capital.\n" +
                "\n" +
                "About:\n", 14, 2, 6, 7, 35, 4, 6, 30);
        addProduct("kyo", "Kyoshi", "Minimum requirement: Control all 4 elements and Ba Sing Se.\n" +
                "\n" +
                "About:\n", 14, 2, 6, 8, 35, 4, 6, 31);
    }

    private static void addProduct(String unitId, String name,String description, int type,float attack1, float attack2, int intellect,float life,float evasion,
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