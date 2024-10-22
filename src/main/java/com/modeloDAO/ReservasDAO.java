package com.modeloDAO;

import com.conexion.conexionDB;
import com.interfaces.CRUDReservas;
import com.modelo.AreasComunes;
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
        String sql = "SELECT * FROM reservas order by id desc";
        List<Reservas> lista = new ArrayList<>();
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Reservas r = new Reservas();
                r.setId(rs.getInt("id"));
                r.setIdArea(rs.getInt("id_area"));
                r.setIdAlquiler(rs.getInt("id_alquiler"));
                r.setFechaReservaInicio(rs.getTimestamp("fecha_reserva_inicio"));
                r.setFechaReservaFinal(rs.getTimestamp("fecha_reserva_final"));
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
        String sql = "SELECT * FROM reservas WHERE id = ? order by id desc";
        Reservas r = new Reservas();
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                r.setId(rs.getInt("id"));
                r.setIdArea(rs.getInt("id_area"));
                r.setIdAlquiler(rs.getInt("id_alquiler"));
                r.setFechaReservaInicio(rs.getTimestamp("fecha_reserva_inicio"));
                r.setFechaReservaFinal(rs.getTimestamp("fecha_reserva_final"));
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
        String sql = "INSERT INTO reservas (id_area, id_alquiler, fecha_reserva_inicio, fecha_reserva_final, nombre_responsable, comentario) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            ps.setInt(1, r.getIdArea());
            ps.setInt(2, r.getIdAlquiler());
            ps.setTimestamp(3, new Timestamp(r.getFechaReservaInicio().getTime()));
            ps.setTimestamp(4, new Timestamp(r.getFechaReservaFinal().getTime()));
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
        String sql = "UPDATE reservas SET id_area=?, id_alquiler=?, fecha_reserva_inicio=?, fecha_reserva_final=?, nombre_responsable=?, comentario=? WHERE id=?";
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            ps.setInt(1, r.getIdArea());
            ps.setInt(2, r.getIdAlquiler());
            ps.setTimestamp(3, new Timestamp(r.getFechaReservaInicio().getTime()));
            ps.setTimestamp(4, new Timestamp(r.getFechaReservaFinal().getTime()));
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

    // Nuevo método: Listar reservas por ID de Alquiler
    public List<Reservas> listarPorAlquiler(int idAlquiler) {
        String sql = "SELECT * FROM reservas WHERE id_alquiler = ? order by id desc";
        List<Reservas> lista = new ArrayList<>();
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idAlquiler);
            rs = ps.executeQuery();
            while (rs.next()) {
                Reservas r = new Reservas();
                r.setId(rs.getInt("id"));
                r.setIdArea(rs.getInt("id_area"));
                r.setIdAlquiler(rs.getInt("id_alquiler"));
                r.setFechaReservaInicio(rs.getTimestamp("fecha_reserva_inicio"));
                r.setFechaReservaFinal(rs.getTimestamp("fecha_reserva_final"));
                r.setNombreResponsable(rs.getString("nombre_responsable"));
                r.setComentario(rs.getString("comentario"));
                lista.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public List<AreasComunes> obtenerAreasDisponibles(Timestamp fechaInicio, Timestamp fechaFin) {
        List<AreasComunes> areasDisponibles = new ArrayList<>();
        String sql = "SELECT * FROM areascomunes WHERE id NOT IN "
                   + "(SELECT id_area FROM reservas WHERE "
                   + "(fecha_reserva_inicio < ? AND fecha_reserva_final > ?) "
                   + "OR (fecha_reserva_inicio < ? AND fecha_reserva_final > ?))";
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            // Establecemos los valores para evitar solapamientos de fechas
            ps.setTimestamp(1, fechaFin);   // La reserva debe terminar antes de la nueva reserva
            ps.setTimestamp(2, fechaInicio); // La reserva debe comenzar después de la nueva reserva
            ps.setTimestamp(3, fechaFin);   // Verificamos las mismas condiciones para evitar solapamientos
            ps.setTimestamp(4, fechaInicio);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                // Crear objeto área con los datos recuperados
                AreasComunes area = new AreasComunes();
                area.setId(rs.getInt("id"));
                area.setCodigo(rs.getString("codigo"));
                area.setTipo(rs.getString("tipo"));
                area.setUbicacion(rs.getString("ubicacion"));
                area.setCapacidad(rs.getInt("capacidad"));
                area.setEstado(rs.getString("estado"));
                areasDisponibles.add(area);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return areasDisponibles;
    }
}
