package com.iesam.huellas.domain.useCases;

import com.iesam.huellas.domain.CatRepository;
import com.iesam.huellas.domain.models.Cat;

public class DeleteCatUseCase {
    private CatRepository catRepository;

    public DeleteCatUseCase (CatRepository catRepository){
        this.catRepository = catRepository;
    }

    public void execute (Integer idCat){
        catRepository.delete(idCat);
        System.out.println("Gato eliminado correctamente");
    }
}
