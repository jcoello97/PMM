package com.jorch.proyecto.aulavirtual.data;

import android.content.ContentValues;
import android.database.Cursor;

/**
 * Created by JORCH on 17/01/2017.
 */

public class Curso {
    private String id;
    private String nombre;
    private String descripcion;
    private int foto_curso;
    private String fecha_inicial;
    private String fecha_final;

    public Curso() {
    }

    public Curso(String nombre, String descripcion, int foto_curso, String fecha_inicial, String fecha_final) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.foto_curso = foto_curso;
        this.fecha_inicial = fecha_inicial;
        this.fecha_final = fecha_final;
    }

    public Curso (Cursor cursor){
        id = cursor.getString(cursor.getColumnIndex(AulaVirtualContract.Cursos.ID));
        nombre = cursor.getString(cursor.getColumnIndex(AulaVirtualContract.Cursos.NOMBRE));
        descripcion = cursor.getString(cursor.getColumnIndex(AulaVirtualContract.Cursos.DESCRIPCION));
        foto_curso = cursor.getInt(cursor.getColumnIndex(AulaVirtualContract.Cursos.FOTO_CURSO));
        fecha_inicial = cursor.getString(cursor.getColumnIndex(AulaVirtualContract.Cursos.FECHA_INICIO));
        fecha_final = cursor.getString(cursor.getColumnIndex(AulaVirtualContract.Cursos.FECHA_FIN));
    }
    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(AulaVirtualContract.Cursos.ID,id);
        values.put(AulaVirtualContract.Cursos.NOMBRE,nombre);
        values.put(AulaVirtualContract.Cursos.DESCRIPCION,descripcion);
        values.put(AulaVirtualContract.Cursos.FOTO_CURSO,foto_curso);
        values.put(AulaVirtualContract.Cursos.FECHA_INICIO,fecha_inicial);
        values.put(AulaVirtualContract.Cursos.FECHA_FIN, fecha_final);
        return values;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getFoto_curso() {
        return foto_curso;
    }

    public void setFoto_curso(int foto_curso) {
        this.foto_curso = foto_curso;
    }

    public String getFecha_inicial() {
        return fecha_inicial;
    }

    public void setFecha_inicial(String fecha_inicial) {
        this.fecha_inicial = fecha_inicial;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }
}
