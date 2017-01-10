package com.example.jorch.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JORCH on 29/12/2016.
 */

public class DialogoConListaDeCheckboxes extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final CharSequence[] listaCheckBoxes = new CharSequence[]{"OPCIÓN PRIMERA","OPCIÓN SEGUNDA","OPCIÓN TERCERA"};
        final List<CharSequence> listaSeleccionados = new ArrayList<>();

        builder.setTitle("DIÁLOGO CON LISTA DE CHECKBOXES")
                .setNeutralButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(),"Has marcado: CANCELAR",Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (listaSeleccionados.size() == 0){
                            Toast.makeText(getActivity(),"NO has seleccionado ninguna opción",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getActivity(),"Has seleccionado: "+listaSeleccionados.toString(),Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setMultiChoiceItems(listaCheckBoxes, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked){
                            listaSeleccionados.add(listaCheckBoxes[which]);
                            Toast.makeText(getActivity(),"Has seleccionado: "+listaCheckBoxes[which],Toast.LENGTH_SHORT).show();
                        }else {
                            listaSeleccionados.remove(which);
                            Toast.makeText(getActivity(),"Has deseleccionado: "+listaCheckBoxes[which],Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        return builder.create();
    }
}
