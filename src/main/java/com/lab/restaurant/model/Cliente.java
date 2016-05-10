package com.lab.restaurant.model;

import java.util.Date;

/**
 * Created by Kei on 10/05/2016.
 */
public class Cliente extends Persona {

    public Cliente() {
    }

    public Cliente(int id, String numDocumento, String nombre, String apPaterno, String apMaterno, int estado) {
        super(id, numDocumento, nombre, apPaterno, apMaterno, estado);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
