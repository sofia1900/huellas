package com.iesam.huellas.presentation;

import com.iesam.huellas.data.local.CatDataRepository;
import com.iesam.huellas.data.local.CatFileLocalDataSource;
import com.iesam.huellas.data.local.CatMemLocalDataSource;
import com.iesam.huellas.domain.models.Cat;
import com.iesam.huellas.domain.useCases.AddCatUseCase;
import com.iesam.huellas.domain.useCases.DeleteCatUseCase;
import com.iesam.huellas.domain.useCases.ListCatsUseCase;

import java.util.List;
import java.util.Scanner;

public class GatosTerminalView {
    Scanner scanner = new Scanner(System.in);

    CatFileLocalDataSource catFileLocalDataSource = CatFileLocalDataSource.getInstance();
    CatMemLocalDataSource catMemLocalDataSource = CatMemLocalDataSource.getInstance();
    CatDataRepository catFDataRepository = new CatDataRepository(catFileLocalDataSource);
    CatDataRepository catMDataRepository = new CatDataRepository(catMemLocalDataSource);

    public void nuevoGato() {
        AddCatUseCase  addCatUseCase = new AddCatUseCase(catFDataRepository);
        Cat cat = new Cat();
        System.out.println("Introduce un id");
        cat.setId(scanner.nextInt());
        String sobra = scanner.nextLine();
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
        DeleteCatUseCase deleteCatUseCase = new DeleteCatUseCase(catFDataRepository);
        Integer id;
        System.out.println("Introduce el id del gato que desea eliminar");
        id = scanner.nextInt();
        String sobra = scanner.nextLine();
        deleteCatUseCase.execute(id);
    }

    public void listarGato (){
        ListCatsUseCase listCatsUseCase = new ListCatsUseCase(catMDataRepository);

        List<Cat> catList = listCatsUseCase.execute();
        for (Cat cat : catList) {
            System.out.println(cat);
        }
    }
}
