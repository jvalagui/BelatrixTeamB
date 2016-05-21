package com.lab.restaurant.transactional.cruds;

import com.lab.restaurant.model.Cliente;
import com.lab.restaurant.transactional.dao.DaoCliente;
import com.lab.restaurant.transactional.implement.PersistenceDaoCliente;

import java.util.List;

/**
 * Created by Braulio Trigueros on 20/05/2016.
 * *INCOMPLETO*
 */
public class ClienteCrud {

    String accion = request.getParameter("accion");
    String resultado = null;
    String target = null;

    // ---
    DaoCliente daoCliente = new PersistenceDaoCliente();
    if (accion == null) {
        resultado = "Solicitud no recibida";
    } else if (accion.equals("QRY")) {
        List<Cliente> lista = daoCliente.consultar();
        if (lista!= null) {
            request.getSession().setAttribute("list", lista);
            //target = " ";
        } else {
            resultado = "Problemas en Consulta";
        }
    } else if (accion.equals("INS")) {
        Cliente cliente = new Cliente();
        resultado = valida(cliente, request);

        if (resultado == null) {
            resultado = daoCliente.insertar(cliente);
        }

        if (resultado == null) {
            List<Cliente> lista = daoCliente.consultar();
            request.getSession().setAttribute("list", lista);
            //target = " ";
        }

    } else if (accion.equals("DEL")) {
        String id = request.getParameter("id");
        resultado = daoCliente.eliminar(id);

        if (resultado == null){
            List<Cliente> lista = daoCliente.consultar();
            request.getSession().setAttribute("list", lista);
            //target = " ";
        }

    } else if (accion.equals("GET")) {
        String id = request.getParameter("id");
        Cliente cliente = daoCliente.obtenerCliente(Integer.valueOf(id));
        if (cliente != null) {
            request.getSession().setAttribute("cliente", cliente);
            //target = " ";
        } else {
            resultado = "Problemas en obtener datos del Cliente";
        }

    } else if (accion.equals("UPD")) {
        Cliente cliente = new Cliente();
        resultado = valida(cliente, request);

        if (resultado == null) {
            resultado = daoCliente.actualizar(cliente);
        }

        if (resultado == null) {
            List<Cliente> lista = daoCliente.consultar();
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

    private String valida(Cliente cliente) {

        String mensaje = "";
        // solicitando datos (idCliente==null para INS)
        String idCliente = request.getParameter("idCliente");
        String numeroDocumento = request.getParameter("numeroDocumento");
        String apellidoPaterno = request.getParameter("apellidoPaterno");
        String apellidoMaterno = request.getParameter("apellidoMaterno");
        String nombres = request.getParameter("nombres");
        Integer estado = request.getParameter("estado");
        //Integer numeroAcompanantes = request.getParameter("numeroAcompanantes");
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
            if (idCliente == null) { // null para INS
                cliente.setId(null);
            } else {
                cliente.setId(Integer.valueOf(idCliente));
            }

            cliente.setNumDocumento(apellidoPaterno);
            cliente.setApellidoPaterno(apellidoPaterno);
            cliente.setApellidoMaterno(apellidoMaterno);
            cliente.setNombre(nombres);
            cliente.setEstado(1); // activo inicialmente
            //cliente.setNumeroAcompanantes("1");  // activo inicialmente
        }

        return mensaje;
    }
}