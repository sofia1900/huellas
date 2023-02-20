package com.iesam.huellas.data.local.cat;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.huellas.domain.models.Cat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CatFileLocalDataSource implements CatLocalDataSource {

    private static CatFileLocalDataSource instance = null;

    private String nameFile = "cats.txt";

    private Gson gson = new Gson();

    private final Type typeAlumnList = new TypeToken<ArrayList<Cat>>() {
    }.getType();

    private CatFileLocalDataSource() {
    }

    @Override
    public void save(Cat cat) {
        List<Cat> cats = findAll();
        cats.add(cat);
        saveToFile(cats);
    }

    public void saveList(List<Cat> cats) {
        saveToFile(cats);
    }

    private void saveToFile(List<Cat> cats) {
        try {
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(gson.toJson(cats));
            myWriter.close();
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la información.");
            e.printStackTrace();
        }
    }

    @Override
    public Cat findById(Integer catId) {
        List<Cat> cats = findAll();
        for (Cat cat : cats) {
            if (Objects.equals(cat.getId(), catId)) {
                return cat;
            }
        }
        return null;
    }

    @Override
    public List<Cat> findAll() {
        try {
            File myObj = new File(nameFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myReader.close();
                return gson.fromJson(data, typeAlumnList);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ha ocurrido un error al obtener el listado.");
            e.printStackTrace();
        }
        return new ArrayList<Cat>();
    }

    @Override
    public void delete(Integer idCat) {
        List<Cat> cats = findAll();
        List<Cat> newList = new ArrayList<>();
        for (Cat cat : cats) {
            if (!Objects.equals(cat.getId(), idCat)) {
                newList.add(cat);
            }
        }
        saveToFile(newList);
    }
    public static CatFileLocalDataSource getInstance() {
        if (instance == null) {
            instance = new CatFileLocalDataSource();
        }
        return instance;
    }
}
