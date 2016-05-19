package com.lab.restaurant.model;

/**
 * Created by Braulio Trigueros on 11/05/2016.
 */
public class Bebida {
    private int id;
    private double precio;
    private String tipoBebida;

    public Bebida(){}

    public Bebida(int id, double precio, String tipoBebida){
        this.id = id;
        this.precio = precio;
        this.tipoBebida = tipoBebida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(String tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

    @Override
    public String toString() {
        return "Bebida{" +
                "id=" + id +
                ", precio=" + precio +
                ", tipoBebida='" + tipoBebida + '\'' +
                '}';
    }
}
