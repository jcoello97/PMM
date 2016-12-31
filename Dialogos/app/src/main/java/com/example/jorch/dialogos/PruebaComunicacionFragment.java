package com.example.jorch.dialogos;

import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by JORCH on 31/12/2016.
 */

public class PruebaComunicacionFragment extends DialogFragment {
    private Button buttonMostrarOpciones;
    private TextView textViewOpcionElegida;

    public static PruebaComunicacionFragment newInstance() {

        Bundle args = new Bundle();

        PruebaComunicacionFragment fragment = new PruebaComunicacionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialogo_probando_comunicacion,container,false);
        textViewOpcionElegida = (TextView) view.findViewById(R.id.tv_opcion_elegida);
        buttonMostrarOpciones = (Button) view.findViewById(R.id.bttn_elegir_opcion);
        buttonMostrarOpciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().add(DialogoConListaDeRadios.newInstance(),"LISTARADIOS").commit();
            }
        });

        return view;
    }
    public void ponerOpcion(String opcion){
        textViewOpcionElegida.setText(opcion);
    }
}
