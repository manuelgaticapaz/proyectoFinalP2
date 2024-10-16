package com.modeloDAO;

import com.conexion.conexionDB;
import com.interfaces.CRUDAlquiler;
import com.modelo.Alquiler;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlquilerDAO implements CRUDAlquiler {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    conexionDB cn = new conexionDB();
    
    public boolean validarDisponibilidad(int idVivienda, Date fechaInicio, Date fechaFin) {
        String sql = "SELECT * FROM alquiler WHERE id_vivienda = ? AND (fecha_fin IS NULL OR (fecha_inicio <= ? AND (fecha_fin >= ? OR fecha_fin IS NULL)))";
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idVivienda);
            ps.setDate(2, fechaFin != null ? fechaFin : fechaInicio);  // Si no hay fecha fin, usamos la fecha de inicio
            ps.setDate(3, fechaInicio);
            rs = ps.executeQuery();
            return !rs.next(); // Si no hay resultados, la vivienda está disponible
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public List<Alquiler> listar() {
        String sql = "SELECT * FROM alquiler";
        List<Alquiler> lista = new ArrayList<>();
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Alquiler a = new Alquiler();
                a.setId(rs.getInt("id"));
                a.setIdVivienda(rs.getInt("id_vivienda"));
                a.setDocumentoResidente(rs.getString("documento_residente"));
                a.setFechaInicio(rs.getDate("fecha_inicio"));
                a.setFechaFin(rs.getDate("fecha_fin"));
                lista.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    @Override
    public Alquiler list(int id) {
        String sql = "SELECT * FROM alquiler WHERE id = ?";
        Alquiler a = new Alquiler();
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                a.setId(rs.getInt("id"));
                a.setIdVivienda(rs.getInt("id_vivienda"));
                a.setDocumentoResidente(rs.getString("documento_residente"));
                a.setFechaInicio(rs.getDate("fecha_inicio"));
                a.setFechaFin(rs.getDate("fecha_fin"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return a;
    }

    @Override
    public boolean add(Alquiler a) {
        String sql = "INSERT INTO alquiler (id_vivienda, documento_residente, fecha_inicio, fecha_fin) VALUES (?, ?, ?, ?)";
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            ps.setInt(1, a.getIdVivienda());
            ps.setString(2, a.getDocumentoResidente());
            ps.setDate(3, new java.sql.Date(a.getFechaInicio().getTime()));
            if (a.getFechaFin() != null) {
                ps.setDate(4, new java.sql.Date(a.getFechaFin().getTime()));
            } else {
                ps.setNull(4, java.sql.Types.DATE); // Si no hay fecha fin, establecemos NULL
            }
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean edit(Alquiler a) {
        String sql = "UPDATE alquiler SET id_vivienda=?, documento_residente=?, fecha_inicio=?, fecha_fin=? WHERE id=?";
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            ps.setInt(1, a.getIdVivienda());
            ps.setString(2, a.getDocumentoResidente());
            ps.setDate(3, new java.sql.Date(a.getFechaInicio().getTime()));
            ps.setDate(4, a.getFechaFin() != null ? new java.sql.Date(a.getFechaFin().getTime()) : null);
            ps.setInt(5, a.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM alquiler WHERE id = ?";
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
