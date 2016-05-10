package com.lab.restaurant.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Kei on 10/05/2016.
 */
public class Helper {

    public static String dateFormat(Date date){

        DateFormat dFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        return dFormat.format(date);
    }

}
