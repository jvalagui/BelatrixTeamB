package com.lab.restaurant.model;

/**
 * Created by Braulio Trigueros on 11/05/2016.
 */
public class Alimento {
//Incompleto
    private String tipoAlimento(){
        String tA = "F";
        if (tA == tA){
            System.out.println("El alimento es Fresco");
        }
        else if (tA == "E"){
            System.out.println("El alimento es Envasado");
        }
        else{
            System.out.println("Ingrese tipo de alimento correcto (Fresco o Envasado");
        }
        return tA;
    }
}
