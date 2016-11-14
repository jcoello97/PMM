package com.example.mati.ejerlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class LayoutEjercicio1 extends AppCompatActivity {

    protected RadioGroup groupColores;
    protected Button btnColor, btnCancelar;
    protected TextView txtViewColor;
    protected Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_ejercicio1);

        iniciarBotones();

    }

    public  void iniciarBotones()
    {
        groupColores = (RadioGroup) findViewById(R.id.rgColores);
        btnColor = (Button) findViewById(R.id.btnSetColor);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        txtViewColor = (TextView) findViewById(R.id.txtViewColores);

        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (groupColores.getCheckedRadioButtonId() == R.id.rbRed)
                {
                    txtViewColor.setBackgroundColor(getResources().getColor(R.color.colorRojo));
                }
                if (groupColores.getCheckedRadioButtonId() == R.id.rbWhite)
                {
                    txtViewColor.setBackgroundColor(getResources().getColor(R.color.colorBlanco));
                }
                if (groupColores.getCheckedRadioButtonId() == R.id.rbBlue)
                {
                    txtViewColor.setBackgroundColor(getResources().getColor(R.color.colorAzul));
                }
            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
