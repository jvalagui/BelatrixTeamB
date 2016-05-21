package com.lab.restaurant.transactional.dao;
import com.lab.restaurant.model.Bebida;
import java.util.List;

/**
 * Created by Braulio Trigueros on 12/05/2016.
 */
public interface DaoBebida {
    public List <Bebida> consultar();
    public String insertar(Bebida bebida);
    public String eliminar(String id);
    public Bebida obtenerBebida(Integer idBebida);
    public String actualizar(Bebida bebida);
}
