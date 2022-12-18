package com.example.primer_evaluacion_lab_pddm_2022.Modelos;

public class Encuestado {
    private String Nombres;
    private String Genero;
    private int Edad;
    private String ComidaFavorita;

    public Encuestado(String nombres, String genero, int edad, String comidaFavorita) {
        Nombres = nombres;
        Genero = genero;
        Edad = edad;
        ComidaFavorita = comidaFavorita;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getComidaFavorita() {
        return ComidaFavorita;
    }

    public void setComidaFavorita(String comidaFavorita) {
        ComidaFavorita = comidaFavorita;
    }
}
