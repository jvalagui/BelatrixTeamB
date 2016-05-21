package com.lab.restaurant.model;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Kei on 09/05/2016
 */

public class Mesero extends Persona {

    private ArrayList<Mesa> listaMesas;

    public Mesero(int id, String numDocumento, String nombre, String apPaterno, String apMaterno) {
        super(id, numDocumento, nombre, apPaterno, apMaterno);
        this.listaMesas = new ArrayList<Mesa>();
    }

    public Mesero() {

    }

    public void anadirMesa(Mesa mesa) {
        this.listaMesas.add(mesa);
        mesa.setMesero(this);
    }

    public ArrayList<Mesa> getListaMesas() {
        return listaMesas;
    }

    public void setListaMesas(ArrayList<Mesa> listaMesas) {
        this.listaMesas = listaMesas;
    }
}