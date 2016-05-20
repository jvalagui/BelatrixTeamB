package com.lab.restaurant.transactional.sql;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Created by Braulio Trigueros on 20/05/2016.
 */
public class SqlConecta {
    private final String dataBase;

    public SqlConecta() {
        dataBase = "AppRestaurante";
    }

    public Connection connection()  {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                    +dataBase , "root","mysql");

        } catch (SQLException |
                ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            Logger.getLogger(SqlConecta.class.getName()).log(Level.SEVERE, null, e);
        }
        return connection;
    }
}