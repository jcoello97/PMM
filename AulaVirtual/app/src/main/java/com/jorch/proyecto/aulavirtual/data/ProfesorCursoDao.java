package com.jorch.proyecto.aulavirtual.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

/**
 * Created by JORCH on 18/01/2017.
 */

public class ProfesorCursoDao {
    private static AulaVirtualSQLiteHelper baseDatos;
    private static ProfesorCursoDao instance = new ProfesorCursoDao();
    private ProfesorCursoDao(){}

    public static ProfesorCursoDao createInstance (Context context){
        if (baseDatos == null){
            baseDatos = new AulaVirtualSQLiteHelper(context);
        }
        return instance;
    }
    public Cursor obtenerAllCursosByProfesorId(String profesorId){
        SQLiteDatabase db = baseDatos.getReadableDatabase();
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        String inners = "" +
                "profesores_cursos INNER JOIN profesores ON profesores_cursos.id_profesor = profesores.id " +
                "INNER JOIN cursos ON profesores_cursos.id_curso = cursos.id";
        builder.setTables(inners);
        String[] columnas = {
                AulaVirtualSQLiteHelper.Tablas.CURSOS+"."+AulaVirtualContract.Cursos.NOMBRE,
                AulaVirtualContract.Cursos.DESCRIPCION,
                AulaVirtualContract.Cursos.FOTO_CURSO
        };
        String whereClause = String.format("%s=?", AulaVirtualContract.ProfesoresCursos.ID_PROFESOR);
        String[] whereArgs = {profesorId};
        return builder.query(db,columnas,whereClause,whereArgs,null,null,null);
    }
}
