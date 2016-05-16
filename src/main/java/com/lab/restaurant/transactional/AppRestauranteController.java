package com.lab.restaurant.transactional;

import com.lab.restaurant.model.*;

import java.util.*;


/**
 * Created by Kei on 10/05/2016.
 */
public class AppRestauranteController {
    public static ArrayList<Cliente> listaCliente;
    public static ArrayList<Mesa> listaMesas = new ArrayList<Mesa>();
    public static ArrayList<Mesero> listaMeseros = new ArrayList<Mesero>();
    public static ArrayList<Alimento> listaAlimentos = new ArrayList<Alimento>();
    public static ArrayList<Bebida> listaBebida = new ArrayList<Bebida>();

    private static int buscaMesa(Cliente cliente) {

        for (Mesa mesa : listaMesas) {
            if (mesa.getCapacidad() >= cliente.getNumeroAcompanantes() && mesa.getEstado() == 1)
                return mesa.getNumMesa();
        }

        return 0;
    }

    public static void asignarMeseroMesa(Mesero mesero, int idMesa) {
        mesero.AnadirMesa(listaMesas.get(idMesa));
        listaMesas.get(idMesa).setMesero(mesero);
    }

    public static int asignarMesa(Cliente cliente) {

        int numeroMesa;

        if ((numeroMesa = buscaMesa(cliente)) == 0)
            System.out.println("No hay mesas disponibles en este momento");
        else {
            System.out.println("El cliente " + cliente.getNombre() + " " + cliente.getApellidoPaterno() + " entrará a la mesa " + numeroMesa);
            System.out.println("El mesero " + listaMesas.get(numeroMesa).getMesero().getNombre() + " lo atenderá");
        }

        return 1;
    }

    private static void menuAtencion() {
        //COMPLETAR
        System.out.println("\nEn mantemiento! :v\n");
        menuPrincipal();
    }

    private static boolean existeMesa(int numMesa) {

        if (listaMesas.size() > 0)
            for (Mesa mesa : listaMesas)
                if (mesa.getNumMesa() == numMesa)
                    return true;

        return false;
    }

    private static void registrarMesa() {
        int nuevoNumMesa;
        int nuevaCapacidad;
        Scanner in = new Scanner(System.in);

        //FALTAN VALIDACIONES (POR EJEMPLO VERIFICAR QUE SE INGRESEN SÓLO NUMEROS Y NO LETRAS)

        System.out.println("\nRESTAURANTE BELATRIX - Registrar nueva mesa\n");
        System.out.print("Ingresar nuevo numero de mesa: ");
        nuevoNumMesa = in.nextInt();

        while (existeMesa(nuevoNumMesa)) { //VALIDACION BÁSICA
            System.out.println("\nEse número de mesa ya existe!");
            System.out.print("Ingresar nuevo numero de mesa: ");
            nuevoNumMesa = in.nextInt();
        }

        System.out.print("\nIngresar capacidad: ");
        nuevaCapacidad = in.nextInt();

        while(nuevaCapacidad<=0){
            System.out.println("\nDebe ingresar una capacidad mayor a cero!");
            System.out.print("Ingresar capacidad: ");
            nuevaCapacidad = in.nextInt();
        }

        listaMesas.add(new Mesa(nuevoNumMesa,nuevoNumMesa,nuevaCapacidad));

        System.out.println("\nMesa registrada correctamente!");

        menuMesas();
    }

    private static void listarMesas() {
        System.out.println("\nRESTAURANTE BELATRIX - Listado de mesas\n");
        if (listaMesas.size() > 0)
            for (Mesa mesa : listaMesas) {
                System.out.print("Mesa " + mesa.getNumMesa() + ": " + "capacidad(" + mesa.getCapacidad() + ") - mesero a cargo(");
                if (mesa.getMesero() != null)
                    System.out.println("" + mesa.getMesero().getNombre() + ") - estado(" + mesa.getEstado() + ")");
                else
                    System.out.println("sin asignar) - estado(" + mesa.getEstado() + ")");
            }
        else
            System.out.println("\nNo hay mesas registradas!\n");

        menuMesas();
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
                registrarMesa();
                break;
            case 2:
                //modificar mesa
                break;
            case 3:
                //eliminar mesa
                break;
            case 4:
                listarMesas();
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
        int opcion;
        Scanner in = new Scanner(System.in);

        System.out.println("\nRESTAURANTE BELATRIX - Menú Bebidas\n");
        System.out.println("\t(1)Bebidas con alcohol");
        System.out.println("\t(2)Bebidas sin alcohol");
        System.out.println("\t(3)Regresar al menú de opciones\n");
        System.out.print("Ingrese una opción: ");
        opcion = in.nextInt();
        //COMPLETAR
        switch (opcion) {
            case 1:
                //bebidasConalcohol();
                break;
            case 2:
                //bebidasSinalcohol();
                break;
            case 3:
                menuOpciones();
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
}
