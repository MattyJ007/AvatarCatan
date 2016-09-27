package com.catan.mycatan;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String unitId = getIntent().getStringExtra(Units.UNIT_ID);
        Unit unit = UnitDataProvider.unitMap.get(unitId);

        TextView tv = (TextView) findViewById(R.id.nameText);
        tv.setText(unit.getName());

        String stat = "d6 Attack:   "+ unit.getAttack1()
                +"\nd20 Attack:   "+ unit.getAttack2()
                +"\nEvasion:   "+ unit.getEvasion()
                +"\nLife:   "+  unit.getLife()
                +"\nNumber of Attacks:   "+ unit.getNumAtts()
                +"\nIntellect:   "+ unit.getIntellect()
                +"\nBending Type:   "+ unit.getTypeString()+"\n\n";

        TextView descView = (TextView) findViewById(R.id.descriptionText);
        descView.setText(stat + unit.getDescription());

        String price = unit.getPrice() + " Gold";
        TextView priceText = (TextView) findViewById(R.id.priceText);
        priceText.setText(price);

        ImageView iv = (ImageView) findViewById(R.id.imageView);
        Bitmap bitmap = getBitmapFromAsset(unit.getUnitId());
        iv.setImageBitmap(bitmap);
        

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private Bitmap getBitmapFromAsset(String unitId){
        AssetManager assetManager = getAssets();
        InputStream stream = null;

        try {
            stream = assetManager.open(unitId + ".png");
            return BitmapFactory.decodeStream(stream);
        } catch (IOException e) {
            e.printStackTrace();
//            System.out.println("Pic not available\n\n____________\n___________");
            return null;
        }
    }

}
