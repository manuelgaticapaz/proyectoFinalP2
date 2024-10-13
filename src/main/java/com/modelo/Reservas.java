package com.modelo;

import java.util.Date;

public class Reservas {

    public Reservas(int id, int idArea, String documentoResidente, Date fechaReserva, int cantidadPersonas, String nombreResponsable, String comentario) {
        this.id = id;
        this.idArea = idArea;
        this.documentoResidente = documentoResidente;
        this.fechaReserva = fechaReserva;
        this.cantidadPersonas = cantidadPersonas;
        this.nombreResponsable = nombreResponsable;
        this.comentario = comentario;
    }

    public Reservas() {
    }
    private int id;
    private int idArea;
    private String documentoResidente;
    private Date fechaReserva;
    private int cantidadPersonas;
    private String nombreResponsable;
    private String comentario;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public String getDocumentoResidente() {
        return documentoResidente;
    }

    public void setDocumentoResidente(String documentoResidente) {
        this.documentoResidente = documentoResidente;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public String getNombreResponsable() {
        return nombreResponsable;
    }

    public void setNombreResponsable(String nombreResponsable) {
        this.nombreResponsable = nombreResponsable;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
