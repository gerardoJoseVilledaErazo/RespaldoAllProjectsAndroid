package com.example.primer_evaluacion_lab_pddm_2022.Modelos;

public class Comida {
    private String nombre;
    private String categoria;

    public Comida(){}

    public Comida(String nombre, String categoria) {
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
