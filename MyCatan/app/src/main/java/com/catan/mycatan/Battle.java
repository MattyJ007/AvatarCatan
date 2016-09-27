package com.catan.mycatan;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.catan.mycatan.BattleResources.GetAttackList;
import com.catan.mycatan.BattleResources.GetDefenseList;
import com.catan.mycatan.BattleResources.HeroDataProvider;

import java.util.List;

public class Battle extends AppCompatActivity implements View.OnClickListener {
    public static final String UNIT_ID = "UNIT_ID";
    private List<Unit> units = HeroDataProvider.unitList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        Button button1 = (Button)findViewById(R.id.Contbutton);
        Button button2 = (Button)findViewById(R.id.Showbutton);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Register the onClick listener with the implementation above


//        final String[] units1 = getResources().getStringArray(R.array.units);
        BattleListAdapter adapter = new BattleListAdapter(
                this, R.layout.battle_list_units, units);
        ListView lv = (ListView) findViewById(R.id.listView2);
        if (lv != null) {
            lv.setAdapter(adapter);
        }

        if (lv != null) {
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Unit unit = units.get(position);
                    GetAttackList.getAttackList(unit, view);
                }
            });
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void onClick(View v) {

        switch (v.getId() ) {
            case R.id.Contbutton:
                Intent intent1 = new Intent(this, BattleUnits.class);
                startActivity(intent1);

                break;
            case R.id.Showbutton:
                Snackbar.make(v,GetAttackList.getAttTeamNames()+"", Snackbar.LENGTH_SHORT).setAction("Action",null).show();
                break;
            default:
                break;
        }
    }

}
