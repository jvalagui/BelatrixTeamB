package com.lab.examen.model;

/**
 * Created by Braulio Trigueros on 21/05/2016.
 */
public class TipoDocumento {
    private int id;
    private String tipoDocumento;
    //private String numeroDocumento;

    TipoDocumento(){
    }

    TipoDocumento(int id, String tipoDocumento){
        this.id=id;
        this.tipoDocumento=tipoDocumento;
        //this.numeroDocumento=numeroDocumento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }



    @Override
    public String toString() {
        return "TipoDocumento{" +
                "id=" + id +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                '}';
    }
}
