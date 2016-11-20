package com.trabajo.jorch.activityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EdadActivity extends AppCompatActivity {

    private TextView textViewEdad;
    private Button buttonAceptar, buttonCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edad);

        textViewEdad = (TextView) findViewById(R.id.tvResultadoEdad);
        buttonAceptar = (Button) findViewById(R.id.bttnResultadoEdadAceptar);
        buttonCancelar = (Button)findViewById(R.id.bttnResultadoEdadCancelar);

        Intent mIntent = getIntent();
        String edad = mIntent.getStringExtra("edad");
        textViewEdad.setText(edad);
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
