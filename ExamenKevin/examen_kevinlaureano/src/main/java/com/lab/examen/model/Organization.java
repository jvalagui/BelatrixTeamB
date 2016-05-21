package main.java.com.lab.examen.model;

/**
 * Created by ELMER on 21/05/2016.
 */
public class Organization {

    private int id;
    private String nombreOrganizacion;

    public Organization(){
    }

    public String getNombreOrganizacion() {
        return nombreOrganizacion;
    }

    public void setNombreOrganizacion(String nombreOrganizacion) {
        this.nombreOrganizacion = nombreOrganizacion;
    }

    public Organization(int id, String nombreOrganizacion){
        this.id = id;
        this.nombreOrganizacion = nombreOrganizacion;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
