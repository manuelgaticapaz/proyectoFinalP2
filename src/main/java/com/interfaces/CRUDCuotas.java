package com.interfaces;

import com.modelo.Cuotas;
import java.util.List;

public interface CRUDCuotas {
    public List<Cuotas> listar();
    public Cuotas list(int id);
    public boolean add(Cuotas cuota);
    public boolean edit(Cuotas cuota);
    public boolean eliminar(int id);
}
