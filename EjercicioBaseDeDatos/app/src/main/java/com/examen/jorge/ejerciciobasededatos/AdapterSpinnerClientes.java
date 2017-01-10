package com.examen.jorge.ejerciciobasededatos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by mati on 9/01/17.
 */
public class AdapterSpinnerClientes extends ArrayAdapter<Cliente>{
    Context context;
    Cliente[] clientes;
    private TextView textViewId, textViewNombre,textViewTelefono;
    public AdapterSpinnerClientes(Context context, Cliente[] clientes) {
        super(context, R.layout.spinner_clientes, clientes);
        this.context = context;
        this.clientes = clientes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null){
            view = inflater.inflate(R.layout.spinner_clientes,null);
        }
        textViewId = (TextView) view.findViewById(R.id.tv_spinner_id);
        textViewNombre = (TextView) view.findViewById(R.id.tv_spinner_nombre);
        textViewTelefono = (TextView) view.findViewById(R.id.tv_spinner_telefono);

        textViewId.setText(String.valueOf(clientes[position].getId()));
        textViewNombre.setText(clientes[position].getNombre());
        textViewTelefono.setText(clientes[position].getTelefono());
        return super.getView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position,convertView,parent);
    }
}
