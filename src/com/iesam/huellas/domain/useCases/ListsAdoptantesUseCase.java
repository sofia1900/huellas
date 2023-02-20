package com.iesam.huellas.domain.useCases;

import com.iesam.huellas.domain.AdoptanteRepository;
import com.iesam.huellas.domain.models.Adoptante;

import java.util.List;

public class ListsAdoptantesUseCase {
    private AdoptanteRepository adoptanteRepository;

    public ListsAdoptantesUseCase (AdoptanteRepository adoptanteRepository){
        this.adoptanteRepository = adoptanteRepository;
    }

    public List<Adoptante> execute(){
        return adoptanteRepository.getAll();
    }
}
