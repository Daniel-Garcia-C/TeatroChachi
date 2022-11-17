/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;

/**
 *
 * @author DANIEL GARCIA
 */
public class ObraTeatro implements Serializable{
    
    private int id;
    private String nombre;
    private String genero;
    private String resumen;
    private int duracion;
    private String ActorPrincipal[];
    private double precio;

    public ObraTeatro() {
      
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String[] getActorPrincipal() {
        return ActorPrincipal;
    }

    public void setActorPrincipal(String[] ActorPrincipal) {
        this.ActorPrincipal = ActorPrincipal;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
