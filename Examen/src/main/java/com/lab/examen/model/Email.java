package com.lab.examen.model;

import java.util.Date;

/**
 * Created by Kei on 21/05/2016.
 */
public class Email {

    private int id;
    private String email;
    private Organization organization;
    private Person person;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

    public Email() {
    }

    public Email(int id, String email, Organization organization, Person person) {
        this.id = id;
        this.email = email;
        this.organization = organization;
        this.person = person;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
