package com.modelo;

public class Residente {

    public Residente(String documento, String nombre, int edad, String correo, String claveAcceso) {
        this.documento = documento;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.claveAcceso = claveAcceso;
    }

    public Residente() {
    }
    private String documento;
    private String nombre;
    private int edad;
    private String correo;
    private String claveAcceso;

    // Getters and Setters
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }
}
