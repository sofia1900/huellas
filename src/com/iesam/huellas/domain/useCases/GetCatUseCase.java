package com.iesam.huellas.domain.useCases;

import com.iesam.huellas.data.local.CatDataRepository;
import com.iesam.huellas.domain.CatRepository;
import com.iesam.huellas.domain.models.Cat;

public class GetCatUseCase {
    private CatRepository catRepository;

    public GetCatUseCase (CatRepository catRepository){
        this.catRepository = catRepository;
    }

    public Cat execute(String idCat){
        return catRepository.findById(idCat);
    }
}
