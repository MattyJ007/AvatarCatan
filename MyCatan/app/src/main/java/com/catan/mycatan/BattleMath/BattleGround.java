package com.catan.mycatan.BattleMath;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.catan.mycatan.Battle;
import com.catan.mycatan.BattleListAdapter;
import com.catan.mycatan.BattleResources.BattleGridAdapter;
import com.catan.mycatan.BattleResources.GetAttackList;
import com.catan.mycatan.BattleResources.attTempListStorage;
import com.catan.mycatan.BattleResources.defTempListStorage;
import com.catan.mycatan.BattleUnits;
import com.catan.mycatan.R;
import com.catan.mycatan.Unit;

import java.util.ArrayList;
import java.util.List;

public class BattleGround extends AppCompatActivity implements View.OnClickListener {
    private List<Unit> unitsAtt = attTempListStorage.getAttUnitList();
    private List<Unit> unitsDef = defTempListStorage.getDefUnitList();
    private static TextView cenText;
    private static TextView defSide;
    private static TextView attSide;

    private GridView gridDef;
    private GridView gridAtt;
    public static Context battleContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_ground);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView centText = (TextView) findViewById(R.id.centerText);
        setCenText(centText);
        centText.setText("Attacker goes First");
        centText.setRotation(180);

        TextView defSide = (TextView) findViewById((R.id.defendView));
        setDefSide(defSide);
        TextView attSide = (TextView) findViewById((R.id.attackView));
        setAttSide(attSide);

        Button button1 = (Button)findViewById(R.id.attsNoButt);
        Button button2 = (Button)findViewById(R.id.defsNoButt);
        Button button3 = (Button)findViewById(R.id.attsYesButt);
        Button button4 = (Button)findViewById(R.id.defsYesButt);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        battleContext = this.getApplicationContext();

        gridDef = (GridView) findViewById(R.id.defendGrid);
        final String defender = "defender";

        BattleGridAdapter adapterDef = new BattleGridAdapter (BattleGround.this,R.layout.grid_layout, unitsDef);
        gridDef.setAdapter(adapterDef);

        gridDef.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Unit unit = unitsDef.get(position);
                CurrentlyAttackingHero.currentlyAttackingU(unit, defender, view, unitsDef);
            }
        });


        gridAtt = (GridView) findViewById(R.id.attackGrid);
        final String attacker = "attacker";

        BattleGridAdapter adapterAtt = new BattleGridAdapter (BattleGround.this,R.layout.grid_layout, unitsAtt);
        gridAtt.setAdapter(adapterAtt);

        gridAtt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Unit unit = unitsAtt.get(position);
                CurrentlyAttackingHero.currentlyAttackingU(unit, attacker, view, unitsAtt);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onClick(View v) {

        switch (v.getId() ) {
            case R.id.attsNoButt:
                CurrentlyAttackingHero.canIpressButtons("attacker", "no");
                break;
            case R.id.defsNoButt:
                CurrentlyAttackingHero.canIpressButtons("defender", "no");
                break;
            case R.id.attsYesButt:
                CurrentlyAttackingHero.canIpressButtons("attacker", "yes");
                break;
            case R.id.defsYesButt:
                CurrentlyAttackingHero.canIpressButtons("defender", "yes");
                break;
            default:
                break;
        }
    }
    public static void setCenText(TextView cenT){
        cenText = cenT;
    }
    public static void setDefSide(TextView def){
        defSide = def;
    }
    public static void setAttSide(TextView att){

        attSide = att;
    }


    public static TextView returnCenTextView(){
        return cenText;
    }

    public static TextView returnAttTextView(){
        return defSide;
    }

    public static TextView returnDefTextView(){
        return attSide;
    }

    public static Context returnBattleContext(){
        return battleContext;
    }
}
