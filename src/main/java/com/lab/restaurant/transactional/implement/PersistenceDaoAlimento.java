package com.lab.restaurant.transactional.implement;

import com.lab.restaurant.model.Alimento;
import com.lab.restaurant.transactional.dao.DaoAlimento;
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
public class PersistenceDaoAlimento implements DaoAlimento {
    private final SqlConecta conecta;

    public PersistenceDaoAlimento() {
        this.conecta = new SqlConecta();
    }

    @Override
    public List<Alimento> consultar() {
        List<Alimento> list = null;
        Connection conexion = conecta.connection();
        String sentencia = "SELECT "
                + "idAlimento,"
                + "precio,"
                + "tipo "
                + "FROM tb_Alimento"
                + "ORDER BY idAlimento, tipo, precio";
        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sentencia)) {
            list = new ArrayList<>();
            while (rs.next()) {
                Alimento alimento = new Alimento();
                alimento.setId(rs.getInt(1));
                alimento.setPrecio(rs.getDouble(2));
                alimento.setTipoAlimento(rs.getString(3));
                list.add(alimento);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            Logger.getLogger(PersistenceDaoAlimento.class.getName()).log(Level.SEVERE, null, e);

        }
        return list;
    }

    @Override
    public String insertar(Alimento alimento) {
        String resultado = null;
        Connection cn = conecta.connection();
        String sentencia = "INSERT INTO tb_Alimento("
                + "idAlimento,"
                + "precio,"
                + "tipo "
                + ") values(?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sentencia);

            ps.setDouble(1, alimento.getPrecio());
            ps.setString(2, alimento.getTipoAlimento());
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
        String sentencia = "DELETE FROM tb_Alimento WHERE idAlimento=" + id;

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
    public Alimento obtenerAlimento(Integer idAlimeto) {
        Alimento alimento = null;
        Connection cn = conecta.connection();
        String sentencia = "SELECT "
                + "idAlimento,"
                + "precio,"
                + "tipo "
                + "FROM tb_Alimento "
                + "WHERE idAlimento=? ";
        try{
            PreparedStatement ps = cn.prepareStatement(sentencia);
            ps.setInt(1, idAlimeto);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                alimento = new Alimento();
                alimento.setId(rs.getInt(1));
                alimento.setPrecio(rs.getDouble(2));
                alimento.setTipoAlimento(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
            }
        }
        return alimento;
    }

    @Override
    public String actualizar(Alimento alimento) {
        String resultado = null;
        Connection cn = conecta.connection();
        String sentencia = "UPDATE tb_Alimento SET "
                + "precio=?,"
                + "tipo=?, "
                + "WHERE idAlimento=?";
        try {
            PreparedStatement ps = cn.prepareStatement(sentencia);

            ps.setDouble(1, alimento.getPrecio());
            ps.setString(2, alimento.getTipoAlimento());

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
