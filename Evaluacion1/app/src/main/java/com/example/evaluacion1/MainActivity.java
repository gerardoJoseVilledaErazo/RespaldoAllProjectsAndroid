package com.example.evaluacion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Verdatos(View view)
    {
        startActivity(new Intent(MainActivity.this, Datos.class));
    }
    public void regitrar(View view)
    {
        startActivity(new Intent(MainActivity.this, Registrar.class));
    }
    public void ver(View view)
    {
        startActivity(new Intent(MainActivity.this, Ver.class));
    }
}