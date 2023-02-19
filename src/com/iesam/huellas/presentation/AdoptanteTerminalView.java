package com.iesam.huellas.presentation;

import com.iesam.huellas.data.local.AdoptanteDataRepository;
import com.iesam.huellas.domain.models.Adoptante;
import com.iesam.huellas.domain.useCases.AddAdoptanteUseCase;

import java.util.Scanner;

public class AdoptanteTerminalView {
    Scanner scanner = new Scanner(System.in);
    AdoptanteDataRepository adoptanteDataRepository = new AdoptanteDataRepository();

    public void nuevoAdoptante(){
        AddAdoptanteUseCase addAdoptanteUseCase = new AddAdoptanteUseCase(adoptanteDataRepository);
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

        addAdoptanteUseCase.execute(adoptante);
    }
}
