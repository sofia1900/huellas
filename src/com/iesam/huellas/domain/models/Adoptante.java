package com.iesam.huellas.domain.models;

public class Adoptante extends Persona {
    //Atributos
    private String fechaNac;
    private String direccion;

    //Getters and Setters
    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
