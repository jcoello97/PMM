package com.example.mati.ejemplorecopilacin;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private Spinner spinner;
    private RadioButton radioButtonTarifaNormal, radioButtonTarifaUrgente;
    private CheckBox checkBoxCajaRegalo, checkBoxTarjetaDedicada;
    private EditText editTextPesoPaquete;
    private Button buttonHacerCalculos;
    private Destino[] destinos = new Destino[]
            {
                    new Destino("ZonaA","Asia y Oceanía",30),
                    new Destino("ZonaB","América y África",20),
                    new Destino("ZonaC","Europa",10)

            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarComponentesUI();
        iniciarSpinner();
    }

    private void iniciarSpinner() {

        AdapterSpinner adapter = new AdapterSpinner(this,destinos);
        spinner.setAdapter(adapter);

    }

    private void iniciarComponentesUI()
    {
        spinner = (Spinner) findViewById(R.id.spinnerZonas);

        radioButtonTarifaNormal = (RadioButton) findViewById(R.id.rdButtonTarifaNormal);
        radioButtonTarifaUrgente = (RadioButton) findViewById(R.id.rdButtonUrgente);

        checkBoxCajaRegalo = (CheckBox) findViewById(R.id.checkBoxCajaRegalo);
        checkBoxTarjetaDedicada = (CheckBox) findViewById(R.id.checkBoxTarjetaDedicada);

        editTextPesoPaquete = (EditText) findViewById(R.id.editTextPeso);

        buttonHacerCalculos = (Button) findViewById(R.id.buttonHacerCalculos);
    }
}

