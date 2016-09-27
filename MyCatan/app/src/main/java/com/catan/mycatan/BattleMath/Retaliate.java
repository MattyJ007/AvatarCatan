package com.catan.mycatan.BattleMath;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.catan.mycatan.R;
import com.catan.mycatan.Unit;

import java.util.Random;

public class Retaliate {
    public static boolean retaliate(Unit attacker, Unit defender, View attView){
        Random dice = new Random();
        int chance = dice.nextInt(10) + 1;
        if (chance < defender.getIntellect()){
            System.out.println("Retaliate!");
            float att1 = defender.getAttack1();
            float att2 = defender.getAttack2();
            float attackTot = 0;
            for (int j = 0; j < (att1); j++) {
                attackTot += dice.nextInt(6) + 1;
            }
            for (int k = 0; k < (att2); k++) {
                attackTot += dice.nextInt(20) + 1;
            }
            double def = 1 - (attacker.getEvasion() / 10);
            double intel = 1 - (attacker.getIntellect()/20);
            double dam = def * attackTot * intel;
            dam = Math.round((dam*100))/100;
            if (WhoseTurnIsIt.getTurn().equals("defender")){
                TextView defText = BattleGround.returnDefTextView();
                defText.setTextSize(20);
                defText.setText(defender.getName() + " retaliated against " + attacker.getName() + "  for " + dam + " damage.");
            }
            else {
                TextView attText = BattleGround.returnAttTextView();
                attText.setTextSize(20);
                attText.setText(defender.getName() + " retaliated against " + attacker.getName() + "  for " + dam + " damage.");
            }
            double life1 = attacker.getLife() - dam;
            float total1 = (float) Math.round((life1 * 100)) / 100;
            attacker.setLife(total1);
            TextView life1Text = (TextView) attView.findViewById(R.id.gridLife);
            life1Text.setText(attacker.getLife() + " Life");

            if (life1 <= 0){
                DeadUnits.addToDeadList(attacker);
                TextView cenText = BattleGround.returnCenTextView();
                cenText.setText(attacker.getName() + " took " + dam + " damage.");
                if (WhoseTurnIsIt.getTurn().equals("defender")){
                    cenText.setRotation(0);
                }
                else {
                    cenText.setRotation(180);
                }
                TextView lifeDText = (TextView) attView.findViewById(R.id.gridLife);
                lifeDText.setText(attacker.getLife()+" Life");
                TextView nameText = (TextView) attView.findViewById(R.id.gridName);
                attView.setBackgroundColor(Color.parseColor("#D50400"));
                lifeDText.setBackgroundColor(Color.parseColor("#000000"));
                nameText.setText(attacker.getName());
                DeadUnits.addToDeadList(attacker);
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
}
