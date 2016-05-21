package com.lab.examen.utils;

import java.util.Scanner;

/**
 * Created by Kei on 10/05/2016.
 */
public class Helper {

    public static void pausa(){
        System.out.println("Presiona \"ENTER\" para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

}
