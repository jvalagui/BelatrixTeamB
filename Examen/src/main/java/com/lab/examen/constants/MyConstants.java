package com.lab.examen.constants;

import com.lab.examen.model.*;
import com.lab.examen.utils.Helper;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by edu24 on 21/05/2016.
 */
public class MyConstants {

    private static boolean dataCargada = false;
    private static ArrayList<Person> personas = new ArrayList<Person>();
    private static ArrayList<Organization> organizaciones = new ArrayList<Organization>();

    private static void cargarData() {

        //COUNTRIES
        Country peru = new Country(1, "Perú", "");
        Country argentina = new Country(2, "Argentina", "");
        Country estadosUnidos = new Country(3, "Estados Unidos", "");
        Country colombia = new Country(4, "Colombia", "");
        Country mexico = new Country(5, "Mexico", "");
        Country espana = new Country(6, "España", "");

        //PHONEOPERATORS
        PhoneOperator movistar = new PhoneOperator(1, "Movistar", "");
        PhoneOperator claro = new PhoneOperator(2, "Claro", "");
        PhoneOperator entel = new PhoneOperator(3, "Entel", "");
        PhoneOperator vodafone = new PhoneOperator(4, "Vodafone", "");

        //DOCUMENTTYPES
        DocumentType dni = new DocumentType(1, "DNI", "");
        DocumentType pasaporte = new DocumentType(2, "PASAPORTE", "");

        //ORGANIZATIONS
        Organization belatrix = new Organization(1, "Belatrix", "");
        Organization pucp = new Organization(2, "PUCP", "");

        organizaciones.add(belatrix);
        organizaciones.add(pucp);

        //PERSONS
        Person persona1 = new Person(1, "65453432", "Mario1", "Bros1", "Peach1", peru, dni);
        Person persona2 = new Person(2, "65444555", "Mario2", "Bros2", "Peach2", espana, dni);
        Person persona3 = new Person(3, "65433432", "Mario3", "Bros3", "Peach3", colombia, dni);
        Person persona4 = new Person(4, "65454532", "Mario4", "Bros4", "Peach4", mexico, dni);
        Person persona5 = new Person(5, "65453432", "Mario5", "Bros5", "Peach5", peru, dni);
        Person persona6 = new Person(6, "58453432", "Mario6", "Bros6", "Peach6", espana, dni);
        Person persona7 = new Person(7, "96053432", "Mario7", "Bros7", "Peach7", argentina, dni);
        Person persona8 = new Person(8, "65469432", "Mario8", "Bros8", "Peach8", peru, dni);
        Person persona9 = new Person(9, "65453694", "Mario9", "Bros9", "Peach9", mexico, dni);
        Person persona10 = new Person(10, "65458732", "Mario10", "Bros10", "Peach10", estadosUnidos, pasaporte);
        Person persona11 = new Person(11, "65423432", "Mario11", "Bros11", "Peach11", argentina, pasaporte);
        Person persona12 = new Person(12, "65452092", "Mario12", "Bros12", "Peach12", peru, pasaporte);
        Person persona13 = new Person(13, "65457842", "Mario13", "Bros13", "Peach13", estadosUnidos, pasaporte);
        Person persona14 = new Person(14, "63423432", "Mario14", "Bros14", "Peach14", argentina, pasaporte);
        Person persona15 = new Person(15, "65532432", "Mario15", "Bros15", "Peach15", argentina, pasaporte);
        Person persona16 = new Person(16, "65453869", "Mario16", "Bros16", "Peach16", estadosUnidos, pasaporte);
        Person persona17 = new Person(17, "65458392", "Mario17", "Bros17", "Peach17", peru, pasaporte);
        Person persona18 = new Person(18, "69353432", "Mario18", "Bros18", "Peach18", argentina, pasaporte);
        Person persona19 = new Person(19, "65448422", "Mario19", "Bros19", "Peach19", estadosUnidos, pasaporte);
        Person persona20 = new Person(20, "65404952", "Mario20", "Bros20", "Peach20", espana, pasaporte);

        //PHONES
        Phone telefono1 = new Phone(1, "987545656", persona1, belatrix, movistar);
        Phone telefono2 = new Phone(2, "376247863", persona1, pucp, claro);
        Phone telefono3 = new Phone(3, "342353423", persona2, belatrix, movistar);
        Phone telefono4 = new Phone(4, "829748938", persona3, belatrix, claro);
        Phone telefono5 = new Phone(5, "324789383", persona4, pucp, movistar);
        Phone telefono6 = new Phone(6, "654534332", persona5, belatrix, movistar);
        Phone telefono7 = new Phone(7, "654534352", persona6, belatrix, entel);
        Phone telefono8 = new Phone(8, "645645656", persona6, pucp, movistar);
        Phone telefono9 = new Phone(9, "564651232", persona7, pucp, vodafone);
        Phone telefono10 = new Phone(10, "654543215", persona8, belatrix, movistar);
        Phone telefono11 = new Phone(11, "548648465", persona8, belatrix, entel);
        Phone telefono12 = new Phone(12, "231684656", persona9, pucp, claro);
        Phone telefono13 = new Phone(13, "524684561", persona9, belatrix, movistar);
        Phone telefono14 = new Phone(14, "564894256", persona10, pucp, vodafone);
        Phone telefono15 = new Phone(15, "657856245", persona10, belatrix, movistar);
        Phone telefono16 = new Phone(16, "645345353", persona11, belatrix, movistar);
        Phone telefono17 = new Phone(17, "376247845", persona11, pucp, claro);
        Phone telefono18 = new Phone(18, "342353555", persona12, belatrix, movistar);
        Phone telefono19 = new Phone(19, "829745638", persona13, belatrix, claro);
        Phone telefono20 = new Phone(20, "645454545", persona14, pucp, movistar);
        Phone telefono21 = new Phone(21, "567849914", persona15, belatrix, movistar);
        Phone telefono22 = new Phone(22, "168978475", persona16, belatrix, entel);
        Phone telefono23 = new Phone(23, "848577944", persona16, pucp, movistar);
        Phone telefono24 = new Phone(24, "792849516", persona17, pucp, vodafone);
        Phone telefono25 = new Phone(25, "194818444", persona18, belatrix, movistar);
        Phone telefono26 = new Phone(26, "684978948", persona18, belatrix, entel);
        Phone telefono27 = new Phone(27, "486487658", persona19, pucp, claro);
        Phone telefono28 = new Phone(28, "682584585", persona19, belatrix, movistar);
        Phone telefono29 = new Phone(29, "574657565", persona20, pucp, vodafone);
        Phone telefono30 = new Phone(30, "647878778", persona20, belatrix, movistar);

        persona1.addPhone(telefono1);
        persona1.addPhone(telefono2);
        persona2.addPhone(telefono3);
        persona3.addPhone(telefono4);
        persona4.addPhone(telefono5);
        persona5.addPhone(telefono6);
        persona6.addPhone(telefono7);
        persona6.addPhone(telefono8);
        persona7.addPhone(telefono9);
        persona8.addPhone(telefono10);
        persona8.addPhone(telefono11);
        persona9.addPhone(telefono12);
        persona9.addPhone(telefono13);
        persona10.addPhone(telefono14);
        persona10.addPhone(telefono15);
        persona11.addPhone(telefono16);
        persona11.addPhone(telefono17);
        persona12.addPhone(telefono18);
        persona13.addPhone(telefono19);
        persona14.addPhone(telefono20);
        persona15.addPhone(telefono21);
        persona16.addPhone(telefono22);
        persona16.addPhone(telefono23);
        persona17.addPhone(telefono24);
        persona18.addPhone(telefono25);
        persona18.addPhone(telefono26);
        persona19.addPhone(telefono27);
        persona19.addPhone(telefono28);
        persona20.addPhone(telefono29);
        persona20.addPhone(telefono30);

        pucp.addPhone(telefono2);
        pucp.addPhone(telefono5);
        pucp.addPhone(telefono8);
        pucp.addPhone(telefono9);
        pucp.addPhone(telefono12);
        pucp.addPhone(telefono14);
        pucp.addPhone(telefono17);
        pucp.addPhone(telefono20);
        pucp.addPhone(telefono23);
        pucp.addPhone(telefono24);
        pucp.addPhone(telefono27);
        pucp.addPhone(telefono29);
        belatrix.addPhone(telefono1);
        belatrix.addPhone(telefono3);
        belatrix.addPhone(telefono4);
        belatrix.addPhone(telefono6);
        belatrix.addPhone(telefono7);
        belatrix.addPhone(telefono10);
        belatrix.addPhone(telefono11);
        belatrix.addPhone(telefono13);
        belatrix.addPhone(telefono15);
        belatrix.addPhone(telefono16);
        belatrix.addPhone(telefono18);
        belatrix.addPhone(telefono19);
        belatrix.addPhone(telefono21);
        belatrix.addPhone(telefono22);
        belatrix.addPhone(telefono25);
        belatrix.addPhone(telefono26);
        belatrix.addPhone(telefono28);
        belatrix.addPhone(telefono30);

        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);
        personas.add(persona4);
        personas.add(persona5);
        personas.add(persona6);
        personas.add(persona7);
        personas.add(persona8);
        personas.add(persona9);
        personas.add(persona10);
        personas.add(persona11);
        personas.add(persona12);
        personas.add(persona13);
        personas.add(persona14);
        personas.add(persona15);
        personas.add(persona16);
        personas.add(persona17);
        personas.add(persona18);
        personas.add(persona19);
        personas.add(persona20);

        //Hice mucha data xD, no me alcanzó tiempo para emails ni otras listas

        System.out.println("\nData cargada correctamente!\n");
    }

    private static Organization buscaOrganizacion(Person persona){
        Organization organizacion = null;

        if(persona.getPhones().size()>0)
            organizacion = persona.getPhones().get(0).getOrganization();
        else
            if(persona.getEmails().size()>0)
                organizacion = persona.getEmails().get(0).getOrganization();

        return organizacion;
    }

    private static void imprimeInfoPersona(int indice){
        Person persona = personas.get(indice);

        System.out.println("Persona: " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno() + ", " + persona.getNombre());
        System.out.println("Nro de Documento: " + persona.getNumDocumento());
        System.out.print("Emails: ");
        if (persona.getEmails().size() > 0) {
            for (Email email : persona.getEmails())
                System.out.print(" " + email.getMail());
            System.out.println();
        }
        else
            System.out.println("No tiene emails registrados");
        System.out.print("Teléfonos: ");
        if (persona.getPhones().size() > 0) {
            for (Phone phone : persona.getPhones())
                System.out.print(" " + phone.getNumber());
            System.out.println();
        }
        else
            System.out.println("No tiene teléfonos registrados");
        System.out.println("Organización: "+ buscaOrganizacion(persona).getName() +"\n");
    }

    private static void listarPersonas(){
        int contador = 0;
        if (personas.size() > 0)
            for (Person persona : personas) {
                contador++;
                System.out.println("(" + contador + ")Persona: " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno() + ", " + persona.getNombre());
                System.out.println("Nro de Documento: " + persona.getNumDocumento());
                System.out.println();
            }
        else
            System.out.println("\nNo hay personas registradas!\n");
    }

    private static void reportePersonas(){
        int indice=0;
        Scanner in = new Scanner(System.in);
        listarPersonas();

        System.out.print("Ingrese el número de la persona a revisar: ");
        indice = in.nextInt();

        System.out.println();

        while (indice<=0 || indice>personas.size()) { //VALIDACION BÁSICA
            System.out.println("\nEsa persona no existe!\n");
            listarPersonas();
            System.out.print("Ingrese el número de la persona a revisar: ");
            indice = in.nextInt();
            System.out.println();
        }

        imprimeInfoPersona(indice-1);
    }

    private static void menuReportes() {
        int opcion;
        Scanner in = new Scanner(System.in);

        System.out.println("\nEXAMEN BELATRIX - Menú Reportes\n");
        System.out.println("\t(1)Información de una persona");
        System.out.println("\t(2)Organizaciones");
        System.out.println("\t(3)Operadores telefónicos");
        System.out.println("\t(4)Países");
        System.out.println("\t(5)Salir\n");
        System.out.print("Ingrese una opción: ");
        opcion = in.nextInt();

        while (opcion > 5 || opcion < 1) { //si escoge una opcion inválida
            System.out.println("\nOpción no válida!");

            System.out.println("\nEXAMEN BELATRIX - Menú Reportes\n");
            System.out.println("\t(1)Información de una persona");
            System.out.println("\t(2)Organizaciones");
            System.out.println("\t(3)Operadores telefónicos");
            System.out.println("\t(4)Países");
            System.out.println("\t(5)Salir\n");
            System.out.print("Ingrese una opción: ");
            opcion = in.nextInt();
        }

        switch (opcion) {
            case 1:
                System.out.println("\nEXAMEN BELATRIX - Lista de Personas\n");
                reportePersonas();
                Helper.pausa();
                menuReportes();
                break;
            case 2:
                System.out.println("\nEn mantemiento! :v\n");
                Helper.pausa();
                menuReportes();
                break;
            case 3:
                System.out.println("\nEn mantemiento! :v\n");
                Helper.pausa();
                menuReportes();
                break;
            case 4:
                System.out.println("\nEn mantemiento! :v\n");
                Helper.pausa();
                menuReportes();
                break;
            case 5:
                System.out.println("\nHasta luego!\n");
                break;
            default:
                break;
        }
    }

    public static void menuPrincipal() {
        int opcion;
        Scanner in = new Scanner(System.in);

        System.out.println("\nEXAMEN BELATRIX - Menú Principal\n");
        System.out.println("\t(1)Cargar Data");
        System.out.println("\t(2)Reportes");
        System.out.println("\t(3)Salir\n");
        System.out.print("Ingrese una opción: ");
        opcion = in.nextInt();

        while (opcion > 3 || opcion < 1) { //si escoge una opcion inválida
            System.out.println("\nOpción no válida!");

            System.out.println("\nEXAMEN BELATRIX - Menú Principal\n");
            System.out.println("\t(1)Cargar Data");
            System.out.println("\t(2)Reportes");
            System.out.println("\t(3)Salir\n");
            System.out.print("Ingrese una opción: ");
            opcion = in.nextInt();
        }

        switch (opcion) {
            case 1:
                if (!dataCargada) {
                    cargarData();
                    dataCargada = true;
                } else
                    System.out.println("\nLa data ya está cargada!\n");
                Helper.pausa();
                menuPrincipal();
                break;
            case 2:
                if (!dataCargada) {
                    System.out.println("\nNo ha cargado la data!\n");
                    Helper.pausa();
                    menuPrincipal();
                } else
                    menuReportes();
                break;
            case 3:
                System.out.println("\nHasta luego!\n");
                break;
            default:
                break;
        }
    }
}
