package com.lab.restaurant.model;
import java.io.Serializable;
/**
 * Created by Braulio Trigueros on 11/05/2016.
 * Modified by Edu Chuks
 */
public class Alimento {

    private int id;
    private double precio;
    private String tipoAlimento;

    public Alimento(){}

    public Alimento(int id, double precio, String tipoAlimento){
        this.id = id;
        this.precio = precio;
        this.tipoAlimento = tipoAlimento;
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

    public String getTipoAlimento() {
        return tipoAlimento;
    }

    public void setTipoAlimento(String tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }
}
