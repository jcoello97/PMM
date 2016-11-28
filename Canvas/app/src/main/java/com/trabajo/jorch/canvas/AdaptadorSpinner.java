package com.trabajo.jorch.canvas;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Jorch on 20/11/2016.
 */

public class AdaptadorSpinner extends ArrayAdapter<String>
{
    Activity context;
    String[] dibujos;
    private TextView textViewTipoDibujo;
    public AdaptadorSpinner(Activity context, String[] dibujos) {
        super(context, R.layout.content_spinnerdibujo, dibujos);
        this.context = context;
        this.dibujos = dibujos;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null){
            view = context.getLayoutInflater().inflate(R.layout.content_spinnerdibujo,null);
        }
        textViewTipoDibujo = (TextView) view.findViewById(R.id.tvTipoDibujo);

        textViewTipoDibujo.setText(dibujos[position]);
        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position,convertView,parent);
    }
}
