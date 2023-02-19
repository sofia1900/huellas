package com.iesam.huellas.data.local;
import com.iesam.huellas.domain.CatRepository;
import com.iesam.huellas.domain.models.Cat;

import java.util.List;

public class CatDataRepository implements CatRepository {
    private CatFileLocalDataSource catLocalDataSource = CatFileLocalDataSource.getInstance();

    @Override
    public void save(Cat cat) {
        catLocalDataSource.save(cat);
    }

    @Override
    public List<Cat> getAll() {
        return catLocalDataSource.findAll();
    }

    @Override
    public void delete(String idCat) {
        catLocalDataSource.delete(idCat);
    }

    @Override
    public Cat findById(String idCat) {
        return catLocalDataSource.findById(idCat);
    }
}
