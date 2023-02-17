package com.iesam.huellas.domain;

import com.iesam.huellas.domain.models.Adoptante;
import com.iesam.huellas.domain.models.Cat;

public interface AdoptanteRepository {

    public void save(Adoptante adoptante);
    public Adoptante findById (String idAdoptante);

}
