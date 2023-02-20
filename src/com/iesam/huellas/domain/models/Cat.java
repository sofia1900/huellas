package com.iesam.huellas.domain.models;

import com.google.gson.Gson;

public class Cat extends Animal{
    //Atributos
    private boolean has_virus;

    //Getters and Setters
    public boolean isVirus() {
        return has_virus;
    }

    public void setVirus(boolean virus) {
        this.has_virus = virus;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
