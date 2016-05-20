package com.lab.restaurant.transactional.implement;

import com.lab.restaurant.model.Mesero;
import com.lab.restaurant.transactional.dao.DaoMesero;
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
public class PersistenceDaoMesero implements DaoMesero {
    private final SqlConecta conecta;

    public PersistenceDaoMesero() {
        this.conecta = new SqlConecta();
    }

    @Override
    public List<Mesero> consultar() {
        List<Mesero> list = null;
        Connection conexion = conecta.connection();
        String sentencia = "SELECT "
                + "idMesero,"
                + "numero_Documento,"
                + "apellidoPaterno,"
                + "apellidoMaterno,"
                + "nombre "
                //+ "estado "
                + "FROM tb_Mesero "
                + "ORDER BY apellidoPaterno, apellidoMaterno, nombre";
        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sentencia)) {
            list = new ArrayList<>();
            while (rs.next()) {
                Mesero mesero = new Mesero();
                mesero.setId(rs.getInt(1));
                mesero.setNumDocumento(rs.getString(2));
                mesero.setNombre(rs.getString(3));
                mesero.setApellidoPaterno(rs.getString(4));
                mesero.setApellidoMaterno(rs.getString(5));
                //mesero.setEstado(rs.getInt(6));
                list.add(mesero);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            Logger.getLogger(PersistenceDaoMesero.class.getName()).log(Level.SEVERE, null, e);

        }
        return list;
    }

    @Override
    public String insertar(Mesero mesero) {
        String resultado = null;
        Connection cn = conecta.connection();
        String sentencia = "INSERT INTO tb_Mesero("
                + "numeroDocumento,"
                + "apellidoPaterno,"
                + "apellidoMaterno,"
                + "nombres "
                //+ "estado "
                + ") values(?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sentencia);

            ps.setString(1, mesero.getNumDocumento());
            ps.setString(1, mesero.getApellidoPaterno());
            ps.setString(2, mesero.getApellidoMaterno());
            ps.setString(3, mesero.getNombre());
            //ps.setString(4, mesero.getEstado());
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
        String sentencia = "DELETE FROM tb_Mesero WHERE idMesero=" + id;

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
    public Mesero obtenerMesero(Integer idMesero) {
        Mesero mesero = null;
        Connection cn = conecta.connection();
        String sentencia = "SELECT "
                + "idMesero,"
                + "numeroDocumento,"
                + "apellidoPaterno,"
                + "apellidoMaterno,"
                + "nombres "
                //+ "estado "
                + "FROM tb_Mesero "
                + "WHERE idMesero=? ";
        try{
            PreparedStatement ps = cn.prepareStatement(sentencia);
            ps.setInt(1, idMesero);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                mesero = new Mesero();
                mesero.setId(rs.getInt(1));
                mesero.setNumDocumento(rs.getString(2));
                mesero.setApellidoPaterno(rs.getString(3));
                mesero.setApellidoMaterno(rs.getString(4));
                mesero.setNombre(rs.getString(5));
                //mesero.setEstado(rs.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
            }
        }
        return mesero;
    }

    @Override
    public String actualizar(Mesero mesero) {
        String resultado = null;
        Connection cn = conecta.connection();
        String sentencia = "UPDATE tb_Mesero SET "
                + "numeroDocumento=?,"
                + "apellidoPaterno=?,"
                + "apellidoMaterno=?,"
                + "nombres=? "
                //+ "estado=? "
                + "WHERE idMesero=?";
        try {
            PreparedStatement ps = cn.prepareStatement(sentencia);

            ps.setString(1, mesero.getNumDocumento());
            ps.setString(2, mesero.getApellidoPaterno());
            ps.setString(3, mesero.getApellidoMaterno());
            ps.setString(4, mesero.getNombre());
            //ps.setInt(5, mesero.getEstado());
            ps.setInt(5, mesero.getId());

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
