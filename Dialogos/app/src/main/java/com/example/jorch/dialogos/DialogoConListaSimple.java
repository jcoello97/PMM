package com.example.jorch.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by JORCH on 29/12/2016.
 */

public class DialogoConListaSimple extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final CharSequence[] listaSimple = new CharSequence[4];
        listaSimple[0] = "OPCIÓN 1";
        listaSimple[1] = "OPCIÓN 2";
        listaSimple[2] = "OPCIÓN 3";
        listaSimple[3] = "OPCIÓN 4";

        builder.setTitle("DIÁLOGO CON LISTA SIMPLE")
                .setItems(listaSimple, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(),"Has marcado "+listaSimple[which],Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(),"Has marcado:CANCELAR",Toast.LENGTH_SHORT).show();
                    }
                });
                return builder.create();

    }
}
