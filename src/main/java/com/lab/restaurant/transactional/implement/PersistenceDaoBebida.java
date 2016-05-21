package com.lab.restaurant.transactional.implement;

import com.lab.restaurant.model.Bebida;
import com.lab.restaurant.transactional.dao.DaoBebida;
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
public class PersistenceDaoBebida implements DaoBebida {
    private final SqlConecta conecta;

    public PersistenceDaoBebida() {
        this.conecta = new SqlConecta();
    }

    @Override
    public List<Bebida> consultar() {
        List<Bebida> list = null;
        Connection conexion = conecta.connection();
        String sentencia = "SELECT "
                + "idBebida,"
                + "precio,"
                + "tipo "
                + "FROM tb_Bebida"
                + "ORDER BY idBebida, tipo, precio";
        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sentencia)) {
            list = new ArrayList<>();
            while (rs.next()) {
                Bebida bebida = new Bebida();
                bebida.setId(rs.getInt(1));
                bebida.setPrecio(rs.getDouble(2));
                bebida.setTipoBebida(rs.getString(3));
                list.add(bebida);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            Logger.getLogger(PersistenceDaoBebida.class.getName()).log(Level.SEVERE, null, e);

        }
        return list;
    }

    @Override
    public String insertar(Bebida bebida) {
        String resultado = null;
        Connection cn = conecta.connection();
        String sentencia = "INSERT INTO tb_Bebida("
                + "idBebida,"
                + "precio,"
                + "tipo "
                + ") values(?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sentencia);

            ps.setDouble(1, bebida.getPrecio());
            ps.setString(2, bebida.getTipoBebida());
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
        String sentencia = "DELETE FROM tb_Bebida WHERE idBebida=" + id;

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
    public Bebida obtenerBebida(Integer idBebida) {
        Bebida bebida = null;
        Connection cn = conecta.connection();
        String sentencia = "SELECT "
                + "idBebida,"
                + "precio,"
                + "tipo "
                + "FROM tb_Bebida "
                + "WHERE idBebida=? ";
        try{
            PreparedStatement ps = cn.prepareStatement(sentencia);
            ps.setInt(1, idBebida);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                bebida = new Bebida();
                bebida.setId(rs.getInt(1));
                bebida.setPrecio(rs.getDouble(2));
                bebida.setTipoBebida(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
            }
        }
        return bebida;
    }

    @Override
    public String actualizar(Bebida bebida) {
        String resultado = null;
        Connection cn = conecta.connection();
        String sentencia = "UPDATE tb_Bebida SET "
                + "precio=?,"
                + "tipo=?, "
                + "WHERE idBebida=?";
        try {
            PreparedStatement ps = cn.prepareStatement(sentencia);

            ps.setDouble(1, bebida.getPrecio());
            ps.setString(2, bebida.getTipoBebida());

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
