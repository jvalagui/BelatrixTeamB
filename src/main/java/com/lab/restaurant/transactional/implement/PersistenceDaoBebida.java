package com.lab.restaurant.transactional.implement;

import com.lab.restaurant.model.Bebida;
import com.lab.restaurant.transactional.dao.DaoBebida;

import java.util.List;

/**
 * Created by Braulio Trigueros on 20/05/2016.
 */
public class PersistenceDaoBebida implements DaoBebida {
    @Override
    public List<Bebida> consultar() {
        return null;
    }

    @Override
    public String insertar(Bebida bebida) {
        return null;
    }

    @Override
    public String eliminar(String ids) {
        return null;
    }

    @Override
    public Bebida obtenerBebida(Integer idbebida) {
        return null;
    }

    @Override
    public String actualizar(Bebida bebida) {
        return null;
    }
}
