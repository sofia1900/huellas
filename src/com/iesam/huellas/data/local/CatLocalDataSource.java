package com.iesam.huellas.data.local;

import com.iesam.huellas.domain.models.Cat;

import java.util.List;

public interface CatLocalDataSource {
    public void save (Cat cat);

    public Cat findById (Integer idCat);

    public List<Cat> findAll();

    public void delete (Integer idCat);
}
