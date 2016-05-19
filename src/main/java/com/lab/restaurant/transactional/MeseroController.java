package com.lab.restaurant.transactional;

import com.lab.restaurant.model.Mesero;

import java.util.Scanner;

/**
 * Created by Kei on 16/05/2016.
 */
public class MeseroController {

    public static void registrar(){

        String nombre;
        String apellidoPaterno;
        String apellidoMaterno;
        String numeroDocumento;

        Scanner in = new Scanner(System.in);

        //FALTAN VALIDACIONES (POR EJEMPLO VERIFICAR QUE SE INGRESEN SÓLO NUMEROS Y NO LETRAS)

        System.out.println("\nRESTAURANTE BELATRIX - Registrar nuevo mesero\n");
        System.out.print("Ingresar el numero de documento del mesero: ");
        numeroDocumento = in.nextLine();

        while (existeMesero(numeroDocumento)) { //VALIDACION BÁSICA
            System.out.println("\nEse número de documento ya existe!");
            System.out.print("Ingresar el numero de documento del mesero: ");
            numeroDocumento = in.nextLine();
        }

        System.out.print("\nIngresar nombre: ");
        nombre = in.nextLine();

        System.out.print("\nIngresar apellido paterno: ");
        apellidoPaterno = in.nextLine();

        System.out.print("\nIngresar apellido materno: ");
        apellidoMaterno = in.nextLine();

        int id_mesero = obtenerIdMesero();
        AppRestauranteBD.getListaMeseros().add(new Mesero(id_mesero,numeroDocumento,nombre,apellidoPaterno,apellidoMaterno));

        System.out.println("\nMesero registrado correctamente!");

    }

//    public static void editar(){
//
//    }
//
//    public static void eliminar(){
//
//    }

    private static int obtenerIdMesero(){

        int cantidadMeseros = AppRestauranteBD.getListaMeseros().size();

        if(cantidadMeseros == 0){
            return 1;
        }
        else{
            int id_mesero = cantidadMeseros++;
            return id_mesero;
        }
    }

    private static boolean existeMesero(String numeroDocumento){

        if (AppRestauranteBD.getListaMeseros().size() > 0){
            for (Mesero mesero : AppRestauranteBD.getListaMeseros())
                if (mesero.getNumDocumento().equalsIgnoreCase(numeroDocumento)){
                    return true;
                }
        }

        return false;
    }
}
