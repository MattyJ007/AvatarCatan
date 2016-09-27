package com.catan.mycatan.BattleMath;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.catan.mycatan.R;
import com.catan.mycatan.Unit;

import java.util.HashMap;
import java.util.List;


public class CurrentlyAttackingHero {

    public static Unit mightBeAttacked;
    public static View gridCell;
    public static void setMightBeAttacked(Unit mightBeAttacked, View view) {
        CurrentlyAttackingHero.mightBeAttacked = mightBeAttacked;
        gridCell = view;
    }

    public static Unit getMightBeAttacked() {
        return mightBeAttacked;
    }
    public static View getMightBeGridCell() {
        return gridCell;
    }

    public static void currentlyAttackingU(Unit unit, String turn, View view, List<Unit> attackers){
        if (WillDefend.getWillSomeoneBlock().equals("choose")){
            TextView cenText = BattleGround.returnCenTextView();
            cenText.setText("Blocking phase. Choose Yes or No.");
            if (WhoseTurnIsIt.getTurn().equals("attacker")){
                cenText.setRotation(0);
            }
            else {
                cenText.setRotation(180);
            }
        }
        else if (WillDefend.getWillSomeoneBlock().equals("yes") && !turn.equals(WhoseTurnIsIt.getTurn())){
            if (DeadUnits.getDeadList().contains(unit)){
                TextView cenText = BattleGround.returnCenTextView();
                cenText.setText("Dead units don't block...");
                if (WhoseTurnIsIt.getTurn().equals("attacker")){
                    cenText.setRotation(0);
                }
                else {
                    cenText.setRotation(180);
                }
            }
            else {
                if (WillDefend.getBlockers().contains(unit.getName())){
                    TextView cenText = BattleGround.returnCenTextView();
                    cenText.setText(unit.getName() + " is already blocking another attack.");
                }
                else if(CurrentlyBeingAttacked.getBeingAttacked().contains(unit)){
                    TextView cenText = BattleGround.returnCenTextView();
                    cenText.setText(unit.getName() + " is already being attacked.");
                }
                else{
                    CurrentlyBeingAttacked.setBeingAttacked(unit);
                    CurrentlyBeingAttacked.setBeingAttackedHash(unit, view);
                    CurrentlyBeingAttacked.addCount();
                    TextView numAtt = (TextView) CurrentlyBeingAttacked.getAttackerView().findViewById(R.id.gridnumAtts);
                    numAtt.setText(CurrentlyBeingAttacked.getCount() + "/" + CurrentlyBeingAttacked.getAttacker().getNumAtts() + " attacks used.");
                    WillDefend.setBlockers(unit.getName());
                    WillDefend.resetBlock();
                    CurrentlyBeingAttacked.checkCount();
                    TextView cenText = BattleGround.returnCenTextView();
                    cenText.setText(unit.getName() + " will block.");
                    if (WhoseTurnIsIt.getTurn().equals("attacker")){
                        cenText.setRotation(0);
                    }
                    else {
                        cenText.setRotation(180);
                    }
                }
            }
        }
        else if (WillDefend.getWillSomeoneBlock().equals("yes") && turn.equals(WhoseTurnIsIt.getTurn()) && attackers.contains(CurrentlyBeingAttacked.getAttacker())){
            TextView cenText = BattleGround.returnCenTextView();
            cenText.setText("Wrong Team...");
            if (WhoseTurnIsIt.getTurn().equals("attacker")){
                cenText.setRotation(0);
            }
            else {
                cenText.setRotation(180);
            }

        }
        else if (turn.equals(WhoseTurnIsIt.getTurn()) && (CurrentlyBeingAttacked.getAttacker() == null) && WillDefend.getWillSomeoneBlock().equals("NA")) {
            if (FinishedAttacking.getFinished().contains(unit)){
                Snackbar.make(view, unit.getName() + " has already attacked", Snackbar.LENGTH_SHORT).setAction("Action",null).show();
            }
            else if (DeadUnits.getDeadList().contains(unit)){
                Snackbar.make(view, unit.getName() + " is Dead.", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
            }
            else {
                CurrentlyBeingAttacked.setAttacker(unit);
                view.setBackgroundColor(Color.parseColor("#7fff3f"));
                CurrentlyBeingAttacked.setAttackerView(view);
                CurrentlyBeingAttacked.setNumAtts(unit.getNumAtts());
                CurrentlyBeingAttacked.resetCount();
                TextView cenText = BattleGround.returnCenTextView();
                cenText.setText(unit.getName() + " is attacking. Choose unit to attack.");
                if (WhoseTurnIsIt.getTurn().equals("defender")){
                    cenText.setRotation(0);
                }
                else {
                    cenText.setRotation(180);
                }
            }
        }
        else if (turn.equals(WhoseTurnIsIt.getTurn()) && (CurrentlyBeingAttacked.getAttacker()== unit )&& CurrentlyBeingAttacked.getBeingAttacked().isEmpty()&& WillDefend.getWillSomeoneBlock().equals("NA")){
            TextView cenText = BattleGround.returnCenTextView();
            view.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            cenText.setText(unit.getName() + " deselected.");
            if (WhoseTurnIsIt.getTurn().equals("defender")){
                cenText.setRotation(0);
            }
            else {
                cenText.setRotation(180);
            }
            CurrentlyBeingAttacked.resetAttacker();
        }
        else if (turn.equals(WhoseTurnIsIt.getTurn()) && attackers.contains(CurrentlyBeingAttacked.getAttacker())&& WillDefend.getWillSomeoneBlock().equals("NA")){
            Snackbar.make(view, CurrentlyBeingAttacked.getAttacker().getName() + " can't attack own team...", Snackbar.LENGTH_SHORT).setAction("Action",null).show();
        }
        else if (!turn.equals(WhoseTurnIsIt.getTurn()) && !(CurrentlyBeingAttacked.getAttacker() == null) && WillDefend.getWillSomeoneBlock().equals("NA")){
            if (DeadUnits.getDeadList().contains(unit)){
                Snackbar.make(view, unit.getName() + "That unit is Dead...", Snackbar.LENGTH_SHORT).setAction("Action",null).show();
            }
            else {
                TextView cenText = BattleGround.returnCenTextView();
                cenText.setText(unit.getName() +" will be attacked.");
                if (WhoseTurnIsIt.getTurn().equals("attacker")){
                    cenText.setRotation(0);
                    TextView attSide = BattleGround.returnAttTextView();
                    attSide.setText("Select Blocker?");
                }
                else {
                    cenText.setRotation(180);
                    TextView defSide = BattleGround.returnDefTextView();
                    defSide.setText("Select Blocker?");

                }
                setMightBeAttacked(unit, view);
                WillDefend.setBlockChoose();
            }
        }
        else{
            Snackbar.make(view, "Not "+ turn +"'s turn...", Snackbar.LENGTH_SHORT).setAction("Action",null).show();
        }
    }
    public static void canIpressButtons(String turn, String option){




        if (turn.equals(WhoseTurnIsIt.getTurn())){
            TextView cenText = BattleGround.returnCenTextView();
            cenText.setText("Don't Touch Buttons");
            if (WhoseTurnIsIt.getTurn().equals("defender")){
                cenText.setRotation(0);
            }
            else {
                cenText.setRotation(180);
            }
        }
        else{
            if (WillDefend.getWillSomeoneBlock().equals("choose")){
                if (option.equals("yes")){
                    WillDefend.setBlockYes();
                }
                else {
                    TextView cenText = BattleGround.returnCenTextView();
                    cenText.setText("No Blocker for " + getMightBeAttacked().getName());
                    if (WhoseTurnIsIt.getTurn().equals("defender")){
                        cenText.setRotation(0);
                    }
                    else {
                        cenText.setRotation(180);
                    }
                    CurrentlyBeingAttacked.setBeingAttacked(getMightBeAttacked());
                    CurrentlyBeingAttacked.setBeingAttackedHash(getMightBeAttacked(), getMightBeGridCell());
                    CurrentlyBeingAttacked.addCount();
                    TextView numAtt = (TextView) CurrentlyBeingAttacked.getAttackerView().findViewById(R.id.gridnumAtts);
                    numAtt.setText(CurrentlyBeingAttacked.getCount() +"/"+CurrentlyBeingAttacked.getAttacker().getNumAtts()+" attacks used.");
                    CurrentlyBeingAttacked.checkCount();
                    WillDefend.resetBlock();
                }

            }
            else {
                System.out.println("Don't touch Buttons yet...");
            }
        }

    }
}
