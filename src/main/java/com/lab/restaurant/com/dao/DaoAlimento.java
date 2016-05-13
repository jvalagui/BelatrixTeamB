package com.lab.restaurant.com.dao;
import com.lab.restaurant.model.Alimento;
import java.util.List;

/**
 * Created by Braulio Trigueros on 12/05/2016.
 */
public interface DaoAlimento {
    public List <Alimento> consultar();
    public String insertar(Alimento alimento);
    public String eliminar(String ids);
    public Alimento obtenerAlimento(Integer idalimeto);
    public String actualizar(Alimento alimento);
}
