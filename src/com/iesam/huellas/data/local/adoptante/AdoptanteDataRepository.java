package com.iesam.huellas.data.local.adoptante;

import com.iesam.huellas.domain.AdoptanteRepository;
import com.iesam.huellas.domain.models.Adoptante;

public class AdoptanteDataRepository implements AdoptanteRepository {

    private AdoptanteFileLocalDataSource adoptanteLocalDataSource = AdoptanteFileLocalDataSource.getInstance();

    @Override
    public void save(Adoptante adoptante) {
        adoptanteLocalDataSource.save(adoptante);
    }

    @Override
    public Adoptante findById(String idAdoptante) {
        return adoptanteLocalDataSource.findById(idAdoptante);
    }
}
