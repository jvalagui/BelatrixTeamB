package com.lab.restaurant.transactional;

import com.lab.restaurant.app.AppRestaurant;
import com.lab.restaurant.model.Mesa;
import com.lab.restaurant.model.Mesero;
import com.lab.restaurant.transactional.dao.DaoMesa;

import java.util.Scanner;

/**
 * Created by Kei on 16/05/2016.
 */
public class MesaController {

    public static void registrar() {

        int nuevoNumMesa;
        int nuevaCapacidad;
        Scanner in = new Scanner(System.in);

        //FALTAN VALIDACIONES (POR EJEMPLO VERIFICAR QUE SE INGRESEN SÓLO NUMEROS Y NO LETRAS)

        System.out.println("\nRESTAURANTE BELATRIX - Registrar nueva mesa\n");
        System.out.print("Ingresar nuevo número de mesa: ");
        nuevoNumMesa = in.nextInt();

        while (existeMesa(nuevoNumMesa)) { //VALIDACION BÁSICA
            System.out.println("\nEse número de mesa ya existe!\n");
            System.out.print("Ingresar nuevo número de mesa: ");
            nuevoNumMesa = in.nextInt();
        }

        in.nextLine();
        System.out.print("\nIngresar capacidad: ");
        nuevaCapacidad = in.nextInt();
        in.nextLine();

        while (nuevaCapacidad <= 0) {
            System.out.println("\nDebe ingresar una capacidad mayor a cero!");
            System.out.print("Ingresar capacidad: ");
            nuevaCapacidad = in.nextInt();
        }

        int nuevoIdMesa = obtenerIdMesa();
        AppRestauranteBD.getListaMesas().add(new Mesa(nuevoIdMesa, nuevoNumMesa, nuevaCapacidad));

        System.out.println("\nMesa registrada correctamente!\n");
    }

//    public static void editar(int numeroMesa){
//
//    }

//    public static void eliminar(int numeroMesa){
//
//    }

    public static void listar() {
        if (AppRestauranteBD.getListaMesas().size() > 0) {
            for (Mesa mesa : AppRestauranteBD.getListaMesas()) {
                System.out.print("Mesa " + mesa.getNumMesa() + ": " + "capacidad(" + mesa.getCapacidad() + ") - mesero a cargo(");
                if (mesa.getMesero() != null)
                    System.out.println("" + mesa.getMesero().getNombre() + ") - estado(" + mesa.getEstado() + ")");
                else
                    System.out.println("sin asignar) - estado(" + mesa.getEstado() + ")");
            }
            System.out.println("");
        } else
            System.out.println("No hay mesas registradas!\n");
    }

    public static void asignarMesa() {
        if (AppRestauranteBD.getListaMesas().size() > 0) {
            int numeroMesa;
            int numeroMesero;
            Scanner in = new Scanner(System.in);

            listar();
            System.out.print("Ingresar numero de mesa a asignar: ");
            numeroMesa = in.nextInt();

            while (verificaAsignacion(numeroMesa)) { //VALIDACION BÁSICA
                System.out.println("\nEsa mesa ya está asignada!\n");
                listar();
                System.out.print("Ingresar número de mesa: ");
                numeroMesa = in.nextInt();
            }

            System.out.println("");

            if (AppRestauranteBD.getListaMeseros().size() > 0) {

                MeseroController.listar();
                System.out.print("Ingresar numero del mesero: ");
                numeroMesero = in.nextInt();

                while (numeroMesero <= 0 || numeroMesero > AppRestauranteBD.getListaMeseros().size()) {
                    System.out.println("\nNo existe ese mesero!\n");
                    MeseroController.listar();
                    System.out.print("Ingresar numero del mesero: ");
                    numeroMesero = in.nextInt();
                }

                Mesa mesa = AppRestauranteBD.getListaMesas().get(obtenIndiceMesa(numeroMesa));
                //Mesero mesero = AppRestauranteBD.getListaMeseros().get(numeroMesero - 1);
                //2AppRestauranteBD.getListaMesas().get(obtenIndiceMesa(numeroMesa)).setMesero(mesero);
                AppRestauranteBD.getListaMeseros().get(numeroMesero - 1).anadirMesa(mesa);

                System.out.println("\nMesa asignada correctamente!\n");
            } else
                System.out.println("No hay meseros registrados!\n");

        } else
            System.out.println("No hay mesas registradas!\n");

    }

    private static int obtenIndiceMesa(int numeroMesa) {
        //se asume que para invocar esta funcion la lista de mesas siempre tendrá al menos un elemento
        int i = 0;
        while (i < AppRestauranteBD.getListaMesas().size()) {
            if (AppRestauranteBD.getListaMesas().get(i).getNumMesa() == numeroMesa)
                break;
        }
        return i;
    }

    private static boolean verificaAsignacion(int numMesa) {

        if (AppRestauranteBD.getListaMesas().size() > 0)
            for (Mesa mesa : AppRestauranteBD.getListaMesas())
                if (mesa.getNumMesa() == numMesa && mesa.getMesero() != null) //si ya está asignada
                    return true;

        return false;
    }

    private static int obtenerIdMesa() {

        int cantidadMesas = AppRestauranteBD.getListaMesas().size();

        if (cantidadMesas == 0) {
            return 1;
        } else {
            int idMesa = cantidadMesas++;
            return idMesa;
        }
    }

    private static boolean existeMesa(int numMesa) {

        if (AppRestauranteBD.getListaMesas().size() > 0)
            for (Mesa mesa : AppRestauranteBD.getListaMesas())
                if (mesa.getNumMesa() == numMesa) {
                    return true;
                }

        return false;
    }

}
