package com.lab.restaurant.transactional.cruds;

import com.lab.restaurant.model.Mesero;
import com.lab.restaurant.transactional.dao.DaoMesero;
import com.lab.restaurant.transactional.implement.PersistenceDaoMesero;

import java.util.List;

/**
 * Created by Braulio Trigueros on 20/05/2016.
 */

public class MeseroCrud {

    String accion = request.getParameter("accion");
    String resultado = null;
    String target = null;
    // ---
    DaoMesero daoMesero = new PersistenceDaoMesero();
    if(accion==null){
        resultado = "Solicitud no recibida";
    }

    else if(accion.equals("QRY")){
        List<Mesero> lista = daoMesero.consultar();
        if (lista != null) {
            request.getSession().setAttribute("list", lista);
            //target = " ";
        } else {
            resultado = "Problemas en Consulta";
        }
    }

    else if(accion.equals("INS")){
        Mesero mesero = new Mesero();
        resultado = valida(mesero, request);

        if (resultado == null) {
            resultado = daoMesero.insertar(mesero);
        }

        if (resultado == null) {
            List<Mesero> lista = daoMesero.consultar();
            request.getSession().setAttribute("list", lista);
            //target = " ";
        }
    }

    else if(accion.equals("DEL")){
        String id = request.getParameter("id");
        resultado = daoMesero.eliminar(id);

        if (resultado == null) {
            List<Mesero> lista = daoMesero.consultar();
            request.getSession().setAttribute("list", lista);
            //target = " ";
        }
    }

    else if(accion.equals("GET")){
        String id = request.getParameter("id");
        Mesero mesero = daoMesero.obtenerMesero(Integer.valueOf(id));
        if (mesero != null) {
            request.getSession().setAttribute("mesero", mesero);
            //target = " ";
        } else {
            resultado = "Problemas en obtener datos del Mesero";
        }
    }

    else if(accion.equals("UPD")){
        Mesero mesero = new Mesero();
        resultado = valida(mesero, request);

        if (resultado == null) {
            resultado = daoMesero.actualizar(mesero);
        }

        if (resultado == null) {
            List<Mesero> lista = daoMesero.consultar();
            request.getSession().setAttribute("list", lista);
            //target = " ";
        }
    }

    else{
        resultado = "Solicitud no reconocida";
    }

    if(resultado!=null){
        request.getSession().setAttribute("msg", resultado);
        //target = " ";
    }

    if(target!=null){
        response.sendRedirect(target);
    }

}


    private String valida(Mesero mesero) {

        String mensaje = "";
        // solicitando datos (idMesero==null para INS)
        String idMesero = request.getParameter("idMesero");
        String numeroDocumento = request.getParameter("numeroDocumento");
        String apellidoPaterno = request.getParameter("apellidoPaterno");
        String apellidoMaterno = request.getParameter("apellidoMaterno");
        String nombres = request.getParameter("nombres");
        //Integer estado = request.getParameter("estado");
        // ---

        // validaciones

        if (mensaje == null) {
            mensaje = ((numeroDocumento == null) || (numeroDocumento.trim().isEmpty()))
                    ? "¡ingrese Numero de Documento!" : null;
        }

        mensaje = ((apellidoPaterno == null) || (apellidoPaterno.trim().isEmpty()))
                ? "Ingrese Apellido Paterno!" : null;

        if (mensaje == null) {
            mensaje = ((apellidoMaterno == null) || (apellidoMaterno.trim().isEmpty()))
                    ? "¡Ingrese Apellido Materno!" : null;
        }

        if (mensaje == null) {
            mensaje = ((nombres == null) || (nombres.trim().isEmpty()))
                    ? "¡Ingrese Nombres!" : null;
        }

        // ---

        // encapsula si todo OK
        if (mensaje == null) {
            if (idMesero == null) { // null para INS
                mesero.setId(null);
            } else {
                mesero.setId(Integer.valueOf(idMesero));
            }

            mesero.setNumDocumento(apellidoPaterno);
            mesero.setApellidoPaterno(apellidoPaterno);
            mesero.setApellidoMaterno(apellidoMaterno);
            mesero.setNombre(nombres);
            //mesero.setEstado("1"); // activo inicialmente
        }
        return mensaje;
    }
}
