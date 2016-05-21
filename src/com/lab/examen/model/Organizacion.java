package com.lab.examen.model;

/**
 * Created by Braulio on 21/05/2016.
 */
public class Organizacion {

    private int id;
    private Persona persona;

    public Organizacion() {
    }

    public Organizacion(int id,Persona persona) {
        this.id = id;
        this.persona = persona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
