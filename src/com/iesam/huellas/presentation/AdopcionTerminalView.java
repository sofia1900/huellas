package com.iesam.huellas.presentation;

import com.iesam.huellas.data.local.AdoptanteDataRepository;
import com.iesam.huellas.data.local.CatDataRepository;
import com.iesam.huellas.data.local.RegistroDataRepository;
import com.iesam.huellas.domain.models.RegistroAdopcion;
import com.iesam.huellas.domain.useCases.GetAdoptanteUseCase;
import com.iesam.huellas.domain.useCases.GetCatUseCase;

import java.net.CacheRequest;
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

        System.out.println("Introduce el id de la adopcion");
        registro.setId(scanner.nextLine());
        System.out.println("Introduce la fecha de la adopcion");
        registro.setFecha(scanner.nextLine());
        System.out.println("Introduce el id de la persona adoptante");
        registro.setAdoptante(getAdoptanteUseCase.execute(scanner.nextLine()));
        System.out.println("Introduce si el animal es gato o perro");
        if (scanner.nextLine() == "gato"){
            System.out.println("Introduce el id del gato");
            registro.setAnimal(getCatUseCase.execute(scanner.nextLine()));
        }

    }
}
