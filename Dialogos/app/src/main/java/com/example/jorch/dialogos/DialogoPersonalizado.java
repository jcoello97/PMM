package com.example.jorch.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.TextView;

/**
 * Created by JORCH on 30/12/2016.
 */

public class DialogoPersonalizado extends DialogFragment {
    private Button bttnCrearCuenta, bttnEntrarCuenta;
    private CheckBox checkBox_Recordarme;
    private TextInputEditText editTextNombre, editTextContraseña;
    private CheckedTextView textViewOlvidasteContraseña;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialogo_personalizado,null);
        builder.setView(view);

        //INICIAMOS COMPONENTES
        bttnCrearCuenta = (Button) view.findViewById(R.id.bttn_dialogo_crear_cuenta);
        bttnEntrarCuenta = (Button) view.findViewById(R.id.bttn_entrar_cuenta);
        checkBox_Recordarme = (CheckBox) view.findViewById(R.id.checkbox_recordar);
        editTextNombre = (TextInputEditText) view.findViewById(R.id.ti_et_name);
        editTextContraseña = (TextInputEditText)view.findViewById(R.id.ti_et_password);
        textViewOlvidasteContraseña = (CheckedTextView) view.findViewById(R.id.tv_olvidaste_contraseña);

        bttnCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        bttnEntrarCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return builder.create();
    }

    public static DialogoPersonalizado newInstance() {
        
        Bundle args = new Bundle();
        
        DialogoPersonalizado fragment = new DialogoPersonalizado();
        fragment.setArguments(args);
        return fragment;
    }
}
