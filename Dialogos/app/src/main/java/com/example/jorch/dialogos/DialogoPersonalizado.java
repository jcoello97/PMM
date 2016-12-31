package com.example.jorch.dialogos;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;

/**
 * Created by JORCH on 30/12/2016.
 */

public class DialogoPersonalizado extends DialogFragment {
    private Button bttnCrearCuenta, bttnEntrarCuenta;
    private CheckBox checkBox_Recordarme;
    private EditText editTextNombre, editTextContraseña;
    private CheckedTextView textViewOlvidasteContraseña;

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        try {
            listener = (OnDialogoPersonalizadoListener) context;
        }catch (ClassCastException e){
            e.printStackTrace();
        }
    }

    public interface OnDialogoPersonalizadoListener {
        void entrarCuenta(String usuario,String contraseña);
        void crearCuenta();
    }
    OnDialogoPersonalizadoListener listener;

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
        editTextNombre = (EditText) view.findViewById(R.id.ti_et_name);
        editTextContraseña = (EditText)view.findViewById(R.id.ti_et_password);
        textViewOlvidasteContraseña = (CheckedTextView) view.findViewById(R.id.tv_olvidaste_contraseña);

        bttnCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.crearCuenta();
                dismiss();
            }
        });

        bttnEntrarCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextNombre.getText().toString().isEmpty() || editTextContraseña.getText().toString().isEmpty()){
                    if (editTextNombre.getText().toString().isEmpty()){
                        editTextNombre.setError("Introduce un usuario válido");
                    }
                    if (editTextContraseña.getText().toString().isEmpty()){
                        editTextContraseña.setError("Introduce una contraseña válida");
                    }
                } else {
                    listener.entrarCuenta(editTextNombre.getText().toString(),editTextContraseña.getText().toString());
                    dismiss();
                }
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
