/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperacionesSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author quiroz
 */
public class Consultar {

    public LinkedList ConsultaGenerica(String Query, LinkedList parametros) {
        LinkedList lista = new LinkedList();
        Conexion con = new Conexion();
        Connection conexion = con.conectar();
        boolean existe = false;
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(Query);
            while (rs.next()) {
                existe = true;
                for (int i = 0; i < parametros.size(); i++) {
                    lista.add(rs.getString(String.valueOf(parametros.get(i))));
                }
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error consultando base de datos: " + e);
            try {
                conexion.close();
            } catch (Exception ex) {
            }
        }
        if(!existe){
            JOptionPane.showMessageDialog(null, "El registro no existe");
        }
        return lista;
    }

}
