package com.lab.restaurant.transactional;

import com.lab.restaurant.model.Cliente;
import com.lab.restaurant.model.Mesa;
import com.lab.restaurant.model.Mesero;
import com.lab.restaurant.model.Visita;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


/**
 * Created by Kei on 10/05/2016.
 */
public class AppRestauranteController {
    public static ArrayList<Cliente> listaCliente;
    public static ArrayList<Mesa> listaMesas = new ArrayList<Mesa>();
    public static ArrayList<Mesero> listaMeseros = new ArrayList<Mesero>();

    private static int buscaMesa(Cliente cliente){

        for(Mesa mesa:listaMesas){
            if(mesa.getCapacidad()>=cliente.getNumeroAcompanantes() && mesa.getEstado()==1)
                return mesa.getNumMesa();
        }

        return 0;
    }

    public static void asignarMeseroMesa(Mesero mesero, int idMesa){
        mesero.AnadirMesa(listaMesas.get(idMesa));
        listaMesas.get(idMesa).setMesero(mesero);
    }

    public static int asignarMesa(Cliente cliente) {

        int numeroMesa = 0;

        if ((numeroMesa=buscaMesa(cliente)) == 0)
            System.out.println("No hay mesas disponibles en este momento");
        else {
            System.out.println("El cliente "+cliente.getNombre()+" "+cliente.getApellidoPaterno()+" entrará a la mesa "+numeroMesa);
            System.out.println("El mesero "+listaMesas.get(numeroMesa).getMesero().getNombre()+" lo atenderá");
        }

        return 1;
    }
}
