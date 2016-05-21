package com.lab.restaurant.model;
import java.io.Serializable;

/**
 * Created by Kei on 10/05/2016.
 */
public class Cliente extends Persona {

    public Cliente() {
    }

    public Cliente(int id, String numDocumento, String nombre, String apPaterno, String apMaterno) {
        super(id, numDocumento, nombre, apPaterno, apMaterno);


    }

    @Override
    public String toString() {
        return super.toString();
    }
}
