package com.examen.jorge.ejemplocontentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.Nullable;

/**
 * Created by mati on 25/01/17.
 */
public class UsuariosProvider extends ContentProvider {
    private static final String uri =
            "content://com.examen.jorge.Ejemplocontentprovider/usuarios";
    private static final Uri CONTENT_URI = Uri.parse(uri);

    //Base de datos
    private UsuariosSqliteHelper usudbh;
    private static final String BD_NOMBRE = "DBUsuarios";
    private static final int BD_VERSION = 1;
    private static final String TABLA_USUARIOS = "Usuarios";

    //UriMatcher
    private static final int USUARIOS = 1;
    private static final int USUARIOS_ID = 2;
    private static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(
                "com.examen.jorge.ejemploContentProvider.UsuariosProvider","usuarios",USUARIOS);
        uriMatcher.addURI(
                "com.examen.jorge.ejemploContentProvider.UsuariosProvider","usuarios/#",USUARIOS_ID);
    }
    public static final class Usuarios implements BaseColumns {
        private Usuarios(){}
        public static final String COL_USUARIO = "usuario";
        public static final String COL_PASSWORD = "password";
        public static final String COL_EMAIL = "email";

    }

    @Override
    public boolean onCreate() {
        usudbh = new UsuariosSqliteHelper(getContext(),BD_NOMBRE,null,BD_VERSION);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        String where = selection;
        if (uriMatcher.match(uri) == USUARIOS_ID){
            where = "_id="+uri.getLastPathSegment();
        }
        SQLiteDatabase db = usudbh.getWritableDatabase();
        Cursor cursor = db.query(TABLA_USUARIOS,projection,where,selectionArgs,null,null,sortOrder);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long regId = 1;
        SQLiteDatabase db = usudbh.getWritableDatabase();

        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int cont;
        String where = selection;
        if (uriMatcher.match(uri) == USUARIOS_ID){
            where = "_id="+uri.getLastPathSegment();
        }
        SQLiteDatabase db = usudbh.getWritableDatabase();
        cont = db.delete(TABLA_USUARIOS,where,selectionArgs);
        return cont;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int cont;
        String where = selection;
        if (uriMatcher.match(uri) == USUARIOS_ID){
            where = "_id="+uri.getLastPathSegment();
        }
        SQLiteDatabase db = usudbh.getWritableDatabase();
        cont = db.update(TABLA_USUARIOS,values,where,selectionArgs);
        return cont;
    }
}
