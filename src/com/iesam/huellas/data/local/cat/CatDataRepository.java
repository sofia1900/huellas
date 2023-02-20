package com.iesam.huellas.data.local.cat;
import com.iesam.huellas.domain.CatRepository;
import com.iesam.huellas.domain.models.Cat;

import java.util.List;

public class CatDataRepository implements CatRepository {
    private CatLocalDataSource catLocalDataSource;

    public CatDataRepository(CatLocalDataSource catLocalDataSource) {
        this.catLocalDataSource = catLocalDataSource;
    }

    @Override
    public void save(Cat cat) {
        catLocalDataSource.save(cat);
    }

    @Override
    public List<Cat> getAll() {
        return catLocalDataSource.findAll();
    }

    @Override
    public void delete(Integer idCat) {
        catLocalDataSource.delete(idCat);
    }

    @Override
    public Cat findById(String idCat) {
        return catLocalDataSource.findById(idCat);
    }
}
