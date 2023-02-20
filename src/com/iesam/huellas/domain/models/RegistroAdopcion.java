package com.iesam.huellas.domain.models;

import com.google.gson.Gson;

public class RegistroAdopcion {

    //Atributos
    private String id;
    private String fecha;
    private Animal animal;
    private Adoptante adoptante;


    //Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Adoptante getAdoptante() {
        return adoptante;
    }

    public void setAdoptante(Adoptante adoptante) {
        this.adoptante = adoptante;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", fecha de adopcion: " + fecha + ", animal: " + animal.getNombre() + ", adoptante: " + adoptante.getNombre();
    }
}
