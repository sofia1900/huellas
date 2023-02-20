package com.iesam.huellas.data.local.adoptante;

import com.iesam.huellas.domain.models.Adoptante;


import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AdoptanteMemLocalDataSource implements AdoptanteLocalDataSource{
    private static AdoptanteMemLocalDataSource instance = null;
    private AdoptanteMemLocalDataSource(){};

    private Map<String, Adoptante> localSource = new TreeMap<>();

    @Override
    public void save(Adoptante adoptante) {
        localSource.put(adoptante.getId(), adoptante);
    }

    @Override
    public Adoptante findById(String id) {
        return localSource.get(id);
    }

    @Override
    public List<Adoptante> findAll() {
        return localSource.values().stream().toList();
    }

    @Override
    public void delete(String id) {
        localSource.remove(id);
    }

    public static AdoptanteMemLocalDataSource getInstance(){
        if (instance == null){
            instance = new AdoptanteMemLocalDataSource();
        }
        return instance;
    }
}
