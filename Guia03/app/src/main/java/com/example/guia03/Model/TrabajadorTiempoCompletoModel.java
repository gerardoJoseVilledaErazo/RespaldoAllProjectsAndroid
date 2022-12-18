package com.example.guia03.Model;

import com.example.guia03.Utils.Constant;

public class TrabajadorTiempoCompletoModel extends TrabajadorModel{

    private float descuentoISSS;
    private float descuentoAFP;

    public TrabajadorTiempoCompletoModel(){
        this.setDescuentoISSS(0);
        this.setDescuentoAFP(0);
    }

    public TrabajadorTiempoCompletoModel(String codigo,
                                         String nombre,
                                         String apellido,
                                         float sm){

        super(codigo, nombre, apellido);
        super.sueldoMensual = sm;

        calcular();
    }

    @Override
    public int getTipoTrabajador() {
        return 2;
    }

    public float getDescuentoISSS() {
        return descuentoISSS;
    }

    public void setDescuentoISSS(float descuentoISSS) {
        this.descuentoISSS = descuentoISSS;
    }

    public float getDescuentoAFP() {
        return descuentoAFP;
    }

    public void setDescuentoAFP(float descuentoAFP) {
        this.descuentoAFP = descuentoAFP;
    }

    private void calcular(){
        // ISSS
        if(super.sueldoMensual > 0 && super.sueldoMensual <= 1000){
            this.descuentoISSS = super.sueldoMensual * 0.03f;
        } else {
            this.descuentoISSS = Constant.cotizacion_limite_isss;
        }
        // AFP
        if(super.sueldoMensual > 0 && super.sueldoMensual <= 7045.06) {
            this.descuentoAFP = super.sueldoMensual * 0.0725f;
        } else{
            this.descuentoAFP = Constant.cotizacion_limite_afp;
        }

        float ri = super.sueldoMensual - (this.getDescuentoISSS() + this.getDescuentoAFP());
        // ISR
        if(ri > 0 && ri <= 487.60){
            super.descuentoISR = 0;
        } else if (ri > 487.60 && ri <= 642.85){
            super.descuentoISR = 17.48f + (super.sueldoMensual - 487.60f) * 0.10f;
        } else if(ri > 642.85 && ri <= 915.82f){
            super.descuentoISR = 32.70f + (super.sueldoMensual - 642.85f)*0.10f;
        } else if(ri > 915.82 && ri <= 2058.67){
            super.descuentoISR = 60.00f + (super.sueldoMensual - 915.81f)*0.20f;
        } else {
            super.descuentoISR = 288.57f + (super.sueldoMensual - 2058.67f)*0.30f;
        }

        super.totalDescuentos = (this.descuentoAFP + this.descuentoISSS + super.descuentoISR);
        super.totalPagar = super.sueldoMensual - super.totalDescuentos;
    }

//    @Override
//    public String toString() {
//        return super.getCodigo() + " -\t" + super.getNombre() + "  " + super.getApellido() + " -\t" + "Trabajador Tiempo Completo" + " -\t" + super.getTotalPagar();
//    }

    @Override
    public String toString() {
        return super.getCodigo() + " -\t" + super.getNombre() + "  " + super.getApellido() + " -\t\t" + "Trabajador Tiempo Completo" + " -\t\t$" + super.getTotalPagar();
    }
}
