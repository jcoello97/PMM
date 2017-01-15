package com.jorch.proyecto.aulavirtual.ui;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import android.os.AsyncTask;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jorch.proyecto.aulavirtual.R;
import com.jorch.proyecto.aulavirtual.data.AulaVirtualSQLiteHelper;
import com.jorch.proyecto.aulavirtual.data.Contracts.UsuarioContract;
import com.jorch.proyecto.aulavirtual.data.Usuario;
import com.jorch.proyecto.aulavirtual.dialogs.CrearCuentaDialog;
import com.jorch.proyecto.aulavirtual.ui.AulaActivity;
import com.jorch.proyecto.aulavirtual.utils.SesionPrefs;

public class LoginActivity extends AppCompatActivity {

    private static final String DUMMY_USER = "dummy_user";
    private static final String DUMMY_PASSWORD = "dummy_password";

    private UserLoginTask mAuthTask = null;

    // UI references.
    private ImageView imageViewLogo;
    private EditText editTextUsuario, editTextPassword;
    private TextInputLayout textInputLayoutUsuario, textInputLayoutPassword;
    private View mProgressView, mLoginFormView;
    private Button buttonIniciarSesion, buttonCrearCuenta;
    AulaVirtualSQLiteHelper aulaVirtualSQLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        aulaVirtualSQLiteHelper = new AulaVirtualSQLiteHelper(this);
        imageViewLogo = (ImageView) findViewById(R.id.img_login_logo);
        editTextUsuario = (EditText) findViewById(R.id.et_login_usuario);
        editTextPassword = (EditText) findViewById(R.id.et_login_password);
        textInputLayoutUsuario = (TextInputLayout) findViewById(R.id.til_login_usuario);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.til_login_password);
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        buttonIniciarSesion = (Button) findViewById(R.id.bttn_login_iniciar_sesion);
        buttonCrearCuenta = (Button) findViewById(R.id.bttn_login_crear_cuenta);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        editTextPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });


        buttonIniciarSesion.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //HAGO ESTO PARA CERRAR EL TECLADO AL DARLE AL BOTON
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                if (editTextUsuario.hasFocus())
                    inputMethodManager.hideSoftInputFromWindow(editTextUsuario.getWindowToken(),0);
                if (editTextPassword.hasFocus())
                    inputMethodManager.hideSoftInputFromWindow(editTextPassword.getWindowToken(),0);

                attemptLogin();
            }
        });
        buttonCrearCuenta.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().add(new CrearCuentaDialog(),"CREAR_CUENTA").commit();
            }
        });
    }

    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        editTextUsuario.setError(null);
        editTextPassword.setError(null);

        String usuario = editTextUsuario.getText().toString();
        String password = editTextPassword.getText().toString();

        boolean cancel = false;
        View focusView = null;

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
            cancel = true;
        } else if (!isPasswordValid(password)) {
            editTextPassword.setError("Contraseña inválida");
            focusView = editTextPassword;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            showProgress(true);
            mAuthTask = new UserLoginTask(usuario, password);
            mAuthTask.execute((Void) null);
        }
    }

    private boolean isUserValid(String usuario) {
        return usuario.length()<=10;
    }

    private boolean isPasswordValid(String password) {
        return password.length() <=15;
    }

    private void showProgress(boolean show) {
        mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);

        int visibility = show ? View.GONE : View.VISIBLE;
        imageViewLogo.setVisibility(visibility);
        mLoginFormView.setVisibility(visibility);
    }

    public class UserLoginTask extends AsyncTask<Void, Void, Integer> {

        private final String mUsuario;
        private final String mPassword;
        private Cursor cursor;
        UserLoginTask(String usuario, String password) {
            mUsuario = usuario;
            mPassword = password;
        }

        @Override
        protected Integer doInBackground(Void... params) {
            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return 3;
            }
            cursor = aulaVirtualSQLiteHelper.getAllUsuarios();
            if (cursor.moveToFirst()){
                do {
                    String usuario = cursor.getString(cursor.getColumnIndex(UsuarioContract.UsuarioEntry.NAME));
                    String password = cursor.getString(cursor.getColumnIndex(UsuarioContract.UsuarioEntry.PASSWORD));
                    if (mUsuario.equals(usuario) && mPassword.equals(password))
                        return  2;
                }while (cursor.moveToNext());
            }
            return 1;
        }

        @Override
        protected void onPostExecute(final Integer success) {
            mAuthTask = null;
            showProgress(false);

            switch (success){
                case 1:
                    showError("Usuario y/o Contraseña inválidas");
                    break;
                case 2:

                    SesionPrefs.get(LoginActivity.this).saveLogInUsuario(new Usuario(cursor));
                    showAulaVirtual();
                    break;
                case 3:
                    showError("Error en el servidor.");
                    break;
            }
        }

        private void showAulaVirtual(){
            startActivity(new Intent(getApplicationContext(),AulaActivity.class));
        }
        private void showError(String error){
            Toast.makeText(getApplicationContext(),error,Toast.LENGTH_LONG).show();
        }
        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }
}

