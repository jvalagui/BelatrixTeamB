package com.lab.restaurant.transactional.implement;

import com.lab.restaurant.model.Alimento;
import com.lab.restaurant.transactional.dao.DaoAlimento;

import java.util.List;

/**
 * Created by Braulio Trigueros on 20/05/2016.
 */
public class PersistenceDaoAlimento implements DaoAlimento {
    @Override
    public List<Alimento> consultar() {
        return null;
    }

    @Override
    public String insertar(Alimento alimento) {
        return null;
    }

    @Override
    public String eliminar(String ids) {
        return null;
    }

    @Override
    public Alimento obtenerAlimento(Integer idalimeto) {
        return null;
    }

    @Override
    public String actualizar(Alimento alimento) {
        return null;
    }
}
