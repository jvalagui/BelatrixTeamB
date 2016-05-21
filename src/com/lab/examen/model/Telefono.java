package com.lab.examen.model;

/**
 * Created by Braulio Trigueros on 21/05/2016.
 */
public class Telefono {
    private String numeroTelefono;
    private String operador;

    private Telefono(){
    }

    public Telefono(String numeroTelefono, String operador) {
        this.numeroTelefono = numeroTelefono;
        this.operador = operador;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    @Override
    public String toString() {
        return "Telefono{" +
                "numeroTelefono='" + numeroTelefono + '\'' +
                ", operador='" + operador + '\'' +
                '}';
    }
}
