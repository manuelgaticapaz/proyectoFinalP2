/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modeloDAO;

import com.conexion.conexionDB;
import com.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kenzy
 */
public class UsuarioDAO {
    conexionDB cn=new conexionDB();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Usuario usr=new Usuario();
    
    /*@Override
    public List listar() {
        ArrayList<Usuario> list=new ArrayList<>();
        String sql="select * from usr_ususarios";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Usuario user=new Usuario();
                user.setId(rs.getInt("usr_id"));
                user.setMail(rs.getString("usr_email"));
                user.setContrasenia(rs.getString("usr_contraseña"));
                user.setEsAdmin(rs.getBoolean("usr_contraseña"));
                user.setEsActivo(rs.getBoolean("usr_es_admin"));
                list.add(user);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    @Override
    public Usuario list(int id) {
        String sql="select * from usr_ususarios where usr_id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                usr.setId(rs.getInt("usr_id"));
                usr.setMail(rs.getString("usr_email"));
                usr.setContrasenia(rs.getString("usr_contraseña"));
                usr.setEsAdmin(rs.getBoolean("usr_contraseña"));
                usr.setEsActivo(rs.getBoolean("usr_es_admin"));
            }
        } catch (Exception e) {
        }
        return usr;
    }

    @Override
    public boolean add(Usuario usr) {
       String sql="insert into usr_ususarios(`usr_email`, `usr_contraseña`, `usr_es_admin`, `usr_activo`) "
               + "VALUES ('"+usr.getMail()+
               "','"+usr.getContrasenia()+
               "','"+usr.getEsAdmin()+
               "','"+usr.getEsActivo()+
               "')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Usuario usr) {
        String sql="update usr_ususarios set "
                + "usr_es_admin='"+usr.getEsAdmin()+"'"
                + ",usr_activo='"+usr.getEsActivo()+"'"
                + "where usr_id="+usr.getId();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql="delete from usr_ususarios where usr_id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }*/
    
}
