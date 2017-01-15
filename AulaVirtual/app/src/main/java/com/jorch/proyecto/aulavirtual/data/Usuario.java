package com.jorch.proyecto.aulavirtual.data;

import android.content.ContentValues;
import android.database.Cursor;

import com.jorch.proyecto.aulavirtual.data.Contracts.UsuarioContract;

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
        id = cursor.getString(cursor.getColumnIndex(UsuarioContract.UsuarioEntry.ID));
        nombre = cursor.getString(cursor.getColumnIndex(UsuarioContract.UsuarioEntry.NAME));
        contraseña = cursor.getString(cursor.getColumnIndex(UsuarioContract.UsuarioEntry.PASSWORD));
        correo = cursor.getString(cursor.getColumnIndex(UsuarioContract.UsuarioEntry.CORREO));
        rol = cursor.getString(cursor.getColumnIndex(UsuarioContract.UsuarioEntry.ROL));
    }

    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(UsuarioContract.UsuarioEntry.ID,id);
        values.put(UsuarioContract.UsuarioEntry.NAME,nombre);
        values.put(UsuarioContract.UsuarioEntry.PASSWORD,contraseña);
        values.put(UsuarioContract.UsuarioEntry.CORREO,correo);
        values.put(UsuarioContract.UsuarioEntry.ROL,rol);
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
}
