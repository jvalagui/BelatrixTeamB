package com.lab.examen.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by edu24 on 21/05/2016.
 */
public class PhoneOperator {

    private int id;
    private String name;
    private String description;
    private ArrayList<Phone> phones;
    private int status;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

    public PhoneOperator() {
    }

    public PhoneOperator(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
