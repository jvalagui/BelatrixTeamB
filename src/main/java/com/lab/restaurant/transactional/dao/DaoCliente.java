package com.lab.restaurant.transactional.dao;

import com.lab.restaurant.model.Cliente;
import java.util.List;

/**
 * Created by Braulio Trigueros on 12/05/2016.
 */
public interface DaoCliente {
    public List <Cliente> consultar();
    public String insertar(Cliente cliente);
    public String eliminar(String id);
    public Cliente obtenerCliente(Integer idCliente);
    public String actualizar(Cliente cliente);
}
