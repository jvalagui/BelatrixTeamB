package com.lab.restaurant.transactional.implement;

import com.lab.restaurant.model.Cliente;
import com.lab.restaurant.transactional.dao.DaoCliente;
import com.lab.restaurant.transactional.sql.SqlConecta;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Braulio Trigueros on 20/05/2016.
 */
public class PersistenceDaoCliente implements DaoCliente {
    private final SqlConecta conecta;

    public PersistenceDaoCliente() {
        this.conecta = new SqlConecta();
    }

    @Override
    public List<Cliente> consultar() {
        List<Cliente> list = null;
        Connection conexion = conecta.connection();
        String sentencia = "SELECT "
                + "idCliente,"
                + "numero_Documento,"
                + "apellidoPaterno,"
                + "apellidoMaterno,"
                + "nombre,"
                + "estado,"
                + "numeroAcompanantes "
                + "FROM tb_Cliente"
                + "ORDER BY apellidoPaterno, apellidoMaterno, nombre";
        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sentencia)) {
            list = new ArrayList<>();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt(1));
                cliente.setNumDocumento(rs.getString(2));
                cliente.setApellidoPaterno(rs.getString(3));
                cliente.setApellidoMaterno(rs.getString(4));
                cliente.setNombre(rs.getString(5));
                cliente.setEstado(rs.getInt(6));
                //cliente.setNumeroAcompanantes(rs.getInt(7));
                list.add(cliente);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            Logger.getLogger(PersistenceDaoCliente.class.getName()).log(Level.SEVERE, null, e);

        }
        return list;
    }

    @Override
    public String insertar(Cliente cliente) {
        String resultado = null;
        Connection cn = conecta.connection();
        String sentencia = "INSERT INTO tb_Cliente("
                + "numeroDocumento,"
                + "apellidoPaterno,"
                + "apellidoMaterno,"
                + "nombres,"
                + "estado,"
                + "numeroAcompanantes"
                + ") values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sentencia);

            ps.setString(1, cliente.getNumDocumento());
            ps.setString(2, cliente.getApellidoPaterno());
            ps.setString(3, cliente.getApellidoMaterno());
            ps.setString(4, cliente.getNombre());
            ps.setInt(5, cliente.getEstado());
            //ps.setInt(5, cliente.getNumeroAcompanantes());
            int resultadoQuery = ps.executeUpdate();
            if (resultadoQuery == 0) {
                resultado = "0 filas afectadas";
            }
        } catch (SQLException e) {
            resultado = e.getMessage();
        }
        return resultado;
    }

    @Override
    public String eliminar(String id) {
        String resultado = null;
        Connection cn = conecta.connection();
        String sentencia = "DELETE FROM tb_Cliente WHERE idCliente=" + id;

        try{
            PreparedStatement ps = cn.prepareStatement(sentencia);
            int resultadoQuery = ps.executeUpdate(sentencia);
            if (resultadoQuery == 0) {
                resultado = "0 filas afectadas";
            }
        } catch (SQLException e) {
            resultado = e.getMessage();
        }
        finally {
            try {
                cn.close();
            } catch (SQLException e) {
                resultado = e.getMessage();
            }
        }
        return resultado;
    }

    @Override
    public Cliente obtenerCliente(Integer idCliente) {
        Cliente cliente = null;
        Connection cn = conecta.connection();
        String sentencia = "SELECT "
                + "idCliente,"
                + "numeroDocumento,"
                + "apellidoPaterno,"
                + "apellidoMaterno,"
                + "nombres,"
                + "estado,"
                + "numeroAcompanantes "
                + "FROM tb_Cliente "
                + "WHERE idCliente=? ";
        try{
            PreparedStatement ps = cn.prepareStatement(sentencia);
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt(1));
                cliente.setNumDocumento(rs.getString(2));
                cliente.setApellidoPaterno(rs.getString(3));
                cliente.setApellidoMaterno(rs.getString(4));
                cliente.setNombre(rs.getString(5));
                cliente.setEstado(rs.getInt(6));
                //cliente.setNumeroAcompanantes(rs.getInt(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
            }
        }
        return cliente;
    }

    @Override
    public String actualizar(Cliente cliente) {
        String resultado = null;
        Connection cn = conecta.connection();
        String sentencia = "UPDATE tb_Cliente SET "
                + "numeroDocumento=?,"
                + "apellidoPaterno=?,"
                + "apellidoMaterno=?,"
                + "nombres=?,"
                + "estado=?,"
                + "numeroAcompanantes=?,"
                + "WHERE idCliente=?";
        try {
            PreparedStatement ps = cn.prepareStatement(sentencia);

            ps.setString(1, cliente.getNumDocumento());
            ps.setString(2, cliente.getApellidoPaterno());
            ps.setString(3, cliente.getApellidoMaterno());
            ps.setString(4, cliente.getNombre());
            ps.setInt(5, cliente.getEstado());
            //ps.setInt(6, cliente.getNumeroAcompanantes());
            ps.setInt(6, cliente.getId());

            int resultadoQuery = ps.executeUpdate();
            if (resultadoQuery == 0) {
                resultado = "0 filas afectadas";
            }
        } catch (SQLException e) {
            resultado = e.getMessage();
        }
        finally {
            try {
                cn.close();
            } catch (SQLException e) {
                resultado = e.getMessage();
            }
        }
        return resultado;
    }
}
