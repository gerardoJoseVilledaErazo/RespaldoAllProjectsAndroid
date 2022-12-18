package com.example.sesion2;

import static com.example.sesion2.RegistrarActivity.superHeroe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sesion2.model.SuperHeroe;

public class ListarActivity extends AppCompatActivity {

    ListView lsvHeroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        if ( getSupportActionBar() != null ) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        lsvHeroes = findViewById(R.id.lsvHeroes);

        ArrayAdapter<SuperHeroe> adaptadorHeroe = new ArrayAdapter(this, android.R.layout.simple_list_item_1, superHeroe);

        lsvHeroes.setAdapter(adaptadorHeroe);

        adaptadorHeroe.notifyDataSetChanged();
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