package com.example.registroapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class CapturaActivity extends AppCompatActivity {

    private TextView tv_nombre,tv_direccion,tv_dui,tv_fecha_nacimiento,tv_genero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captura);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        tv_nombre = (TextView)findViewById(R.id.tv_nombre);
        tv_direccion = (TextView)findViewById(R.id.tv_direccion);
        tv_dui = (TextView)findViewById(R.id.tv_dui);
        tv_fecha_nacimiento = (TextView)findViewById(R.id.tv_fecha_nacimiento);
        tv_genero = (TextView)findViewById(R.id.tv_genero);

        Bundle i = getIntent().getExtras();
        String nombre = i.getString("nombre");
        tv_nombre.setText("Hola "+nombre);

        String direccion = i.getString("direccion");
        tv_direccion.setText(direccion);

        String dui = i.getString("dui");
        tv_dui.setText(dui);

        String fecha_nacimiento = i.getString("fecha_nacimiento");
        tv_fecha_nacimiento.setText(fecha_nacimiento);

        String genero = getIntent().getStringExtra("genero");
        tv_genero.setText(genero);
    }

    // Metodo para el boton Regresar
    public void Regresar(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}