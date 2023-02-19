package com.iesam.huellas.domain;

import com.iesam.huellas.domain.models.RegistroAdopcion;

import java.util.List;

public interface RegistroRepository {

    public void save(RegistroAdopcion registroAdopcion);
    public List<RegistroAdopcion> getAll();
}
