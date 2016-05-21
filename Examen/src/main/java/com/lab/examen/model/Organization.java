package com.lab.examen.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kei on 21/05/2016.
 */
public class Organization {

    private int id;
    private String name;
    private ArrayList<Email> emailList;
    private ArrayList<Phone> phoneList;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

    public Organization() {
    }

    public Organization(int id, String name) {
        this.id = id;
        this.name = name;
        this.emailList = new ArrayList<>();
        this.phoneList = new ArrayList<>();
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

    public ArrayList<Email> getEmailList() {
        return emailList;
    }

    public void setEmailList(ArrayList<Email> emailList) {
        this.emailList = emailList;
    }

    public ArrayList<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(ArrayList<Phone> phoneList) {
        this.phoneList = phoneList;
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