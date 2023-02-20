package com.iesam.huellas.domain.useCases;

import com.iesam.huellas.domain.RegistroRepository;
import com.iesam.huellas.domain.models.RegistroAdopcion;

public class AddAdopcionUseCase {
    private RegistroRepository registroRepository;

    public AddAdopcionUseCase (RegistroRepository registroRepository){
        this.registroRepository = registroRepository;
    }

    public void execute (RegistroAdopcion registroAdopcion){
        registroRepository.save(registroAdopcion);
    }
}
