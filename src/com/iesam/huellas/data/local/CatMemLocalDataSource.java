package com.iesam.huellas.data.local;

import com.iesam.huellas.domain.models.Cat;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CatMemLocalDataSource implements CatLocalDataSource {
    private static CatMemLocalDataSource instance =  null;
    private CatMemLocalDataSource(){};

    private Map<Integer, Cat> dataSource = new TreeMap<>();
    @Override
    public void save (Cat cat){
        dataSource.put(cat.getId(), cat);
    }
    @Override
    public Cat findById (Integer idCat){
        return dataSource.get(idCat);
    }
    @Override
    public List<Cat> findAll(){
        return dataSource.values().stream().toList();
    }

    @Override
    public void delete(Integer idCat) {
        dataSource.remove(idCat);
    }

    public static CatMemLocalDataSource getInstance(){
        if (instance == null){
            instance = new CatMemLocalDataSource();
        }
        return instance;
    }
}
