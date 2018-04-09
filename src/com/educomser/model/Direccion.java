/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.educomser.model;

import java.io.Serializable;

/**
 *
 * @author hmontes
 */
public class Direccion implements Serializable{

    private int id;
    private String calle;
    private String zona;
    private int numero;

    public Direccion() {
    }

    public Direccion(int id, String calle, String zona, int numero) {
        this.id = id;
        this.calle = calle;
        this.zona = zona;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
