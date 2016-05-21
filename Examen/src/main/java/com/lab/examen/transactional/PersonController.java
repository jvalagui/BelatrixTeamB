package com.lab.examen.transactional;

import com.lab.examen.app.AppExamen;
import com.lab.examen.model.*;

/**
 * Created by Kei on 21/05/2016.
 */
public class PersonController {
    public static void store(){

    }

    public static void update(){

    }

    public static void destroy(){

    }

    public static void list(){

    }

    public static void load(){

        DocumentType DNI = AppExamenDB.getDocumentTypes().get(0);
        DocumentType CEI = AppExamenDB.getDocumentTypes().get(1);

        Country country1 = AppExamenDB.getCountries().get(0);
        Country country2 = AppExamenDB.getCountries().get(1);
        Country country3 = AppExamenDB.getCountries().get(2);
        Country country4 = AppExamenDB.getCountries().get(3);
        Country country5 = AppExamenDB.getCountries().get(4);

        Organization organization1 = AppExamenDB.getOrganizations().get(0);
        Organization organization2 = AppExamenDB.getOrganizations().get(1);

        PhoneOperator phoneOperator1 = AppExamenDB.getPhoneOperators().get(0);
        PhoneOperator phoneOperator2 = AppExamenDB.getPhoneOperators().get(1);


        Person person1 = new Person(1,DNI,"12345678","Kei","Takayama",country1);
        Email email1 = new Email(1,"inbox@email.com",organization1,person1);
        Phone phone1 = new Phone(1,"1234567",phoneOperator1,person1);
        person1.getEmailList().add(email1);
        person1.getPhoneList().add(phone1);

        AppExamenDB.getPersons().add(person1);
        AppExamenDB.getCountries().get(0).getPeople().add(person1);
        AppExamenDB.getDocumentTypes().get(0).getPeople().add(person1);
        AppExamenDB.getOrganizations().get(0).getEmailList().add(email1);
        AppExamenDB.getOrganizations().get(0).getPhoneList().add(phone1);
        AppExamenDB.getPhoneOperators().get(0).getPhoneList().add(phone1);

        Person person2 = new Person(2,DNI,"12345678","Eduardo","Chuquilin",country2);
        Email email2 = new Email(2,"inbox@email.com",organization1,person2);
        Phone phone2 = new Phone(2,"1234567",phoneOperator1,person2);
        person1.getEmailList().add(email2);
        person1.getPhoneList().add(phone2);

        AppExamenDB.getPersons().add(person1);
        AppExamenDB.getCountries().get(1).getPeople().add(person2);
        AppExamenDB.getDocumentTypes().get(0).getPeople().add(person2);
        AppExamenDB.getOrganizations().get(0).getEmailList().add(email2);
        AppExamenDB.getOrganizations().get(0).getPhoneList().add(phone2);
        AppExamenDB.getPhoneOperators().get(0).getPhoneList().add(phone2);

        Person person3 = new Person(3,DNI,"12345678","Braulio","Trigueros",country3);
        Email email3 = new Email(3,"inbox@email.com",organization2,person3);
        Phone phone3 = new Phone(3,"1234567",phoneOperator2,person3);
        person1.getEmailList().add(email3);
        person1.getPhoneList().add(phone3);

        AppExamenDB.getPersons().add(person1);
        AppExamenDB.getCountries().get(2).getPeople().add(person3);
        AppExamenDB.getDocumentTypes().get(0).getPeople().add(person3);
        AppExamenDB.getOrganizations().get(1).getEmailList().add(email3);
        AppExamenDB.getOrganizations().get(1).getPhoneList().add(phone3);
        AppExamenDB.getPhoneOperators().get(1).getPhoneList().add(phone3);

        Person person4 = new Person(4,CEI,"12345678","Alonso","Tealdo",country4);
        Email email4 = new Email(4,"inbox@email.com",organization1,person4);
        Phone phone4 = new Phone(4,"1234567",phoneOperator1,person4);
        person1.getEmailList().add(email4);
        person1.getPhoneList().add(phone4);

        AppExamenDB.getPersons().add(person1);
        AppExamenDB.getCountries().get(3).getPeople().add(person4);
        AppExamenDB.getDocumentTypes().get(1).getPeople().add(person4);
        AppExamenDB.getOrganizations().get(0).getEmailList().add(email4);
        AppExamenDB.getOrganizations().get(0).getPhoneList().add(phone4);
        AppExamenDB.getPhoneOperators().get(0).getPhoneList().add(phone4);

        Person person5 = new Person(5,CEI,"12345678","Luis","Landa",country5);
        Email email5 = new Email(5,"inbox@email.com",organization2,person5);
        Phone phone5 = new Phone(5,"1234567",phoneOperator2,person5);
        person1.getEmailList().add(email5);
        person1.getPhoneList().add(phone5);

        AppExamenDB.getPersons().add(person1);
        AppExamenDB.getCountries().get(4).getPeople().add(person5);
        AppExamenDB.getDocumentTypes().get(1).getPeople().add(person5);
        AppExamenDB.getOrganizations().get(1).getEmailList().add(email5);
        AppExamenDB.getOrganizations().get(1).getPhoneList().add(phone5);
        AppExamenDB.getPhoneOperators().get(1).getPhoneList().add(phone5);
    }

    public static Person search(){
        return null;
    }

}
