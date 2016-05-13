package com.lab.restaurant.model;

/**
 * Created by Braulio Trigueros on 11/05/2016.
 */
public class Bebida {
    //SUPER INCOMPLETO
    private String tipoBebida() {
        int t = 1;
        switch (t) {
            case 0:
                System.out.println("Bebida: Jugo");
                break;
            case 1:
                System.out.println("Bebida: Gaseosa");
                break;
            case 2:
                System.out.println("Bedida: Cervaza");
                break;
            case 3:
                System.out.println("Bebida: Infusión");
                break;
        }
    }
}
