package com.examen.jorge.ejerciciobasededatos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerClientes;
    private  ArrayList<Cliente> clientes= new ArrayList<Cliente>();
    String[] columnas = new String[] {"codigo","nombre", "telefono"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClientesSQLiteHelper clientesSQLHelper = new ClientesSQLiteHelper(this,"DBClientes",null,1);
        spinnerClientes = (Spinner) findViewById(R.id.spinnerClientes);
        SQLiteDatabase bd = clientesSQLHelper.getReadableDatabase();

        Cursor cursor = bd.query("Clientes", columnas,null,null,null,null,null);

        if (cursor.moveToFirst()){
            do {
                int id = cursor.getInt(0);
                String nombre = cursor.getString(1);
                String telefono = cursor.getString(2);
                clientes.add(new Cliente(id,nombre,telefono));
            }while(cursor.moveToNext());
        }
        AdapterSpinnerClientes adapter = new AdapterSpinnerClientes(this,clientes);

        spinnerClientes.setAdapter(adapter);
        spinnerClientes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String mensaje = "ID:"+clientes.get(position).getId()+
                        "\nNOMBRE:"+clientes.get(position).getNombre()+
                        "\nTELEFONO:"+clientes.get(position).getTelefono();
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //SQLiteDatabase bd = clientesSQLHelper.getWritableDatabase();

        /*if (bd!=null){
            for (int cont=1; cont <=3; cont++){
                int codigo = cont;
                String nombre = "Cliente"+cont;
                String telefono = cont+"XXXXXXX";
                bd.execSQL("INSERT INTO Clientes (codigo, nombre, telefono) "+
                        "VALUES (" + codigo + ", '" + nombre + "', '" + telefono + "')");
            }
            ContentValues nuevoRegistro = new ContentValues();

            //Insertar un registro
            nuevoRegistro.put("nombre","cli10");
            nuevoRegistro.put("telefono", "101010");
            bd.insert("Clientes",null,nuevoRegistro);
            //bd.execSQL("INSERT INTO Clientes (nombre, telefono) VALUES ('cli1','11111') ");
            //Actualizar un registro
            //bd.execSQL("UPDATE Clientes SET telefono='00000' WHERE nombre='cli1' ");
            //Eliminar un registro
            //bd.execSQL("DELETE FROM Clientes");
        }*/

    }
}
