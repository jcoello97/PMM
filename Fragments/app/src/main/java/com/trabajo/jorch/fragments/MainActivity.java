package com.trabajo.jorch.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Intent mIntent = null;
    private Button buttonFragmentStatico, buttonFragmentDinamico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonFragmentStatico = (Button) findViewById(R.id.bttn_main_Estatico);
        buttonFragmentDinamico = (Button) findViewById(R.id.bttn_main_Dinamico);

        buttonFragmentStatico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(MainActivity.this,EjemploEstatico.class);
                startActivity(mIntent);
            }
        });

        buttonFragmentDinamico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(MainActivity.this,EjemploDinamico.class);
                startActivity(mIntent);
            }
        });
    }
}
