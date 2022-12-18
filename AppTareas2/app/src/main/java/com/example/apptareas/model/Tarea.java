package com.example.apptareas.model;

import java.io.Serializable;

public class Tarea implements Serializable {

    public  static Long serialID=1L;
    private Integer id;
    private String titulo;
    private String descripcion;

    public Tarea(Integer id, String titulo, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Tarea() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
