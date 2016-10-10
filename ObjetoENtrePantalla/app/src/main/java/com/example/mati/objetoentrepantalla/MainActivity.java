package com.example.mati.objetoentrepantalla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected Button btnEnviar;
    protected RadioGroup radioGroupSexo;
    protected EditText editTextNombre, editTextApellido, editTextEdad;
    protected Intent miIntento;
    protected Bundle miBundle;

    String nombre,apellido,sexo;
    int edad;
    int imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();
    }

    protected void iniciarComponentes()
    {
        editTextNombre = (EditText) findViewById(R.id.campoNombre);
        editTextApellido = (EditText) findViewById(R.id.campoApellido);
        editTextEdad = (EditText) findViewById(R.id.campoEdad);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        radioGroupSexo = (RadioGroup) findViewById(R.id.rdgroupSexo);

        funcionBotonEnviar();

    }
    protected void funcionBotonEnviar()
    {
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (comprobarVacio() == Boolean.FALSE)
                {
                    datosPersona();


                    Persona persona = new Persona(nombre, apellido, edad,sexo,imagen);
                    miIntento = new Intent(MainActivity.this,Pantalla2.class);
                    miBundle = new Bundle();

                    miBundle.putSerializable("Persona",persona);

                    miIntento.putExtras(miBundle);

                    startActivity(miIntento);

                }
                else
                {

                    showToast("Por favor rellene todos los datos.");

                }

            }
        });
    }
    protected boolean comprobarVacio()
    {
        if(editTextNombre.getText().toString().isEmpty() || editTextApellido.getText().toString().isEmpty() || editTextEdad.getText().toString().isEmpty())
        {
            return Boolean.TRUE;
        }
        else
        {
            return Boolean.FALSE;
        }
    }

    protected  void showToast(CharSequence text)
    {
        Toast toast = Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
        toast.show();
    }
    protected void datosPersona()
    {
        nombre = editTextNombre.getText().toString();
        apellido = editTextApellido.getText().toString();
        edad = Integer.parseInt(editTextEdad.getText().toString());

        if (radioGroupSexo.getCheckedRadioButtonId() == R.id.rdSexoFemenino)
        {
            sexo = "Mujer" ;
            imagen = R.drawable.siluetamujer;
        }
        if (radioGroupSexo.getCheckedRadioButtonId() == R.id.rdSexoMasculino)
        {
            sexo = "Hombre";
            imagen = R.drawable.siluetahombre;
        }
    }
}
