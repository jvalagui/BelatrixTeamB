package com.lab.restaurant.transactional.implement;

import com.lab.restaurant.model.Mesa;
import com.lab.restaurant.transactional.dao.DaoMesa;

import java.util.List;

/**
 * Created by Braulio Trigueros on 20/05/2016.
 */
public class PersistenceDaoMesa implements DaoMesa {
    @Override
    public List<Mesa> listar() {
        return null;
    }

    @Override
    public String registrar(Mesa mesa) {
        return null;
    }

    @Override
    public String actualizar(Mesa mesa) {
        return null;
    }

    @Override
    public String eliminar(String ids) {
        return null;
    }

    @Override
    public Mesa obtenerMesa(Integer idMesa) {
        return null;
    }
}
