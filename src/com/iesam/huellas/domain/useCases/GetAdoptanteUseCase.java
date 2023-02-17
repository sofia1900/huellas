package com.iesam.huellas.domain.useCases;

import com.iesam.huellas.domain.AdoptanteRepository;
import com.iesam.huellas.domain.models.Adoptante;

public class GetAdoptanteUseCase {
    private AdoptanteRepository adoptanteRepository;

    public GetAdoptanteUseCase (AdoptanteRepository adoptanteRepository){
        this.adoptanteRepository = adoptanteRepository;
    }

    public Adoptante execute(String adoptanteId){
       return adoptanteRepository.findById(adoptanteId);
    }
}
