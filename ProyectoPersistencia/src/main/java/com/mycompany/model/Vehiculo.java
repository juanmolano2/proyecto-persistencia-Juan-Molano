/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author Juan Esteban Aponte
 * @author Nicolas Tovar
 * @author Juan Molano
 */
public class Vehiculo {
    
    
    
    public static final int TAM_REGISTRO = 42;
    public static final int TAM_PLACA =10;
    public static final int TAM_ESTADO=15;
    
    private int modelo;
    private String placa;
    private double precio;
    private boolean nuevo;
    private String estado;

    public Vehiculo(int modelo, String placa, double precio, boolean nuevo, String estado) {
        this.modelo = modelo;
        this.placa = placa;
        this.precio = precio;
        this.nuevo = nuevo;
        this.estado = estado;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isNuevo() {
        return nuevo;
    }

    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
