package com.lab.restaurant.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Kei on 10/05/2016.
 */
public class Helper {

    public static String dateFormat(Date date){

        DateFormat dFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        return dFormat.format(date);
    }

    public static void pausa(){
        System.out.println("Presiona \"ENTER\" para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

}
