/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Marcos Gatica Paz
 */
public class conexionDB {
    private Connection cn = null;
    private final String urlmysql = "jdbc:mysql://localhost:3306/mydb";
    
    private final String usuario = "root";
    private final String contrasena = "";
    
    public Connection getConexionMysql() throws SQLException{
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        cn = DriverManager.getConnection(urlmysql, usuario,contrasena);
        return cn;
    }
}
