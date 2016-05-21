package com.lab.examen.model;

/**
 * Created by Braulio Trigueros on 21/05/2016.
 */
public class Pais {
    private int id;
    private String nombrePais;

    Pais(){
    }

    Pais(int id, String nombrePais){
        this.id=id;
        this.nombrePais=nombrePais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nombrePais='" + nombrePais + '\'' +
                '}';
    }
}
