package com.lab.restaurant.transactional;

import com.lab.restaurant.app.AppRestaurant;
import com.lab.restaurant.model.Mesa;
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
        System.out.print("Ingresar nuevo numero de mesa: ");
        nuevoNumMesa = in.nextInt();

        while (existeMesa(nuevoNumMesa)) { //VALIDACION BÁSICA
            System.out.println("\nEse número de mesa ya existe!");
            System.out.print("Ingresar nuevo numero de mesa: ");
            nuevoNumMesa = in.nextInt();
        }

        in.nextLine();
        System.out.print("Ingresar capacidad: ");
        nuevaCapacidad = in.nextInt();
        in.nextLine();

        while(nuevaCapacidad<=0){
            System.out.println("\nDebe ingresar una capacidad mayor a cero!");
            System.out.print("Ingresar capacidad: ");
            nuevaCapacidad = in.nextInt();
        }

        int nuevoIdMesa = obtenerIdMesa();
        AppRestauranteBD.getListaMesas().add(new Mesa(nuevoIdMesa,nuevoNumMesa,nuevaCapacidad));

        System.out.println("\nMesa registrada correctamente!");
    }

//    public static void editar(int numeroMesa){
//
//    }

//    public static void eliminar(int numeroMesa){
//
//    }

    public static void listar() {
        System.out.println("\nRESTAURANTE BELATRIX - Listado de mesas\n");
        if (AppRestauranteBD.getListaMesas().size() > 0)
            for (Mesa mesa : AppRestauranteBD.getListaMesas()) {
                System.out.print("Mesa " + mesa.getNumMesa() + ": " + "capacidad(" + mesa.getCapacidad() + ") - mesero a cargo(");
                if (mesa.getMesero() != null)
                    System.out.println("" + mesa.getMesero().getNombre() + ") - estado(" + mesa.getEstado() + ")");
                else
                    System.out.println("sin asignar) - estado(" + mesa.getEstado() + ")");
            }
        else
            System.out.println("\nNo hay mesas registradas!\n");
    }

    private static int obtenerIdMesa(){

        int cantidadMesas = AppRestauranteBD.getListaMesas().size();

        if(cantidadMesas == 0){
            return 1;
        }
        else{
            int idMesa = cantidadMesas++;
            return idMesa;
        }
    }

    private static boolean existeMesa(int numMesa) {

        if (AppRestauranteBD.getListaMesas().size() > 0)
            for (Mesa mesa : AppRestauranteBD.getListaMesas())
                if (mesa.getNumMesa() == numMesa){
                    return true;
                }

        return false;
    }

}
