package com.example.mati.objetoentrepantalla;

import java.io.Serializable;

public class Persona  implements Serializable
{
    private String nombre;
    private String apellido;
    private int edad;
    private int foto;
    private String sexo;

    public Persona(String nombre, String apellido, int edad, String sexo,int foto)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
        this.foto = foto;
    }
    public Persona(String nombre, String apellido, int edad, String sexo)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
    }
    //SETTERS
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }
    public void setEdad(int edad)
    {
        this.edad = edad;
    }
    public void setFoto(int foto)
    {
        this.foto = foto;
    }
    public void setSexo(String sexo)
    {
        this.sexo = sexo;
    }
    //GETTERS

    public int getFoto() {
        return foto;
    }

    public int getEdad() {
        return edad;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSexo() {
        return sexo;
    }

    @Override
    public String toString() {
        if (this.sexo.isEmpty())
        {
            return "Nombre: "+this.nombre+"" +
                    "\nApellido: "+this.apellido+"" +
                    "\nEdad: "+this.edad+"";
        }else
        {
            return "Nombre: "+this.nombre+"" +
                    "\nApellido: "+this.apellido+"" +
                    "\nEdad: "+this.edad+""+
                    "\nSexo:"+this.sexo;
        }

        //         "\nFoto: "+this.foto;
    }
}
