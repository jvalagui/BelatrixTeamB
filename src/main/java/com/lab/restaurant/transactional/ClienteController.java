package com.lab.restaurant.transactional;

import com.lab.restaurant.model.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Kei on 16/05/2016.
 */
public class ClienteController {

    public static void registrar(){

        String nombre;
        String apellidoPaterno;
        String apellidoMaterno;
        String numeroDocumento;

        Scanner in = new Scanner(System.in);

        //FALTAN VALIDACIONES (POR EJEMPLO VERIFICAR QUE SE INGRESEN SÓLO NUMEROS Y NO LETRAS)

        System.out.println("\nRESTAURANTE BELATRIX - Registrar nuevo mesero\n");
        System.out.print("Ingresar el numero de documento del cliente: ");
        numeroDocumento = in.nextLine();

        while (exiseCliente(numeroDocumento)) { //VALIDACION BÁSICA
            System.out.println("\nEse número de documento ya existe!");
            System.out.print("Ingresar el numero de documento del cliente: ");
            numeroDocumento = in.nextLine();
        }

        System.out.print("\nIngresar nombre: ");
        nombre = in.nextLine();

        System.out.print("\nIngresar apellido paterno: ");
        apellidoPaterno = in.nextLine();

        System.out.print("\nIngresar apellido materno: ");
        apellidoMaterno = in.nextLine();

        int idCliente = obtenerIdCliente();
        AppRestauranteBD.getListaCliente().add(new Cliente(idCliente,numeroDocumento,nombre,apellidoPaterno,apellidoMaterno));

        System.out.println("\nCliente registrado correctamente!");
    }

//    public static void editar(){
//
//    }
//
//    public static void eliminar(){
//
//    }

    private static int obtenerIdCliente(){

        int cantidadClientes = AppRestauranteBD.getListaCliente().size();

        if(cantidadClientes == 0){
            return 1;
        }
        else{
            int idCliente = cantidadClientes++;
            return idCliente;
        }
    }

    private static boolean exiseCliente(String numeroDocumento){

        if (AppRestauranteBD.getListaCliente().size() > 0){
            for (Cliente cliente : AppRestauranteBD.getListaCliente())
                if (cliente.getNumDocumento().equalsIgnoreCase(numeroDocumento)){
                    return true;
                }
        }

        return false;
    }
}
