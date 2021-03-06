package com.catan.mycatan.BattleResources;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.catan.mycatan.BattleListAdapter;
import com.catan.mycatan.BattleUnits;
import com.catan.mycatan.R;
import com.catan.mycatan.Unit;

import java.util.List;

public class BattleDefenders extends AppCompatActivity implements View.OnClickListener {
    public static final String UNIT_ID = "UNIT_ID";
    private List<Unit> units = HeroDataProvider.unitList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_defenders);

        Button button1 = (Button)findViewById(R.id.ContbuttonU);
        Button button2 = (Button)findViewById(R.id.ShowbuttonU);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BattleListAdapter adapter = new BattleListAdapter(
                this, R.layout.battle_list_units, units);
        ListView lv = (ListView) findViewById(R.id.ListViewU);
        if (lv != null) {
            lv.setAdapter(adapter);
        }

        if (lv != null) {
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Unit unit = units.get(position);
                    GetDefenseList.getDefenseList(unit, view);
                }
            });
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void onClick(View v) {

        switch (v.getId() ) {
            case R.id.ContbuttonU:
                Intent intent1 = new Intent(this, BattleUnitDefenders.class);
                startActivity(intent1);

                break;
            case R.id.ShowbuttonU:
                Snackbar.make(v, GetDefenseList.getDefTeamNames() + "", Snackbar.LENGTH_LONG).setAction("Action",null).show();
                break;
            default:
                break;
        }
    }

}