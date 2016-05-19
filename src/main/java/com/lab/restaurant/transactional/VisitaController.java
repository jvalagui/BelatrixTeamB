package com.lab.restaurant.transactional;

import com.lab.restaurant.model.Cliente;
import com.lab.restaurant.model.Visita;

import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Kei on 18/05/2016.
 */
public class VisitaController {

    public static Visita registrar(Cliente cliente){

        Scanner in = new Scanner(System.in);
        int numeroAcompanantes;
        int idVisita;

        System.out.println("\nRESTAURANTE BELATRIX - Registrar nueva visita\n");
        System.out.print("Ingresar el numero de acompanantes del cliente: ");
        numeroAcompanantes = in.nextInt();

        idVisita = obtenerIdVisita();

        Visita visita = new Visita(idVisita,cliente,numeroAcompanantes);

        return visita;
    }

    public static boolean visitaEnCola(Cliente cliente, Queue<Visita> colaEspera){

        for (Visita visita: colaEspera) {
            if(visita.getCliente().getNumDocumento().equalsIgnoreCase(cliente.getNumDocumento())){

                return true;
            }
        }
        return false;
    }

    private static int obtenerIdVisita(){

        int cantidadVisitas = AppRestauranteBD.getListaVisita().size();

        if(cantidadVisitas == 0){
            return 1;
        }
        else{
            int idVisita = cantidadVisitas++;
            return idVisita;
        }
    }

//    private static int buscarMesa(Cliente cliente) {
//
//        for (Mesa mesa : AppRestauranteBD.getListaMesas()) {
//            if (mesa.getCapacidad() >= cliente.getNumeroAcompanantes() && mesa.getEstado() == 1)
//                return mesa.getNumMesa();
//        }
//
//        return 0;
//    }
//
//    public static int asignarMesa(Cliente cliente) {
//
//        int numeroMesa = buscarMesa(cliente);
//
//        if ((numeroMesa = buscarMesa(cliente)) == 0)
//            System.out.println("No hay mesas disponibles en este momento");
//        else {
//            System.out.println("El cliente " + cliente.getNombre() + " " + cliente.getApellidoPaterno() + " entrará a la mesa " + numeroMesa);
//            System.out.println("El mesero " + AppRestauranteBD.getListaMesas().get(numeroMesa).getMesero().getNombre() + " lo atenderá");
//        }
//
//        return 1;
//    }
//
//    public static void asignarMeseroMesa(Mesero mesero, int idMesa) {
//        mesero.anadirMesa(AppRestauranteBD.getListaMesas().get(idMesa));
//        AppRestauranteBD.getListaMesas().get(idMesa).setMesero(mesero);
//    }

}
