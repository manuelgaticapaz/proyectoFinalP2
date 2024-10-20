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
        try (Connection con = cn.getConexionMysql();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
             
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

    // Método renombrado para obtener residente por documento
    public Residente obtenerPorDocumento(String documento) {
        String sql = "SELECT * FROM residente WHERE documento = ?";
        Residente r = null;  // Inicializar en null para verificar si no se encuentra un resultado
        try (Connection con = cn.getConexionMysql();
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setString(1, documento);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    r = new Residente();
                    r.setDocumento(rs.getString("documento"));
                    r.setNombre(rs.getString("nombre"));
                    r.setEdad(rs.getInt("edad"));
                    r.setCorreo(rs.getString("correo"));
                    r.setClaveAcceso(rs.getString("claveAcceso"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;  // Si no se encuentra el documento, retorna null
    }

    @Override
    public boolean add(Residente r) {
        String sql = "INSERT INTO residente (documento, nombre, edad, correo, claveAcceso) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = cn.getConexionMysql();
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setString(1, r.getDocumento());
            ps.setString(2, r.getNombre());
            ps.setInt(3, r.getEdad());
            ps.setString(4, r.getCorreo());
            ps.setString(5, r.getClaveAcceso());  // Asegúrate de que el valor de claveAcceso se maneje correctamente
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
        try (Connection con = cn.getConexionMysql();
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setString(1, r.getNombre());
            ps.setInt(2, r.getEdad());
            ps.setString(3, r.getCorreo());
            ps.setString(4, r.getDocumento());
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminar(String documento) {
        String sql = "DELETE FROM residente WHERE documento = ?";
        try (Connection con = cn.getConexionMysql();
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setString(1, documento);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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
}
