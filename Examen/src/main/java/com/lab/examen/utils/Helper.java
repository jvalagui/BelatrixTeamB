package com.lab.examen.utils;

import java.util.Scanner;

/**
 * Created by edu24 on 21/05/2016.
 */
public class Helper {

    public static void pausa(){
        System.out.println("Presione \"ENTER\" para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

}
