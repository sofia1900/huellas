package com.iesam.huellas.domain.models;

public class Animal {

    //Atributos
    /*
        protected para que puedan ser heredados por las clases hijas,
        pero no por el resto de clases.
     */
    protected Integer id;
    protected String name;
    protected String date_birth;
    protected String sex;


    //Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String nombre) {
        this.name = nombre;
    }

    public String getFechaNac() {
        return date_birth;
    }

    public void setFechaNac(String fechaNac) {
        this.date_birth = fechaNac;
    }

    public String getSexo() {
        return sex;
    }

    public void setSexo(String sexo) {
        this.sex = sexo;
    }
}
