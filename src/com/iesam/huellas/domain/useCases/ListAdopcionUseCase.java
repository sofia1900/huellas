package com.iesam.huellas.domain.useCases;

import com.iesam.huellas.domain.RegistroRepository;
import com.iesam.huellas.domain.models.RegistroAdopcion;

import java.util.List;

public class ListAdopcionUseCase {
    private RegistroRepository registroRepository;

    public ListAdopcionUseCase (RegistroRepository registroRepository){
        this.registroRepository = registroRepository;
    }

    public List<RegistroAdopcion> execute (){
        return registroRepository.getAll();
    }
}
