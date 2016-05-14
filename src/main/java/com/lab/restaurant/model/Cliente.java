package com.lab.restaurant.model;

import java.util.Date;

/**
 * Created by Kei on 10/05/2016.
 */
public class Cliente extends Persona {

    private int numeroAcompanantes;

    public Cliente() {
    }

    public Cliente(int id, String numDocumento, String nombre, String apPaterno, String apMaterno, int estado, int numeroAcompanantes) {
        super(id, numDocumento, nombre, apPaterno, apMaterno, estado);

        this.numeroAcompanantes = numeroAcompanantes;
    }

    public int getNumeroAcompanantes() {
        return numeroAcompanantes;
    }

    public void setNumeroAcompanantes(int numeroAcompanantes) {
        this.numeroAcompanantes = numeroAcompanantes;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
