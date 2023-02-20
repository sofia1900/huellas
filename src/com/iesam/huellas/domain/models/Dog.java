package com.iesam.huellas.domain.models;

public class Dog extends Animal{

    //Atributos
    private String raza;
    private Boolean amigable;


    //Getters and Setters
    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Boolean getAmigable() {
        return amigable;
    }

    public void setAmigable(Boolean amigable) {
        this.amigable = amigable;
    }
}
