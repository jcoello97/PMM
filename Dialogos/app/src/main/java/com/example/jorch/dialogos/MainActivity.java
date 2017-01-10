package com.example.jorch.dialogos;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements
        DialogoPersonalizado.OnDialogoPersonalizadoListener,
        DialogoConListaDeRadios.OnDialogoListaRadiosListener,
        DatePickerDialog.OnDateSetListener,
        TimePickerDialog.OnTimeSetListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListaDialogosFragment listaDialogosFragment = (ListaDialogosFragment) getFragmentManager().findFragmentById(R.id.main_container);

        if (listaDialogosFragment == null){
            listaDialogosFragment = ListaDialogosFragment.newInstance();
            getFragmentManager().beginTransaction().add(R.id.main_container,listaDialogosFragment).commit();
        }
    }
    @Override
    public void entrarCuenta(String usuario, String contraseña) {
        Toast.makeText(getApplicationContext(),"USUARIO: "+usuario+"\nCONTRASEÑA: "+contraseña,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void crearCuenta() {
        Toast.makeText(getApplicationContext(),"Creando cuenta",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void opcionElegida(String opcion) {
        PruebaComunicacionFragment fragment = (PruebaComunicacionFragment) getFragmentManager().findFragmentByTag("PRUEBA_COMUNICACION");

        fragment.ponerOpcion(opcion);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Toast.makeText(getApplicationContext(),"FECHA ELEGIDA: "+dayOfMonth+" de "+month+" del "+year,Toast.LENGTH_SHORT).show();
        DialogoFullScreen fragment = (DialogoFullScreen) getFragmentManager().findFragmentByTag("PRUEBA");
        fragment.setFecha(year,month,dayOfMonth);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Toast.makeText(getApplicationContext(),"TIEMPO ACTUAL: "+hourOfDay+":"+minute,Toast.LENGTH_SHORT).show();

    }
}
