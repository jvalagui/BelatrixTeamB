package com.lab.examen.transactional;

import com.lab.examen.model.Country;

/**
 * Created by Kei on 21/05/2016.
 */
public class CountryController {

    public static void store(){

    }

    public static void update(){

    }

    public static void destroy(){

    }

    public static void list(){

        int count = AppExamenDB.getCountries().size();

        for (int i=0; i < count; i++){
            System.out.println("[" + (i+1) + "]" + AppExamenDB.getCountries().get(i).getName());
        }
    }

    public static void listAll(){

        int count = AppExamenDB.getCountries().size();

        for (int i=0; i < count; i++){
            System.out.println("[" + (i+1) + "]" + AppExamenDB.getCountries().get(i).getName());
            Country country = AppExamenDB.getCountries().get(i);
            int peopleCount = country.getPeople().size();

            if(peopleCount == 0){
                System.out.println("Empty Country");
            }
            else{
                for(int j=0; j< peopleCount; j++){
                    System.out.println("\t[" + (j+1) + "]" + country.getPeople().get(j).getLastName() + " " + country.getPeople().get(j).getName());
                }
            }
        }
    }

    public static void listByCountry(int index){

        int countryCount = AppExamenDB.getCountries().size();
        int realIndex = index - 1;

        if(realIndex > countryCount){
            System.out.println("Invalid option");
        }
        else{
            Country country = AppExamenDB.getCountries().get(realIndex);
            int peopleCount = country.getPeople().size();

            if(peopleCount == 0){
                System.out.println("Empty Country");
            }
            else{
                for(int j=0; j< peopleCount; j++){
                    System.out.println("\t[" + (j+1) + "]" + country.getPeople().get(j).getLastName() + " " + country.getPeople().get(j).getName());
                }
            }
        }

    }

    public static void load(){

        Country country1 = new Country(1,"PERU");
        Country country2 = new Country(2,"BRASIL");
        Country country3 = new Country(3,"ARGENTINA");
        Country country4 = new Country(4,"ECUADOR");
        Country country5 = new Country(5,"COLOMBIA");

        AppExamenDB.getCountries().add(country1);
        AppExamenDB.getCountries().add(country2);
        AppExamenDB.getCountries().add(country3);
        AppExamenDB.getCountries().add(country4);
        AppExamenDB.getCountries().add(country5);

    }

    public static Country search(){
        return null;
    }

}
