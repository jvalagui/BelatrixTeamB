package com.lab.examen.app;

import com.lab.examen.transactional.AppExamenController;

/**
 * Created by Kei on 21/05/2016.
 */
public class AppExamen {

    public static void main (String[] args){

        AppExamenController.load();
        AppExamenController.home();

    }
}
