package com.example.jorch.examen1rtrimestre;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by JORCH on 08/01/2017.
 */

public class AdaptadorSpinnerCoches extends ArrayAdapter<Coche> {
    private Coche[] coches;
    private TextView textViewNombre, textViewMarca, textViewPrecio;
    private ImageView imageViewCoche;

    public AdaptadorSpinnerCoches(Context context, Coche[] coches) {
        super(context, R.layout.spinner_coches, coches);
        this.coches = coches;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view =

        return super.getView(position, convertView, parent);
    }
}
