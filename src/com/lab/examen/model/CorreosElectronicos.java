package com.lab.examen.model;

/**
 * Created by Braulio Trigueros on 21/05/2016.
 */
public class CorreosElectronicos {
    private String correoElectronico;

    private CorreosElectronicos(){
    }

    public CorreosElectronicos(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public String toString() {
        return "CorreosElectronicos{" +
                "correoElectronico='" + correoElectronico + '\'' +
                '}';
    }
}
