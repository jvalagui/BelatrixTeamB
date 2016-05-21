package com.lab.examen.transactional;

import com.lab.examen.model.PhoneOperator;

/**
 * Created by Kei on 21/05/2016.
 */
public class PhoneOperatorController {

    public static void store(){

    }

    public static void update(){

    }

    public static void destroy(){

    }

    public static void list(){

        int count = AppExamenDB.getPhoneOperators().size();

        for (int i=0; i < count; i++){
            System.out.println("[" + (i+1) + "]" + AppExamenDB.getPhoneOperators().get(i).getName());
        }

    }

    public static void listAll(){

        int count = AppExamenDB.getPhoneOperators().size();

        for (int i=0; i < count; i++){
            System.out.println("[" + (i+1) + "]" + AppExamenDB.getDocumentTypes().get(i).getName());
            PhoneOperator phoneOperator = AppExamenDB.getPhoneOperators().get(i);
            int phoneCount = phoneOperator.getPhoneList().size();

            if(phoneCount == 0){
                System.out.println("Empty Phone Operator");
            }
            else{
                for(int j=0; j< phoneCount; j++){
                    System.out.println("\t[" + (j+1) + "]" + phoneOperator.getPhoneList().get(j).getPhoneNumber() + "-> "
                            + phoneOperator.getPhoneList().get(j).getPerson().getLastName() + " "
                            + phoneOperator.getPhoneList().get(j).getPerson().getName());
                }
            }
        }
    }

    public static void listByPhoneOperator(int index){

        int phoneOperatorCount = AppExamenDB.getPhoneOperators().size();
        int realIndex = index - 1;

        if(realIndex > phoneOperatorCount){
            System.out.println("Invalid option");
        }
        else{
            PhoneOperator phoneOperator = AppExamenDB.getPhoneOperators().get(realIndex);
            int phoneCount = phoneOperator.getPhoneList().size();

            if(phoneCount == 0){
                System.out.println("Empty Phone Operator");
            }
            else{
                for(int j=0; j< phoneCount; j++){
                    System.out.println("\t[" + (j+1) + "]" + phoneOperator.getPhoneList().get(j).getPhoneNumber() + "-> "
                            + phoneOperator.getPhoneList().get(j).getPerson().getLastName() + " "
                            + phoneOperator.getPhoneList().get(j).getPerson().getName());
                }
            }
        }

    }

    public static void load(){

        PhoneOperator phoneOperator1 = new PhoneOperator(1,"MOVISTAR");
        PhoneOperator phoneOperator2 = new PhoneOperator(2,"CLARO");

        AppExamenDB.getPhoneOperators().add(phoneOperator1);
        AppExamenDB.getPhoneOperators().add(phoneOperator2);
    }

    public static PhoneOperator search(){
        return null;
    }
}
