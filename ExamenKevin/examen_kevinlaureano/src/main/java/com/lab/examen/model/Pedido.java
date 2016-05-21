package main.java.com.lab.examen.model;

import java.util.Date;

/**
 * Created by Braulio Trigueros on 11/05/2016.
 */
public class Pedido {

    private int numPedido;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

    public Pedido(){
    }

    private Mesero mesero;
    private Mesa mesa;

    public Pedido(int numPedido) {
        this.numPedido = numPedido;
        this.created_at = new Date();
        this.updated_at = null;
        this.deleted_at = null;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
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

    public Mesero getMesero() {
        return mesero;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "numPedido=" + numPedido +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", deleted_at=" + deleted_at +
                ", mesero=" + mesero +
                ", mesa=" + mesa +
                '}';
    }
}
