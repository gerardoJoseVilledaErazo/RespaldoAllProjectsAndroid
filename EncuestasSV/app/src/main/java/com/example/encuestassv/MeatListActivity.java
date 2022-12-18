package com.example.encuestassv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.encuestassv.modelo.Food;
import com.example.encuestassv.modelo.Persona;

import java.util.ArrayList;

public class MeatListActivity extends AppCompatActivity {
    ListView lsvMeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meat_list);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        lsvMeat = (ListView) findViewById(R.id.lsvMeat);
        ArrayList<Food> meat = new ArrayList<>();
/*
        for (int i=0;i<4;i++ ){
            meat.add(new Food("Pollo", "Carne") );
        }*/
        meat.add(new Food("Pollo", "Carne") );
        ArrayAdapter<Persona> adapterMeat = new ArrayAdapter(this, android.R.layout.simple_list_item_1,meat);
        lsvMeat.setAdapter(adapterMeat);
        adapterMeat.notifyDataSetChanged();
    }
    public void Finish(View view){

        Intent intent = new Intent(this, ListarActivity.class);
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