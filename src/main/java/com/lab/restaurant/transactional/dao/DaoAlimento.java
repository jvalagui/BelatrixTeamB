package com.lab.restaurant.transactional.dao;
import com.lab.restaurant.model.Alimento;
import java.util.List;

/**
 * Created by Braulio Trigueros on 12/05/2016.
 */
public interface DaoAlimento {
    public List <Alimento> consultar();
    public String insertar(Alimento alimento);
    public String eliminar(String id);
    public Alimento obtenerAlimento(Integer idAlimeto);
    public String actualizar(Alimento alimento);
}
