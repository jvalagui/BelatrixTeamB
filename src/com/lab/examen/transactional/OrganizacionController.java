package com.lab.examen.transactional;

import com.lab.examen.model.Persona;
import com.lab.examen.model.Organizacion;

import java.util.Scanner;

/**
 * Created by Kei on 18/05/2016.
 */
public class OrganizacionController {

    public static Organizacion registrar(Persona persona){

        Scanner in = new Scanner(System.in);
        int idVisita;

        System.out.println("\nApp Examen - Registrar nueva consulta\n");

        idVisita = obtenerIdVisita();

        Organizacion organizacion = new Organizacion(idVisita,persona);
        AppExamenBD.getListaOrganizacion().add(organizacion);

        return organizacion;
    }

    private static int obtenerIdVisita(){

        int cantidadVisitas = AppExamenBD.getListaOrganizacion().size();

        if(cantidadVisitas == 0){
            return 1;
        }
        else{
            int idVisita = cantidadVisitas++;
            return idVisita;
        }
    }

}
