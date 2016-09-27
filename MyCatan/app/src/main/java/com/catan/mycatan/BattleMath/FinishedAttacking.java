package com.catan.mycatan.BattleMath;

import com.catan.mycatan.Unit;

import java.util.ArrayList;

public class FinishedAttacking {

    public static ArrayList<Unit>  finished = new ArrayList<>();

    public static ArrayList<Unit> getFinished() {
        return finished;
    }

    public static void setFinished(Unit unit) {
        finished.add(unit);
    }

    public static void resetFinishedAttacking(){
        finished.clear();
    }
}
