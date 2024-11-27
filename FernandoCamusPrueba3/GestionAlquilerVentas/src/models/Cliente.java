/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Cetecom
 */
public class Cliente {
    private int rut;
    private String nombre;
    private String numero_de_contacto;
    private String direccion;
    private String tipo_de_cliente;

    public Cliente() {
    }

    public Cliente(int rut, String nombre, String numero_de_contacto, String direccion, String tipo_de_cliente) {
        this.rut = rut;
        this.nombre = nombre;
        this.numero_de_contacto = numero_de_contacto;
        this.direccion = direccion;
        this.tipo_de_cliente = tipo_de_cliente;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero_de_contacto() {
        return numero_de_contacto;
    }

    public void setNumero_de_contacto(String numero_de_contacto) {
        this.numero_de_contacto = numero_de_contacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo_de_cliente() {
        return tipo_de_cliente;
    }

    public void setTipo_de_cliente(String tipo_de_cliente) {
        this.tipo_de_cliente = tipo_de_cliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "rut=" + rut + ", nombre=" + nombre + ", numero_de_contacto=" + numero_de_contacto + ", direccion=" + direccion + ", tipo_de_cliente=" + tipo_de_cliente + '}';
    }
    
    

}
