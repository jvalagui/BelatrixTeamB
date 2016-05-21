package com.lab.restaurant.transactional.cruds;

import com.lab.restaurant.model.Alimento;
import com.lab.restaurant.transactional.dao.DaoAlimento;
import com.lab.restaurant.transactional.implement.PersistenceDaoAlimento;

import java.util.List;
/**
 * Created by Braulio Trigueros on 20/05/2016.
 */
public class AlimentoCrud {

    String accion = request.getParameter("accion");
    String resultado = null;
    String target = null;
    // ---
    DaoAlimento daoAlimento = new PersistenceDaoAlimento();
    if (accion == null) {
        resultado = "Solicitud no recibida";
    } else if (accion.equals("QRY")) {
        List<Alimento> lista = daoAlimento.consultar();
        if (lista!= null) {
            request.getSession().setAttribute("list", lista);
            //target = " ";
        } else {
            resultado = "Problemas en Consulta";
        }
    } else if (accion.equals("INS")) {
        Alimento alimento = new Alimento();
        resultado = valida(alimento, request);

        if (resultado == null) {
            resultado = daoAlimento.insertar(alimento);
        }

        if (resultado == null) {
            List<Alimento> lista = daoAlimento.consultar();
            request.getSession().setAttribute("list", lista);
            //target = " ";
        }

    } else if (accion.equals("DEL")) {
        String id = request.getParameter("id");
        resultado = daoAlimento.eliminar(id);

        if (resultado == null){
            List<Alimento> lista = daoAlimento.consultar();
            request.getSession().setAttribute("list", lista);
            //target = " ";
        }

    } else if (accion.equals("GET")) {
        String id = request.getParameter("id");
        Alimento alimento = daoAlimento.obtenerAlimento(Integer.valueOf(id));
        if (mesero != null) {
            request.getSession().setAttribute("alimento", alimento);
            //target = " ";
        } else {
            resultado = "Problemas en obtener datos del Alimento";
        }

    } else if (accion.equals("UPD")) {
        Alimento alimento = new Alimento();
        resultado = valida(alimento, request);

        if (resultado == null) {
            resultado = daoAlimento.actualizar(alimento);
        }

        if (resultado == null) {
            List<Alimento> lista = daoAlimento.consultar();
            request.getSession().setAttribute("list", lista);
            //target = " ";
        }
    }
    else {
        resultado = "Solicitud no reconocida";
    }
    if (resultado != null) {
        request.getSession().setAttribute("msg", resultado);
        //target = " ";
    }
    if (target != null) {
        response.sendRedirect(target);
    }
}

    private String valida(Alimento alimento) {

        String mensaje;

        Integer idAlimento = request.getParameter("idAlimento");
        Double precio = request.getParameter("precio");
        String tipo = request.getParameter("tipo");

        // encapsula si todo OK
        if (mensaje == null) {
            if (idAlimento == null) { // null para INS
                alimento.setId(null);
            } else {
                alimento.setId(Integer.valueOf(idAlimento));
            }

            alimento.setPrecio(precio);
            alimento.setTipoAlimento(tipo);
        }
        return mensaje;
    }
}
