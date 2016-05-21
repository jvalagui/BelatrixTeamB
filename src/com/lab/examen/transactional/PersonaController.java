package com.lab.examen.transactional;

import com.lab.examen.model.Persona;

import java.util.Scanner;

/**
 * Created by Braulio on 21/05/2016.
 */
public class PersonaController {

    public static Persona registrar(){

        String nombre;
        String apellidoPaterno;
        String apellidoMaterno;
        String tipoDocumento;
        String numeroDocumento;
        String numeroTelefono;
        String operador;
        String correoElectronico;

        Scanner in = new Scanner(System.in);

        //FALTAN VALIDACIONES (POR EJEMPLO VERIFICAR QUE SE INGRESEN SÓLO NUMEROS Y NO LETRAS)

        System.out.println("\nApp Examen - Registrar nueva Persona\n");
        System.out.print("Ingresar el numero de documento de la persona: ");
        numeroDocumento = in.nextLine();

        while (existePersona(numeroDocumento)) { //VALIDACION BÁSICA
            System.out.println("\nEse número de documento ya existe!");
            System.out.print("Ingresar el numero de documento de la persona: ");
            numeroDocumento = in.nextLine();
        }

        System.out.print("\nIngresar nombre: ");
        nombre = in.nextLine();

        System.out.print("Ingresar apellido paterno: ");
        apellidoPaterno = in.nextLine();

        System.out.print("Ingresar apellido materno: ");
        apellidoMaterno = in.nextLine();

        System.out.print("Ingresar tipo de Documento: ");
        tipoDocumento = in.nextLine();

        System.out.print("Ingresar numero de teléfono: ");
        numeroTelefono = in.nextLine();

        System.out.print("Ingresar operador: ");
        operador = in.nextLine();

        System.out.print("Ingresar correo electrónico: ");
        correoElectronico = in.nextLine();

        int idPersona = obtenerIdPersona();
        Persona persona = new Persona(idPersona,numeroDocumento, nombre, apellidoPaterno, apellidoMaterno,tipoDocumento, numeroTelefono,
                operador, correoElectronico);

        AppExamenBD.getListaPersona().add(persona);
        System.out.println("\nLa persona ha sido registrada correctamente!");

        return persona;
    }

    public static Persona buscar(String numeroDocumento){

        Persona persona = null;

        if (AppExamenBD.getListaPersona().size() > 0){
            for (Persona auxPersona : AppExamenBD.getListaPersona()){
                if (auxPersona.getNumeroDocumento().equalsIgnoreCase(numeroDocumento)){
                    persona = auxPersona;
                    break;
                }
            }
        }
        return persona;
    }

    private static int obtenerIdPersona(){

        int cantidadPersona = AppExamenBD.getListaPersona().size();

        if(cantidadPersona == 0){
            return 1;
        }
        else{
            int idPersona = cantidadPersona++;
            return idPersona;
        }
    }

    private static boolean existePersona(String numeroDocumento){

        if (AppExamenBD.getListaPersona().size() > 0){
            for (Persona persona : AppExamenBD.getListaPersona())
                if (persona.getNumeroDocumento().equalsIgnoreCase(numeroDocumento)){
                    return true;
                }
        }
        return false;
    }
}
