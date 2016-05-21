package com.lab.examen.utils;

import java.util.Scanner;

/**
 * Created by Kei on 21/05/2016.
 */
public class Helper {

    public static void pause(){
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
