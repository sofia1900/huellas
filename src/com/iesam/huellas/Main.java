package com.iesam.huellas;

import com.iesam.huellas.data.local.CatDataRepository;
import com.iesam.huellas.data.local.CatFileLocalDataSource;
import com.iesam.huellas.data.local.CatMemLocalDataSource;
import com.iesam.huellas.data.remote.CatApiRemoteDataSource;
import com.iesam.huellas.domain.models.Cat;
import com.iesam.huellas.domain.useCases.DeleteCatUseCase;
import com.iesam.huellas.domain.useCases.ListCatsUseCase;
import com.iesam.huellas.presentation.GatosTerminalView;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GatosTerminalView gatosTerminalView = new GatosTerminalView();
        Integer opcion;
        String sobras;

        do{
            System.out.println("");
            System.out.println("ELIGE UNA OPCION: ");
            System.out.println("1. Añadir gato.");
            System.out.println("2. Eliminar gato.");
            System.out.println("3. Listar gatos.");
            System.out.println("4. Salir.");
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
            }

        }while (opcion < 4);

        /*
        //CatDataRepository
        CatApiRemoteDataSource remoteDataSource = new CatApiRemoteDataSource();
        List<Cat> cats = remoteDataSource.getCats();

        CatFileLocalDataSource fileLocalDataSource = CatFileLocalDataSource.getInstance();
        fileLocalDataSource.saveList(cats);
         */
    }

    public static void datosMemoria (){
        CatFileLocalDataSource catFileLocalDataSource = CatFileLocalDataSource.getInstance();
        CatMemLocalDataSource catMemLocalDataSource = CatMemLocalDataSource.getInstance();
        CatDataRepository catFDataRepository = new CatDataRepository(catFileLocalDataSource);
        CatDataRepository catMDataRepository = new CatDataRepository(catMemLocalDataSource);

        ListCatsUseCase listCatsUseCase = new ListCatsUseCase(catMDataRepository);
        List<Cat> catFile = listCatsUseCase.execute();
        
    }
}