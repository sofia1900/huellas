package com.iesam.huellas.data.local.registro;

import com.iesam.huellas.domain.RegistroRepository;
import com.iesam.huellas.domain.models.RegistroAdopcion;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RegistroMemLocalDataSource implements RegistroLocalRepository{

    private static RegistroMemLocalDataSource instace;

    private RegistroMemLocalDataSource(){};

    private Map<String, RegistroAdopcion> dataSource = new TreeMap<>();

    @Override
    public void save(RegistroAdopcion registroAdopcion) {
        dataSource.put(registroAdopcion.getId(), registroAdopcion);
    }

    @Override
    public RegistroAdopcion findById(String id) {
        return dataSource.get(id);
    }

    @Override
    public List<RegistroAdopcion> findAll() {
        return dataSource.values().stream().toList();
    }

    @Override
    public void delete(String id) {
        dataSource.remove(id);
    }

    public static RegistroMemLocalDataSource getInstance(){
        if (instace == null){
            instace = new RegistroMemLocalDataSource();
        }

        return instace;
    }
}
