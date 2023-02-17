package com.iesam.huellas.domain.models;

public class Animal {

    //Atributos
    /*
        protected para que puedan ser heredados por las clases hijas,
        pero no por el resto de clases.
     */
    protected String id;
    protected String nombre;
    protected String fechaNac;
    protected String sexo;


    //Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
