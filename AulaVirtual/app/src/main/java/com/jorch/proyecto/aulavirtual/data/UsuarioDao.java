package com.jorch.proyecto.aulavirtual.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by JORCH on 17/01/2017.
 */

public final class UsuarioDao {
    private static AulaVirtualSQLiteHelper baseDatos;
    private static UsuarioDao instance = new UsuarioDao();
    private UsuarioDao(){};

    public static UsuarioDao createInstance (Context context){
        if (baseDatos == null){
            baseDatos = new AulaVirtualSQLiteHelper(context);
        }
        return instance;
    }
    public String insertarUsuario(Usuario usuario){
        SQLiteDatabase db = baseDatos.getWritableDatabase();
        String idUsuario = AulaVirtualContract.Usuarios.generarIdUsuario();
        usuario.setId(idUsuario);
        db.insertOrThrow(AulaVirtualSQLiteHelper.Tablas.USUARIOS,null,usuario.toContentValues());
        return idUsuario;
    }
    public String insertarUsuario(String nombreUsuario,String contraseña, String correo, String rol){
        SQLiteDatabase db = baseDatos.getWritableDatabase();
        Usuario usuario = new Usuario(nombreUsuario,contraseña,correo,rol);
        String idUsuario = AulaVirtualContract.Usuarios.generarIdUsuario();
        usuario.setId(idUsuario);
        db.insertOrThrow(AulaVirtualSQLiteHelper.Tablas.USUARIOS,null,usuario.toContentValues());
        return idUsuario;
    }
    public boolean actualizarUsuario (Usuario usuarioNuevo){
        SQLiteDatabase db = baseDatos.getWritableDatabase();
        String whereClause = String.format("%s=?",AulaVirtualContract.ColumnasUsuarios.ID);
        String[] whereArgs ={usuarioNuevo.getId()};
        int resultado = db.update(
                AulaVirtualSQLiteHelper.Tablas.USUARIOS,
                usuarioNuevo.toContentValues(),
                whereClause,
                whereArgs
                );
        return resultado > 0;
    }
    public boolean eliminarUsuario(String usuarioId){
        SQLiteDatabase db = baseDatos.getWritableDatabase();
        String whereClause = String.format("%s=?",AulaVirtualContract.Usuarios.ID);
        String[] whereArgs = {usuarioId};
        int resultado = db.delete(AulaVirtualSQLiteHelper.Tablas.USUARIOS,whereClause,whereArgs);
        return resultado > 0;
    }
    public boolean eliminarUsuario(Usuario usuario){
        SQLiteDatabase db = baseDatos.getWritableDatabase();
        String whereClause = String.format("%s=?",AulaVirtualContract.Usuarios.ID);
        String[] whereArgs = {usuario.getId()};
        int resultado = db.delete(AulaVirtualSQLiteHelper.Tablas.USUARIOS,whereClause,whereArgs);
        return resultado > 0;
    }
    public Cursor obtenerUsuario(String usuarioId){
        SQLiteDatabase db = baseDatos.getReadableDatabase();
        String sql = String.format("SELECT * FROM %s WHERE %s=?",
                AulaVirtualSQLiteHelper.Tablas.USUARIOS,
                AulaVirtualContract.Usuarios.ID);
        return db.rawQuery(sql,new String[]{usuarioId});
    }
    public Cursor obtenerAllUsuarios(){
        SQLiteDatabase db = baseDatos.getReadableDatabase();
        //String sql = String.format("SELECT * FROM %s", AulaVirtualSQLiteHelper.Tablas.USUARIOS);
        return db.query(AulaVirtualSQLiteHelper.Tablas.USUARIOS,null,null,null,null,null,null);
    }
}
