package com.example.mati.ejemploradiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    protected RadioGroup rg;
    protected TextView txtViewSeleccionarID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarlizarBotones();

    }

    public void iniciarlizarBotones()
    {
        rg = (RadioGroup) findViewById(R.id.grupoRbtn);

        txtViewSeleccionarID = (TextView) findViewById(R.id.txtViewSeleccionarID);
        rg.clearCheck();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                String texto = " ";
                if (group.getCheckedRadioButtonId() == R.id.rBtn1)
                {
                    texto = String.valueOf(checkedId);
                }
                if (group.getCheckedRadioButtonId() == R.id.rBtn2)
                {
                    texto = String.valueOf(checkedId);
                }
                txtViewSeleccionarID.setText("ID opción seleccionada "+texto);


            }
        });

    }
}
