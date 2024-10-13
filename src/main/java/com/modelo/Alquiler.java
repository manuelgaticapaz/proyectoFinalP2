package com.modelo;

import java.util.Date;

public class Alquiler {
    private int id;
    private int idVivienda;
    private String documentoResidente;
    private Date fechaInicio;
    private Date fechaFin;

    public Alquiler() {
    }

    public Alquiler(int id, int idVivienda, String documentoResidente, Date fechaInicio, Date fechaFin) {
        this.id = id;
        this.idVivienda = idVivienda;
        this.documentoResidente = documentoResidente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVivienda() {
        return idVivienda;
    }

    public void setIdVivienda(int idVivienda) {
        this.idVivienda = idVivienda;
    }

    public String getDocumentoResidente() {
        return documentoResidente;
    }

    public void setDocumentoResidente(String documentoResidente) {
        this.documentoResidente = documentoResidente;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
