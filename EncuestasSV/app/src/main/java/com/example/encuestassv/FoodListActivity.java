package com.example.encuestassv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.encuestassv.modelo.Food;
import com.example.encuestassv.modelo.Persona;

import java.util.ArrayList;

public class FoodListActivity extends AppCompatActivity {

    String name,gender,category;
    int edad;
    ListView lsvFood;
    public static ArrayList<Persona> personas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ArrayList<String> lstFrutas= new ArrayList<>();
        lstFrutas.add("Coco");
        lstFrutas.add("Kiwi");
        lstFrutas.add("Fresa");
        lstFrutas.add("Melon");
        ArrayList<String> lstCarne= new ArrayList<>();
        lstCarne.add("Carne asada");
        lstCarne.add("Carne guisada");
        lstCarne.add("Bistec de Res");
        lstCarne.add("Carne blanca");
        ArrayList<String> lstEnslada= new ArrayList<>();
        lstEnslada.add("Ensalada rusa");
        lstEnslada.add("Ensalada de coditos");
        lstEnslada.add("Ensalada campero");
        lstEnslada.add("Ensalada fresca");
        lstEnslada.add("Ensalada cesar");

        name = getIntent().getExtras().getString("NAME");
        gender= getIntent().getExtras().getString("GENDER");
        edad = getIntent().getExtras().getInt("EDAD");
        category = getIntent().getExtras().getString("CATEGORY");

        if(category.equals("Frutas"))
        {
            lsvFood = (ListView) findViewById(R.id.lsvFood);
            ArrayAdapter<Food> adaptadorPersona = new ArrayAdapter(FoodListActivity.this,
                    android.R.layout.simple_list_item_1, lstFrutas);
            lsvFood.setAdapter(adaptadorPersona);
            adaptadorPersona.notifyDataSetChanged();
        }

        if(category.equals("Carnes"))
        {
            lsvFood = (ListView) findViewById(R.id.lsvFood);
            ArrayAdapter<Food> adaptadorPersona = new ArrayAdapter(FoodListActivity.this,
                    android.R.layout.simple_list_item_1, lstCarne);
            lsvFood.setAdapter(adaptadorPersona);
            adaptadorPersona.notifyDataSetChanged();
        }

        if(category.equals("Ensaladas"))
        {
            lsvFood = (ListView) findViewById(R.id.lsvFood);
            ArrayAdapter<Food> adaptadorPersona = new ArrayAdapter(FoodListActivity.this,
                    android.R.layout.simple_list_item_1, lstEnslada);
            lsvFood.setAdapter(adaptadorPersona);
            adaptadorPersona.notifyDataSetChanged();
        }

        if(personas == null ){
            personas = new ArrayList<Persona>();
        }
        lsvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String s = lsvFood.getItemAtPosition(i).toString();

                AlertDialog.Builder builder = new AlertDialog.Builder(FoodListActivity.this);
                builder.setTitle("Confirmacion");
                builder.setMessage("Esta seguro que desea seleccionar esa opción?: "+ s);
                builder.setPositiveButton("Aceptar",(dialog,wich)->agregar(s));
                builder.setNegativeButton("Cancelar",null );
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    public  void agregar(String favFood)
    {
        personas.add(new Persona(name,gender,edad,favFood));

        Toast.makeText(FoodListActivity.this,
                "Registro añadido: " + name +" "+ gender +" "+ edad +" "+ favFood,
                Toast.LENGTH_SHORT).show();
        //startActivity(new Intent(FoodListActivity.this, MainActivity.class));
    }

    public void Finish(View view){
        //Intent intent = new Intent(this, ListarActivity.class);
        Intent intent = new Intent(FoodListActivity.this, MainActivity.class);
        startActivity(intent);
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