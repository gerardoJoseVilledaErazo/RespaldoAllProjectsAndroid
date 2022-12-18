package com.example.evaluacion1.MOdel;

public class Encuestado {
    private String nombre;
    private String Genero;
    private int edad;
    private  String platilloFavorito;

    public Encuestado() {
    }

    public Encuestado(String nombre, String genero, int edad, String platilloFavorito) {
        this.nombre = nombre;
        this.Genero = genero;
        this.edad = edad;
        this.platilloFavorito = platilloFavorito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        this.Genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPlatilloFavorito() {
        return platilloFavorito;
    }

    public void setPlatilloFavorito(String platilloFavorito) {
        this.platilloFavorito = platilloFavorito;
    }
}
