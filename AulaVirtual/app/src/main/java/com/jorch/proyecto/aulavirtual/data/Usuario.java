package com.jorch.proyecto.aulavirtual.data;

import android.content.ContentValues;
import android.database.Cursor;
/**
 * Created by JORCH on 14/01/2017.
 */

public class Usuario {
    private String id;
    private String nombre;
    private String contraseña;
    private String correo;
    private String rol;

    public Usuario(String nombre, String contraseña, String correo, String rol) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.correo = correo;
        this.rol = rol;
    }

    public Usuario(Cursor cursor){
        id = cursor.getString(cursor.getColumnIndex(AulaVirtualContract.ColumnasUsuarios.ID));
        nombre = cursor.getString(cursor.getColumnIndex(AulaVirtualContract.ColumnasUsuarios.USUARIO));
        contraseña = cursor.getString(cursor.getColumnIndex(AulaVirtualContract.ColumnasUsuarios.CONTRASEÑA));
        correo = cursor.getString(cursor.getColumnIndex(AulaVirtualContract.ColumnasUsuarios.CORREO));
        rol = cursor.getString(cursor.getColumnIndex(AulaVirtualContract.ColumnasUsuarios.ROL));
    }

    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(AulaVirtualContract.ColumnasUsuarios.ID,id);
        values.put(AulaVirtualContract.ColumnasUsuarios.USUARIO,nombre);
        values.put(AulaVirtualContract.ColumnasUsuarios.CONTRASEÑA,contraseña);
        values.put(AulaVirtualContract.ColumnasUsuarios.CORREO,correo);
        values.put(AulaVirtualContract.ColumnasUsuarios.ROL,rol);
        return values;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public String getRol() {
        return rol;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
