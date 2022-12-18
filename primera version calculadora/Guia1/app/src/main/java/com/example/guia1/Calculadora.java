package com.example.guia1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class Calculadora extends AppCompatActivity {
    TextView tvResultado;
    float numero1 = 0.0f;
    float numero2 = 0.0f;
    String operacion = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        tvResultado = findViewById(R.id.tvResultado);

        tvResultado.setFocusable(true);
        tvResultado.setFocusableInTouchMode(true);
        tvResultado.setInputType(InputType.TYPE_NULL);
    }


    public void EscribirCero(View view) {
        tvResultado.setText(tvResultado.getText() + "0");
        /*
        float valor = Float.parseFloat(tvResultado.getText().toString());
        if(valor == 0.0f){
            tvResultado.setText("0");
        }else{
            tvResultado.setText(tvResultado.getText() + "0");
        }*/
    }

    public void EscribirUno(View view) {
        tvResultado.setText(tvResultado.getText() + "1");/*
        float valor = Float.parseFloat(tvResultado.getText().toString());
        if(valor == 0.0f){
            tvResultado.setText("1");
        }else{
            tvResultado.setText(tvResultado.getText() + "1");
        }*/
    }

    public void EscribirDos(View view) {
        tvResultado.setText(tvResultado.getText() + "2");/*
        float valor = Float.parseFloat(tvResultado.getText().toString());
        if(valor == 0.0f){
            tvResultado.setText("2");
        }else{
            tvResultado.setText(tvResultado.getText() + "2");
        }*/
    }

    public void EscribirTres(View view) {
        tvResultado.setText(tvResultado.getText() + "3");/*
        float valor = Float.parseFloat(tvResultado.getText().toString());
        if(valor == 0.0f){
            tvResultado.setText("3");
        }else{
            tvResultado.setText(tvResultado.getText() + "3");
        }*/
    }

    public void EscribirCuatro(View view) {
        tvResultado.setText(tvResultado.getText() + "4");/*
        float valor = Float.parseFloat(tvResultado.getText().toString());
        if(valor == 0.0f){
            tvResultado.setText("4");
        }else{
            tvResultado.setText(tvResultado.getText() + "4");
        }*/
    }

    public void EscribirCinco(View view) {
        tvResultado.setText(tvResultado.getText() + "5");/*
        float valor = Float.parseFloat(tvResultado.getText().toString());
        if(valor == 0.0f){
            tvResultado.setText("5");
        }else{
            tvResultado.setText(tvResultado.getText() + "5");
        }*/
    }

    public void EscribirSeis(View view) {
        tvResultado.setText(tvResultado.getText() + "6");/*
        float valor = Float.parseFloat(tvResultado.getText().toString());
        if(valor == 0.0f){
            tvResultado.setText("6");
        }else{
            tvResultado.setText(tvResultado.getText() + "6");
        }*/
    }

    public void EscribirSiete(View view) {
        tvResultado.setText(tvResultado.getText() + "7");/*
        float valor = Float.parseFloat(tvResultado.getText().toString());
        if(valor == 0.0f){
            tvResultado.setText("7");
        }else{
            tvResultado.setText(tvResultado.getText() + "7");
        }*/
    }

    public void EscribirOcho(View view) {
        tvResultado.setText(tvResultado.getText() + "8");/*
        float valor = Float.parseFloat(tvResultado.getText().toString());
        if(valor == 0.0f){
            tvResultado.setText("8");
        }else{
            tvResultado.setText(tvResultado.getText() + "8");
        }*/
    }

    public void EscribirNueve(View view) {
        tvResultado.setText(tvResultado.getText() + "9");
        /*
        float valor = Float.parseFloat(tvResultado.getText().toString());

        if(valor == 0.0f){
            tvResultado.setText("9");
        }else{
            tvResultado.setText(tvResultado.getText() + "9");
        }*/
    }

    //AC
    public void LimpiarResultado(View view) {
        numero1 = 0.0f;
        numero2 = 0.0f;
        operacion = "";
        tvResultado.setText("0");
    }

    //DEL
    public void DEL(View view){
        String textAnterior = tvResultado.getText().toString();
        if(textAnterior.length() > 0) {
            String nuevaOperacion = textAnterior.substring(0, textAnterior.length() - 1);
            tvResultado.setText(nuevaOperacion);
        }
    }

    //Porcentaje de un numero
    public void OperacionPorcentaje(View view) {
        numero1 = Float.parseFloat(String.valueOf(tvResultado.getText()));
        operacion = "%";
        tvResultado.setText("0");
    }

    //Operaciones
    public void OperacionDividir(View view) {
        numero1 = Float.parseFloat(String.valueOf(tvResultado.getText()));
        operacion = "/";
        tvResultado.setText("0");
    }

    public void OperacionMulti(View view) {
        numero1 = Float.parseFloat(String.valueOf(tvResultado.getText()));
        operacion = "*";
        tvResultado.setText("0");
    }

    public void OperacionMenos(View view) {
        numero1 = Float.parseFloat(String.valueOf(tvResultado.getText()));
        operacion = "-";
        tvResultado.setText("0");
    }

    public void OperacionMas(View view) {
        numero1 = Float.parseFloat(String.valueOf(tvResultado.getText()));
        operacion = "+";
        tvResultado.setText("0");
    }

    //Escribir Punto
    public void EscribirPunto(View view) {
        if( !String.valueOf(tvResultado.getText()).contains(".") ){
            tvResultado.setText(tvResultado.getText() + ".");
        }
    }

    //Cambio de signo
    public void CambioSigno(View view) {
        float valor = Float.parseFloat(String.valueOf(tvResultado.getText()));
        valor = valor * -1.0f;
        tvResultado.setText("" + valor);
    }

    //Igual
    public void MostrarResultado(View view) {
        numero2 = Float.parseFloat(String.valueOf(tvResultado.getText()));

        float result = 0.0f;

        if(operacion.equals("%")){
            result = (numero1 / 100.0f) * numero2;
        }else if(operacion.equals("/")){
            if(numero2 != 0.0f){
                result = numero1 / numero2;
            }else{
                result = 0.0f;
                Toast.makeText(this, "OPERACION NO VALIDA", Toast.LENGTH_LONG).show();
            }
        }else if(operacion.equals("*")){
            result = numero1 * numero2;
        }else if(operacion.equals("-")){
            result = numero1 - numero2;
        }else if(operacion.equals("+")){
            result = numero1 + numero2;
        }

        tvResultado.setText(result + "");
        numero1 = 0.0f;
        numero2 = 0.0f;
        operacion = "";
    }
}