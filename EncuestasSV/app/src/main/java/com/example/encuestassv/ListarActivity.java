package com.example.encuestassv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.encuestassv.modelo.Persona;

import java.util.ArrayList;

import static com.example.encuestassv.FoodListActivity.personas;

public class ListarActivity extends AppCompatActivity {
    ListView lsvPersonas;
    TextView tvNumber;//TextView cantidad de encuestados
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        if ( getSupportActionBar() != null ) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        tvNumber = (TextView) findViewById(R.id.tvNumber);
        lsvPersonas = (ListView) findViewById(R.id.lsvPersonas);
        ArrayList<String> LstString = new ArrayList<String>();
        int x = personas.size();
        for (int i=0;i<x;i++){
            String s = "Nombre: " + personas.get(i).getName() + " - Genero: " + personas.get(i).getGender() + " - Edad: " + personas.get(i).getAge() + " - Comida Favorita: " + personas.get(i).getFavFood();
            LstString.add(s);
        }
        /*String name = getIntent().getExtras().getString("NAME");
        String gender= getIntent().getExtras().getString("GENDER");
        int edad = getIntent().getExtras().getInt("EDAD");*/
        ArrayAdapter<Persona> adaptadorPersona =
                new ArrayAdapter(ListarActivity.this,
                        android.R.layout.simple_list_item_1,
                        LstString/*personas*/);
        lsvPersonas.setAdapter(adaptadorPersona);
        adaptadorPersona.notifyDataSetChanged();

        //TextView cantidad de encuestados
        int n = lsvPersonas.getAdapter().getCount();
        tvNumber.setText("Cantidad de encuestados: " + n);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}