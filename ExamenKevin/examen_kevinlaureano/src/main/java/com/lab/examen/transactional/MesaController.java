package main.java.com.lab.examen.transactional;
import main.java.com.lab.examen.model.Mesa;

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
        nuevoNumMesa = in.nextInt();}

    public static void listar() {
        if (AppExamenBD.getListaMesas().size() > 0) {
            for (Mesa mesa : AppExamenBD.getListaMesas()) {
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







}
