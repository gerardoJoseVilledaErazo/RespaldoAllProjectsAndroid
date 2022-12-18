package com.example.guia03.Model;

public class TrabajadorHoraModel extends TrabajadorModel{
    private int numHoras;
    private float valorHoras;

    public TrabajadorHoraModel(){
        this.numHoras = 0;
        this.valorHoras = 0;
    }

    public TrabajadorHoraModel(String codigo, String nombre, String apellido, int nh, float vh){

        super(codigo,nombre,apellido);
        this.numHoras = nh;
        this.valorHoras = vh;
        super.sueldoMensual = this.numHoras * this.valorHoras;
        super.descuentoISR = super.sueldoMensual * 0.1f;
        super.totalDescuentos = super.descuentoISR;
        super.totalPagar = super.sueldoMensual - super.totalDescuentos;
    }

    @Override
    public int getTipoTrabajador() {
        return 1;
    }

    public int getNumHoras() {
        return numHoras;
    }

    public void setNumHoras(int numHoras) {
        this.numHoras = numHoras;
    }

    public float getValorHoras() {
        return valorHoras;
    }

    public void setValorHoras(float valorHoras) {
        this.valorHoras = valorHoras;
    }

//    @Override
//    public String toString() {
//        return super.getCodigo() + " -\t" + super.getNombre() + "  " + super.getApellido() + " -\t" + "Trabajador hora" + " -\t" + super.getTotalPagar();
//    }

    @Override
    public String toString() {
        return super.getCodigo() + " -\t" + super.getNombre() + "  " + super.getApellido() + " -\t\t" + "Trabajador hora" + " -\t\t$" + super.getTotalPagar();
    }
}
