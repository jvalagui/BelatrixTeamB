package com.lab.restaurant.transactional.cruds;
import com.lab.restaurant.model.Bebida;
import com.lab.restaurant.transactional.dao.DaoBebida;
import com.lab.restaurant.transactional.implement.PersistenceDaoBebida ;

import java.util.List;

/**
 * Created by Braulio Trigueros on 20/05/2016.
 */
public class BebidaCrud {

    String accion = request.getParameter("accion");
    String resultado = null;
    String target = null;
    // ---
    DaoBebida daoBebida = new PersistenceDaoBebida();
    if (accion == null) {
        resultado = "Solicitud no recibida";
    } else if (accion.equals("QRY")) {
        List<Bebida> lista = daoBebida.consultar();
        if (lista!= null) {
            request.getSession().setAttribute("list", lista);
            //target = " ";
        } else {
            resultado = "Problemas en Consulta";
        }
    } else if (accion.equals("INS")) {
        Bebida bebida = new Bebida();
        resultado = valida(bebida, request);

        if (resultado == null) {
            resultado = daoBebida.insertar(bebida);
        }

        if (resultado == null) {
            List<Bebida> lista = daoBebida.consultar();
            request.getSession().setAttribute("list", lista);
            //target = " ";
        }

    } else if (accion.equals("DEL")) {
        String id = request.getParameter("id");
        resultado = daoBebida.eliminar(id);

        if (resultado == null){
            List<Bebida> lista = daoBebida.consultar();
            request.getSession().setAttribute("list", lista);
            //target = " ";
        }

    } else if (accion.equals("GET")) {
        String id = request.getParameter("id");
        Bebida bebida = daoBebida.obtenerBebida(Integer.valueOf(id));
        if (mesero != null) {
            request.getSession().setAttribute("bebida", bebida);
            //target = " ";
        } else {
            resultado = "Problemas en obtener datos de la Bebida";
        }

    } else if (accion.equals("UPD")) {
        Bebida bebida = new Bebida();
        resultado = valida(bebida, request);

        if (resultado == null) {
            resultado = daoBebida.actualizar(bebida);
        }

        if (resultado == null) {
            List<Bebida> lista = daoBebida.consultar();
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

    private String valida(Bebida bebida) {

        String mensaje;

        Integer idBebida = request.getParameter("idBebida");
        Double precio = request.getParameter("precio");
        String tipo = request.getParameter("tipo");

        // encapsula si todo OK
        if (mensaje == null) {
            if (idBebida == null) { // null para INS
                bebida.setId(null);
            } else {
                bebida.setId(Integer.valueOf(idBebida));
            }

            bebida.setPrecio(precio);
            bebida.setTipoBebida(tipo);
        }

        return mensaje;
    }
}
