package com.example.evaluacion1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.location.GnssAntennaInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.evaluacion1.MOdel.Comida;
import com.example.evaluacion1.MOdel.Encuestado;

import java.util.ArrayList;

public class Comidas extends AppCompatActivity {

    String nombre,edad,genero,categoria;
    ListView lsvComida;
    public static ArrayList<Encuestado> encuestados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comidas);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        ArrayList<String> lstFrutas= new ArrayList<>();
        lstFrutas.add("Mango");
        lstFrutas.add("Manzana");
        lstFrutas.add("Sandia");
        lstFrutas.add("Pera");
        ArrayList<String> lstCarne= new ArrayList<>();
        lstCarne.add("Carne asada");
        lstCarne.add("Carne a la plancha");
        lstCarne.add("Bistec de Res");
        lstCarne.add("Filete");
        ArrayList<String> lstEnslada= new ArrayList<>();
        lstEnslada.add("Ensalada rusa");
        lstEnslada.add("Ensalada de codos");
        lstEnslada.add("Ensalada fresca");
        lstEnslada.add("Ensalada simple");
        nombre = getIntent().getStringExtra("Nombre");
        edad = getIntent().getStringExtra("Edad");
        genero = getIntent().getStringExtra("Genero");
        categoria = getIntent().getStringExtra("Categoria");


        if(categoria.equals("Frutas"))
        {
            lsvComida = (ListView) findViewById(R.id.lscomida);
            ArrayAdapter<Comida> adPersona = new ArrayAdapter(Comidas.this, android.R.layout.simple_list_item_1, lstFrutas);
            lsvComida.setAdapter(adPersona);
            adPersona.notifyDataSetChanged();
        }

        if(categoria.equals("Carnes"))
        {
            lsvComida = (ListView) findViewById(R.id.lscomida);
            ArrayAdapter<Comida> adPersona = new ArrayAdapter(Comidas.this, android.R.layout.simple_list_item_1, lstCarne);
            lsvComida.setAdapter(adPersona);
            adPersona.notifyDataSetChanged();
        }


        if(categoria.equals("Ensaladas"))
        {
            lsvComida = (ListView) findViewById(R.id.lscomida);
            ArrayAdapter<Comida> adPersona = new ArrayAdapter(Comidas.this, android.R.layout.simple_list_item_1, lstEnslada);
            lsvComida.setAdapter(adPersona);
            adPersona.notifyDataSetChanged();
        }

        if(encuestados==null){
            encuestados= new ArrayList<Encuestado>();
        }

        lsvComida.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String s = lsvComida.getItemAtPosition(i).toString();

                AlertDialog.Builder builder = new AlertDialog.Builder(Comidas.this);
                builder.setTitle("Confirmacion");
                builder.setMessage("Seguro que deseas elegir: "+ s);
                builder.setPositiveButton("Aceptar",(dialog,wich)->agregar(s));
                builder.setNegativeButton("Cancelar",null );
                AlertDialog dialog = builder.create();
                dialog.show();


            }
        });
    }


    public  void agregar(String platillo)
    {
        /*
        Encuestado e = new Encuestado();
        e.setEdad(Integer.parseInt(edad));
        e.setGenero(genero);
        e.setNombre(nombre);
        e.setPlatilloFavorito(platillo);
        */
        encuestados.add(new Encuestado(nombre,genero,Integer.parseInt(edad),platillo));

        Toast.makeText(Comidas.this, "Registro añadido "+nombre+edad+genero+platillo,
                Toast.LENGTH_LONG).show();
        startActivity(new Intent(Comidas.this, MainActivity.class));
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