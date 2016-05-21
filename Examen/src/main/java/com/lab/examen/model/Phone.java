package com.lab.examen.model;

import java.util.Date;

/**
 * Created by edu24 on 21/05/2016.
 */
public class Phone {

    private int id;
    private String number;
    private Person person;
    private Organization organization;
    private PhoneOperator phoneOperator;
    private int status;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

    public Phone() {
    }

    public Phone(int id, String number, Person person, Organization organization, PhoneOperator phoneOperator) {
        this.id = id;
        this.number = number;
        this.person = person;
        this.organization = organization;
        this.phoneOperator = phoneOperator;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public PhoneOperator getPhoneOperator() {
        return phoneOperator;
    }

    public void setPhoneOperator(PhoneOperator phoneOperator) {
        this.phoneOperator = phoneOperator;
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
}
