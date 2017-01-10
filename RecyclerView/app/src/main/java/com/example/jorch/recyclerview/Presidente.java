package com.example.jorch.recyclerview;

/**
 * Created by JORCH on 28/12/2016.
 */

public class Presidente {
    private String nombre;
    private String pais;
    private int imagen;

    public Presidente(String nombre, String pais, int imagen) {
        this.nombre = nombre;
        this.pais = pais;
        this.imagen = imagen;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
