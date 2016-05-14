package com.lab.restaurant.model;

import java.util.Date;

/**
 * Created by Kei on 09/05/2016.
 */
public class Mesa {

    private int id;
    private int numMesa;
    private int capacidad;
    private Mesero mesero;
    private int estado;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

    public Mesa() {
    }

    public Mesa(int id, int numMesa, int capacidad) {
        this.id = id;
        this.numMesa = numMesa;
        this.capacidad = capacidad;
        this.mesero = null;
        this.estado = 1;
        this.created_at = new Date();
        this.updated_at = null;
        this.deleted_at = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Mesero getMesero() {
        return mesero;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Date deleted_at) {
        this.deleted_at = deleted_at;
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "id=" + id +
                ", numMesa=" + numMesa +
                ", capacidad=" + capacidad +
                ", estado=" + estado +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", deleted_at=" + deleted_at +
                '}';
    }
}
