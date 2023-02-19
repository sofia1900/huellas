package com.iesam.huellas.data.local;
import com.iesam.huellas.data.remote.CatApiRemoteDataSource;
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
        List<Cat> catsFile = catLocalDataSource.findAll();
        if (catsFile.size() == 0){
            //CatDataRepository
            CatApiRemoteDataSource remoteDataSource = new CatApiRemoteDataSource();
            List<Cat> cats = remoteDataSource.getCats();

            catLocalDataSource.saveList(cats);
        }
        return catLocalDataSource.findAll();
    }

    @Override
    public void delete(Integer idCat) {
        catLocalDataSource.delete(idCat);
    }

    @Override
    public Cat findById(Integer idCat) {
        return catLocalDataSource.findById(idCat);
    }
}
