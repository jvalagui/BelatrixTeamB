package main.java.com.lab.examen.transactional.dao;

import main.java.com.lab.examen.model.Cliente;
import java.util.List;

/**
 * Created by Braulio Trigueros on 12/05/2016.
 */
public interface DaoCliente {
    public List <Cliente> consultar();
    public String insertar(Cliente cliente);
    public String eliminar(String ids);
    public Cliente obtenerCliente(Integer idcliente);
    public String actualizar(Cliente cliente);
}
