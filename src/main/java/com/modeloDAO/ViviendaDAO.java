package com.modeloDAO;

import com.conexion.conexionDB;
import com.interfaces.CRUDVivienda;
import com.modelo.Vivienda;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViviendaDAO implements CRUDVivienda {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    conexionDB cn = new conexionDB();

    @Override
    public List<Vivienda> listar() {
        String sql = "SELECT * FROM vivienda";
        List<Vivienda> lista = new ArrayList<>();
        try (Connection con = cn.getConexionMysql();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
             
            while (rs.next()) {
                Vivienda v = new Vivienda();
                v.setId(rs.getInt("id"));
                v.setDireccion(rs.getString("direccion"));
                v.setTipo(rs.getString("tipo"));
                v.setNumHabitaciones(rs.getInt("num_habitaciones"));
                v.setPrecio(rs.getDouble("precio"));
                v.setDisponibilidad(rs.getBoolean("disponibilidad"));
                lista.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Método renombrado para obtener vivienda por ID
    public Vivienda obtenerPorId(int id) {
        String sql = "SELECT * FROM vivienda WHERE id = ?";
        Vivienda v = null;
        try (Connection con = cn.getConexionMysql();
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    v = new Vivienda();
                    v.setId(rs.getInt("id"));
                    v.setDireccion(rs.getString("direccion"));
                    v.setTipo(rs.getString("tipo"));
                    v.setNumHabitaciones(rs.getInt("num_habitaciones"));
                    v.setPrecio(rs.getDouble("precio"));
                    v.setDisponibilidad(rs.getBoolean("disponibilidad"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return v;
    }

    @Override
    public boolean add(Vivienda v) {
        String sql = "INSERT INTO vivienda (direccion, tipo, num_habitaciones, precio, disponibilidad) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = cn.getConexionMysql();
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setString(1, v.getDireccion());
            ps.setString(2, v.getTipo());
            ps.setInt(3, v.getNumHabitaciones());
            ps.setDouble(4, v.getPrecio());
            ps.setBoolean(5, v.isDisponibilidad());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean edit(Vivienda v) {
        String sql = "UPDATE vivienda SET direccion=?, tipo=?, num_habitaciones=?, precio=?, disponibilidad=? WHERE id=?";
        try (Connection con = cn.getConexionMysql();
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setString(1, v.getDireccion());
            ps.setString(2, v.getTipo());
            ps.setInt(3, v.getNumHabitaciones());
            ps.setDouble(4, v.getPrecio());
            ps.setBoolean(5, v.isDisponibilidad());
            ps.setInt(6, v.getId());
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM vivienda WHERE id = ?";
        try (Connection con = cn.getConexionMysql();
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Vivienda list(int id) {
        String sql = "SELECT * FROM vivienda WHERE id = ?";
        Vivienda v = new Vivienda();
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                v.setId(rs.getInt("id"));
                v.setDireccion(rs.getString("direccion"));
                v.setTipo(rs.getString("tipo"));
                v.setNumHabitaciones(rs.getInt("num_habitaciones"));
                v.setPrecio(rs.getDouble("precio"));
                v.setDisponibilidad(rs.getBoolean("disponibilidad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return v;
    }

}
