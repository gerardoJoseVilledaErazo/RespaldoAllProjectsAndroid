package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.M.C;
import com.example.myapplication.M.E;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {
    private Button button4;
    ListView lcf;
    String nombre, edad, genero, categoria;
    public static ArrayList<E> e;
    String cf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        this.button4 =  findViewById(R.id.button4);
        nombre = getIntent().getStringExtra("Nombre");
        edad = getIntent().getStringExtra("Edad");
        genero = getIntent().getStringExtra("Genero");
        categoria = getIntent().getStringExtra("Categoria");
        ArrayList<String> f = new ArrayList<>();
        f.add("a");
        f.add("b");
        f.add("c");
        ArrayList<String> c = new ArrayList<>();
        c.add("x");
        c.add("y");
        c.add("z");
        ArrayList<String> e = new ArrayList<>();
        e.add("a");
        e.add("b");
        e.add("c");
        if (categoria.equals("Frutas")){
            lcf =  findViewById(R.id.listview);
            ArrayAdapter<C> adapterComida = new ArrayAdapter(MainActivity4.this, android.R.layout.simple_list_item_1, f);
            lcf.setAdapter(adapterComida);
        }
        if (categoria.equals("Carnes")){
            lcf =  findViewById(R.id.listview);
            ArrayAdapter<C> adapterComida = new ArrayAdapter(MainActivity4.this, android.R.layout.simple_list_item_1, c);
            lcf.setAdapter(adapterComida);
        }
        if (categoria.equals("Ensaladas")){
            lcf = findViewById(R.id.listview);
            ArrayAdapter<C> adapterComida = new ArrayAdapter(MainActivity4.this, android.R.layout.simple_list_item_1, e);
            lcf.setAdapter(adapterComida);
        }
        lcf.setOnItemClickListener((adapterView, view, i, l) -> {
            cf = lcf.getItemAtPosition(i).toString();
            new android.app.AlertDialog.Builder(MainActivity4.this).setTitle("c")                    .setMessage("S")                    .setPositiveButton("OK", (dialogInterface, i1) -> {
                        a(cf);
                    })
                    .setNegativeButton("Cancelar", null)                    .show();
        });
        button4.setOnClickListener(v -> new AlertDialog.Builder(MainActivity4.this).setTitle("r").setMessage("a").setPositiveButton("Ok", (dialogInterface, i) -> {
                    startActivity(new Intent(MainActivity4.this, MainActivity.class));
                }).show());
    }
    public void a(String comidaFavorita){
        e.add(new E(nombre,genero,Integer.parseInt(edad),comidaFavorita));
    }
}