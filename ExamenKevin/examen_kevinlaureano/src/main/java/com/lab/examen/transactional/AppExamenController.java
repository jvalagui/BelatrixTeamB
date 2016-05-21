package main.java.com.lab.examen.transactional;

import main.java.com.lab.examen.model.*;
import main.java.com.lab.examen.utils.Helper;


import java.util.*;


/**
 * Created by Kei on 10/05/2016.
 */
public class AppExamenController {

    private static Queue<Visita> colaEspera = new LinkedList<Visita>();

    public static void menuPrincipal() {
        int opcion;
        Scanner in = new Scanner(System.in);

        System.out.println("\nBELATRIX - Menú Principal\n");
        System.out.println("\t(1)Persona\n");
        System.out.println("\t(2)Salir\n");

        System.out.print("Ingrese una opción: ");
        opcion = in.nextInt();

        while (opcion > 3 || opcion < 1) { //si escoge una opcion inválida
            System.out.println("\nOpción no válida!");

            System.out.println("\nBELATRIX - Menú Principal\n");
            System.out.println("\t(1)Persona");
            System.out.println("\t(2)SALIR\n");
            System.out.print("Ingrese una opción: ");
            opcion = in.nextInt();
        }

        switch (opcion) {

            case 1:
                menuMeseros();
            case 2:

                System.out.println("\nHasta luego!\n");
                break;
            default:
                break;
        }
    }












    private static void menuMeseros() {
        int opcion;
        Scanner in = new Scanner(System.in);

        System.out.println("\nBELATRIX - Menú Persona\n");
        System.out.println("\t(1)Registrar Persona");
        System.out.println("\t(2)Regresar al menú de opciones\n");
        System.out.println("\t(3)Listar Personas");
        System.out.print("Ingrese una opción: ");
        opcion = in.nextInt();

        while (opcion > 5 || opcion < 1) { //si escoge una opcion inválida
            System.out.println("\nOpción no válida!");

            System.out.println("\nBELATRIX - Menú Persona\n");
            System.out.println("\t(1)Registrar Persona");
            System.out.println("\t(2)Listar Personas\n");
            System.out.println("\t(3)Regresar al menu anterior");
            System.out.print("Ingrese una opción: ");
            opcion = in.nextInt();
        }

        switch (opcion) {
            case 1:
                System.out.println("\nBELATRIX - Registrar nuevo Persona\n");
                MeseroController.registrar();
                menuMeseros();
                Helper.pausa();
                break;
            case 2:
                System.out.println("\nBELATRIX - Listado de Persona\n");
                MeseroController.listar();
                Helper.pausa();
                menuMeseros();
                break;
            case 3:

                menuPrincipal();
                break;

            default:
                break;
        }
    }



    private static boolean visitaEnCola(Cliente cliente, Queue<Visita> colaEspera){

        for (Visita visita: colaEspera) {
            if(visita.getCliente().getNumDocumento().equalsIgnoreCase(cliente.getNumDocumento())){
                return true;
            }
        }
        return false;
    }

    private static void verCola(){
        int contador = 0;

        if(colaEspera.isEmpty()){
            System.out.println("\nLa cola está vacía");
        }
        else{

            for (Visita visita: colaEspera) {
                System.out.println("\n[" + contador + "]");
                System.out.println("Cliente: " + visita.getCliente().getApellidoPaterno() + " " + visita.getCliente().getApellidoMaterno() + ", " + visita.getCliente().getNombre());
                System.out.println("Numero de acompanantes: " + visita.getNumeroAcompanantes() + "\n");

            }
        }
    }
}
