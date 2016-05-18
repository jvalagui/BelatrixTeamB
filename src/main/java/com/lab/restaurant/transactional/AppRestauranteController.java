package com.lab.restaurant.transactional;

import com.lab.restaurant.model.*;

import java.util.*;


/**
 * Created by Kei on 10/05/2016.
 */
public class AppRestauranteController {

//    public static ArrayList<Cliente> listaCliente;
//    public static ArrayList<Mesa> listaMesas = new ArrayList<Mesa>();
//    public static ArrayList<Mesero> listaMeseros = new ArrayList<Mesero>();
//    public static ArrayList<Alimento> listaAlimentos = new ArrayList<Alimento>();
//    public static ArrayList<Bebida> listaBebida = new ArrayList<Bebida>();

    private static Queue<Visita> colaEspera = new LinkedList<Visita>();

    /** ATENCION CLIENTE **/
    private static int buscarMesa(Cliente cliente) {

        for (Mesa mesa : AppRestauranteBD.getListaMesas()) {
            if (mesa.getCapacidad() >= cliente.getNumeroAcompanantes() && mesa.getEstado() == 1)
                return mesa.getNumMesa();
        }

        return 0;
    }

    public static int asignarMesa(Cliente cliente) {

        int numeroMesa = buscarMesa(cliente);

        if ((numeroMesa = buscarMesa(cliente)) == 0)
            System.out.println("No hay mesas disponibles en este momento");
        else {
            System.out.println("El cliente " + cliente.getNombre() + " " + cliente.getApellidoPaterno() + " entrará a la mesa " + numeroMesa);
            System.out.println("El mesero " + AppRestauranteBD.getListaMesas().get(numeroMesa).getMesero().getNombre() + " lo atenderá");
        }

        return 1;
    }

    public static void asignarMeseroMesa(Mesero mesero, int idMesa) {
        mesero.AnadirMesa(AppRestauranteBD.getListaMesas().get(idMesa));
        AppRestauranteBD.getListaMesas().get(idMesa).setMesero(mesero);
    }

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
        //COMPLETAR
        System.out.println("\nEn mantemiento! :v\n");
        menuPrincipal();
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
        //COMPLETAR
        System.out.println("\nEn mantemiento! :v\n");
        menuOpciones();
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
