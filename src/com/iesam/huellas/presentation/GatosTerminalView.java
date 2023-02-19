package com.iesam.huellas.presentation;

import com.iesam.huellas.data.local.CatDataRepository;
import com.iesam.huellas.domain.models.Cat;
import com.iesam.huellas.domain.useCases.AddCatUseCase;
import com.iesam.huellas.domain.useCases.DeleteCatUseCase;
import com.iesam.huellas.domain.useCases.ListCatsUseCase;

import java.util.List;
import java.util.Scanner;

public class GatosTerminalView {
    Scanner scanner = new Scanner(System.in);
    CatDataRepository catDataRepository = new CatDataRepository();

    public void nuevoGato() {
        AddCatUseCase  addCatUseCase = new AddCatUseCase(catDataRepository);
        Cat cat = new Cat();
        System.out.println("Introduce un id");
        cat.setId(scanner.nextLine());
        System.out.println("Introduce el nombre");
        cat.setNombre(scanner.nextLine());
        System.out.println("Introduce la fecha de nacimiento");
        cat.setFechaNac(scanner.nextLine());
        System.out.println("Introduce el sexo");
        cat.setSexo(scanner.nextLine());
        System.out.println("Introduce si tiene el virus de la leucemia felina (true / false)");
        cat.setVirus(scanner.nextBoolean());

        addCatUseCase.execute(cat);
    }

    public void eliminarGato(){
        DeleteCatUseCase deleteCatUseCase = new DeleteCatUseCase(catDataRepository);
        String id;
        System.out.println("Introduce el id del gato que desea eliminar");
        id = scanner.nextLine();
        deleteCatUseCase.execute(id);
    }

    public void listarGato (){
        ListCatsUseCase listCatsUseCase = new ListCatsUseCase(catDataRepository);

        List<Cat> catList = listCatsUseCase.execute();
        for (Cat cat : catList) {
            System.out.println(cat);
        }
    }
}
