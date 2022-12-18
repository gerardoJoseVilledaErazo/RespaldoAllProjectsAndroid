package com.example.encuestassv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import static com.example.encuestassv.FoodListActivity.personas;

public class MainActivity extends AppCompatActivity {
    Button btnAgregar, btnListar, btnMostrarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnListar = findViewById(R.id.btnVerLista);
        btnMostrarDatos = findViewById(R.id.btnMostrarDatos);
    }
    public void agregarEncuesta(View view){
        startActivity(new Intent(MainActivity.this, RegistrarActivity.class));

    }

    public void verLista(View view){
        if(!personas.isEmpty()){
            startActivity(new Intent(MainActivity.this, ListarActivity.class));

        }else{
            Toast.makeText(this,"Lista vacia.", Toast.LENGTH_SHORT).show();

        }
    }

    //Ver datos
    public void mostrarDatos(View view){
        startActivity(new Intent(MainActivity.this, MostrarActivity.class));

    }
}