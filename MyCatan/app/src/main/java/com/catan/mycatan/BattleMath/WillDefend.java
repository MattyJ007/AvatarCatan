package com.catan.mycatan.BattleMath;

import java.util.ArrayList;

public class WillDefend {
    public static String willSomeoneBlock = "NA";
    public static ArrayList<String> blockers = new ArrayList<>();

    public static void resetBlock(){
        willSomeoneBlock = "NA";
    }
    public static String getWillSomeoneBlock() {
        return willSomeoneBlock;
    }

    public static void setBlockChoose() {
        willSomeoneBlock = "choose";
    }

    public static void setBlockYes() {
            willSomeoneBlock = "yes";
    }

    public static ArrayList<String> getBlockers() {
        return blockers;
    }

    public static void setBlockers(String blocker) {
        blockers.add(blocker);
    }

    public static void resetBlockers() {
        blockers.clear();
    }
}
