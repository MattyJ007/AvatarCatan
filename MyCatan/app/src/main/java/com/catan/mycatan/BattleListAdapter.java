package com.catan.mycatan;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BattleListAdapter extends ArrayAdapter<Unit>{

    private List<Unit> units;

    public BattleListAdapter(Context context, int resource, List<Unit> objects) {
        super(context, resource, objects);
        units = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.battle_list_units, parent, false);
        }

        Unit unit = units.get(position);

        TextView nameText = (TextView) convertView.findViewById(R.id.nameText1);
        nameText.setText(unit.getName());

        ImageView iv = (ImageView) convertView.findViewById(R.id.imageView1);
        Bitmap bitmap = getBitmapFromAsset(unit.getUnitId());
        iv.setImageBitmap(bitmap);

        return convertView;
    }

    private Bitmap getBitmapFromAsset(String unitId){
        AssetManager assetManager = getContext().getAssets();
        InputStream stream = null;

        try {
            stream = assetManager.open(unitId + ".png");
            return BitmapFactory.decodeStream(stream);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Pic not available\n\n____________\n___________");
            return null;
        }
    }



}
