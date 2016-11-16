package com.example.mati.ejemplorecopilacin;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private Spinner spinner;
    private RadioButton radioButtonTarifaNormal, radioButtonTarifaUrgente;
    private CheckBox checkBoxCajaRegalo, checkBoxTarjetaDedicada;
    private EditText editTextPesoPaquete;
    private Button buttonHacerCalculos;
    private RadioGroup radioGroupTarifas;
    private Facturacion facturacion = new Facturacion();
    private String mZona;
    private String mDecoracion = "";
    private Destino[] destinos = new Destino[]
            {
                    new Destino("ZonaA","Asia y Oceanía",30.0),
                    new Destino("ZonaB","América y África",20.0),
                    new Destino("ZonaC","Europa",10.0)

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

        radioGroupTarifas = (RadioGroup) findViewById(R.id.rdgroupTarifas);

        checkBoxCajaRegalo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    if (mDecoracion.isEmpty())
                    {
                        mDecoracion = "Caja Regalo";
                    }
                    else
                    {
                        mDecoracion = mDecoracion +" y Caja Regalo";
                    }
                }
            }
        });
        checkBoxTarjetaDedicada.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    if (mDecoracion.isEmpty())
                    {
                        mDecoracion = "Tarjeta Dedicada";
                    }
                    else
                    {
                        mDecoracion = mDecoracion +" y Tarjeta Dedicada";
                    }
                }
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                facturacion.setPrecioZona(destinos[position].getPrecio());
                mZona = destinos[position].getZona();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if(!editTextPesoPaquete.getText().toString().isEmpty())
        {
            facturacion.setPrecioPaquete(Double.parseDouble(editTextPesoPaquete.getText().toString()));
            facturacion.setPesoPaquete(Double.parseDouble(editTextPesoPaquete.getText().toString()));

        }
        radioGroupTarifas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (group.getCheckedRadioButtonId())
                {
                    case R.id.rdButtonTarifaNormal:
                        facturacion.setUrgente(Boolean.FALSE);
                        break;

                    case R.id.rdButtonUrgente:
                        facturacion.setUrgente(Boolean.TRUE);
                        break;
                }
            }
        });

        buttonHacerCalculos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Resultado.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("factura",facturacion);
                bundle.putString("zona",mZona);
                bundle.putString("decoracion",mDecoracion);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}

