package com.example.apiwebve.modelVE;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.sql.Date;

@Entity(tableName = "notas")
public class NotaVE implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int id;
    String titulo;
    String descripcion;
    Date fecha;
    String usuario;

    //constructor vacio
    public NotaVE() {
    }

    //constructor

    public NotaVE(int id, String titulo, String descripcion, Date fecha, String usuario) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    //Getters & Setters correspondientes

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
