package com.example.mati.objetoentrepantalla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Pantalla2 extends AppCompatActivity {

    protected Bundle miBundle;
    protected TextView resultado;
    protected ImageView imageView;
    protected Persona persona;
    protected String nombrePersona,apellidoPersona,edadPersona,fotoPersona,sexoPersona;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);


        resultado = (TextView) findViewById(R.id.txtViewResultado);
        imageView = (ImageView) findViewById(R.id.imageView);
        miBundle = getIntent().getExtras();

        persona = (Persona) miBundle.getSerializable("Persona");
        nombrePersona = persona.getNombre();
        apellidoPersona = persona.getApellido();
        edadPersona = String.valueOf(persona.getEdad());
        fotoPersona = String.valueOf(persona.getFoto());
        sexoPersona = persona.getSexo();

        String resultadoTexto = "Nombre: "+nombrePersona
                +"\nApellido: "+apellidoPersona
                +"\nEdad: "+edadPersona
                +"\nSexo: "+sexoPersona;

        resultado.setText(resultadoTexto);
        imageView.setImageResource(persona.getFoto());



    }
    public void botonVolver(View v)
    {
        setResult(RESULT_OK);
        finish();
    }
}
