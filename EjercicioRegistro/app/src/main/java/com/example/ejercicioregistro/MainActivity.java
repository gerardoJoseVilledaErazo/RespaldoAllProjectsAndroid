package com.example.ejercicioregistro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText edtNombre, edtGenero, edtEdad, edtDireccion;

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNombre = (EditText) findViewById(R.id.edtNombre);
        edtGenero = (EditText) findViewById(R.id.edtGenero);
        edtEdad = (EditText) findViewById(R.id.edtEdad);
        edtDireccion = (EditText) findViewById(R.id.edtDireccion);
        tv = findViewById(R.id.tv);

    }
    public void Cancelar(View view){
        edtNombre.setText("");
        edtGenero.setText("");
        edtEdad.setText("");
        edtDireccion.setText("");
    }
    public void Registrar(View view){
            // Envio de parametros a otra vista
            String nombre = edtNombre.getText().toString();
            int edad = Integer.parseInt(String.valueOf(edtEdad.getText()));
        if (edad>=18){
            tv.setText("BIENVENIDO "+nombre);
        } else {
            tv.setText("Usted es menor de edad. No se puede registrar");
        }

    }
}