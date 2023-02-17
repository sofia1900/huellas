package com.iesam.huellas.data.local;

import com.iesam.huellas.domain.RegistroRepository;
import com.iesam.huellas.domain.models.RegistroAdopcion;

import java.util.List;

public class RegistroDataRepository implements RegistroRepository {

    private RegistroFileLocalDataSource registroLocalDataSource = RegistroFileLocalDataSource.getIntance();
    @Override
    public void save(RegistroAdopcion registroAdopcion) {
        registroLocalDataSource.save(registroAdopcion);
    }

    @Override
    public List<RegistroAdopcion> getAll() {
        return registroLocalDataSource.findAll();
    }
}
