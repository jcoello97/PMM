package com.example.jorch.dialogos;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class DetalleActivity extends AppCompatActivity implements
        DialogoFullScreen.OnDialogoFullScreenListener,
        DatePickerDialog.OnDateSetListener,
        TimePickerDialog.OnTimeSetListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        DialogoFullScreen dialogoFullScreen = (DialogoFullScreen) getFragmentManager().findFragmentById(R.id.activity_detalle);
        dialogoFullScreen = DialogoFullScreen.newInstance();
        getFragmentManager().beginTransaction().add(R.id.activity_detalle,dialogoFullScreen,"DIALOGO_FULLSCREEN").commit();

    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        DialogoFullScreen fragment = (DialogoFullScreen) getFragmentManager().findFragmentByTag("DIALOGO_FULLSCREEN");
        fragment.setFecha(year,month,dayOfMonth);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        DialogoFullScreen fragment = (DialogoFullScreen) getFragmentManager().findFragmentByTag("DIALOGO_FULLSCREEN");
        fragment.setHora(hourOfDay,minute);
    }

    @Override
    public void datosGuardados(String cliente, String producto, String prioridad, String nota, String fecha, String hora) {
        Toast.makeText(getApplicationContext(),"CLIENTE: "+cliente+
                "\nPRODUCTO: "+producto+
                "\nPRIORIDAD: "+prioridad+
                "\nFECHA Y HORA: "+fecha+" | "+hora,Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void cerrarDetalle() {
        finish();
    }
}
