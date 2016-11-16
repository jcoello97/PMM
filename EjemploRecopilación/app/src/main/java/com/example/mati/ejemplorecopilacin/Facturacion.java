package com.example.mati.ejemplorecopilacin;

import java.io.Serializable;

/**
 * Created by mati on 14/11/16.
 */
public class Facturacion implements Serializable
{
    private double PrecioZona;
    private double PesoPaquete;
    private double Incremento = 0.3;
    private double PrecioPaquete;
    private double PrecioFinal;
    private boolean Urgente = true;

    public Facturacion(double precioZona, double pesoPaquete, double incremento, double precioFinal, boolean urgente) {
        PrecioZona = precioZona;
        PesoPaquete = pesoPaquete;
        Incremento = incremento;
        PrecioFinal = precioFinal;
        Urgente = urgente;
        gestionarPeso();
    }
    public Facturacion() {

    }
    private void gestionarPeso() {
        if (PesoPaquete <= 5)
        {
            PrecioPaquete = 1;
            PrecioPaquete = PrecioPaquete*PesoPaquete;
        }
        if (PesoPaquete >= 6 && PesoPaquete <=10)
        {
            PrecioPaquete = 1.5;
            PrecioPaquete = PrecioPaquete*PesoPaquete;
        }
        if (PesoPaquete > 10)
        {
            PrecioPaquete = 2;
            PrecioPaquete = PrecioPaquete*PesoPaquete;
        }
    }

    public boolean isUrgente() {
        return Urgente;
    }

    public void setUrgente(boolean urgente) {
        this.Urgente = urgente;
    }

    public double getPrecioZona() {
        return PrecioZona;
    }

    public void setPrecioZona(double precioZona) {
        PrecioZona = precioZona;
    }

    public double getPesoPaquete() {
        return PesoPaquete;
    }

    public void setPesoPaquete(double pesoPaquete) {
        PesoPaquete = pesoPaquete;
    }

    public double getIncremento() {
        return Incremento;
    }

    public double getPrecioPaquete() {
        return PrecioPaquete;
    }

    public void setPrecioPaquete(double precioPaquete) {
        PrecioPaquete = precioPaquete;
    }

    public double getPrecioFinal()
    {
        if(this.isUrgente() == true)
        {
            PrecioFinal = (getPrecioZona()+getPrecioPaquete())*getIncremento();
        }
        else
        {
            PrecioFinal = (getPrecioZona()+getPrecioPaquete());
        }
        return PrecioFinal;
    }
}
