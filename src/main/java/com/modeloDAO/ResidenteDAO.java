package com.modeloDAO;

import com.conexion.conexionDB;
import com.interfaces.CRUDResidente;
import com.modelo.Residente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResidenteDAO implements CRUDResidente {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    conexionDB cn = new conexionDB();
    
    @Override
    public List<Residente> listar() {
        String sql = "SELECT * FROM residente";
        List<Residente> lista = new ArrayList<>();
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Residente r = new Residente();
                r.setDocumento(rs.getString("documento"));
                r.setNombre(rs.getString("nombre"));
                r.setEdad(rs.getInt("edad"));
                r.setCorreo(rs.getString("correo"));
                r.setClaveAcceso(rs.getString("claveAcceso"));
                lista.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    @Override
    public Residente list(String documento) {
        String sql = "SELECT * FROM residente WHERE documento = ?";
        Residente r = new Residente();
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            ps.setString(1, documento);
            rs = ps.executeQuery();
            while (rs.next()) {
                r.setDocumento(rs.getString("documento"));
                r.setNombre(rs.getString("nombre"));
                r.setEdad(rs.getInt("edad"));
                r.setCorreo(rs.getString("correo"));
                r.setClaveAcceso(rs.getString("claveAcceso"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public boolean add(Residente r) {
        String sql = "INSERT INTO residente (documento, nombre, edad, correo, claveAcceso) VALUES (?, ?, ?, ?, 1)";
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            ps.setString(1, r.getDocumento());
            ps.setString(2, r.getNombre());
            ps.setInt(3, r.getEdad());
            ps.setString(4, r.getCorreo());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean edit(Residente r) {
        String sql = "UPDATE residente SET nombre=?, edad=?, correo=? WHERE documento=?";
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            ps.setString(1, r.getNombre());
            ps.setInt(2, r.getEdad());
            ps.setString(3, r.getCorreo());
            ps.setString(4, r.getDocumento());
            int rowsUpdated = ps.executeUpdate(); // Devuelve cuántas filas fueron actualizadas
            return rowsUpdated > 0;  // Si al menos una fila fue actualizada, retorna true
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean eliminar(String documento) {
        String sql = "DELETE FROM residente WHERE documento = ?";
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            ps.setString(1, documento);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
