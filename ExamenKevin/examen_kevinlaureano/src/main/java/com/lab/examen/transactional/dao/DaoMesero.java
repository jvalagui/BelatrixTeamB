package main.java.com.lab.examen.transactional.dao;
import main.java.com.lab.examen.model.Mesero;

import java.util.List;

/**
 * Created by Braulio Trigueros on 12/05/2016.
 */
public interface DaoMesero {
    public List <Mesero> consultar();
    public String insertar(Mesero mesero);
    public String eliminar(String ids);
    public Mesero obtenerMesero(Integer idmesero);
    public String actualizar(Mesero mesero);
}
