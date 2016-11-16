package com.example.mati.ejemplorecopilacin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    private TextView textViewZonas, textViewTarifas, textViewPrecioFinal, textViewPeso, textViewDecoracion;
    private String mZona,mTarifa,mPeso,mPrecioFinal,mDecoracion;
    private Facturacion mFacturacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        iniciarComponentesUI();

    }

    private void iniciarComponentesUI() {
        textViewZonas = (TextView) findViewById(R.id.textView_Resultado_Zonas);
        textViewTarifas = (TextView) findViewById(R.id.textView_Resultado_Tarifa);
        textViewPeso = (TextView) findViewById(R.id.textView_Resultado_Peso);
        textViewPrecioFinal = (TextView) findViewById(R.id.textView_Resultado_Final);
        textViewDecoracion = (TextView) findViewById(R.id.textView_Resultado_Decoracion);

        mostrarFactura();



    }

    private void mostrarFactura() {
        Intent intent = getIntent();
        mFacturacion = (Facturacion) intent.getSerializableExtra("factura");
        mZona = intent.getStringExtra("zona");
        mDecoracion = intent.getStringExtra("decoracion");

        if (mFacturacion.isUrgente()) {
            mTarifa = "Urgente";
        }
        else{
            mTarifa = "Normal";
        }
        mPeso = String.valueOf(mFacturacion.getPesoPaquete());
        mPrecioFinal = String.valueOf(mFacturacion.getPrecioFinal());


        textViewZonas.setText(mZona);
        textViewTarifas.setText(mTarifa);
        textViewPeso.setText(mPeso);
        textViewDecoracion.setText(mDecoracion);
        textViewPrecioFinal.setText(mPrecioFinal);
    }
}
