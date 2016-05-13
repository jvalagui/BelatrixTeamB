package com.lab.restaurant.transactional.dao;
import com.lab.restaurant.model.Mesa;

import java.util.List;
/**
 * Created by Braulio Trigueros on 12/05/2016.
 */

public interface DaoMesa {
    public List <Mesa> consultar();
    public String insertar(Mesa mesa);
    public String eliminar(String ids);
    public Mesa obtenerMesa(Integer idmesa);
    public String actualizar(Mesa mesa);
}
