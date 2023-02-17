package com.iesam.huellas.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.huellas.domain.models.RegistroAdopcion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class RegistroFileLocalDataSource {
    private static RegistroFileLocalDataSource instance = null;
    private RegistroFileLocalDataSource (){};

    private String nameFile = "registros.txt";

    private Gson gson = new Gson();

    private final Type typeAlumnList = new TypeToken<ArrayList<RegistroAdopcion>>() {
    }.getType();

    public void save(RegistroAdopcion registroAdopcion) {
        List<RegistroAdopcion> registros = findAll();
        registros.add(registroAdopcion);
        saveToFile(registros);
    }

    private void saveToFile(List<RegistroAdopcion> registros) {
        try {
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(gson.toJson(registros));
            myWriter.close();
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la información.");
            e.printStackTrace();
        }
    }


    public RegistroAdopcion findById(String registroId) {
        List<RegistroAdopcion> registros = findAll();
        for (RegistroAdopcion registro : registros) {
            if (Objects.equals(registro.getId(), registroId)) {
                return registro;
            }
        }
        return null;
    }

    public List<RegistroAdopcion> findAll() {
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
        return new ArrayList<RegistroAdopcion>();
    }

    public static RegistroFileLocalDataSource getIntance(){
        if (instance == null){
            instance = new RegistroFileLocalDataSource();
        }
        return instance;
    }

}
