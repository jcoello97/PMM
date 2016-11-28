package com.trabajo.jorch.canvas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerTipoDibujo;
    private String[] dibujos = new String[]{" ","TRIANGULO","CIRCULO","CUADRADO","ARCO","RECTANGULO"};
    private Intent mIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerTipoDibujo = (Spinner) findViewById(R.id.spinnerTipoDibujo);
        AdaptadorSpinner adaptadorSpinner = new AdaptadorSpinner(this,dibujos);
        spinnerTipoDibujo.setAdapter(adaptadorSpinner);
        spinnerTipoDibujo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (dibujos[position]){
                    case "CIRCULO":
                        mIntent = new Intent(MainActivity.this,DibujoCirculo.class);
                        startActivity(mIntent);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
