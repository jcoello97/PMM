package com.example.jorch.examen1rtrimestre;

import java.io.Serializable;

/**
 * Created by JORCH on 08/01/2017.
 */

public class Coche implements Serializable{
    private String nombre;
    private String marca;
    private double precio;
    private int imagenCoche;

    public Coche(String nombre, String marca, double precio, int imagenCoche) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.imagenCoche = imagenCoche;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getImagenCoche() {
        return imagenCoche;
    }

    public void setImagenCoche(int imagenCoche) {
        this.imagenCoche = imagenCoche;
    }
}
