/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.interfaces;

import com.modelo.Usuario;
import java.util.List;

/**
 *
 * @author Kenzy
 */
public interface CRUD {
    public List listar();
    public Usuario list(int id);
    public boolean add(Usuario per);
    public boolean edit(Usuario per);
    public boolean eliminar(int id);
}
