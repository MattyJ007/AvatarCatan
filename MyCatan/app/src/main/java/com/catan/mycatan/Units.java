package com.catan.mycatan;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class Units extends AppCompatActivity {
    public static final String UNIT_ID = "UNIT_ID";
    private List<Unit> units = UnitDataProvider.unitList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_units);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final String[] units1 = getResources().getStringArray(R.array.units);
//        ArrayAdapter<String> adapter =
//                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, units1);

        UnitListAdapter adapter = new UnitListAdapter(
                this, R.layout.list_units, units);
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Units.this, DetailActivity.class);

                Unit unit = units.get(position);
                intent.putExtra(UNIT_ID, unit.getUnitId());

                startActivity(intent);
            }
        });


                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
