package com.examen.jorge.ejerciciobasededatos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mati on 9/01/17.
 */
public class AdapterSpinnerClientes extends ArrayAdapter<Cliente>{
    Context context;
    List<Cliente> clientes;
    private TextView textViewId, textViewNombre,textViewTelefono;

    public AdapterSpinnerClientes(Context context, List<Cliente> clientes) {
        super(context, R.layout.spinner_clientes, clientes);
        this.context = context;
        this.clientes= clientes ;
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

        textViewId.setText(String.valueOf(clientes.get(position).getId()));
        textViewNombre.setText(clientes.get(position).getNombre());
        textViewTelefono.setText(clientes.get(position).getTelefono());
        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position,convertView,parent);
    }
}
