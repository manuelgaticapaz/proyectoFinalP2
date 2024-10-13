package com.modeloDAO;

import com.conexion.conexionDB;
import com.interfaces.CRUDReservas;
import com.modelo.Reservas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservasDAO implements CRUDReservas {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    conexionDB cn = new conexionDB();
    
    @Override
    public List<Reservas> listar() {
        String sql = "SELECT * FROM reservas";
        List<Reservas> lista = new ArrayList<>();
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Reservas r = new Reservas();
                r.setId(rs.getInt("id"));
                r.setIdArea(rs.getInt("id_area"));
                r.setDocumentoResidente(rs.getString("documento_residente"));
                r.setFechaReserva(rs.getDate("fecha_reserva"));
                r.setCantidadPersonas(rs.getInt("cantidad_personas"));
                r.setNombreResponsable(rs.getString("nombre_responsable"));
                r.setComentario(rs.getString("comentario"));
                lista.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    @Override
    public Reservas list(int id) {
        String sql = "SELECT * FROM reservas WHERE id = ?";
        Reservas r = new Reservas();
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                r.setId(rs.getInt("id"));
                r.setIdArea(rs.getInt("id_area"));
                r.setDocumentoResidente(rs.getString("documento_residente"));
                r.setFechaReserva(rs.getDate("fecha_reserva"));
                r.setCantidadPersonas(rs.getInt("cantidad_personas"));
                r.setNombreResponsable(rs.getString("nombre_responsable"));
                r.setComentario(rs.getString("comentario"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public boolean add(Reservas r) {
        String sql = "INSERT INTO reservas (id_area, documento_residente, fecha_reserva, cantidad_personas, nombre_responsable, comentario) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            ps.setInt(1, r.getIdArea());
            ps.setString(2, r.getDocumentoResidente());
            ps.setDate(3, new java.sql.Date(r.getFechaReserva().getTime()));
            ps.setInt(4, r.getCantidadPersonas());
            ps.setString(5, r.getNombreResponsable());
            ps.setString(6, r.getComentario());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public boolean edit(Reservas r) {
        String sql = "UPDATE reservas SET id_area=?, documento_residente=?, fecha_reserva=?, cantidad_personas=?, nombre_responsable=?, comentario=? WHERE id=?";
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            ps.setInt(1, r.getIdArea());
            ps.setString(2, r.getDocumentoResidente());
            ps.setDate(3, new java.sql.Date(r.getFechaReserva().getTime()));
            ps.setInt(4, r.getCantidadPersonas());
            ps.setString(5, r.getNombreResponsable());
            ps.setString(6, r.getComentario());
            ps.setInt(7, r.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM reservas WHERE id = ?";
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
