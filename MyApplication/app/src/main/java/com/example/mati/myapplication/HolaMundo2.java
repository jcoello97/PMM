package com.example.mati.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class HolaMundo2 extends AppCompatActivity {

    protected MediaPlayer miMusica;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holamundo2);


        miMusica= MediaPlayer.create(getApplicationContext(),R.raw.simpson);

        miMusica.start();
        final TextView mensajeMostrar = (TextView) findViewById(R.id.mensaje);
        ImageButton botonVolver = (ImageButton) findViewById(R.id.botonVolver);

        Bundle miBundleRecoger = getIntent().getExtras();

        mensajeMostrar.setText(miBundleRecoger.getString("Respuesta"));
        final String completarSaludo = miBundleRecoger.getString("Respuesta");

        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent miIntentVolver = new Intent();
                Bundle miBundleVolver = new Bundle();

                String mensajeDevuelto ="Devuelto al menu Principal: "+completarSaludo;

                miBundleVolver.putString("Devuelto",mensajeDevuelto);
                miIntentVolver.putExtras(miBundleVolver);

                setResult(RESULT_OK,miIntentVolver);
                finish();

            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"Iniciando HolaMundo2", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"Resumen HolaMundo2", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        Toast.makeText(this,"En pausa HolaMundo2", Toast.LENGTH_SHORT).show();
        super.onPause();
    }
    @Override
    protected void onStop() {

        super.onStop();
        miMusica.stop();
        Toast.makeText(this,"Saliendo HolaMundo2", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"Volviendo a HolaMundo2", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        Toast.makeText(this,"Destruyendo  HolaMundo2", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
