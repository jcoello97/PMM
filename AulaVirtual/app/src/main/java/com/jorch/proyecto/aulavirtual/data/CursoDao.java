package com.jorch.proyecto.aulavirtual.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

/**
 * Created by JORCH on 18/01/2017.
 */

public class CursoDao
{
    private static AulaVirtualSQLiteHelper baseDatos;
    private static CursoDao instance = new CursoDao();
    private CursoDao(){}

    public static CursoDao createInstance (Context context){
        if (baseDatos == null){
            baseDatos = new AulaVirtualSQLiteHelper(context);
        }
        return instance;
    }
}
