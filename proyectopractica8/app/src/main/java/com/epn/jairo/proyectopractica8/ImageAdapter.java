package com.epn.jairo.proyectopractica8;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.epn.jairo.proyectopractica8.R;

/**
 * Created by Jairo on 05/01/2018.
 */

public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    public Integer[] mThumbsID={R.drawable.animal1,
            R.drawable.animal2,
            R.drawable.animal3,
            R.drawable.banana};


    public ImageAdapter(Context c){
        mContext = c;
    }


    @Override
    public int getCount() {
        return mThumbsID.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(185,185));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);
        }
        else{
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbsID[position]);
        return imageView;
    }
}
