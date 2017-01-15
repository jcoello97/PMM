package com.example.jorch.examen1rtrimestre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerCoches;
    private EditText editTextNumHoras;
    private Button buttonTotalPrecio, buttonFactura;
    private RadioButton radioButtonSinSeguro, radioButtonConSeguro;
    private RadioGroup radioGroupSeguros;
    private CheckBox checkBoxAire, checkBoxGps, checkBoxRadioDvd;
    private TextView textViewTotalPrecio;
    private Coche[] coches = new Coche[]{
            new Coche("Megane","Seat",20,R.drawable.megan1),
            new Coche("X-11","Ferrari",100,R.drawable.ferrari1),
            new Coche("Leon","Seat",30,R.drawable.leon1),
            new Coche("Fiesta","Ford",40,R.drawable.fiesta1)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerCoches = (Spinner) findViewById(R.id.spinner);
        editTextNumHoras = (EditText) findViewById(R.id.et_num_horas);
        buttonTotalPrecio = (Button) findViewById(R.id.bttn_total_precio);
        buttonFactura = (Button) findViewById(R.id.bttn_factura);
        radioButtonSinSeguro = (RadioButton) findViewById(R.id.rbttn_sin_seguro);
        radioButtonConSeguro = (RadioButton) findViewById(R.id.rbttn_con_seguro);
        radioGroupSeguros = (RadioGroup) findViewById(R.id.radioGroupSeguros);
        checkBoxAire = (CheckBox) findViewById(R.id.cb_aire_acondicionado);
        checkBoxGps = (CheckBox) findViewById(R.id.cb_gps);
        checkBoxRadioDvd = (CheckBox) findViewById(R.id.cb_radio_dvd);
        textViewTotalPrecio = (TextView) findViewById(R.id.tv_total_precio);

        AdaptadorSpinnerCoches adapter = new AdaptadorSpinnerCoches(this,coches);
        spinnerCoches.setAdapter(adapter);


    }
}
