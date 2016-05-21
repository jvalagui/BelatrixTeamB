package com.lab.examen.model;

/**
 * Created by Braulio on 21/05/2016.
 */
public class Persona {

    private int id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String numeroDocumento;
    private TipoDocumento tipoDocumento;
    private Pais nombrePais;
    private Telefono numeroTelefono;
    private Telefono operador;
    private CorreosElectronicos correoElectronicos;

    Persona() {
    }

    public Persona(int idPersona, String numeroDocumento, String nombre, String apellidoPaterno, String apellidoMaterno, String tipoDocumento, String numeroTelefono, String operador, String correoElectronico) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.tipoDocumento = null;
        this.numeroDocumento = numeroDocumento;
        this.nombrePais = null;
        this.numeroTelefono = null;
        this.operador = null;
        this.correoElectronicos = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Pais getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(Pais nombrePais) {
        this.nombrePais = nombrePais;
    }

    public Telefono getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(Telefono numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public Telefono getOperador() {
        return operador;
    }

    public void setOperador(Telefono operador) {
        this.operador = operador;
    }

    public CorreosElectronicos getCorreoElectronicos() {
        return correoElectronicos;
    }

    public void setCorreoElectronicos(CorreosElectronicos correoElectronicos) {
        this.correoElectronicos = correoElectronicos;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", tipoDocumento=" + tipoDocumento +
                ", numeroDocumento=" + numeroDocumento +
                ", nombrePais=" + nombrePais +
                ", numeroTelefono=" + numeroTelefono +
                ", operador=" + operador +
                ", correoElectronicos=" + correoElectronicos +
                '}';
    }
}
