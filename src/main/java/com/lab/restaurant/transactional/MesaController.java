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

    public static void asignarMesero() {
        if (AppRestauranteBD.getListaMesas().size() > 0) {
            int numeroMesa;
            int numeroMesero;
            Mesa mesaActual;
            Scanner in = new Scanner(System.in);

            listar();
            System.out.print("Ingresar numero de mesa a asignar: ");
            numeroMesa = in.nextInt();
            mesaActual = verificaAsignacion(numeroMesa);

            while (mesaActual == null) { //VALIDACION BÁSICA
                System.out.println("\nEsa mesa ya está asignada!\n");
                listar();
                System.out.print("Ingresar número de mesa: ");
                numeroMesa = in.nextInt();
                mesaActual = verificaAsignacion(numeroMesa);
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
                AppRestauranteBD.getListaMeseros().get(numeroMesero - 1).anadirMesa(mesaActual);

                System.out.println("\nMesa asignada correctamente!\n");
            } else
                System.out.println("No hay meseros registrados!\n");

        } else
            System.out.println("No hay mesas registradas!\n");

    }

    public static void ocuparMesa(Mesa mesa){

        mesa.setEstado(2);

    }

    public static void desocuparMesa(Mesa mesa){

        mesa.setEstado(1);

    }

    private static int obtenIndiceMesa(int numeroMesa) {
        //se asume que para invocar esta funcion la lista de mesas siempre tendrá al menos un elemento
        int contador = AppRestauranteBD.getListaMesas().size();
        int indice = 0;

        for(int i = 0; i < contador; i++){
            if (AppRestauranteBD.getListaMesas().get(i).getNumMesa() == numeroMesa){
                indice = i;
                break;
            }
        }

        return indice;
    }

    private static Mesa verificaAsignacion(int numMesa) {

        Mesa mesa = null;

        if (AppRestauranteBD.getListaMesas().size() > 0)
            for (Mesa auxMesa : AppRestauranteBD.getListaMesas())
                if (auxMesa.getNumMesa() == numMesa && auxMesa.getMesero() == null){
                    mesa = auxMesa;
                    return mesa;
                }

        return mesa;
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
