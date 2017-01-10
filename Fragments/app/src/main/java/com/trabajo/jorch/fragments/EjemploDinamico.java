package com.trabajo.jorch.fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class EjemploDinamico extends AppCompatActivity {
    private Button buttonAñadirFragmento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_dinamico);
        buttonAñadirFragmento = (Button) findViewById(R.id.bttn_EjemDinam_añadirfragmento);

        buttonAñadirFragmento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.app.FragmentManager fragmentManager = getFragmentManager();
                android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();

                DinamicoFragment fragment = new DinamicoFragment();
                transaction.add(R.id.activity_ejemplo_dinamico,fragment);

                transaction.commit();
            }
        });
    }
}
