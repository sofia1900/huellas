package com.iesam.huellas.domain.useCases;

import com.iesam.huellas.domain.CatRepository;

public class DeleteCatUseCase {
    private CatRepository catRepository;

    public DeleteCatUseCase (CatRepository catRepository){
        this.catRepository = catRepository;
    }

    public void execute (Integer idCat){
        catRepository.delete(idCat);
    }
}
