package com.lab.restaurant.transactional;

import com.lab.restaurant.model.*;

import java.util.ArrayList;

/**
 * Created by Kei on 16/05/2016.
 */
public class AppRestauranteBD {

    private static ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
    private static ArrayList<Mesa> listaMesas = new ArrayList<Mesa>();
    private static ArrayList<Mesero> listaMeseros = new ArrayList<Mesero>();
    private static ArrayList<Alimento> listaAlimentos = new ArrayList<Alimento>();
    private static ArrayList<Bebida> listaBebida = new ArrayList<Bebida>();
    private static ArrayList<Visita> listaVisita = new ArrayList<Visita>();

    public static ArrayList<Cliente> getListaCliente() {
        return listaCliente;
    }

    public static void setListaCliente(ArrayList<Cliente> listaCliente) {
        AppRestauranteBD.listaCliente = listaCliente;
    }

    public static ArrayList<Mesa> getListaMesas() {
        return listaMesas;
    }

    public static void setListaMesas(ArrayList<Mesa> listaMesas) {
        AppRestauranteBD.listaMesas = listaMesas;
    }

    public static ArrayList<Mesero> getListaMeseros() {
        return listaMeseros;
    }

    public static void setListaMeseros(ArrayList<Mesero> listaMeseros) {
        AppRestauranteBD.listaMeseros = listaMeseros;
    }

    public static ArrayList<Alimento> getListaAlimentos() {
        return listaAlimentos;
    }

    public static void setListaAlimentos(ArrayList<Alimento> listaAlimentos) {
        AppRestauranteBD.listaAlimentos = listaAlimentos;
    }

    public static ArrayList<Bebida> getListaBebida() {
        return listaBebida;
    }

    public static void setListaBebida(ArrayList<Bebida> listaBebida) {
        AppRestauranteBD.listaBebida = listaBebida;
    }

    public static ArrayList<Visita> getListaVisita() {
        return listaVisita;
    }

    public static void setListaVisita(ArrayList<Visita> listaVisita) {
        AppRestauranteBD.listaVisita = listaVisita;
    }
}
