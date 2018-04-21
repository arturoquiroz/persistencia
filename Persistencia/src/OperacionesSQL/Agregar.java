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
public class Agregar {

    public boolean Agregarusuario(String nombre, String paterno, String materno,
            int tipo) {
        Conexion con = new Conexion();
        Connection conexion = con.conectar();
        String Query = "";
        if (tipo == 0) {
            Query = "INSERT INTO Profesor (Nombre, A_Paterno, A_Materno) values"
                    + " ('" + nombre + "', '" + paterno + "', '" + materno + "')";
        }
        if (tipo == 1) {
            Query = "INSERT INTO Alumno (Nombre, A_Paterno, A_Materno) values"
                    + " ('" + nombre + "', '" + paterno + "', '" + materno + "')";
        }
        try {
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(Query);
            conexion.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al agregar usuario: " + e);
            try {
                conexion.close();
            } catch (Exception ex) {
            }
            return false;
        }
    }

}
