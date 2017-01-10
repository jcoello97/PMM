package com.examen.jorge.ejerciciobasededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mati on 9/01/17.
 */
public class ClientesSQLiteHelper extends SQLiteOpenHelper{
    String tabla = "CREATE TABLE Clientes (codigo INTEGER,nombre TEXT, telefono TEXT)";
    public ClientesSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Clientes");
        db.execSQL(tabla);
    }
}
