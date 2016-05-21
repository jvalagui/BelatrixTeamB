package main.java.com.lab.examen.model;

/**
 * Created by ELMER on 21/05/2016.
 */
public class PhoneOperator {

    private int id;
    private String tipoOperador;

    public PhoneOperator(){
    }


    public PhoneOperator(int id, String tipoOperador){
        this.id=id;
        this.tipoOperador=tipoOperador;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoOperador() {
        return tipoOperador;
    }

    public void setTipoOperador(String tipoOperador) {
        this.tipoOperador = tipoOperador;
    }

}
