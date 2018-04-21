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
public class Actualizar {

    public boolean Editarusuario(String nombre, String paterno, String materno,
            int tipo, int Id) {
        Conexion con = new Conexion();
        Connection conexion = con.conectar();
        String Query = "";
        if (tipo == 0) {
            Query = "UPDATE Profesor SET Nombre  = '" + nombre + "', A_Paterno = '"
                    + paterno + "', A_Materno = '" + materno + "' WHERE id = "
                    + Id;
        }
        if (tipo == 1) {
            Query = "UPDATE Alumno SET Nombre  = '" + nombre + "', A_Paterno = '"
                    + paterno + "', A_Materno = '" + materno + "' WHERE id = "
                    + Id;
        }
        try {
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(Query);
            conexion.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al editar el usuario: " + e);
            try {
                conexion.close();
            } catch (Exception ex) {
            }
            return false;
        }
    }
}
