package com.interfaces;

import com.modelo.Residente;
import java.util.List;

public interface CRUDResidente {
    public List<Residente> listar();
    public Residente list(String documento);
    public boolean add(Residente residente);
    public boolean edit(Residente residente);
    public boolean eliminar(String documento);
}
