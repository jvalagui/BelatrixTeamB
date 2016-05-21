package main.java.com.lab.examen.transactional;

import main.java.com.lab.examen.model.Cliente;
import main.java.com.lab.examen.model.Visita;

import java.util.Scanner;

/**
 * Created by Kei on 18/05/2016.
 */
public class VisitaController {

    public static Visita registrar(Cliente cliente){

        Scanner in = new Scanner(System.in);
        int numeroAcompanantes;
        int idVisita;

        System.out.println("\nRESTAURANTE BELATRIX - Registrar nueva visita\n");
        System.out.print("Ingresar el numero de acompanantes del cliente: ");
        numeroAcompanantes = in.nextInt();

        idVisita = obtenerIdVisita();

        Visita visita = new Visita(idVisita,cliente,numeroAcompanantes);

        return visita;
    }

    private static int obtenerIdVisita(){

        int cantidadVisitas = AppExamenBD.getListaVisita().size();

        if(cantidadVisitas == 0){
            return 1;
        }
        else{
            int idVisita = cantidadVisitas++;
            return idVisita;
        }
    }


}
