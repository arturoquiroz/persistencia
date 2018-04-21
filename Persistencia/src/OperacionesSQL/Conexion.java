/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperacionesSQL;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quiroz
 */
public class Conexion {

    

    public Connection conectar() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de MySQL: " + ex);
        }
        try {
            connection = (Connection) DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Escuela",
                    "root", "050286artqui");
        } catch (Exception e) {
            System.out.println("Error al conectar con la base: " + e);
        }
        return connection;
    }
}
