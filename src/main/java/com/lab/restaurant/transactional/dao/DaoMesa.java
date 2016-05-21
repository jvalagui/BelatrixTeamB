package com.lab.restaurant.transactional.dao;
import com.lab.restaurant.model.Mesa;

import java.util.List;
/**
 * Created by Braulio Trigueros on 12/05/2016.
 */

public interface DaoMesa {
    public List <Mesa> listar();
    public String insertar(Mesa mesa);
    public String actualizar(Mesa mesa);
    public String eliminar(String id);
    public Mesa obtenerMesa(Integer idMesa);
}
