package com.iesam.huellas.presentation;

import com.iesam.huellas.data.local.CatDataRepository;
import com.iesam.huellas.data.local.CatFileLocalDataSource;
import com.iesam.huellas.data.remote.CatApiRemoteDataSource;
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
        cat.setId(scanner.nextInt());
        String sobras = scanner.nextLine(); //para que no haya problemas con el siguiente dato
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
        Integer id;
        System.out.println("Introduce el id del gato que desea eliminar");
        id = scanner.nextInt();
        String sobras = scanner.nextLine(); //para que no haya problemas con el siguiente dato
        deleteCatUseCase.execute(id);
    }

    public void listarGato () {
        ListCatsUseCase listCatsUseCase = new ListCatsUseCase(catDataRepository);

        List<Cat> catList = listCatsUseCase.execute();

        if (catList.size() == 0) {

            //CatDataRepository
            CatApiRemoteDataSource remoteDataSource = new CatApiRemoteDataSource();
            List<Cat> cats = remoteDataSource.getCats();

            CatFileLocalDataSource fileLocalDataSource = CatFileLocalDataSource.getInstance();
            fileLocalDataSource.saveList(cats);

            List<Cat> catListNew = listCatsUseCase.execute();

            for (Cat cat : catListNew) {
                System.out.println(cat);
            }

        } else {
            for (Cat cat : catList) {
                System.out.println(cat);
            }
        }
    }
}
