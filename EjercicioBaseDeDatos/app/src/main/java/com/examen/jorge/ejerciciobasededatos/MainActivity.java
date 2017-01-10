package com.examen.jorge.ejerciciobasededatos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerClientes;
    private  Cliente[] clientes= new Cliente[]{};
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
            }while(cursor.moveToNext());
        }


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
