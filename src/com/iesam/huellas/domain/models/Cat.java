package com.iesam.huellas.domain.models;

import com.google.gson.Gson;

public class Cat extends Animal{
    //Atributos
    private boolean virus;

    //Getters and Setters
    public boolean isVirus() {
        return virus;
    }

    public void setVirus(boolean virus) {
        this.virus = virus;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
