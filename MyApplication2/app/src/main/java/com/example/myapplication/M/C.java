package com.example.myapplication.M;

public class C {
    private String nombre;
    private String categoria;
    public C(){}
    public C(String nombre, String categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
