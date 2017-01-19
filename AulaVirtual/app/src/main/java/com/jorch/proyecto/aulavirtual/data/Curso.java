package com.jorch.proyecto.aulavirtual.data;

import android.content.ContentValues;
import android.database.Cursor;

import java.io.Serializable;

/**
 * Created by JORCH on 17/01/2017.
 */

public class Curso implements Serializable{
    private String id;
    private String nombre;
    private String descripcion;
    private int foto_curso;

    public Curso() {
    }

    public Curso(String nombre, String descripcion, int foto_curso) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.foto_curso = foto_curso;
    }

    public Curso (Cursor cursor){
        id = cursor.getString(cursor.getColumnIndex(AulaVirtualContract.Cursos.ID));
        nombre = cursor.getString(cursor.getColumnIndex(AulaVirtualContract.Cursos.NOMBRE));
        descripcion = cursor.getString(cursor.getColumnIndex(AulaVirtualContract.Cursos.DESCRIPCION));
        foto_curso = cursor.getInt(cursor.getColumnIndex(AulaVirtualContract.Cursos.FOTO_CURSO));
    }
    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(AulaVirtualContract.Cursos.ID,id);
        values.put(AulaVirtualContract.Cursos.NOMBRE,nombre);
        values.put(AulaVirtualContract.Cursos.DESCRIPCION,descripcion);
        values.put(AulaVirtualContract.Cursos.FOTO_CURSO,foto_curso);
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
}
