package com.example.guia03.Model;

public abstract class TrabajadorModel extends PersonaModel {
    protected float sueldoMensual;
    protected float descuentoISR;
    protected float totalDescuentos;
    protected float totalPagar;

    public TrabajadorModel(){
        this.sueldoMensual = 0;
        this.descuentoISR = 0;
        this.totalDescuentos = 0;
        this.totalPagar = 0;
    }

    public TrabajadorModel(String codigo, String nombre, String apellido){
        super(codigo, nombre ,apellido);

        this.sueldoMensual = 0;
        this.descuentoISR = 0;
        this.totalDescuentos = 0;
        this.totalPagar = 0;
    }

    public float getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(float sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    public float getDescuentoISR() {
        return descuentoISR;
    }

    public void setDescuentoISR(float descuentoISR) {
        this.descuentoISR = descuentoISR;
    }

    public float getTotalDescuentos() {
        return totalDescuentos;
    }

    public void setTotalDescuentos(float totalDescuentos) {
        this.totalDescuentos = totalDescuentos;
    }

    public float getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(float totalPagar) {
        this.totalPagar = totalPagar;
    }

    public abstract int getTipoTrabajador();
}
