package com.interfaces;

import com.modelo.Alquiler;
import java.util.List;

public interface CRUDAlquiler {
    public List<Alquiler> listar();
    public Alquiler list(int id);
    public boolean add(Alquiler alquiler);
    public boolean edit(Alquiler alquiler);
    public boolean eliminar(int id);
}
