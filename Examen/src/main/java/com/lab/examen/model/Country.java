package com.lab.examen.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kei on 21/05/2016.
 */
public class Country {

    private int id;
    private String name;
    private ArrayList<Person> people;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

    public Country() {
    }

    public Country(int id, String name) {
        this.id = id;
        this.name = name;
        this.people = new ArrayList<>();
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

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
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
