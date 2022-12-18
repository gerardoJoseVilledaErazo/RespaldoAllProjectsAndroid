package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.M.E;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {
    ListView le;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        le = findViewById(R.id.listview2);
        ArrayList<String> l = new ArrayList<String>();
        for (int i=0; i<e.size();i++) {
            String encuestado = e.get(i).getNombres()+" - "+e.get(i).getComidaFavorita();
            l.add(encuestado);
        }
        ArrayAdapter<E> adapterEncuestado = new ArrayAdapter(MainActivity5.this, android.R.layout.simple_list_item_1,l);
        le.setAdapter(adapterEncuestado);
    }
}