package com.iesam.huellas;

import com.iesam.huellas.data.local.CatDataRepository;
import com.iesam.huellas.data.local.CatFileLocalDataSource;
import com.iesam.huellas.data.local.adoptante.AdoptanteDataRepository;
import com.iesam.huellas.data.local.adoptante.AdoptanteFileLocalDataSource;
import com.iesam.huellas.data.local.adoptante.AdoptanteMemLocalDataSource;
import com.iesam.huellas.data.local.cat.CatDataRepository;
import com.iesam.huellas.data.local.cat.CatFileLocalDataSource;
import com.iesam.huellas.data.local.cat.CatMemLocalDataSource;
import com.iesam.huellas.data.remote.CatApiRemoteDataSource;
import com.iesam.huellas.domain.models.Adoptante;
import com.iesam.huellas.domain.models.Cat;
import com.iesam.huellas.domain.useCases.*;
import com.iesam.huellas.presentation.AdoptanteTerminalView;
import com.iesam.huellas.presentation.GatosTerminalView;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GatosTerminalView gatosTerminalView = new GatosTerminalView();
        AdoptanteTerminalView adoptanteTerminalView = new AdoptanteTerminalView();
        Integer opcion;
        String sobras;

        do{
            System.out.println("");
            System.out.println("ELIGE UNA OPCION: ");
            System.out.println("1. Añadir gato.");
            System.out.println("2. Eliminar gato.");
            System.out.println("3. Listar gatos.");
            System.out.println("4. Añadir persona (adoptante).");
            System.out.println("5. Salir.");
            System.out.println("");
            opcion = scanner.nextInt();
            sobras = scanner.nextLine(); //para que no haya problemas con el siguiente dato
            switch (opcion){
                case 1:
                    gatosTerminalView.nuevoGato();
                    break;
                case 2:
                    gatosTerminalView.eliminarGato();
                    break;
                case 3:
                    gatosTerminalView.listarGato();
                    break;
                case 4:
                    adoptanteTerminalView.nuevoAdoptante();
                    break;
            }

        }while (opcion < 5);

    }

    public static void datosMemoria () {

        //Gatos
        CatFileLocalDataSource catFileLocalDataSource = CatFileLocalDataSource.getInstance();
        CatMemLocalDataSource catMemLocalDataSource = CatMemLocalDataSource.getInstance();
        CatDataRepository catFDataRepository = new CatDataRepository(catFileLocalDataSource);
        CatDataRepository catMDataRepository = new CatDataRepository(catMemLocalDataSource);

        ListCatsUseCase listCatsUseCase = new ListCatsUseCase(catFDataRepository);
        AddCatUseCase addCatUseCase = new AddCatUseCase(catMDataRepository);
        List<Cat> catFile = listCatsUseCase.execute();
        for (Cat cat : catFile) {
            addCatUseCase.execute(cat);
        }

        //Adoptantes
        AdoptanteFileLocalDataSource adopanteFileLocalDataSource = AdoptanteFileLocalDataSource.getInstance();
        AdoptanteMemLocalDataSource adoptanteMemLocalDataSource = AdoptanteMemLocalDataSource.getInstance();
        AdoptanteDataRepository adopanteFDataRepository = new AdoptanteDataRepository(adopanteFileLocalDataSource);
        AdoptanteDataRepository adopanteMDataRepository = new AdoptanteDataRepository(adoptanteMemLocalDataSource);

        ListsAdoptantesUseCase listAdoptanteUseCase = new ListsAdoptantesUseCase(adopanteFDataRepository);
        AddAdoptanteUseCase addAdoptanteUseCase = new AddAdoptanteUseCase(adopanteMDataRepository);
        List<Adoptante> adoptantes = listAdoptanteUseCase.execute();
        for (Adoptante adoptante : adoptantes) {
            addAdoptanteUseCase.execute(adoptante);
        }
    }
}