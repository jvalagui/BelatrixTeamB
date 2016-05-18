package com.lab.restaurant.transactional;

import com.lab.restaurant.model.*;

import java.util.*;


/**
 * Created by Kei on 10/05/2016.
 */
public class AppRestauranteController {

    private static Queue<Visita> colaEspera = new LinkedList<Visita>();

    public static void menuPrincipal() {
        int opcion;
        Scanner in = new Scanner(System.in);

        System.out.println("\nRESTAURANTE BELATRIX - Menú Principal\n");
        System.out.println("\t(1)Atención de clientes");
        System.out.println("\t(2)Opciones");
        System.out.println("\t(3)Salir\n");
        System.out.print("Ingrese una opción: ");
        opcion = in.nextInt();

        while (opcion > 3 || opcion < 1) { //si escoge una opcion inválida
            System.out.println("\nOpción no válida!");

            System.out.println("\nRESTAURANTE BELATRIX - Menú Principal\n");
            System.out.println("\t(1)Atención de clientes");
            System.out.println("\t(2)Opciones");
            System.out.println("\t(3)Salir\n");
            System.out.print("Ingrese una opción: ");
            opcion = in.nextInt();
        }

        switch (opcion) {
            case 1:
                menuAtencion();
                break;
            case 2:
                menuOpciones();
                break;
            case 3:
                System.out.println("\nHasta luego! :D");
                break;
            default:
                break;
        }
    }

    private static void menuOpciones() {
        int opcion;
        Scanner in = new Scanner(System.in);

        System.out.println("\nRESTAURANTE BELATRIX - Menú Opciones\n");
        System.out.println("\t(1)Mesas");
        System.out.println("\t(2)Meseros");
        System.out.println("\t(3)Alimentos");
        System.out.println("\t(4)Bebidas");
        System.out.println("\t(5)Regresar al menú principal\n");
        System.out.print("Ingrese una opción: ");
        opcion = in.nextInt();

        while (opcion > 5 || opcion < 1) { //si escoge una opcion inválida
            System.out.println("\nOpción no válida!");

            System.out.println("\nRESTAURANTE BELATRIX - Menú Opciones\n");
            System.out.println("\t(1)Mesas");
            System.out.println("\t(2)Meseros");
            System.out.println("\t(3)Alimentos");
            System.out.println("\t(4)Bebidas");
            System.out.println("\t(5)Regresar al menú principal\n");
            System.out.print("Ingrese una opción: ");
            opcion = in.nextInt();
        }

        switch (opcion) {
            case 1:
                menuMesas();
                break;
            case 2:
                menuMeseros();
                break;
            case 3:
                menuAlimentos();
                break;
            case 4:
                menuBebidas();
                break;
            case 5:
                menuPrincipal();
                break;
            default:
                break;
        }
    }

    private static void menuAtencion() {
        int opcion;
        Scanner in = new Scanner(System.in);

        System.out.println("\nRESTAURANTE BELATRIX - Menú Atención\n");
        System.out.println("\t(1)Registrar cliente");
        System.out.println("\t(5)Regresar al menú de opciones\n");
        System.out.print("Ingrese una opción: ");
        opcion = in.nextInt();

        while (opcion > 5 || opcion < 1) { //si escoge una opcion inválida
            System.out.println("\nOpción no válida!");

            System.out.println("\nRESTAURANTE BELATRIX - Menú Mesas\n");
            System.out.println("\t(1)Registrar cliente");
            System.out.println("\t(5)Regresar al menú de opciones\n");
            System.out.print("Ingrese una opción: ");
            opcion = in.nextInt();
        }

        switch (opcion) {
            case 1:
                ClienteController.registrar();
                menuAtencion();
                break;
            case 2:
                System.out.println("\nEn mantemiento! :v\n");
                menuAtencion();
                break;
            case 3:
                System.out.println("\nEn mantemiento! :v\n");
                menuAtencion();
                break;
            case 4:
                System.out.println("\nEn mantemiento! :v\n");
                menuAtencion();
                break;
            case 5:
                menuPrincipal();
                break;
            default:
                break;
        }
    }

    private static void menuMesas() {
        int opcion;
        Scanner in = new Scanner(System.in);

        System.out.println("\nRESTAURANTE BELATRIX - Menú Mesas\n");
        System.out.println("\t(1)Registrar mesa");
        System.out.println("\t(2)Modificar mesa");
        System.out.println("\t(3)Eliminar mesa");
        System.out.println("\t(4)Listar mesas");
        System.out.println("\t(5)Regresar al menú de opciones\n");
        System.out.print("Ingrese una opción: ");
        opcion = in.nextInt();

        while (opcion > 5 || opcion < 1) { //si escoge una opcion inválida
            System.out.println("\nOpción no válida!");

            System.out.println("\nRESTAURANTE BELATRIX - Menú Mesas\n");
            System.out.println("\t(1)Registrar mesa");
            System.out.println("\t(2)Modificar mesa");
            System.out.println("\t(3)Eliminar mesa");
            System.out.println("\t(4)Listar mesas");
            System.out.println("\t(5)Regresar al menú de opciones\n");
            System.out.print("Ingrese una opción: ");
            opcion = in.nextInt();
        }

        switch (opcion) {
            case 1:
                MesaController.registrar();
                menuMesas();
                break;
            case 2:
                //modificar mesa
                System.out.println("\nEn mantemiento! :v\n");
                menuMesas();
                break;
            case 3:
                //eliminar mesa
                System.out.println("\nEn mantemiento! :v\n");
                menuMesas();
                break;
            case 4:
                MesaController.listar();
                menuMesas();
                break;
            case 5:
                menuOpciones();
                break;
            default:
                break;
        }
    }

    private static void menuMeseros() {
        int opcion;
        Scanner in = new Scanner(System.in);

        System.out.println("\nRESTAURANTE BELATRIX - Menú Meseros\n");
        System.out.println("\t(1)Registrar mesero");
        System.out.println("\t(2)Modificar mesero");
        System.out.println("\t(3)Eliminar mesero");
        System.out.println("\t(4)Listar meseros");
        System.out.println("\t(5)Regresar al menú de opciones\n");
        System.out.print("Ingrese una opción: ");
        opcion = in.nextInt();

        while (opcion > 5 || opcion < 1) { //si escoge una opcion inválida
            System.out.println("\nOpción no válida!");

            System.out.println("\nRESTAURANTE BELATRIX - Menú Meseros\n");
            System.out.println("\t(1)Registrar mesero");
            System.out.println("\t(2)Modificar mesero");
            System.out.println("\t(3)Eliminar mesero");
            System.out.println("\t(4)Listar meseros");
            System.out.println("\t(5)Regresar al menú de opciones\n");
            System.out.print("Ingrese una opción: ");
            opcion = in.nextInt();
        }

        switch (opcion) {
            case 1:
                MeseroController.registrar();
                menuMeseros();
                break;
            case 2:
                //modificar mesero
                System.out.println("\nEn mantemiento! :v\n");
                menuMeseros();
                break;
            case 3:
                //eliminar mesero
                System.out.println("\nEn mantemiento! :v\n");
                menuMeseros();
                break;
            case 4:
                //listar meseros
                System.out.println("\nEn mantemiento! :v\n");
                menuMeseros();
                break;
            case 5:
                menuOpciones();
                break;
            default:
                break;
        }
    }

    private static void menuAlimentos() {
        //COMPLETAR
        System.out.println("\nEn mantemiento! :v\n");
        menuOpciones();
    }

    private static void menuBebidas() {
        //COMPLETAR
        System.out.println("\nEn mantemiento! :v\n");
        menuOpciones();
    }
}
