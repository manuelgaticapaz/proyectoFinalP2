package com.interfaces;

import com.modelo.AreasComunes;
import java.util.List;

public interface CRUDAreasComunes {
    public List<AreasComunes> listar();
    public AreasComunes list(int id);
    public boolean add(AreasComunes area);
    public boolean edit(AreasComunes area);
    public boolean eliminar(int id);
}
