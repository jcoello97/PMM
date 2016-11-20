package com.trabajo.jorch.activityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NombreActivity extends AppCompatActivity {

    private TextView textViewNombre;
    private Button buttonAceptar,buttonCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombre);

        textViewNombre = (TextView) findViewById(R.id.tvResultadoNombre);
        buttonAceptar = (Button)findViewById(R.id.bttnResultadoNombreAceptar);
        buttonCancelar = (Button) findViewById(R.id.bttnResultadoNombreCancelar);

        Intent mIntent = getIntent();
        String nombre = mIntent.getStringExtra("nombre");

        textViewNombre.setText(nombre);

        buttonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });

        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
