package com.lab.restaurant.model;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * Created by Kei on 09/05/2016
 */

public class Mesero extends Persona {

    private ArrayList<Mesa> listaMesas;

    public Mesero(int id, String numDocumento, String nombre, String apPaterno, String apMaterno, int estado) {
        super(id, numDocumento, nombre, apPaterno, apMaterno, estado);
        this.listaMesas = new ArrayList<Mesa>();
    }

    public void AnadirMesa(Mesa mesa){
        this.listaMesas.add(mesa);
    }

    public ArrayList<Mesa> getListaMesas() {
        return listaMesas;
    }

    public void setListaMesas(ArrayList<Mesa> listaMesas) {
        this.listaMesas = listaMesas;
    }
}