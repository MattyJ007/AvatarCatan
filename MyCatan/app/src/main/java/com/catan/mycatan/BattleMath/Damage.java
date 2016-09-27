package com.catan.mycatan.BattleMath;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.catan.mycatan.R;
import com.catan.mycatan.Unit;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Damage {

    public static void UnitAttacks(){
        HashMap<Unit,View> defendersHash;
        List<Unit> defenders;
        List<String> blockers = WillDefend.getBlockers();
        defenders = CurrentlyBeingAttacked.getBeingAttacked();
        defendersHash = CurrentlyBeingAttacked.getBeingAttackedHash();
        Unit attacker = CurrentlyBeingAttacked.getAttacker();
        float att1 = attacker.getAttack1();
        float att2 = attacker.getAttack2();
        float attackTot = 0;
        float intel = attacker.getIntellect();
        float avAtt = 0;

        for (int j = 0; j < (att1); j++) {
            Random dice = new Random();
            attackTot += dice.nextInt(6) + 1;
        }
        for (int k = 0; k < (att2); k++) {
            Random dice = new Random();
            attackTot += dice.nextInt(20) + 1;
        }
        attackTot += (intel/3);
        avAtt = attackTot/defenders.size();
        avAtt = Math.round(avAtt*100)/100;
            TextView attSide = BattleGround.returnAttTextView();
            attSide.setTextSize(20);
            attSide.setText(attacker.getName() + " did an average of " + avAtt + " damage.");
            TextView defSide = BattleGround.returnDefTextView();
            defSide.setTextSize(20);
            defSide.setText(attacker.getName() + " did an average of " + avAtt + " damage.");
        for (Unit defending: defenders) {
            System.out.println("========\n" + blockers);
            if (blockers.contains(defending.getName())){
                double life1 = defending.getLife() - avAtt;
                float total1 = (float) Math.round((life1 * 100)) / 100;
                defending.setLife(total1);
                View vDam1 = defendersHash.get(defending);
                TextView life1Text = (TextView) vDam1.findViewById(R.id.gridLife);
                life1Text.setText(defending.getLife() + " Life");

                if (life1 <= 0 && !DeadUnits.getDeadList().contains(attacker)) {
                    if (Retaliate.retaliate(attacker, defending, CurrentlyBeingAttacked.getAttackerView())){
                        GridView attView = (GridView) CurrentlyBeingAttacked.getAttackerView();
                        attView.setBackgroundColor(Color.parseColor("#D50400"));
                    }
                    View vDead = defendersHash.get(defending);
                    TextView lifeDText = (TextView) vDead.findViewById(R.id.gridLife);
                    lifeDText.setText(defending.getLife()+" Life");
                    TextView nameText = (TextView) vDead.findViewById(R.id.gridName);
                    vDead.setBackgroundColor(Color.parseColor("#D50400"));
                    vDead.findViewById(R.id.gridLife).setBackgroundColor(Color.parseColor("#000000"));
                    nameText.setText(defending.getName());
                    DeadUnits.addToDeadList(defending);

                }
            }
            else {
                double def = 1 - (defending.getEvasion() / 10);
                double dam = def * avAtt;
                double life = defending.getLife() - dam;
                float total = (float) Math.round((life * 100)) / 100;
                defending.setLife(total);
                View vDam = defendersHash.get(defending);
                TextView lifeText = (TextView) vDam.findViewById(R.id.gridLife);
                lifeText.setText(defending.getLife() + " Life");

                if (life <= 0 && !DeadUnits.getDeadList().contains(defending)) {

                    if (Retaliate.retaliate(attacker, defending, CurrentlyBeingAttacked.getAttackerView())){
                        System.out.println("Vengence is " + defending.getName());
                    }
                    View vDead = defendersHash.get(defending);
                    TextView lifeDText = (TextView) vDead.findViewById(R.id.gridLife);
                    lifeDText.setText(defending.getLife()+" Life");
                    TextView nameText = (TextView) vDead.findViewById(R.id.gridName);
                    vDead.setBackgroundColor(Color.parseColor("#D50400"));
                    lifeDText.setBackgroundColor(Color.parseColor("#000000"));
                    nameText.setText(defending.getName());
                    DeadUnits.addToDeadList(defending);
                }
            }
        }

    }
}
