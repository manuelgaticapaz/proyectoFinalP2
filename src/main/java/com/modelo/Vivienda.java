package com.modelo;

public class Vivienda {

    // Constructores
    public Vivienda(int id, String direccion, String tipo, int numHabitaciones, double precio, boolean disponibilidad) {
        this.id = id;
        this.direccion = direccion;
        this.tipo = tipo;
        this.numHabitaciones = numHabitaciones;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
    }

    public Vivienda() {
    }

    // Atributos de la clase Vivienda
    private int id;
    private String direccion;
    private String tipo;
    private int numHabitaciones;
    private double precio;
    private boolean disponibilidad;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
