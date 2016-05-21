package com.lab.examen.transactional;

import com.lab.examen.model.*;

import java.util.ArrayList;

/**
 * Created by Braulio on 21/05/2016.
 */
public class AppExamenBD {

    private static ArrayList<Persona> listaPersona = new ArrayList<Persona>();
    private static ArrayList<Pais> listaPais = new ArrayList<Pais>();
    private static ArrayList<TipoDocumento> tipoDocumento = new ArrayList<TipoDocumento>();
    private static ArrayList<Telefono> listaTelefono = new ArrayList<Telefono>();
    private static ArrayList<CorreosElectronicos> listaCorreosElectronicos = new ArrayList<CorreosElectronicos>();
    private static ArrayList<Organizacion> listaOrganizacion = new ArrayList<Organizacion>();

    public static ArrayList<Persona> getListaPersona() {
        return listaPersona;
    }

    public static void setListaPersona(ArrayList<Persona> listaPersona) {
        AppExamenBD.listaPersona = listaPersona;
    }

    public static ArrayList<Pais> getListaPais() {
        return listaPais;
    }

    public static void setListaPais(ArrayList<Pais> listaPais) {
        AppExamenBD.listaPais = listaPais;
    }

    public static ArrayList<TipoDocumento> getTipoDocumento() {
        return tipoDocumento;
    }

    public static void setTipoDocumento(ArrayList<TipoDocumento> tipoDocumento) {
        AppExamenBD.tipoDocumento = tipoDocumento;
    }

    public static ArrayList<Telefono> getListaTelefono() {
        return listaTelefono;
    }

    public static void setListaTelefono(ArrayList<Telefono> listaTelefono) {
        AppExamenBD.listaTelefono = listaTelefono;
    }

    public static ArrayList<CorreosElectronicos> getListaCorreosElectronicos() {
        return listaCorreosElectronicos;
    }

    public static void setListaCorreosElectronicos(ArrayList<CorreosElectronicos> listaCorreosElectronicos) {
        AppExamenBD.listaCorreosElectronicos = listaCorreosElectronicos;
    }

    public static ArrayList<Organizacion> getListaOrganizacion() {
        return listaOrganizacion;
    }

    public static void setListaOrganizacion(ArrayList<Organizacion> listaOrganizacion) {
        AppExamenBD.listaOrganizacion = listaOrganizacion;
    }
}
