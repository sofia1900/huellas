package com.iesam.huellas.domain;

import com.iesam.huellas.domain.models.Adoptante;

public interface AdoptanteRepository {

    public void save(Adoptante adoptante);
    public Adoptante findById (String idAdoptante);

}
