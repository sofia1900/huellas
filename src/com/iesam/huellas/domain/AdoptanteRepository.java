package com.iesam.huellas.domain;

import com.iesam.huellas.domain.models.Adoptante;

import java.util.List;

public interface AdoptanteRepository {

    public void save(Adoptante adoptante);
    public Adoptante findById (String idAdoptante);

    public List<Adoptante> getAll ();

}
