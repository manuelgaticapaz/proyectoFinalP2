package com.modeloDAO;

import com.conexion.conexionDB;
import com.interfaces.CRUDAreasComunes;
import com.modelo.AreasComunes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AreasComunesDAO implements CRUDAreasComunes {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    conexionDB cn = new conexionDB();
    
    @Override
    public List<AreasComunes> listar() {
        String sql = "SELECT * FROM areascomunes";
        List<AreasComunes> lista = new ArrayList<>();
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                AreasComunes a = new AreasComunes();
                a.setId(rs.getInt("id"));
                a.setCodigo(rs.getString("codigo"));
                a.setTipo(rs.getString("tipo"));
                a.setUbicacion(rs.getString("ubicacion"));
                a.setCapacidad(rs.getInt("capacidad"));
                a.setEstado(rs.getString("estado"));
                lista.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    @Override
    public AreasComunes list(int id) {
    String sql = "SELECT * FROM areascomunes WHERE id = ?";
    AreasComunes area = new AreasComunes();
    try {
        con = cn.getConexionMysql();
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
            area.setId(rs.getInt("id"));
            area.setCodigo(rs.getString("codigo"));
            area.setTipo(rs.getString("tipo"));
            area.setUbicacion(rs.getString("ubicacion"));
            area.setCapacidad(rs.getInt("capacidad"));
            area.setEstado(rs.getString("estado"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return area;
}

    @Override
    public boolean add(AreasComunes a) {
        String sql = "INSERT INTO areascomunes (codigo, tipo, ubicacion, capacidad, estado) VALUES (?, ?, ?, ?, ?)";
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            ps.setString(1, a.getCodigo());
            ps.setString(2, a.getTipo());
            ps.setString(3, a.getUbicacion());
            ps.setInt(4, a.getCapacidad());
            ps.setString(5, a.getEstado());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean edit(AreasComunes a) {
        String sql = "UPDATE areascomunes SET codigo=?, tipo=?, ubicacion=?, capacidad=?, estado=? WHERE id=?";
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            ps.setString(1, a.getCodigo());
            ps.setString(2, a.getTipo());
            ps.setString(3, a.getUbicacion());
            ps.setInt(4, a.getCapacidad());
            ps.setString(5, a.getEstado());
            ps.setInt(6, a.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM areascomunes WHERE id = ?";
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
