package main.java.com.lab.examen.transactional;
import main.java.com.lab.examen.model.*;
import java.util.ArrayList;
//import main.java.util.ArrayList;
//import com.lab.restaurant.model.*;

//import java.util.ArrayList;

/**
 * Created by Kei on 16/05/2016.
 */
public class AppExamenBD {

    private static ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
    private static ArrayList<Mesa> listaMesas = new ArrayList<Mesa>();
    private static ArrayList<Mesero> listaMeseros = new ArrayList<Mesero>();

    private static ArrayList<Visita> listaVisita = new ArrayList<Visita>();

    public static ArrayList<Cliente> getListaCliente() {
        return listaCliente;
    }

    public static void setListaCliente(ArrayList<Cliente> listaCliente) {
        AppExamenBD.listaCliente = listaCliente;
    }

    public static ArrayList<Mesa> getListaMesas() {
        return listaMesas;
    }

    public static void setListaMesas(ArrayList<Mesa> listaMesas) {
        AppExamenBD.listaMesas = listaMesas;
    }

    public static ArrayList<Mesero> getListaMeseros() {
        return listaMeseros;
    }

    public static void setListaMeseros(ArrayList<Mesero> listaMeseros) {
        AppExamenBD.listaMeseros = listaMeseros;
    }





    public static ArrayList<Visita> getListaVisita() {
        return listaVisita;
    }

    public static void setListaVisita(ArrayList<Visita> listaVisita) {
        AppExamenBD.listaVisita = listaVisita;
    }
}
