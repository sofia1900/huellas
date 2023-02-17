package com.iesam.huellas.presentation;

import com.iesam.huellas.data.local.AdoptanteDataRepository;
import com.iesam.huellas.data.local.CatDataRepository;
import com.iesam.huellas.data.local.RegistroDataRepository;
import com.iesam.huellas.domain.models.Cat;
import com.iesam.huellas.domain.models.RegistroAdopcion;
import com.iesam.huellas.domain.useCases.*;

import java.net.CacheRequest;
import java.util.List;
import java.util.Scanner;

public class AdopcionTerminalView {
    Scanner scanner = new Scanner(System.in);
    RegistroDataRepository registroDataRepository = new RegistroDataRepository();
    AdoptanteDataRepository adoptanteDataRepository = new AdoptanteDataRepository();
    CatDataRepository catDataRepository = new CatDataRepository();

    public void nuevaAdopcion(){
        RegistroAdopcion registro = new RegistroAdopcion();

        GetAdoptanteUseCase getAdoptanteUseCase = new GetAdoptanteUseCase(adoptanteDataRepository);
        GetCatUseCase getCatUseCase = new GetCatUseCase(catDataRepository);
        AddAdopcionUseCase addAdopcionUseCase = new AddAdopcionUseCase(registroDataRepository);
        DeleteCatUseCase deleteCatUseCase = new DeleteCatUseCase(catDataRepository);

        System.out.println("Introduce el id de la adopcion");
        registro.setId(scanner.nextLine());
        System.out.println("Introduce la fecha de la adopcion");
        registro.setFecha(scanner.nextLine());
        System.out.println("Introduce el id de la persona adoptante");
        registro.setAdoptante(getAdoptanteUseCase.execute(scanner.nextLine()));
        System.out.println("Introduce el id del gato");
        String id = scanner.nextLine();
        registro.setAnimal(getCatUseCase.execute(id));

        /*
        System.out.println("Introduce si el animal es gato o perro");
        String animal = scanner.nextLine();
        if (animal == "gato"){
            System.out.println("Introduce el id del gato");
            registro.setAnimal(getCatUseCase.execute(scanner.nextLine()));
        }
         */

        addAdopcionUseCase.execute(registro);
        deleteCatUseCase.execute(id);

    }

    public void listarAdopciones (){
        ListAdopcionUseCase listAdopcionUseCase = new ListAdopcionUseCase(registroDataRepository);

        List<RegistroAdopcion> registroList = listAdopcionUseCase.execute();
        for (RegistroAdopcion registroAdopcion : registroList) {
            System.out.println(registroAdopcion);
        }
    }
}
