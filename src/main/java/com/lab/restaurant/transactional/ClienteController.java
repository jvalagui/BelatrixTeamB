package com.lab.restaurant.transactional;

import com.lab.restaurant.model.Cliente;

import java.util.ArrayList;

/**
 * Created by Kei on 16/05/2016.
 */
public class ClienteController {

    public static void agregar(Cliente cliente){

        int ultimoId = AppRestauranteBD.getListaCliente().size();

        cliente.setId(ultimoId++);
        AppRestauranteBD.getListaCliente().add(cliente);

    }
}
