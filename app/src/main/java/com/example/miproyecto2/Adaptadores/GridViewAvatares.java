package com.example.miproyecto2.Adaptadores;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.miproyecto2.R;

public class GridViewAvatares extends BaseAdapter {
    private Context mContext;
    public int[] avataresArray = {
            R.drawable.icono1,
            R.drawable.icono2,
            R.drawable.icono3,
            R.drawable.icono4,
            R.drawable.icono5,
            R.drawable.icono6,
            R.drawable.icono7,
            R.drawable.icono8,
            R.drawable.icono9,
            R.drawable.icono10,
            R.drawable.icono11,
            R.drawable.icono12,
            R.drawable.icono13,
            R.drawable.icono14,
            R.drawable.icono15,
    };

    public GridViewAvatares(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return avataresArray.length;
    }

    @Override
    public Object getItem(int position) {
        return avataresArray[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView avatarView = new ImageView(mContext);
        avatarView.setImageResource(avataresArray[position]);
        avatarView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        avatarView.setLayoutParams(
                new GridView.LayoutParams(
                       350,
                        350
                )
        );
        return avatarView;
    }
}
