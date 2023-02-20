package com.iesam.huellas.data.local.registro;

import com.iesam.huellas.domain.RegistroRepository;
import com.iesam.huellas.domain.models.RegistroAdopcion;

import java.util.List;

public class RegistroDataRepository implements RegistroRepository {

    private RegistroLocalRepository registroLocalRepository;

    public RegistroDataRepository (RegistroLocalRepository registroLocalRepository){
        this.registroLocalRepository = registroLocalRepository;
    }
    @Override
    public void save(RegistroAdopcion registroAdopcion) {
        registroLocalRepository.save(registroAdopcion);
    }

    @Override
    public List<RegistroAdopcion> getAll() {
        return registroLocalRepository.findAll();
    }

}
