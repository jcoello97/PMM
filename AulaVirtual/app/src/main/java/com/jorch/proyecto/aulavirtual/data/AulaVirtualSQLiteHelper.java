package com.jorch.proyecto.aulavirtual.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jorch.proyecto.aulavirtual.data.Contracts.UsuarioContract;

/**
 * Created by JORCH on 14/01/2017.
 */

public class AulaVirtualSQLiteHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "AulaVirtual.db";

    private String crearTablaUsuario = "CREATE TABLE "+ UsuarioContract.UsuarioEntry.TABLE_NAME + " ("
            + UsuarioContract.UsuarioEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UsuarioContract.UsuarioEntry.NAME + " TEXT NOT NULL,"
            + UsuarioContract.UsuarioEntry.PASSWORD + " TEXT NOT NULL,"
            + UsuarioContract.UsuarioEntry.CORREO + " TEXT NOT NULL,"
            + UsuarioContract.UsuarioEntry.ROL + " TEXT NOT NULL,"
            + "UNIQUE (" + UsuarioContract.UsuarioEntry.ID + "))";

    public AulaVirtualSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(crearTablaUsuario);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //USUARIOS
    public long saveUsuario(Usuario usuario){
        return getWritableDatabase().insert(
                UsuarioContract.UsuarioEntry.TABLE_NAME,
                null,
                usuario.toContentValues());
    }
    public long saveUsuario(String nombreUsuario,String contraseña, String correo, String rol){
        Usuario usuario = new Usuario(nombreUsuario,contraseña,correo,rol);
        return getWritableDatabase().insert(
                UsuarioContract.UsuarioEntry.TABLE_NAME,
                null,
                usuario.toContentValues());
    }
    public int updateUsuario (String usuarioId, Usuario usuario){
        return getWritableDatabase().update(
                UsuarioContract.UsuarioEntry.TABLE_NAME,
                usuario.toContentValues(),
                UsuarioContract.UsuarioEntry.ID + " LIKE ?",
                new String[]{usuarioId});
    }
    public int deleteUsuario(String usuarioId){
        return getWritableDatabase().delete(
                UsuarioContract.UsuarioEntry.TABLE_NAME,
                UsuarioContract.UsuarioEntry.ID+" LIKE ?",
                new String[]{usuarioId});
    }
    public int deleteUsuario(Usuario usuario){
        String usuarioId = usuario.getId();
        return getWritableDatabase().delete(
                UsuarioContract.UsuarioEntry.TABLE_NAME,
                UsuarioContract.UsuarioEntry.ID+" LIKE ?",
                new String[]{usuarioId});
    }
    public Cursor getUsuarioById(String usuarioId){
        Cursor cursor = getReadableDatabase().query(
                UsuarioContract.UsuarioEntry.TABLE_NAME,
                null,
                UsuarioContract.UsuarioEntry.ID +" LIKE ?",
                new String[]{usuarioId},
                null,
                null,
                null);
        return cursor;
    }
    public Cursor getAllUsuarios(){
        return getReadableDatabase().query(
                UsuarioContract.UsuarioEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);
    }
}
