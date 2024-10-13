package com.interfaces;

import com.modelo.Reservas;
import java.util.List;

public interface CRUDReservas {
    public List<Reservas> listar();
    public Reservas list(int id);
    public boolean add(Reservas reserva);
    public boolean edit(Reservas reserva);
    public boolean eliminar(int id);
}
