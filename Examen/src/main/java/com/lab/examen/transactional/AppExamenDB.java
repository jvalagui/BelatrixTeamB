package com.lab.examen.transactional;

import com.lab.examen.model.*;

import java.util.ArrayList;

/**
 * Created by Kei on 21/05/2016.
 */
public class AppExamenDB {

    private static ArrayList<Country> countries = new ArrayList<>();
    private static ArrayList<DocumentType> documentTypes = new ArrayList<>();
    private static ArrayList<Email> emails = new ArrayList<>();
    private static ArrayList<Organization> organizations = new ArrayList<>();
    private static ArrayList<Person> persons = new ArrayList<>();
    private static ArrayList<Phone> phones = new ArrayList<>();
    private static ArrayList<PhoneOperator> phoneOperators = new ArrayList<>();


    public static ArrayList<Country> getCountries() {
        return countries;
    }

    public static void setCountries(ArrayList<Country> countries) {
        AppExamenDB.countries = countries;
    }

    public static ArrayList<DocumentType> getDocumentTypes() {
        return documentTypes;
    }

    public static void setDocumentTypes(ArrayList<DocumentType> documentTypes) {
        AppExamenDB.documentTypes = documentTypes;
    }

    public static ArrayList<Email> getEmails() {
        return emails;
    }

    public static void setEmails(ArrayList<Email> emails) {
        AppExamenDB.emails = emails;
    }

    public static ArrayList<Organization> getOrganizations() {
        return organizations;
    }

    public static void setOrganizations(ArrayList<Organization> organizations) {
        AppExamenDB.organizations = organizations;
    }

    public static ArrayList<Person> getPersons() {
        return persons;
    }

    public static void setPersons(ArrayList<Person> persons) {
        AppExamenDB.persons = persons;
    }

    public static ArrayList<Phone> getPhones() {
        return phones;
    }

    public static void setPhones(ArrayList<Phone> phones) {
        AppExamenDB.phones = phones;
    }

    public static ArrayList<PhoneOperator> getPhoneOperators() {
        return phoneOperators;
    }

    public static void setPhoneOperators(ArrayList<PhoneOperator> phoneOperators) {
        AppExamenDB.phoneOperators = phoneOperators;
    }
}
