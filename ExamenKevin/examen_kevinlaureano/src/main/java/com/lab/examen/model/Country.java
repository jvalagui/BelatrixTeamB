package main.java.com.lab.examen.model;
import java.util.Date;
/**
 * Created by ELMER on 21/05/2016.
 */
public class Country {

    private int id;
    private String numCountry;
    private String nombre;

    Country(){
    }


    Country(int id, String numCountry, String nombre){
        this.id=id;
        this.numCountry=numCountry;
        this.nombre=nombre;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getNumCountry() {return numCountry;}

    public void setNumCountry(String numCountry) {this.numCountry = numCountry;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    @Override
    public String toString(){
        return "Persona{"+
                "id=" + id +
                ",numCountry='" + numCountry+'\''+
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
