package com.example.jorch.examen1rtrimestre;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
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
    private Context context;
    private TextView textViewNombre, textViewMarca, textViewPrecio;
    private ImageView imageViewCoche;

    public AdaptadorSpinnerCoches(Context context, Coche[] coches) {
        super(context, R.layout.spinner_coches, coches);
        this.coches = coches;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.spinner_coches,null);
        textViewNombre = (TextView) view.findViewById(R.id.tv_coche_nombre);
        textViewMarca = (TextView) view.findViewById(R.id.tv_coche_marca);
        textViewPrecio = (TextView) view.findViewById(R.id.tv_coche_precio);
        imageViewCoche = (ImageView) view.findViewById(R.id.img_coche);

        textViewNombre.setText(coches[position].getNombre());
        textViewMarca.setText(coches[position].getMarca());
        textViewPrecio.setText(String.valueOf(coches[position].getPrecio()));
        imageViewCoche.setImageResource(coches[position].getImagenCoche());
        return view;
    }
}
