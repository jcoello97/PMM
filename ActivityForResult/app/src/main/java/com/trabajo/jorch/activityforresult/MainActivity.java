package com.trabajo.jorch.activityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private Button buttonEnviarNombre, buttonEnviarEdad;
    private EditText editTextNombre, editTextEdad;


    private static int REQUEST_NOMBRE = 0;
    private static int REQUEST_EDAD = 1;
    private Bundle mBundle = new Bundle();
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEnviarNombre = (Button) findViewById(R.id.buttonNombre);
        buttonEnviarEdad = (Button) findViewById(R.id.buttonEdad);
        editTextNombre = (EditText) findViewById(R.id.etNombre);
        editTextEdad = (EditText) findViewById(R.id.etEdad);

        buttonEnviarNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextNombre.getText().toString().trim().isEmpty()){
                    editTextNombre.setError("Escriba el nombre primero");
                }else {
                    mIntent = new Intent(MainActivity.this,NombreActivity.class);
                    String nombre = editTextNombre.getText().toString();
                    mBundle.putString("nombre",nombre);
                    mIntent.putExtras(mBundle);
                    startActivityForResult(mIntent,MainActivity.REQUEST_NOMBRE);
                }
            }
        });
        buttonEnviarEdad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextEdad.getText().toString().trim().isEmpty()){
                    editTextEdad.setError("Escriba la edad primero");
                }
                else {
                    mIntent = new Intent(MainActivity.this,EdadActivity.class);
                    String edad = editTextEdad.getText().toString();
                    mBundle.putString("edad",edad);
                    mIntent.putExtras(mBundle);
                    startActivityForResult(mIntent,MainActivity.REQUEST_EDAD);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED){
            if (requestCode == REQUEST_NOMBRE){
                Toast.makeText(getApplicationContext(),"La ventana nombre fue cancelada",Toast.LENGTH_SHORT).show();
            }
            if (requestCode == REQUEST_EDAD){
                Toast.makeText(getApplicationContext(),"La ventana edad fue cancelada",Toast.LENGTH_SHORT).show();
            }
        }
        if (resultCode == RESULT_OK){
            if (requestCode == REQUEST_NOMBRE){
                Toast.makeText(getApplicationContext(),"Acabamos de venir de la ventana nombre",Toast.LENGTH_SHORT).show();
            }
            if (requestCode == REQUEST_EDAD){
                Toast.makeText(getApplicationContext(),"Acabamos de venir de la ventana edad ",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
