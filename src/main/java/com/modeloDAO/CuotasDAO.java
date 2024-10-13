package com.modeloDAO;

import com.conexion.conexionDB;
import com.interfaces.CRUDCuotas;
import com.modelo.Cuotas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CuotasDAO implements CRUDCuotas{

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    conexionDB cn = new conexionDB();
    
    @Override
    public List<Cuotas> listar() {
        String sql = "SELECT * FROM cuotas";
        List<Cuotas> lista = new ArrayList<>();
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cuotas c = new Cuotas();
                c.setId(rs.getInt("id"));
                c.setIdAlquiler(rs.getInt("id_alquiler"));
                c.setCodigoCuota(rs.getString("codigo_cuota"));
                c.setPeriodoYear(rs.getInt("periodo_year"));
                c.setPeriodoMes(rs.getInt("periodo_mes"));
                c.setImporte(rs.getDouble("importe"));
                c.setFechaVencimiento(rs.getDate("fecha_vencimiento"));
                c.setPagada(rs.getBoolean("pagada"));
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    @Override
    public Cuotas list(int id) {
        String sql = "SELECT * FROM cuotas WHERE id = ?";
        Cuotas c = new Cuotas();
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setId(rs.getInt("id"));
                c.setIdAlquiler(rs.getInt("id_alquiler"));
                c.setCodigoCuota(rs.getString("codigo_cuota"));
                c.setPeriodoYear(rs.getInt("periodo_year"));
                c.setPeriodoMes(rs.getInt("periodo_mes"));
                c.setImporte(rs.getDouble("importe"));
                c.setFechaVencimiento(rs.getDate("fecha_vencimiento"));
                c.setPagada(rs.getBoolean("pagada"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public boolean add(Cuotas c) {
        String sql = "INSERT INTO cuotas (id_alquiler, codigo_cuota, periodo_year, periodo_mes, importe, fecha_vencimiento, pagada) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getIdAlquiler());
            ps.setString(2, c.getCodigoCuota());
            ps.setInt(3, c.getPeriodoYear());
            ps.setInt(4, c.getPeriodoMes());
            ps.setDouble(5, c.getImporte());
            ps.setDate(6, new java.sql.Date(c.getFechaVencimiento().getTime()));
            ps.setBoolean(7, c.isPagada());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean edit(Cuotas c) {
        String sql = "UPDATE cuotas SET id_alquiler=?, codigo_cuota=?, periodo_year=?, periodo_mes=?, importe=?, fecha_vencimiento=?, pagada=? WHERE id=?";
        try {
            con = cn.getConexionMysql();
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getIdAlquiler());
            ps.setString(2, c.getCodigoCuota());
            ps.setInt(3, c.getPeriodoYear());
            ps.setInt(4, c.getPeriodoMes());
            ps.setDouble(5, c.getImporte());
            ps.setDate(6, new java.sql.Date(c.getFechaVencimiento().getTime()));
            ps.setBoolean(7, c.isPagada());
            ps.setInt(8, c.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM cuotas WHERE id = ?";
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
