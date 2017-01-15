package com.jorch.proyecto.aulavirtual.data.Contracts;

import android.provider.BaseColumns;

/**
 * Created by JORCH on 14/01/2017.
 */

public class UsuarioContract {
    public static abstract class UsuarioEntry implements BaseColumns{
        public static final String TABLE_NAME = "Usuarios";
        public static final String ID = "id";
        public static final String NAME = "nombre";
        public static final String PASSWORD = "password";
        public static final String CORREO = "correo";
        public static final String ROL = "rol";
    }
}
