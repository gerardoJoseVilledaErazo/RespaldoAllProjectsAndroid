package com.example.evaluacion1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Categoria extends AppCompatActivity {
    TextView messege;
    String nombre;
    String edad;
    String genero;
    RadioGroup categorias;
    RadioButton cat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        nombre=getIntent().getStringExtra("Nombre");
         edad=getIntent().getStringExtra("Edad");
         genero=getIntent().getStringExtra("Genero");
        messege= (TextView) findViewById(R.id.txvCategorias);
        categorias=(RadioGroup) findViewById(R.id.rdgCategorias);
        messege.setText("Bienvenido "+nombre+", Elige una categoria de comida");


        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
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



    public void continuar(View view)
    {
        int id= categorias.getCheckedRadioButtonId();
        cat=(RadioButton) findViewById(id);

        if(categorias.getCheckedRadioButtonId()==-1)
        {
            Toast.makeText(Categoria.this, "Rellene los campos para seguir!",
                    Toast.LENGTH_LONG).show();
        }
        else{
            Intent i = new Intent(Categoria.this,Comidas.class);
            i.putExtra("Nombre",nombre);
            i.putExtra("Edad",edad);
            i.putExtra("Genero",genero);
            i.putExtra("Categoria",cat.getText().toString());
            startActivity(i);
        }


    }




}