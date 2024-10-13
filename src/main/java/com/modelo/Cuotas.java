package com.modelo;

import java.util.Date;

public class Cuotas {

    public Cuotas(int id, int idAlquiler, String codigoCuota, int periodoYear, int periodoMes, double importe, Date fechaVencimiento, boolean pagada) {
        this.id = id;
        this.idAlquiler = idAlquiler;
        this.codigoCuota = codigoCuota;
        this.periodoYear = periodoYear;
        this.periodoMes = periodoMes;
        this.importe = importe;
        this.fechaVencimiento = fechaVencimiento;
        this.pagada = pagada;
    }

    public Cuotas() {
    }
    private int id;
    private int idAlquiler;
    private String codigoCuota;
    private int periodoYear;
    private int periodoMes;
    private double importe;
    private Date fechaVencimiento;
    private boolean pagada;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public String getCodigoCuota() {
        return codigoCuota;
    }

    public void setCodigoCuota(String codigoCuota) {
        this.codigoCuota = codigoCuota;
    }

    public int getPeriodoYear() {
        return periodoYear;
    }

    public void setPeriodoYear(int periodoYear) {
        this.periodoYear = periodoYear;
    }

    public int getPeriodoMes() {
        return periodoMes;
    }

    public void setPeriodoMes(int periodoMes) {
        this.periodoMes = periodoMes;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }
}
