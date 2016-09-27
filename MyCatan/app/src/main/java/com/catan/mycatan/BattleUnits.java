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

import com.catan.mycatan.BattleResources.GetAttackUnitList;
import com.catan.mycatan.BattleResources.InSettlement;
import com.catan.mycatan.BattleResources.PeonDataProvider;

import java.util.List;

public class BattleUnits extends AppCompatActivity implements View.OnClickListener{

    public static final String UNIT_ID = "UNIT_ID";
    private List<Unit> units = PeonDataProvider.unitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_units);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button1 = (Button) findViewById(R.id.Cont1button);
        Button button2 = (Button) findViewById(R.id.Show1button);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        BattleListAdapter adapter = new BattleListAdapter(
                this, R.layout.battle_list_units, units);
        ListView lv = (ListView) findViewById(R.id.listView3);
        if (lv != null) {
            lv.setAdapter(adapter);
        }

        if (lv != null) {
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Unit unit = units.get(position);
                    GetAttackUnitList.getAttackUnitList(unit, view);
                }
            });

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }
    public void onClick(View v) {

        switch (v.getId() ) {
            case R.id.Cont1button:
                Intent intent1 = new Intent(this, InSettlement.class);
                startActivity(intent1);

                break;
            case R.id.Show1button:
                Snackbar.make(v, GetAttackUnitList.getAttTeamNames()+"", Snackbar.LENGTH_LONG).setAction("Action",null).show();
                break;
            default:
                break;
        }
    }
}
