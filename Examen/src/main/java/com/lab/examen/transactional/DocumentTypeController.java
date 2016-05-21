package com.lab.examen.transactional;

import com.lab.examen.model.DocumentType;

import javax.print.Doc;

/**
 * Created by Kei on 21/05/2016.
 */
public class DocumentTypeController {

    public static void store(){

    }

    public static void update(){

    }

    public static void destroy(){

    }

    public static void list(){

        int count = AppExamenDB.getDocumentTypes().size();

        for (int i=0; i < count; i++){
            System.out.println("[" + (i+1) + "]" + AppExamenDB.getDocumentTypes().get(i).getName());
        }

    }

    public static void listAll(){

        int count = AppExamenDB.getDocumentTypes().size();

        for (int i=0; i < count; i++){
            System.out.println("[" + (i+1) + "]" + AppExamenDB.getDocumentTypes().get(i).getName());
            DocumentType documentType = AppExamenDB.getDocumentTypes().get(i);
            int peopleCount = documentType.getPeople().size();

            if(peopleCount == 0){
                System.out.println("Empty Document Type");
            }
            else{
                for(int j=0; j< peopleCount; j++){
                    System.out.println("\t[" + (j+1) + "]" + documentType.getPeople().get(j).getLastName() + " " + documentType.getPeople().get(j).getName());
                }
            }
        }
    }

    public static void listByCountry(int index){

        int documentTypeCount = AppExamenDB.getDocumentTypes().size();
        int realIndex = index - 1;

        if(realIndex > documentTypeCount){
            System.out.println("Invalid option");
        }
        else{
            DocumentType documentType = AppExamenDB.getDocumentTypes().get(realIndex);
            int peopleCount = documentType.getPeople().size();

            if(peopleCount == 0){
                System.out.println("Empty Country");
            }
            else{
                for(int j=0; j< peopleCount; j++){
                    System.out.println("\t[" + (j+1) + "]" + documentType.getPeople().get(j).getLastName() + " " + documentType.getPeople().get(j).getName());
                }
            }
        }

    }

    public static void load(){

        DocumentType documentType1 = new DocumentType(1,"DNI");
        DocumentType documentType2 = new DocumentType(1,"CEI");

        AppExamenDB.getDocumentTypes().add(documentType1);
        AppExamenDB.getDocumentTypes().add(documentType2);
    }

    public static DocumentType search(){
        return null;
    }
}
