/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

/**
 *
 * @author Kenzy
 */
public class Usuario {
    private int id;
    private String mail;
    private String contrasenia;
    private Boolean esAdmin;
    private Boolean esActivo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Boolean getEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(Boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public Boolean getEsActivo() {
        return esActivo;
    }

    public void setEsActivo(Boolean esActivo) {
        this.esActivo = esActivo;
    }
    
    public Usuario(){
    }
    
    public Usuario(String mail, String contrasenia, Boolean esAdmin, Boolean esActivo) {
        this.mail = mail;
        this.contrasenia = contrasenia;
        this.esAdmin = esAdmin;
        this.esActivo = esActivo;
    }
    
    
}
