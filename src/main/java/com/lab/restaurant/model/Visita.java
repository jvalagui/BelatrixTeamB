package com.lab.restaurant.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kei on 10/05/2016.
 * Modified by Braulio on 11/05/2016
 */
public class Visita {

    private int id;
    private Cliente cliente;
    private int numeroAcompanantes;
    private Mesa mesa;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

    public Visita() {
    }

    public Visita(int id, Cliente cliente, Mesa mesa) {
        this.id = id;
        this.cliente = cliente;
        this.mesa = mesa;
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

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getIdMesa() {
        return mesa;
    }

    public void setIdMesa(Mesa mesa) {
        this.mesa = mesa;
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
}
