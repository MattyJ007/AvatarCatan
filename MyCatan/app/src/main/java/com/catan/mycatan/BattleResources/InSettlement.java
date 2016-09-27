package com.catan.mycatan.BattleResources;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.catan.mycatan.R;

public class InSettlement extends AppCompatActivity implements View.OnClickListener {

    public static double settlement;

    public static double getSettlement() {
        return settlement;
    }

    public static void setSettlement(double settlement) {
        InSettlement.settlement = settlement;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_settlement);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button1 = (Button)findViewById(R.id.noSet);
        Button button2 = (Button)findViewById(R.id.village);
        Button button3 = (Button)findViewById(R.id.town);
        Button button4 = (Button)findViewById(R.id.city);
        // Register the onClick listener with the implementation above
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId() ) {
            case R.id.noSet:
                Toast.makeText(InSettlement.this, "No Evasion Bonus added", Toast.LENGTH_SHORT).show();
                setSettlement(0);
                Intent intent1 = new Intent(this, BattleDefenders.class);
                startActivity(intent1);
                break;
            case R.id.village:
                Toast.makeText(InSettlement.this, "1 point Evasion Bonus added", Toast.LENGTH_SHORT).show();
                setSettlement(1);
                Intent intent2 = new Intent(this, BattleDefenders.class);
                startActivity(intent2);

                break;
            case R.id.town:
                Toast.makeText(InSettlement.this, "1.5 points Evasion Bonus added", Toast.LENGTH_SHORT).show();
                setSettlement(1.5);
                System.out.println(settlement);
                Intent intent3 = new Intent(this, BattleDefenders.class);
                startActivity(intent3);

                break;
            case R.id.city:
                Toast.makeText(InSettlement.this,"2 points Evasion Bonus added", Toast.LENGTH_SHORT).show();
                setSettlement(2);
                Intent intent4 = new Intent(this, BattleDefenders.class);
                startActivity(intent4);

                break;
            default:
                break;
        }
    }
}
