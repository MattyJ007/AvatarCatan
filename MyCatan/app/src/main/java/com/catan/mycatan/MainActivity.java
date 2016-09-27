package com.catan.mycatan;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.catan.mycatan.BattleResources.GetAttackList;
import com.catan.mycatan.BattleResources.GetAttackUnitList;
import com.catan.mycatan.BattleResources.GetDefenseList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button1 = (Button)findViewById(R.id.battleButton);
        Button button2 = (Button)findViewById(R.id.ruleButton);
        Button button3 = (Button)findViewById(R.id.unitButton);
        // Register the onClick listener with the implementation above
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {

        switch (v.getId() ) {
            case R.id.battleButton:
                GetAttackList.resetAttTeam();
                GetDefenseList.resetDefTeam();
                GetAttackUnitList.resetAttTeam();
                Intent intent1 = new Intent(this, Battle.class);
                startActivity(intent1);
                break;
            case R.id.ruleButton:
                Intent intent2 = new Intent(this, RulesActivity.class);
                startActivity(intent2);

                break;
            case R.id.unitButton:
                Intent intent3 = new Intent(this, Units.class);
                startActivity(intent3);

                break;
            default:
                break;
        }
    }
}
