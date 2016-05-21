package com.lab.restaurant.transactional;

import com.lab.restaurant.model.Cliente;
import com.lab.restaurant.model.Mesa;
import com.lab.restaurant.model.Visita;

import java.util.Date;
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
        AppRestauranteBD.getListaVisita().add(visita);

        return visita;
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

    private static Mesa buscarMesaDisponible(Visita visita) {

        Mesa mesa = null;

        for (Mesa auxMesa : AppRestauranteBD.getListaMesas()) {
            if (auxMesa.getCapacidad() >= (visita.getNumeroAcompanantes() + 1) && auxMesa.getEstado() == 1){

                mesa = auxMesa;
                return mesa;
            }
        }

        return mesa;
    }

    public static int asignarMesa(Visita visita) {

        Mesa mesaDisponible = buscarMesaDisponible(visita);

        if (mesaDisponible == null){
            return 0;
        }
        else {
            visita.setMesa(mesaDisponible);
            MesaController.ocuparMesa(mesaDisponible);
            return 1;
        }

    }

    public static void listarVisitasEnAtencion(){

        if(AppRestauranteBD.getListaVisita().size() > 0){
            for (Visita visita : AppRestauranteBD.getListaVisita()) {
                if(visita.getDeleted_at() == null && visita.getMesa() != null){
                    System.out.println("Mesa: " + visita.getMesa().getNumMesa());
                }
            }
        }
    }

    public static Visita obtenerVisitaPorNumeroMesa(int numeroMesa){

        Visita visita = null;

        if (AppRestauranteBD.getListaVisita().size() > 0)
            for (Visita auxVisita : AppRestauranteBD.getListaVisita())
                if (auxVisita.getDeleted_at()== null && auxVisita.getMesa().getNumMesa() == numeroMesa){
                    visita = auxVisita;
                    return visita;
                }

        return visita;
    }

    public static void finalizarAtencion(Visita visita){

        visita.setDeleted_at(new Date());
        MesaController.desocuparMesa(visita.getMesa());

    }
}
