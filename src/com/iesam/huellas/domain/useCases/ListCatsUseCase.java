package com.iesam.huellas.domain.useCases;

import com.iesam.huellas.domain.CatRepository;
import com.iesam.huellas.domain.models.Cat;

import java.util.List;

public class ListCatsUseCase {
    private CatRepository catRepository;

    public ListCatsUseCase (CatRepository catRepository){
        this.catRepository = catRepository;
    }

    public List<Cat> execute(){
        return catRepository.getAll();
    }
}
