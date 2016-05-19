package com.lab.restaurant.transactional;

import com.lab.restaurant.model.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Kei on 16/05/2016.
 */
public class ClienteController {

    public static void registrar(){

        String nombre;
        String apellidoPaterno;
        String apellidoMaterno;
        String numeroDocumento;

        Scanner in = new Scanner(System.in);

        //FALTAN VALIDACIONES (POR EJEMPLO VERIFICAR QUE SE INGRESEN SÓLO NUMEROS Y NO LETRAS)

        System.out.println("\nRESTAURANTE BELATRIX - Registrar nuevo mesero\n");
        System.out.print("Ingresar el numero de documento del cliente: ");
        numeroDocumento = in.nextLine();

        while (exiseCliente(numeroDocumento)) { //VALIDACION BÁSICA
            System.out.println("\nEse número de documento ya existe!");
            System.out.print("Ingresar el numero de documento del cliente: ");
            numeroDocumento = in.nextLine();
        }

        System.out.print("\nIngresar nombre: ");
        nombre = in.nextLine();

        System.out.print("\nIngresar apellido paterno: ");
        apellidoPaterno = in.nextLine();

        System.out.print("\nIngresar apellido materno: ");
        apellidoMaterno = in.nextLine();

        int idCliente = obtenerIdCliente();
        AppRestauranteBD.getListaCliente().add(new Cliente(idCliente,numeroDocumento,nombre,apellidoPaterno,apellidoMaterno));

        System.out.println("\nCliente registrado correctamente!");
    }

//    public static void editar(){
//
//    }
//
//    public static void eliminar(){
//
//    }

    private static int obtenerIdCliente(){

        int cantidadClientes = AppRestauranteBD.getListaCliente().size();

        if(cantidadClientes == 0){
            return 1;
        }
        else{
            int idCliente = cantidadClientes++;
            return idCliente;
        }
    }

    private static boolean exiseCliente(String numeroDocumento){

        if (AppRestauranteBD.getListaCliente().size() > 0){
            for (Cliente cliente : AppRestauranteBD.getListaCliente())
                if (cliente.getNumDocumento().equalsIgnoreCase(numeroDocumento)){
                    return true;
                }
        }

        return false;
    }

    //CRUD MySQL
    //public Class ClienteBD implements DaoCliente{
//    private final SqlConecta conecta;
//
//    public ClienteBD() {
//        this.conecta = new SqlConecta();
//    }
//
//@Override
//    public List<Cliente> consultar() {
//        List<Cliente> list = null;
//        Connection conexion = conecta.connection();
//        String sentencia = "SELECT "
//                + "idCliente,"
//                + "numero_Documento,"
//                + "apellidoPaterno,"
//		+ "apellidoMaterno,
//                + "nombre,"
//                + "estado,"
//                + "numeroAcompanantes "
//                + "FROM tb_Cliente"
//                + "ORDER BY apellidoPaterno, apellidoMaterno, nombre";
//        try (Statement st = conexion.createStatement();
//                ResultSet rs = st.executeQuery(sentencia)) {
//            listaCliente = new ArrayList<>();
//            while (rs.next()) {
//                Cliente cliente = new Cliente();
//                cliente.setIdCliente(rs.getInt(1));
//                cliente.setNumeroDocumento(rs.getString(2));
//                cliente.setApellidoPaterno(rs.getString(3));
//                cliente.setApellidoMaterno(rs.getString(4));
//                cliente.setNombres(rs.getString(5));
//                cliente.setEstado(rs.getInt(6));
//		cliente.setNumeroAcompanantes(rs.getInt(7));
//                list.add(cliente);
//            }
//        } catch (SQLException e) {
//            // e.printStackTrace();
//            Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, e);
//
//        }
//        return list;
//    }
//
// @Override
//    public String insertar(Cliente cliente) {
//        String resultado = null;
//        Connection cn = conecta.connection();
//        String sentencia = "INSERT INTO tb_Cliente("
//        + "numeroDocumento,"
//	+ "apellidoPaterno,"
//        + "apellidoMaterno,"
//        + "nombres,"
//	+ "estado,"
//        + "numeroAcompanantes"
//        + ") values(?,?,?,?,?,?)";
//        try {
//            PreparedStatement ps = cn.prepareStatement(sentencia);
//
//	    ps.setString(1, cliente.getNumeroDocumento());
//            ps.setString(1, cliente.getApellidoPaterno());
//            ps.setString(2, cliente.getApellidoMaterno());
//            ps.setString(3, cliente.getNombres());
//            ps.setInt(4, cliente.getEstado());
//            ps.setInt(5, cliente.getNumeroAcompanantes());
//            int resultadoQuery = ps.executeUpdate();
//            if (resultadoQuery == 0) {
//            resultado = "0 filas afectadas";
//        }
//        } catch (SQLException e) {
//            resultado = e.getMessage();
//        }
//        return resultado;
//    }
//
//@Override
//    public String eliminar(String id) {
//        String resultado = null;
//        Connection cn = conecta.connection();
//        String sentencia = "DELETE FROM tb_Cliente WHERE idCliente=" + id;
//
//        try{
//            PreparedStatement ps = cn.prepareStatement(sentencia);
//            int resultadoQuery = ps.executeUpdate(sentencia);
//            if (resultadoQuery == 0) {
//            resultado = "0 filas afectadas";
//        }
//        } catch (SQLException e) {
//            resultado = e.getMessage();
//        }
//         finally {
//            try {
//                cn.close();
//            } catch (SQLException e) {
//                resultado = e.getMessage();
//            }
//        }
//        return resultado;
//    }
//
//@Override
//    public Cliente obtenerCliente (Integer idCliente) {
//        Cliente Cliente = null;
//        Connection cn = conecta.connection();
//        String sentencia = "SELECT "
//        + "idCliente,"
//	+ "numeroDocumento,"
//        + "apellidoPaterno,"
//        + "apellidoMaterno,"
//        + "nombres,"
//        + "estado,"
//        + "numeroAcompanantes "
//        + "FROM tb_Cliente "
//        + "WHERE idCliente=? ";
//        try{
//            PreparedStatement ps = cn.prepareStatement(sentencia);
//            ps.setInt(1, idCliente);
//            ResultSet rs = ps.executeQuery();
//
//        if (rs.next()) {
//            cliente = new Cliente();
//            cliente.setIdCliente(rs.getInt(1));
//	    cliente.setNumeroDocumento(rs.getInt(2));
//            cliente.setApellidoPaterno(rs.getString(3));
//            cliente.setApellidoMaterno(rs.getString(4));
//            cliente.setNombres(rs.getString(5));
//            cliente.setEstado(rs.getInt(6));
//            cliente.setNumeroAcompanantes(rs.getInt(7));
//        }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                cn.close();
//            } catch (SQLException e) {
//                }
//        }
//        return mesero;
//    }
//
//@Override
//    public String actualizar(Cliente cliente) {
//        String resultado = null;
//        Connection cn = conecta.connection();
//        String sentencia = "UPDATE tb_Cliente SET "
//        + "numeroDocumento=?,"
//	+ "apellidoPaterno=?,"
//        + "apellidoMaterno=?,"
//        + "nombres=?,"
//        + "estado=?,"
//        + "numeroAcompanantes=?,"
//        + "WHERE idCliente=?";
//        try {
//            PreparedStatement ps = cn.prepareStatement(sentencia);
//
//	    ps.setString(1, cliente.getNumeroDocumento());
//            ps.setString(2, cliente.getApellidoPaterno());
//            ps.setString(3, cliente.getApellidoMaterno());
//            ps.setString(4, cliente.getNombres());
//            ps.setInt(5, cliente.getEstado());
//            ps.setInt(6, cliente.getNumeroAcompanantes());
//            ps.setInt(7, cliente.getIdCliente());
//
//            int resultadoQuery = ps.executeUpdate();
//            if (resultadoQuery == 0) {
//            resultado = "0 filas afectadas";
//            }
//        } catch (SQLException e) {
//            resultado = e.getMessage();
//        }
//        finally {
//            try {
//                cn.close();
//            } catch (SQLException e) {
//                resultado = e.getMessage();
//            }
//        }
//        return resultado;
//    }
//}

    //---------------------------------------------------

    //String accion = request.getParameter("accion");
//        String resultado = null;
//        String target = null;
//// ---
//        DaoCliente daoCliente = new ClienteBD();
//        if (accion == null) {
//            resultado = "Solicitud no recibida";
//        } else if (accion.equals("QRY")) {
//            List<Cliente> lista = daoCliente.consultar();
//            if (lista!= null) {
//                request.getSession().setAttribute("list", lista);
//                //target = " ";
//            } else {
//                resultado = "Problemas en Consulta";
//            }
//        } else if (accion.equals("INS")) {
//            Cliente cliente = new Cliente();
//            resultado = valida(mesero, request);
//
//            if (resultado == null) {
//                resultado = daoCliente.insertar(cliente);
//            }
//
//            if (resultado == null) {
//                List<Cliente> lista = daoCliente.consultar();
//                request.getSession().setAttribute("list", lista);
//                //target = " ";
//            }
//
//        } else if (accion.equals("DEL")) {
//            String id = request.getParameter("id");
//            resultado = daoCliente.eliminar(id);
//
//            if (resultado == null){
//                List<Cliente> lista = daoCliente.consultar();
//                request.getSession().setAttribute("list", lista);
//                //target = " ";
//            }
//
//        } else if (accion.equals("GET")) {
//            String id = request.getParameter("id");
//            Cliente cliente = daoCliente.obtenerCliente(Integer.valueOf(id));
//            if (cliente != null) {
//                request.getSession().setAttribute("cliente", cliente);
//                //target = " ";
//            } else {
//                resultado = "Problemas en obtener datos del Cliente";
//            }
//
//        } else if (accion.equals("UPD")) {
//            Cliente cliente = new Cliente();
//            resultado = valida(cliente, request);
//
//            if (resultado == null) {
//                resultado = daoCliente.actualizar(cliente);
//            }
//
//            if (resultado == null) {
//                List<Cliente> lista = daoCliente.consultar();
//                request.getSession().setAttribute("list", lista);
//                //target = " ";
//            }
//         }
//            else {
//        resultado = "Solicitud no reconocida";
//        }
//        if (resultado != null) {
//        request.getSession().setAttribute("msg", resultado);
//        //target = " ";
//        }
//        if (target != null) {
//        response.sendRedirect(target);
//        }
//}
//
//private String valida(Cliente cliente) {
//
//        String mensaje;
//        // solicitando datos (idCliente==null para INS)
//        String idCliente = request.getParameter("idCliente");
//	String numeroDocumento = request.getParameter("numeroDocumento");
//        String apellidoPaterno = request.getParameter("apellidoPaterno");
//        String apellidoMaterno = request.getParameter("apellidoMaterno");
//        String nombres = request.getParameter("nombres");
//        Int estado = request.getParameter("estado");
//	Int numeroAcompanantes = request.getParameter("numeroAcompanantes");
//        // ---
//
//        // validaciones
//
//	if (mensaje == null) {
//            mensaje = ((numeroDocumento == null) || (numeroDocumento().isEmpty()))
//                    ? "¡ingrese Numero de Documento!" : null;
//        }
//
//        mensaje = ((apellidoPaterno == null) || (apellidoPaterno.trim().isEmpty()))
//                ? "Ingrese Apellido Paterno!" : null;
//
//        if (mensaje == null) {
//            mensaje = ((apellidoMaterno == null) || (apellidoMaterno.trim().isEmpty()))
//                    ? "¡Ingrese Apellido Materno!" : null;
//        }
//
//        if (mensaje == null) {
//            mensaje = ((nombres == null) || (nombres.trim().isEmpty()))
//                    ? "¡Ingrese Nombres!" : null;
//        }
//
//
//        // ---
//
//        // encapsula si todo OK
//        if (mensaje == null) {
//            if (idCliente == null) { // null para INS
//                cliente.setIdCliente(null);
//            } else {
//                cliente.setIdCliente(Integer.valueOf(idCliente));
//            }
//
//	    cliente.setNumeroDocumento(apellidoPaterno);
//            cliente.setApellidoPaterno(apellidoPaterno);
//            cliente.setApellidoMaterno(apellidoMaterno);
//            cliente.setNombres(nombres);
//            cliente.setEstado("1"); // activo inicialmente
//	    cliente.setNumeroAcompanantes("1");  // activo inicialmente
//	}
//
//        return mensaje;
//    }

}
