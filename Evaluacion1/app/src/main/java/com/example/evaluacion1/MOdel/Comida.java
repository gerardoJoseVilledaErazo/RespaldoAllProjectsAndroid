package com.example.evaluacion1.MOdel;

public class Comida {
    private String nombre;
    private String categoria;

    public Comida() {

    }
    public Comida(String nombre, String categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }
}
