package com.example.jorch.dialogos;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by JORCH on 29/12/2016.
 */

public class DialogoConListaDeRadios extends DialogFragment {
   OnDialogoListaRadiosListener listener;
    String opcionElegida="";
    public interface OnDialogoListaRadiosListener{
        void opcionElegida(String opcion);
    }
    public static DialogoConListaDeRadios newInstance() {
        
        Bundle args = new Bundle();
        
        DialogoConListaDeRadios fragment = new DialogoConListaDeRadios();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (OnDialogoListaRadiosListener) activity;
        }catch (ClassCastException e){
            e.printStackTrace();
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final CharSequence[] listaRadios = new CharSequence[]{"OPCIÓN PRIMERA","OPCIÓN SEGUNDA","OPCIÓN TERCERA"};

        builder.setTitle("DIÁLOGO CON LISTA DE RADIOS")
                .setNeutralButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(),"Has marcado: CANCELAR",Toast.LENGTH_SHORT).show();
                    }
                })
                .setSingleChoiceItems(listaRadios, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(getActivity(),"Has marcado: "+listaRadios[which],Toast.LENGTH_SHORT).show();
                        opcionElegida = (String) listaRadios[which];
                    }
                })
                .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.opcionElegida(opcionElegida);
                        dismiss();
                        //Toast.makeText(getActivity(),"Has marcado: ACEPTAR",Toast.LENGTH_SHORT).show();
                    }
                });
        return builder.create();
    }
}
