package com.lab.examen.transactional;

import com.lab.examen.model.Organizacion;
import com.lab.examen.model.Persona;
import com.lab.examen.utils.Helper;

import java.util.*;


/**
 * Created by Braulio on 21/05/2016.
 */
public class AppExamenController {

    private static Queue<Organizacion> listaPersona = new LinkedList<Organizacion>();

    public static void menuPrincipal() {
        int opcion;
        Scanner in = new Scanner(System.in);

        System.out.println("\nApp Examen - Menú Principal\n");
        System.out.println("\t(1)Ingreso de Personas");
        System.out.println("\t(2)Opciones");
        System.out.println("\t(3)Salir\n");
        System.out.print("Ingrese una opción: ");
        opcion = in.nextInt();

        while (opcion > 3 || opcion < 1) { //si escoge una opcion inválida
            System.out.println("\nOpción no válida!");

            System.out.println("\nApp Examen - Menú Principal\n");
            System.out.println("\t(1)Ingreso de Personas");
            System.out.println("\t(3)Salir\n");
            System.out.print("Ingrese una opción: ");
            opcion = in.nextInt();
        }

        switch (opcion) {
            case 1:
                menuRegistrar();
                break;
            default:
                break;
        }
    }

    private static void menuRegistrar() {
        int opcion;
        String numeroDocumento;
        Organizacion nuevoRegistro;
        int cantidadColaEspera = listaPersona.size();
        Scanner in = new Scanner(System.in);

        System.out.println("\nApp Examen- Menú Atención\n");
        System.out.println("\t(1)Registrar Persona");
        System.out.println("\t(2)Buscar Persona");
        System.out.println("\t(3)Ver lista de Personas");
        System.out.println("\t(4)Finalizar atencion");
        System.out.println("\t(5)Regresar al menú principal\n");
        System.out.print("Ingrese una opción: ");
        opcion = in.nextInt();
        in.nextLine();

        while (opcion > 5 || opcion < 1) { //si escoge una opcion inválida
            System.out.println("\nOpción no válida!");

            System.out.println("\nApp Examen - Menú Mesas\n");
            System.out.println("\t(1)Registrar Persona");
            System.out.println("\t(2)Buscar Persona");
            System.out.println("\t(3)Ver lista de Personas");
            System.out.println("\t(4)Finalizar atencion");
            System.out.println("\t(5)Regresar al menú principal\n");
            System.out.print("Ingrese una opción: ");
            opcion = in.nextInt();
            in.nextLine();
        }

        switch (opcion) {
            case 1:
                Persona nuevaPersona = PersonaController.registrar();
                nuevoRegistro = OrganizacionController.registrar(nuevaPersona);
                listaPersona.offer(nuevoRegistro);
                System.out.println("\nLa persona se registrará a continuación....");
                Helper.pausa();
                menuRegistrar();
                break;
            case 2:
                System.out.println("\nApp Examen - Buscar Persona\n");
                System.out.print("Ingrese el numero de documento: ");
                numeroDocumento = in.nextLine();
                Persona persona = PersonaController.buscar(numeroDocumento);

                if(persona == null){
                    System.out.println("\nLa persona no ha sido encontrada");
                    Helper.pausa();
                }
                else{
                    System.out.println("\nLa persona ha sido encontrada:");
                    System.out.println("\n" + persona.getApellidoPaterno() +" " + persona.getApellidoMaterno() +
                            ", " + persona.getNombre()+", Nativo de: "+persona.getNombrePais()+", #Telefónico: "+
                            persona.getNumeroTelefono()+", del Operador: "+persona.getOperador()+", con el e-mail:"
                            +persona.getCorreoElectronicos());
                }
                break;
            default:
                break;
        }
    }
}
