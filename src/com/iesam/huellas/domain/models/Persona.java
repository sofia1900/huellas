package com.iesam.huellas.domain.models;

public class Persona {
    //Atributos
    /* Protected para que puedan ser heredados por las clases hijas, pero
        no por el resto de clases.
     */
    protected String id;
    protected String nombre;
    protected String apellidos;
    protected String dni;


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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
