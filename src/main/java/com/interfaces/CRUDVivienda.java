/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.interfaces;

import com.modelo.Vivienda;
import java.util.List;

/**
 *
 * @author Marcos Gatica Paz
 */
public interface CRUDVivienda {
    public List<Vivienda> listar();
    public Vivienda list(int id);
    public boolean add(Vivienda vivienda);
    public boolean edit(Vivienda vivienda);
    public boolean eliminar(int id);
    
}
