package com.example.jorch.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by JORCH on 29/12/2016.
 */

public class DialogoSimple extends DialogFragment {

    public DialogoSimple() {
    }

    public static DialogoSimple newInstance() {
        
        Bundle args = new Bundle();
        
        DialogoSimple fragment = new DialogoSimple();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("DIALOGO SIMPLE")
                .setMessage("Probando a hacer un dialogo simple.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(),"Has marcado: OK",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(),"Has marcado: NO",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(),"Has marcado: CANCELAR",Toast.LENGTH_SHORT).show();
                    }
                });
        return builder.create();
    }
}
