package com.lab.restaurant.transactional;

import com.lab.restaurant.model.Mesa;
import com.lab.restaurant.model.Mesero;

import java.util.Scanner;

/**
 * Created by Kei on 16/05/2016.
 */
public class MeseroController {

    public static void registrar() {

        String nombre;
        String apellidoPaterno;
        String apellidoMaterno;
        String numeroDocumento;

        Scanner in = new Scanner(System.in);

        //FALTAN VALIDACIONES (POR EJEMPLO VERIFICAR QUE SE INGRESEN SÓLO NUMEROS Y NO LETRAS)
        System.out.print("Ingresar el numero de documento del mesero: ");
        numeroDocumento = in.nextLine();

        while (existeMesero(numeroDocumento)) { //VALIDACION BÁSICA
            System.out.println("\nEse número de documento ya existe!\n");
            System.out.print("Ingresar el numero de documento del mesero: ");
            numeroDocumento = in.nextLine();
        }

        System.out.print("\nIngresar nombre: ");
        nombre = in.nextLine();

        System.out.print("\nIngresar apellido paterno: ");
        apellidoPaterno = in.nextLine();

        System.out.print("\nIngresar apellido materno: ");
        apellidoMaterno = in.nextLine();

        int idMesero = obtenerIdMesero();
        AppRestauranteBD.getListaMeseros().add(new Mesero(idMesero, numeroDocumento, nombre, apellidoPaterno, apellidoMaterno));

        System.out.println("\nMesero registrado correctamente!\n");

    }

//    public static void editar(){
//
//    }
//
//    public static void eliminar(){
//
//    }

    public static void listar() {
        int contador = 0;
        if (AppRestauranteBD.getListaMeseros().size() > 0)
            for (Mesero mesero : AppRestauranteBD.getListaMeseros()) {
                contador++;
                System.out.println("(" + contador + ")Mesero: " + mesero.getApellidoPaterno() + " " + mesero.getApellidoMaterno() + ", " + mesero.getNombre());
                System.out.println("Nro de Documento: " + mesero.getNumDocumento());
                if (mesero.getListaMesas().size() > 0) {
                    System.out.print("Atendiendo a las mesas:");
                    for (Mesa mesa : mesero.getListaMesas()) {
                        System.out.print(" " + mesa.getNumMesa());
                    }
                    System.out.println();
                }
                System.out.println();
            }
        else
            System.out.println("\nNo hay meseros registrados!\n");
    }

    private static int obtenerIdMesero() {

        int cantidadMeseros = AppRestauranteBD.getListaMeseros().size();

        if (cantidadMeseros == 0) {
            return 1;
        } else {
            int idMesero = cantidadMeseros++;
            return idMesero;
        }
    }

    private static boolean existeMesero(String numeroDocumento) {

        if (AppRestauranteBD.getListaMeseros().size() > 0) {
            for (Mesero mesero : AppRestauranteBD.getListaMeseros())
                if (mesero.getNumDocumento().equalsIgnoreCase(numeroDocumento)) {
                    return true;
                }
        }

        return false;
    }

    //MySQL CRUD
    //public Class MeseroBD implements DaoMesero{
//    private final SqlConecta conecta;
//
//    public MeseroBD() {
//        this.conecta = new SqlConecta();
//    }
//
//@Override
//    public List<Mesero> consultar() {
//        List<Mesero> list = null;
//        Connection conexion = conecta.connection();
//        String sentencia = "SELECT "
//                + "idMesero,"
//                + "numero_Documento,"
//                + "apellidoPaterno,"
//		+ "apellidoMaterno,
//                + "nombre,"
//                + "estado "
//                + "FROM tb_Mesero "
//                + "ORDER BY apellidoPaterno, apellidoMaterno, nombre";
//        try (Statement st = conexion.createStatement();
//                ResultSet rs = st.executeQuery(sentencia)) {
//            listaCliente = new ArrayList<>();
//            while (rs.next()) {
//                Mesero mesero = new Mesero();
//                mesero.setIdCliente(rs.getInt(1));
//                mesero.setNumeroDocumento(rs.getString(2));
//                mesero.setApellidoPaterno(rs.getString(3));
//                mesero.setApellidoMaterno(rs.getString(4));
//                mesero.setNombres(rs.getString(5));
//                mesero.setEstado(rs.getInt(6));
//		list.add(mesero);
//            }
//        } catch (SQLException e) {
//            // e.printStackTrace();
//            Logger.getLogger(MeseroBD.class.getName()).log(Level.SEVERE, null, e);
//
//        }
//        return list;
//    }
//
// @Override
//    public String insertar(Mesero Mesero) {
//        String resultado = null;
//        Connection cn = conecta.connection();
//        String sentencia = "INSERT INTO tb_Mesero("
//        + "numeroDocumento,"
//	+ "apellidoPaterno,"
//        + "apellidoMaterno,"
//        + "nombres,"
//	+ "estado "
//        + ") values(?,?,?,?,?)";
//        try {
//            PreparedStatement ps = cn.prepareStatement(sentencia);
//
//	    ps.setString(1, mesero.getNumeroDocumento());
//            ps.setString(1, mesero.getApellidoPaterno());
//            ps.setString(2, mesero.getApellidoMaterno());
//            ps.setString(3, mesero.getNombres());
//            ps.setString(4, mesero.getEstado());
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
//        String sentencia = "DELETE FROM tb_Mesero WHERE idMesero=" + id;
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
//    public Mesero obtenerMesero (Integer idMesero) {
//        Mesero mesero = null;
//        Connection cn = conecta.connection();
//        String sentencia = "SELECT "
//        + "idMesero,"
//	+ "numeroDocumento,"
//        + "apellidoPaterno,"
//        + "apellidoMaterno,"
//        + "nombres,"
//        + "estado "
//        + "FROM tb_Mesero "
//        + "WHERE idMesero=? ";
//        try{
//            PreparedStatement ps = cn.prepareStatement(sentencia);
//            ps.setInt(1, idMesero);
//            ResultSet rs = ps.executeQuery();
//
//        if (rs.next()) {
//            mesero = new Cliente();
//            mesero.setIdMesero(rs.getInt(1));
//	    mesero.setNumeroDocumento(rs.getInt(2));
//            mesero.setApellidoPaterno(rs.getString(3));
//            mesero.setApellidoMaterno(rs.getString(4));
//            mesero.setNombres(rs.getString(5));
//            mesero.setEstado(rs.getInt(6));
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
//    public String actualizar(Mesero mesero) {
//        String resultado = null;
//        Connection cn = conecta.connection();
//        String sentencia = "UPDATE tb_Mesero SET "
//        + "numeroDocumento=?,"
//	+ "apellidoPaterno=?,"
//        + "apellidoMaterno=?,"
//        + "nombres=?,"
//        + "estado=? "
//        + "WHERE idMesero=?";
//        try {
//            PreparedStatement ps = cn.prepareStatement(sentencia);
//
//	    ps.setString(1, mesero.getNumeroDocumento());
//            ps.setString(2, mesero.getApellidoPaterno());
//            ps.setString(3, mesero.getApellidoMaterno());
//            ps.setString(4, mesero.getNombres());
//            ps.setInt(5, mesero.getEstado());
//            ps.setInt(6, cliente.getIdMesero());
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

    //---------------------------------

    //String accion = request.getParameter("accion");
//        String resultado = null;
//        String target = null;
//// ---
//        DaoMesero daoMesero = new MeseroBD();
//        if (accion == null) {
//            resultado = "Solicitud no recibida";
//        } else if (accion.equals("QRY")) {
//            List<Mesero> lista = daoMesero.consultar();
//            if (lista!= null) {
//                request.getSession().setAttribute("list", lista);
//                //target = " ";
//            } else {
//                resultado = "Problemas en Consulta";
//            }
//        } else if (accion.equals("INS")) {
//            Mesero mesero = new Mesero();
//            resultado = valida(mesero, request);
//
//            if (resultado == null) {
//                resultado = daoMesero.insertar(mesero);
//            }
//
//            if (resultado == null) {
//                List<Mesero> lista = daoMesero.consultar();
//                request.getSession().setAttribute("list", lista);
//                //target = " ";
//            }
//
//        } else if (accion.equals("DEL")) {
//            String id = request.getParameter("id");
//            resultado = daoMesero.eliminar(id);
//
//            if (resultado == null){
//                List<Mesero> lista = daoMesero.consultar();
//                request.getSession().setAttribute("list", lista);
//                //target = " ";
//            }
//
//        } else if (accion.equals("GET")) {
//            String id = request.getParameter("id");
//            Mesero mesero = daoMesero.obtenerMesero(Integer.valueOf(id));
//            if (mesero != null) {
//                request.getSession().setAttribute("mesero", mesero);
//                //target = " ";
//            } else {
//                resultado = "Problemas en obtener datos del Mesero";
//            }
//
//        } else if (accion.equals("UPD")) {
//            Mesero mesero = new Mesero();
//            resultado = valida(mesero, request);
//
//            if (resultado == null) {
//                resultado = daoMesero.actualizar(mesero);
//            }
//
//            if (resultado == null) {
//                List<Mesero> lista = daoMesero.consultar();
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
//private String valida(Mesero mesero) {
//
//        String mensaje;
//        // solicitando datos (idMesero==null para INS)
//        String idMesero = request.getParameter("idMesero");
//	String numeroDocumento = request.getParameter("numeroDocumento");
//        String apellidoPaterno = request.getParameter("apellidoPaterno");
//        String apellidoMaterno = request.getParameter("apellidoMaterno");
//        String nombres = request.getParameter("nombres");
//        Int estado = request.getParameter("estado");
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
//            if (idMesero == null) { // null para INS
//                mesero.setIdMesero(null);
//            } else {
//                mesero.setIdMesero(Integer.valueOf(idMesero));
//            }
//
//	    mesero.setNumeroDocumento(apellidoPaterno);
//            mesero.setApellidoPaterno(apellidoPaterno);
//            mesero.setApellidoMaterno(apellidoMaterno);
//            mesero.setNombres(nombres);
//            mesero.setEstado("1"); // activo inicialmente
//        }
//
//        return mensaje;
//    }
}
