package com.lab.restaurant.transactional;

import com.lab.restaurant.model.Mesa;
import com.lab.restaurant.model.Mesero;

import java.util.Scanner;

/**
 * Created by Kei on 16/05/2016.
 */
public class MeseroController {

    public static void registrar() {

        String nombre;
        String apellidoPaterno;
        String apellidoMaterno;
        String numeroDocumento;

        Scanner in = new Scanner(System.in);

        //FALTAN VALIDACIONES (POR EJEMPLO VERIFICAR QUE SE INGRESEN SÓLO NUMEROS Y NO LETRAS)
        System.out.print("Ingresar el numero de documento del mesero: ");
        numeroDocumento = in.nextLine();

        while (existeMesero(numeroDocumento)) { //VALIDACION BÁSICA
            System.out.println("\nEse número de documento ya existe!\n");
            System.out.print("Ingresar el numero de documento del mesero: ");
            numeroDocumento = in.nextLine();
        }

        System.out.print("\nIngresar nombre: ");
        nombre = in.nextLine();

        System.out.print("\nIngresar apellido paterno: ");
        apellidoPaterno = in.nextLine();

        System.out.print("\nIngresar apellido materno: ");
        apellidoMaterno = in.nextLine();

        int idMesero = obtenerIdMesero();
        AppRestauranteBD.getListaMeseros().add(new Mesero(idMesero, numeroDocumento, nombre, apellidoPaterno, apellidoMaterno));

        System.out.println("\nMesero registrado correctamente!\n");

    }

//    public static void editar(){
//
//    }
//
//    public static void eliminar(){
//
//    }

    public static void listar() {
        int contador = 0;
        if (AppRestauranteBD.getListaMeseros().size() > 0)
            for (Mesero mesero : AppRestauranteBD.getListaMeseros()) {
                contador++;
                System.out.println("(" + contador + ")Mesero: " + mesero.getApellidoPaterno() + " " + mesero.getApellidoMaterno() + ", " + mesero.getNombre());
                System.out.println("Nro de Documento: " + mesero.getNumDocumento());
                if (mesero.getListaMesas().size() > 0) {
                    System.out.print("Atendiendo a las mesas:");
                    for (Mesa mesa : mesero.getListaMesas()) {
                        System.out.print(" " + mesa.getNumMesa());
                    }
                }
                System.out.println();
            }
        else
            System.out.println("\nNo hay meseros registrados!\n");
    }

    private static int obtenerIdMesero() {

        int cantidadMeseros = AppRestauranteBD.getListaMeseros().size();

        if (cantidadMeseros == 0) {
            return 1;
        } else {
            int idMesero = cantidadMeseros++;
            return idMesero;
        }
    }

    private static boolean existeMesero(String numeroDocumento) {

        if (AppRestauranteBD.getListaMeseros().size() > 0) {
            for (Mesero mesero : AppRestauranteBD.getListaMeseros())
                if (mesero.getNumDocumento().equalsIgnoreCase(numeroDocumento)) {
                    return true;
                }
        }

        return false;
    }
}
