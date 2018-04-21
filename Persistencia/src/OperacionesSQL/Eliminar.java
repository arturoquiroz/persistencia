/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperacionesSQL;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author quiroz
 */
public class Eliminar {

    public boolean Eliminarusuario(int tipo, int Id) {
        Conexion con = new Conexion();
        Connection conexion = con.conectar();
        String Query = "";
        if (tipo == 0) {
            Query = "DELETE FROM Profesor WHERE id = " + Id;
        }
        if (tipo == 1) {
            Query = "DELETE FROM Alumno WHERE id = " + Id;
        }
        try {
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(Query);
            conexion.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar usuario: " + e);
            try {
                conexion.close();
            } catch (Exception ex) {
            }
            return false;
        }
    }
}
