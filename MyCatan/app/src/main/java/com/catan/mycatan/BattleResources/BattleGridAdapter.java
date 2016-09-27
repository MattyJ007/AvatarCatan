package com.catan.mycatan.BattleResources;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.catan.mycatan.R;
import com.catan.mycatan.Unit;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BattleGridAdapter extends ArrayAdapter<Unit>{

    private List<Unit> units;

    public BattleGridAdapter(Context context, int resource, List<Unit> objects) {
        super(context, resource, objects);
        units = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.grid_layout, parent, false);
        }
        Unit unit = units.get(position);

        TextView nameText = (TextView) convertView.findViewById(R.id.gridName);
        nameText.setText(unit.getName());

        TextView lifeText = (TextView) convertView.findViewById(R.id.gridLife);
        lifeText.setText(unit.getLife()+" Life");

        TextView numAttsText = (TextView) convertView.findViewById(R.id.gridnumAtts);
        numAttsText.setText("0/" + unit.getNumAtts()+" attacks used.");
//
//        ImageView iv = (ImageView) convertView.findViewById(R.id.imageViewGrid);
//        Bitmap bitmap = getBitmapFromAsset(unit.getUnitId());
//        iv.setImageBitmap(bitmap);

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
