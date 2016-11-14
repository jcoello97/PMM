package com.example.mati.ejerlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class LayoutEjercicio2 extends AppCompatActivity {

    protected Button btnColorRojo,btnColorAmarillo,btnColorAzul, btnClear;
    protected TextView txtViewFila;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_ejercicio2);

        iniciarComponentes();



    }

    protected void iniciarComponentes()
    {
        btnColorRojo = (Button) findViewById(R.id.btnColorRojo);
        btnColorAmarillo = (Button) findViewById(R.id.btnAmarillo);
        btnColorAzul = (Button) findViewById(R.id.btnColorAzul);
        btnClear = (Button) findViewById(R.id.btnClear);
        txtViewFila = (TextView) findViewById(R.id.txtViewColoresFila);

        operacionesBotones();
    }
    protected void operacionesBotones()
    {

        btnColorRojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtViewFila.setBackgroundColor(getResources().getColor(R.color.colorRojo));
            }
        });
        btnColorAzul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtViewFila.setBackgroundColor(getResources().getColor(R.color.colorAzul));
            }
        });
        btnColorAmarillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtViewFila.setBackgroundColor(getResources().getColor(R.color.colorAmarillo));
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtViewFila.setBackgroundColor(getResources().getColor(R.color.colorNegro));
            }
        });
    }
}
