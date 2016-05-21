package com.lab.examen.transactional;

import com.lab.examen.model.DocumentType;
import com.lab.examen.model.Organization;
import com.lab.examen.utils.Helper;

import java.util.Scanner;

/**
 * Created by Kei on 21/05/2016.
 */
public class AppExamenController {

    private static int flagLoad = 0;

    public int getFlagLoad() {
        return flagLoad;
    }

    public void setFlagLoad(int flagLoad) {
        this.flagLoad = flagLoad;
    }

    public  static void load(){

        if(flagLoad == 1){
            System.out.println("You have already load the data.");
        }
        else{
            CountryController.load();
            DocumentTypeController.load();
            PhoneOperatorController.load();
            OrganizationController.load();
            PersonController.load();
            flagLoad = 1;
        }
    }

    public static void home() {
        int option;
        Scanner in = new Scanner(System.in);

        System.out.println("\nEXAMEN BELATRIX - HOME\n");
        System.out.println("\t(1)People by Country");
        System.out.println("\t(2)People by DocumentType");
        System.out.println("\t(3)Email by Organization");
        System.out.println("\t(4)Phones by Organization");
        System.out.println("\t(5)Phones by Phone Operator");
        System.out.println("\t(6)Info by Person");
        System.out.println("\t(7)Exit\n");
        System.out.print("Type your option: ");
        option = in.nextInt();

        while (option > 7 || option < 1) { //si escoge una opcion inválida
            System.out.println("\nInvalid Option!");

            System.out.println("\nRESTAURANTE BELATRIX - HOME\n");
            System.out.println("\t(1)People by Country");
            System.out.println("\t(2)People by DocumentType");
            System.out.println("\t(3)Email by Organization");
            System.out.println("\t(4)Phones by Organization");
            System.out.println("\t(5)Phones by Phone Operator");
            System.out.println("\t(6)Info by Person");
            System.out.println("\t(7)Exit\n");
            System.out.print("Type your option: ");
            option = in.nextInt();
        }

        switch (option) {
            case 1:
                countryIndex();
                break;
            case 2:
                documetTypeIndex();
                break;
            case 3:
                System.out.println("\nUnder Construction! :v\n");
                home();
                break;
            case 4:
                System.out.println("\nUnder Construction! :v\n");
                home();
                break;
            case 5:
                phoneOperatorIndex();
                break;
            case 6:
                System.out.println("\nUnder Construction! :v\n");
                home();
                break;
            case 7:
                System.out.println("\nBye-Bye!\n");
                break;
            default:
                break;
        }
    }

    public static void countryIndex(){

        int option;
        Scanner in = new Scanner(System.in);

        System.out.println("\nEXAMEN BELATRIX - People by Country\n");
        System.out.println("\t(1)List all countries");
        System.out.println("\t(2)List all");
        System.out.println("\t(3)List by Country");
        System.out.println("\t(4)Back\n");
        System.out.print("Type your option: ");

        option = in.nextInt();
        in.nextLine();

        while (option > 4 || option < 1) { //si escoge una opcion inválida
            System.out.println("\nInvalid Option!");

            System.out.println("\nRESTAURANTE BELATRIX - People by Country\n");
            System.out.println("\t(1)List all countries");
            System.out.println("\t(2)List all");
            System.out.println("\t(3)List by Country");
            System.out.println("\t(4)Back\n");
            System.out.print("Type your option: ");
            option = in.nextInt();
            in.nextLine();
        }

        switch (option) {
            case 1:
                CountryController.list();
                Helper.pause();
                countryIndex();
                break;
            case 2:
                CountryController.listAll();
                Helper.pause();
                countryIndex();
                break;
            case 3:
                CountryController.list();
                System.out.print("Type your option: ");
                option = in.nextInt();
                in.nextLine();

                CountryController.listByCountry(option);
                Helper.pause();
                countryIndex();
                break;
            case 4:
                home();
                break;
            default:
                break;
        }

    }

    public static void documetTypeIndex(){

        int option;
        Scanner in = new Scanner(System.in);

        System.out.println("\nEXAMEN BELATRIX - People by DocumentType\n");
        System.out.println("\t(1)List all Document Types");
        System.out.println("\t(2)List all");
        System.out.println("\t(3)List by Document Type");
        System.out.println("\t(4)Back\n");
        System.out.print("Type your option: ");

        option = in.nextInt();
        in.nextLine();

        while (option > 4 || option < 1) { //si escoge una opcion inválida
            System.out.println("\nInvalid Option!");

            System.out.println("\nRESTAURANTE BELATRIX - People by DocumentType\n");
            System.out.println("\t(1)List all Document Types");
            System.out.println("\t(2)List all");
            System.out.println("\t(3)List by Document Type");
            System.out.println("\t(4)Back\n");
            System.out.print("Type your option: ");
            option = in.nextInt();
            in.nextLine();
        }

        switch (option) {
            case 1:
                DocumentTypeController.list();
                Helper.pause();
                documetTypeIndex();
                break;
            case 2:
                DocumentTypeController.listAll();
                Helper.pause();
                documetTypeIndex();
                break;
            case 3:
                DocumentTypeController.list();
                System.out.print("Type your option: ");
                option = in.nextInt();
                in.nextLine();

                DocumentTypeController.listByCountry(option);
                Helper.pause();
                documetTypeIndex();
                break;
            case 4:
                home();
                break;
            default:
                break;
        }

    }

    public static void phoneOperatorIndex(){

        int option;
        Scanner in = new Scanner(System.in);

        System.out.println("\nEXAMEN BELATRIX - People by Phone Operator\n");
        System.out.println("\t(1)List all Phone Operator");
        System.out.println("\t(2)List all");
        System.out.println("\t(3)List by Phone Operator");
        System.out.println("\t(4)Back\n");
        System.out.print("Type your option: ");

        option = in.nextInt();
        in.nextLine();

        while (option > 4 || option < 1) { //si escoge una opcion inválida
            System.out.println("\nInvalid Option!");

            System.out.println("\nRESTAURANTE BELATRIX - People by DocumentType\n");
            System.out.println("\t(1)List all Phone Operator");
            System.out.println("\t(2)List all");
            System.out.println("\t(3)List by Phone Operator");
            System.out.println("\t(4)Back\n");
            System.out.print("Type your option: ");
            option = in.nextInt();
            in.nextLine();
        }

        switch (option) {
            case 1:
                PhoneOperatorController.list();
                Helper.pause();
                phoneOperatorIndex();
                break;
            case 2:
                PhoneOperatorController.listAll();
                Helper.pause();
                phoneOperatorIndex();
                break;
            case 3:
                PhoneOperatorController.list();
                System.out.print("Type your option: ");
                option = in.nextInt();
                in.nextLine();

                PhoneOperatorController.listByPhoneOperator(option);
                Helper.pause();
                phoneOperatorIndex();
                break;
            case 4:
                home();
                break;
            default:
                break;
        }

    }
}
