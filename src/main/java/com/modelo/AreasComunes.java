package com.modelo;

public class AreasComunes {

    public AreasComunes(int id, String codigo, String tipo, String ubicacion, int capacidad, String estado) {
        this.id = id;
        this.codigo = codigo;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public AreasComunes() {
    }
    private int id;
    private String codigo;
    private String tipo;
    private String ubicacion;
    private int capacidad;
    private String estado;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
