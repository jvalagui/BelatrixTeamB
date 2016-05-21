package com.lab.restaurant.transactional.implement;

import com.lab.restaurant.model.Mesa;
import com.lab.restaurant.transactional.dao.DaoMesa;
import com.lab.restaurant.transactional.sql.SqlConecta;

import java.util.List;
import java.sql.Date;
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
public class PersistenceDaoMesa implements DaoMesa {
    private final SqlConecta conecta;

    public PersistenceDaoMesa() {
        this.conecta = new SqlConecta();
    }

    @Override
    public List<Mesa> listar() {
        List<Mesa> list = null;
        Connection conexion = conecta.connection();
        String sentencia = "SELECT "
                + "idMesa,"
                + "numeroMesa,"
                + "capacidad,"
                //+ "mesero,"
                + "estado,"
                + "created_at,"
                + "updated_at,"
                + "deleted_at,"
                + "FROM tb_Mesero "
                + "ORDER BY idMesa, numeroMesa, mesero";
        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sentencia)) {
            list = new ArrayList<>();
            while (rs.next()) {
                Mesa mesa = new Mesa();
                mesa.setId(rs.getInt(1));
                mesa.setNumMesa(rs.getInt(2));
                mesa.setCapacidad(rs.getInt(3));
                //mesa.setMesero(rs.getString(4));
                mesa.setEstado(rs.getInt(4));
                mesa.setCreated_at(rs.getDate(5));
                mesa.setUpdated_at(rs.getDate(6));
                mesa.setDeleted_at(rs.getDate(7));
                list.add(mesa);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            Logger.getLogger(PersistenceDaoMesero.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    @Override
    public String insertar(Mesa mesa) {
        String resultado = null;
        Connection cn = conecta.connection();
        String sentencia = "INSERT INTO tb_Mesa("
                + "idMesa,"
                + "numeroMesa,"
                + "capacidad,"
                //+ "mesero,"
                + "estado,"
                + "created_at,"
                + "updated_at,"
                + "deleted_at "
                + ") values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sentencia);

            ps.setInt(1, mesa.getNumMesa());
            ps.setInt(2, mesa.getCapacidad());
            ps.setInt(3, mesa.getEstado());
            ps.setDate(4, mesa.getCreated_at());
            ps.setDate(5, mesa.getUpdated_at());
            ps.setDate(6, mesa.getDeleted_at());
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
    public String actualizar(Mesa mesa) {
        String resultado = null;
        Connection cn = conecta.connection();
        String sentencia = "UPDATE tb_Mesera SET "
                + "numeroMesa,"
                + "capacidad,"
                //+ "mesero,"
                + "estado,"
                + "created_at,"
                + "updated_at,"
                + "deleted_at "
                + "WHERE idMesa=?";
        try {
            PreparedStatement ps = cn.prepareStatement(sentencia);

            ps.setInt(1, mesa.getNumMesa());
            ps.setInt(2, mesa.getCapacidad());
            ps.setInt(3, mesa.getEstado());
            ps.setDate(4, mesa.getCreated_at());
            ps.setDate(5, mesa.getUpdated_at());
            ps.setDate(6, mesa.getDeleted_at());

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

    @Override
    public String eliminar(String id) {
        String resultado = null;
        Connection cn = conecta.connection();
        String sentencia = "DELETE FROM tb_Mesa WHERE idMesero=" + id;

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
    public Mesa obtenerMesa(Integer idMesa) {
        Mesa mesa = null;
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
            ps.setInt(1, idMesa);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                mesa = new Mesa();
                mesa.setId(rs.getInt(1));
                mesa.setNumMesa(rs.getInt(2));
                mesa.setCapacidad(rs.getInt(3));
                //mesa.setMesero(rs.getString(4));
                mesa.setEstado(rs.getInt(4));
                mesa.setCreated_at(rs.getDate(5));
                mesa.setUpdated_at(rs.getDate(6));
                mesa.setDeleted_at(rs.getDate(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
            }
        }
        return mesa;
    }
}
