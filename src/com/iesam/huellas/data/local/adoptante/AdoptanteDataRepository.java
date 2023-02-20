package com.iesam.huellas.data.local.adoptante;

import com.iesam.huellas.domain.AdoptanteRepository;
import com.iesam.huellas.domain.models.Adoptante;

import java.util.List;

public class AdoptanteDataRepository implements AdoptanteRepository {

    private AdoptanteLocalDataSource adoptanteLocalDataSource;

    public AdoptanteDataRepository (AdoptanteLocalDataSource adoptanteLocalDataSource){
        this.adoptanteLocalDataSource = adoptanteLocalDataSource;
    }

    @Override
    public void save(Adoptante adoptante) {
        adoptanteLocalDataSource.save(adoptante);
    }

    @Override
    public Adoptante findById(String idAdoptante) {
        return adoptanteLocalDataSource.findById(idAdoptante);
    }

    @Override
    public List<Adoptante> getAll() {
        return adoptanteLocalDataSource.findAll();
    }
}
