package main.java.com.lab.examen.transactional.dao;
import main.java.com.lab.examen.model.Mesa;

import java.util.List;
/**
 * Created by Braulio Trigueros on 12/05/2016.
 */

public interface DaoMesa {
    public List <Mesa> listar();
    public String registrar(Mesa mesa);
    public String actualizar(Mesa mesa);
    public String eliminar(String ids);
    public Mesa obtenerMesa(Integer idMesa);
}
