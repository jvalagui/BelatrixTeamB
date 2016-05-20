package com.lab.restaurant.transactional.dao;
import com.lab.restaurant.model.Mesero;

import java.util.List;

/**
 * Created by Braulio Trigueros on 12/05/2016.
 */
public interface DaoMesero {
    public List <Mesero> consultar();
    public String insertar(Mesero mesero);
    public String eliminar(String id);
    public Mesero obtenerMesero(Integer idMesero);
    public String actualizar(Mesero mesero);
}
