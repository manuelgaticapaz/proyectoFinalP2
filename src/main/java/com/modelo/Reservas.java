package com.modelo;

import java.util.Date;

public class Reservas {

    private int id;
    private int idArea;
    private int idAlquiler;
    private Date fechaReservaInicio;
    private Date fechaReservaFinal;
    private String nombreResponsable;
    private String comentario;

    // Constructor vacío
    public Reservas() {
    }

    // Constructor con parámetros
    public Reservas(int id, int idArea, int idAlquiler, Date fechaReservaInicio, Date fechaReservaFinal, String nombreResponsable, String comentario) {
        this.id = id;
        this.idArea = idArea;
        this.idAlquiler = idAlquiler;
        this.fechaReservaInicio = fechaReservaInicio;
        this.fechaReservaFinal = fechaReservaFinal;
        this.nombreResponsable = nombreResponsable;
        this.comentario = comentario;
    }

    // Getters y Setters
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

    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public Date getFechaReservaInicio() {
        return fechaReservaInicio;
    }

    public void setFechaReservaInicio(Date fechaReservaInicio) {
        this.fechaReservaInicio = fechaReservaInicio;
    }

    public Date getFechaReservaFinal() {
        return fechaReservaFinal;
    }

    public void setFechaReservaFinal(Date fechaReservaFinal) {
        this.fechaReservaFinal = fechaReservaFinal;
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
