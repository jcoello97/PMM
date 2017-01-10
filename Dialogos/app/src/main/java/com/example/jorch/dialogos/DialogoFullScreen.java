package com.example.jorch.dialogos;

import android.app.ActionBar;
import android.app.Activity;
import android.app.DialogFragment;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by JORCH on 31/12/2016.
 */

public class DialogoFullScreen extends DialogFragment {
    private Spinner spinnerClientes, spinnerProductos, spinnerPrioridad;
    private TextView textViewFecha, textViewHora;
    private EditText editTextNotas;
    final Calendar calendar = Calendar.getInstance();
    SimpleDateFormat formatFecha = new SimpleDateFormat("E MMM d yyyy");
    SimpleDateFormat formatHora = new SimpleDateFormat("HH:mm a");
    String cliente, producto, prioridad, notas, fecha, hora;

    OnDialogoFullScreenListener listener;


    public interface OnDialogoFullScreenListener{
        void datosGuardados(String cliente, String producto, String prioridad, String nota,String fecha, String hora);
        void cerrarDetalle();
    }

    public static DialogoFullScreen newInstance() {

        Bundle args = new Bundle();

        DialogoFullScreen fragment = new DialogoFullScreen();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        android.support.v7.app.ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_close);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialogo_fullscreen,container,false);

        spinnerClientes = (Spinner) view.findViewById(R.id.sp_clientes);
        spinnerProductos = (Spinner) view.findViewById(R.id.sp_productos);
        spinnerPrioridad = (Spinner) view.findViewById(R.id.sp_prioridad);

        spinnerClientes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerClientes.setSelection(position);
                cliente = spinnerClientes.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerProductos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerProductos.setSelection(position);
                producto = spinnerProductos.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerPrioridad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerPrioridad.setSelection(position);
                prioridad = spinnerPrioridad.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        textViewFecha = (TextView) view.findViewById(R.id.tv_fecha);
        textViewHora = (TextView) view.findViewById(R.id.tv_hora);

        textViewFecha.setText(formatFecha.format(calendar.getTime()));
        textViewHora.setText(formatHora.format(calendar.getTime()));
        textViewFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DialogoDatePicker().show(getFragmentManager(),"DIALOGO_FECHA_EN_FULLSCREEN");
            }
        });
        textViewHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DialogoTimePicker().show(getFragmentManager(),"DIALOGO_TIEMPO_EN_FULLSCREEN");
            }
        });
        editTextNotas = (EditText) view.findViewById(R.id.et_notas);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (OnDialogoFullScreenListener) activity;
        }catch (ClassCastException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_dialogo_fullscreen,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                listener.cerrarDetalle();
                dismiss();
                break;
            case R.id.menu_item_guardar:
                notas = editTextNotas.getText().toString();
                fecha = textViewFecha.getText().toString();
                hora = textViewHora.getText().toString();
                listener.datosGuardados(cliente,producto,prioridad,notas,fecha,hora);
                dismiss();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setFecha(int año,int mes, int dia){
        calendar.set(año, mes, dia);
        textViewFecha.setText(formatFecha.format(calendar.getTime()));
    }
    public void setHora(int hora, int minutos){
        calendar.set(Calendar.HOUR,hora);
        calendar.set(Calendar.MINUTE,minutos);
        textViewHora.setText(formatHora.format(calendar.getTime()));
    }
}
