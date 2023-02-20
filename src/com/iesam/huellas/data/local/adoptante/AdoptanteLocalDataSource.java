package com.iesam.huellas.data.local.adoptante;

import com.iesam.huellas.domain.models.Adoptante;
import com.iesam.huellas.domain.models.Cat;

import java.util.List;

public interface AdoptanteLocalDataSource {
    public void save (Adoptante adoptante);

    public Adoptante findById (String id);

    public List<Adoptante> findAll();

    public void delete (String id);
}
