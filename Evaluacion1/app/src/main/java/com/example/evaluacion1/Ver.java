package com.example.evaluacion1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.evaluacion1.Comidas.encuestados;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.evaluacion1.MOdel.Encuestado;

import java.util.ArrayList;

public class Ver extends AppCompatActivity {

    ListView lsvPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);
        ArrayList<String> LstSytring= new ArrayList<String>();

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        for(int i=0;i<encuestados.size();i++)
        {
            String a=encuestados.get(i).getNombre()+" - "+encuestados.get(i).getPlatilloFavorito();

            LstSytring.add(a);
        }


        lsvPersona = (ListView) findViewById(R.id.lsvPersona);

        ArrayAdapter<Encuestado> adPersona = new ArrayAdapter(Ver.this, android.R.layout.simple_list_item_1,LstSytring);
        lsvPersona.setAdapter(adPersona);
        adPersona.notifyDataSetChanged();
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