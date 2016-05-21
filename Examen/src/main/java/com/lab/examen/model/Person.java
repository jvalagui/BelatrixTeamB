package com.lab.examen.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by edu24 on 21/05/2016.
 */
public class Person {

    private int id;
    private String numDocumento;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Country country;
    private DocumentType documentType;
    private ArrayList<Email> emails;
    private ArrayList<Phone> phones;
    private int status;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

    public Person() {
    }

    public Person(int id, String numDocumento, String nombre, String apellidoPaterno, String apellidoMaterno, Country country, DocumentType documentType) {
        this.id = id;
        this.numDocumento = numDocumento;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.country = country;
        this.documentType = documentType;
        this.emails = new ArrayList<Email>();
        this.phones = new ArrayList<Phone>();
        this.status = 1;
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

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
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

    public void setApellidoPaterno(String apPaterno) {
        this.apellidoPaterno = apPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apMaterno) {
        this.apellidoMaterno = apMaterno;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public void addEmail(Email email){
        this.emails.add(email);
    }

    public ArrayList<Email> getEmails() {
        return emails;
    }

    public void addPhone(Phone phone){
        this.phones.add(phone);
    }

    public ArrayList<Phone> getPhones() {
        return phones;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
        return "Persona{" +
                "id=" + id +
                ", numDocumento='" + numDocumento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", estado=" + status +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", deleted_at=" + deleted_at +
                '}';
    }

}
