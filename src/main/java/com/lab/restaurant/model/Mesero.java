package com.lab.restaurant.model;

/**
 * Created by Kei on 09/05/2016
 */

public class Mesero extends Persona {

    private Mesa mesa;

    public Mesero(int id, String numDocumento, String nombre, String apPaterno, String apMaterno, int estado, Mesa mesa) {
        super(id, numDocumento, nombre, apPaterno, apMaterno, estado);
        this.mesa = mesa;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    @Override
    public String toString() {
        return "Mesero{" +
                "mesa=" + mesa +
                "} " + super.toString();
    }
}