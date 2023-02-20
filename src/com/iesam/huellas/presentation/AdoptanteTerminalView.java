package com.iesam.huellas.presentation;

import com.iesam.huellas.data.local.adoptante.AdoptanteDataRepository;
import com.iesam.huellas.data.local.adoptante.AdoptanteFileLocalDataSource;
import com.iesam.huellas.data.local.adoptante.AdoptanteMemLocalDataSource;
import com.iesam.huellas.domain.models.Adoptante;
import com.iesam.huellas.domain.useCases.AddAdoptanteUseCase;

import java.util.Scanner;

public class AdoptanteTerminalView {
    Scanner scanner = new Scanner(System.in);

    AdoptanteFileLocalDataSource fileLocalDataSource = AdoptanteFileLocalDataSource.getInstance();
    AdoptanteDataRepository adoptanteFDataRepository = new AdoptanteDataRepository(fileLocalDataSource);

    AdoptanteMemLocalDataSource memLocalDataSource = AdoptanteMemLocalDataSource.getInstance();
    AdoptanteDataRepository adoptanteMDataRepository = new AdoptanteDataRepository(memLocalDataSource);

    public void nuevoAdoptante(){
        AddAdoptanteUseCase addFAdoptanteUseCase = new AddAdoptanteUseCase(adoptanteFDataRepository);
        AddAdoptanteUseCase addMAdoptanteUseCase = new AddAdoptanteUseCase(adoptanteMDataRepository);

        Adoptante adoptante = new Adoptante();
        System.out.println("Introduce el id");
        adoptante.setId(scanner.nextLine());
        System.out.println("Introduce el nombre");
        adoptante.setNombre(scanner.nextLine());
        System.out.println("Introduce los apellidos");
        adoptante.setApellidos(scanner.nextLine());
        System.out.println("Introduce el dni");
        adoptante.setDni(scanner.nextLine());
        System.out.println("Introduce la fecha de nacimiento");
        adoptante.setFechaNac(scanner.nextLine());
        System.out.println("Introduce la direccion");
        adoptante.setDireccion(scanner.nextLine());

        addFAdoptanteUseCase.execute(adoptante);
        addMAdoptanteUseCase.execute(adoptante);
    }
}
