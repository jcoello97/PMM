package com.jorch.proyecto.aulavirtual.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.jorch.proyecto.aulavirtual.R;
import com.jorch.proyecto.aulavirtual.data.AulaVirtualSQLiteHelper;

/**
 * Created by JORCH on 14/01/2017.
 */

public class CrearCuentaDialog extends DialogFragment {
    private TextInputLayout textInputLayoutUsuario, textInputLayoutPassword, textInputLayoutCorreo;
    private Button buttonCrearCuenta;
    private EditText editTextUsuario, editTextPassword, editTextCorreo;
    private Spinner spinnerRol;
    AulaVirtualSQLiteHelper aulaVirtualSQLiteHelper;
    String usuario, password, correo, rol;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_crear_cuenta,null);
        builder.setView(view);
        aulaVirtualSQLiteHelper = new AulaVirtualSQLiteHelper(getContext());
        textInputLayoutUsuario = (TextInputLayout) view.findViewById(R.id.til_crear_cuenta_usuario);
        textInputLayoutPassword = (TextInputLayout) view.findViewById(R.id.til_crear_cuenta_password);
        textInputLayoutCorreo = (TextInputLayout) view.findViewById(R.id.til_crear_cuenta_correo);
        editTextUsuario = (EditText) view.findViewById(R.id.et_crear_cuenta_usuario);
        editTextPassword = (EditText) view.findViewById(R.id.et_crear_cuenta_password);
        editTextCorreo = (EditText) view.findViewById(R.id.et_crear_cuenta_correo);
        spinnerRol = (Spinner) view.findViewById(R.id.sp_crear_cuenta);
        buttonCrearCuenta = (Button) view.findViewById(R.id.bttn_crear_cuenta);
        buttonCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextUsuario.setError(null);
                editTextPassword.setError(null);
                editTextCorreo.setError(null);
                usuario = editTextUsuario.getText().toString();
                password = editTextPassword.getText().toString();
                correo = editTextCorreo.getText().toString();
                View focusView = null;
                boolean cancel = false;

                if (TextUtils.isEmpty(usuario)) {
                    editTextUsuario.setError("Campo obligatorio");
                    focusView = editTextUsuario;
                    cancel = true;
                } else if (!isUserValid(usuario)) {
                    editTextUsuario.setError("Usuario inválido");
                    focusView = editTextUsuario;
                    cancel = true;
                }
                if (TextUtils.isEmpty(password)) {
                    editTextPassword.setError("Campo obligatorio");
                    focusView = editTextPassword;
                } else if (!isPasswordValid(password)) {
                    editTextPassword.setError("Contraseña inválida");
                    focusView = editTextPassword;
                    cancel = true;
                }
                if (TextUtils.isEmpty(correo)) {
                    editTextCorreo.setError("Campo obligatorio");
                    focusView = editTextCorreo;
                    cancel = true;
                } else if (!isEmailValid(correo)) {
                    editTextCorreo.setError("Email inválido");
                    focusView = editTextCorreo;
                    cancel = true;
                }
                rol = getResources().getStringArray(R.array.spinner_rol)[spinnerRol.getSelectedItemPosition()];
                spinnerRol.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        rol = getResources().getStringArray(R.array.spinner_rol)[position];
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                if (cancel) {
                    focusView.requestFocus();
                } else {
                    InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (editTextUsuario.hasFocus())
                        inputMethodManager.hideSoftInputFromWindow(editTextUsuario.getWindowToken(),0);
                    if (editTextPassword.hasFocus())
                        inputMethodManager.hideSoftInputFromWindow(editTextPassword.getWindowToken(),0);
                    if (editTextCorreo.hasFocus())
                        inputMethodManager.hideSoftInputFromWindow(editTextCorreo.getWindowToken(),0);

                    //TODO creacion de Usuario , añadido a la base de datos
                    aulaVirtualSQLiteHelper.saveUsuario(usuario,password,correo,rol);

                    dismiss();
                    Toast.makeText(getContext(),"CUENTA CREADA\nPor favor inicie sesión.",Toast.LENGTH_LONG).show();
                }
            }
        });
        return builder.create();
    }
    private boolean isUserValid(String usuario) {
        return usuario.length()<=10;
    }

    private boolean isPasswordValid(String password) {
        return password.length() <=15;
    }
    private boolean isEmailValid(String correo) {
        return correo.contains("@");
    }

}
