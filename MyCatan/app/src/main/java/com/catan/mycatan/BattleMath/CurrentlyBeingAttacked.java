package com.catan.mycatan.BattleMath;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.catan.mycatan.R;
import com.catan.mycatan.Unit;

import java.util.ArrayList;
import java.util.HashMap;

public class CurrentlyBeingAttacked {

    private static ArrayList<Unit> beingAttacked = new ArrayList<>();
    private static HashMap<Unit, View> beingAttackedHash = new HashMap<>();
    private static Unit attacker;
    private static View attackerView;
    private static int numAtts;
    private static int count = 0;


    public static void setBeingAttackedHash(Unit defending, View view) {
        beingAttackedHash.put(defending, view);
    }

        public static HashMap<Unit, View> getBeingAttackedHash() {
        return beingAttackedHash;
    }

    public static void resetBeingAttackedHash() {
        beingAttackedHash.clear();
}

    public static ArrayList<Unit> getBeingAttacked() {
        return beingAttacked;
    }

    public static void setBeingAttacked(Unit defending) {
        beingAttacked.add(defending);
    }

    public static void resetBeingAttacked(){
        beingAttacked.clear();
    }


    public static void setAttacker(Unit attacker) {
        CurrentlyBeingAttacked.attacker = attacker;
    }

    public static void resetAttacker(){
        attacker = null;
    }



    public static Unit getAttacker() {
        return attacker;
    }

    public static void setAttackerView(View view){
        attackerView = view;
    }

    public static View getAttackerView() {
        return attackerView;
    }


    public static void setNumAtts(int numAtts) {
        CurrentlyBeingAttacked.numAtts = numAtts;
    }

    public static int getCount(){
        return count;
    }

    public static void addCount() {
        count += 1;
    }

    public static void resetCount(){
        count = 0;
    }

    public static void checkCount(){
        if (count == numAtts){
            FinishedAttacking.setFinished(getAttacker());
            Damage.UnitAttacks();
            resetCount();
            TextView numAtt = (TextView) CurrentlyBeingAttacked.getAttackerView().findViewById(R.id.gridnumAtts);
            numAtt.setText(CurrentlyBeingAttacked.getCount() + "/" + CurrentlyBeingAttacked.getAttacker().getNumAtts() + " attacks used.");
            getAttackerView().setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            resetAttacker();
            resetBeingAttacked();
            resetBeingAttackedHash();
            WillDefend.resetBlockers();
            if(!WhoseTurnIsIt.availableAttackers()){
                WhoseTurnIsIt.switchTurns();
                TextView cenText = BattleGround.returnCenTextView();
                if (WhoseTurnIsIt.getTurn().equals("defender")){
                    cenText.setText("Defenders Turn");
                    cenText.setRotation(0);
                }
                else {
                    cenText.setText("Attackers Turn");
                    cenText.setRotation(180);
                }
                FinishedAttacking.resetFinishedAttacking();
            };
        }
        else{}
    }
}
