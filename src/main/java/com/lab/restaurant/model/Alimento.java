package com.lab.restaurant.model;

/**
 * Created by Braulio Trigueros on 11/05/2016.
 * Modified by Edu Chuks
 */
public class Alimento {

    private double precio;
    private String tipoAlimento;

    public Alimento(){}

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipoAlimento() {
        return tipoAlimento;
    }

    public void setTipoAlimento(String tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }
}
