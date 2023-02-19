package com.iesam.huellas.domain;

import com.iesam.huellas.domain.models.Cat;

import java.util.List;

public interface CatRepository {
    public void save(Cat cat);
    public List<Cat> getAll();
    public void delete (String idCat);
    public Cat findById (String idAdoptante);
}
