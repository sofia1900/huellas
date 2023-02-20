package com.iesam.huellas.presentation;

import com.iesam.huellas.data.local.adoptante.AdoptanteDataRepository;
import com.iesam.huellas.data.local.adoptante.AdoptanteMemLocalDataSource;
import com.iesam.huellas.data.local.cat.CatDataRepository;
import com.iesam.huellas.data.local.cat.CatFileLocalDataSource;
import com.iesam.huellas.data.local.cat.CatMemLocalDataSource;
import com.iesam.huellas.data.local.registro.RegistroDataRepository;
import com.iesam.huellas.data.local.registro.RegistroFileLocalDataSource;
import com.iesam.huellas.data.local.registro.RegistroMemLocalDataSource;
import com.iesam.huellas.domain.models.RegistroAdopcion;
import com.iesam.huellas.domain.useCases.*;

import java.util.List;
import java.util.Scanner;

public class AdopcionTerminalView {
    Scanner scanner = new Scanner(System.in);

    RegistroFileLocalDataSource registroFileLocalDataSource = RegistroFileLocalDataSource.getIntance();
    RegistroMemLocalDataSource registroMemLocalDataSource = RegistroMemLocalDataSource.getInstance();
    RegistroDataRepository registroFDataRepository = new RegistroDataRepository(registroFileLocalDataSource);
    RegistroDataRepository registroMDataRepository = new RegistroDataRepository(registroMemLocalDataSource);


    AdoptanteMemLocalDataSource adoptanteMemLocalDataSource = AdoptanteMemLocalDataSource.getInstance();
    AdoptanteDataRepository adoptanteMDataRepository = new AdoptanteDataRepository(adoptanteMemLocalDataSource);

    CatFileLocalDataSource catFileLocalDataSource = CatFileLocalDataSource.getInstance();
    CatMemLocalDataSource catMemLocalDataSource = CatMemLocalDataSource.getInstance();
    CatDataRepository catFDataRepository = new CatDataRepository(catFileLocalDataSource);
    CatDataRepository catMDataRepository = new CatDataRepository(catMemLocalDataSource);

    public void nuevaAdopcion(){
        RegistroAdopcion registro = new RegistroAdopcion();

        GetAdoptanteUseCase getAdoptanteUseCase = new GetAdoptanteUseCase(adoptanteMDataRepository);
        GetCatUseCase getCatUseCase = new GetCatUseCase(catMDataRepository);

        AddAdopcionUseCase addFAdopcionUseCase = new AddAdopcionUseCase(registroFDataRepository);
        AddAdopcionUseCase addMAdopcionUseCase = new AddAdopcionUseCase(registroMDataRepository);

        DeleteCatUseCase deleteFCatUseCase = new DeleteCatUseCase(catFDataRepository);
        DeleteCatUseCase deleteMCatUseCase = new DeleteCatUseCase(catMDataRepository);

        System.out.println("Introduce el id de la adopcion");
        registro.setId(scanner.nextLine());
        System.out.println("Introduce la fecha de la adopcion");
        registro.setFecha(scanner.nextLine());
        System.out.println("Introduce el id de la persona adoptante");
        registro.setAdoptante(getAdoptanteUseCase.execute(scanner.nextLine()));
        System.out.println("Introduce el id del gato");
        Integer id = scanner.nextInt();
        registro.setAnimal(getCatUseCase.execute(id));

        /*
        System.out.println("Introduce si el animal es gato o perro");
        String animal = scanner.nextLine();
        if (animal == "gato"){
            System.out.println("Introduce el id del gato");
            registro.setAnimal(getCatUseCase.execute(scanner.nextLine()));
        }
         */

        addFAdopcionUseCase.execute(registro);
        addMAdopcionUseCase.execute(registro);
        deleteMCatUseCase.execute(id);
        deleteFCatUseCase.execute(id);

    }

    public void listarAdopciones (){
        ListAdopcionUseCase listAdopcionUseCase = new ListAdopcionUseCase(registroMDataRepository);

        List<RegistroAdopcion> registroList = listAdopcionUseCase.execute();
        for (RegistroAdopcion registroAdopcion : registroList) {
            System.out.println(registroAdopcion);
        }
    }
}
