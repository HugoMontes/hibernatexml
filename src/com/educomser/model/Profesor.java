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
public class Profesor implements Serializable{

    private int id;
    private String nombre;
    private float sueldo;
    private Direccion direccion;

    public Profesor() {
    }

    // EL CONSTRUCTOR NO RECIBE DIRECCION
    public Profesor(int id, String nombre, float sueldo) {
        this.id = id;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    

}
