package com.example.mati.combinacion;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Combinacion extends AppCompatActivity {

    protected Button miBoton;
    protected TextView miTexto;
    int cont = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combinacion);

        miBoton = (Button) findViewById(R.id.botonPrueba1);

        miTexto = (TextView) findViewById(R.id.texto1);

        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                cont++;
                miTexto.setText("Has pulsado el boton "+cont+" veces.");
            }
        });

    }
}
