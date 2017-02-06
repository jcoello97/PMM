package com.examen.jorge.ejemplocontentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mati on 25/01/17.
 */
public class UsuariosSqliteHelper extends SQLiteOpenHelper{
    String sql = "CREATE TABLE Usuarios " +
            "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "usuario TEXT, " +
            "password TEXT, " + "email TEXT )";

    public UsuariosSqliteHelper(Context contexto, String nombre, SQLiteDatabase.CursorFactory almacen, int version) {
        super(contexto, nombre, almacen, version);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);

        for (int i=1; i<=10; i++) {
            String usuario = "usuario" + i;
            String password = "passw" + i;
            String email = "email" + i + "@cefire.com";
            db.execSQL
                    ("INSERT INTO Usuarios (usuario, password, email) " +
                            " VALUES ('" + usuario + "', '" + password + "', '" + email + "')");
        }
    }
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS Usuarios");
        db.execSQL(sql);
    }
}
