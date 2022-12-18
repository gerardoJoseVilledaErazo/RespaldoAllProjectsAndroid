package com.example.guia03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import static com.example.guia03.TrabajadorTiempoCompletoActivity.trabajadorRepositoryTC;
import static com.example.guia03.TrabajadorHoraActivity.trabajadorRepositoryTH;

import com.example.guia03.Model.TrabajadorModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MostrarListaActivity extends AppCompatActivity {

    FloatingActionButton btnNuevoTrabajador;

    private ListView lstVistaTrabajadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_lista);
        if ( getSupportActionBar() != null ) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        this.btnNuevoTrabajador =(FloatingActionButton)findViewById(R.id.btnNuevoTrabajador);

        ArrayList<String> LstString= new ArrayList<String>();

        for(int i=0;i<trabajadorRepositoryTC.size();i++)
        {
            String tc=trabajadorRepositoryTC.get(i).getCodigo()+" - "+trabajadorRepositoryTC.get(i).getNombre()+" - "+trabajadorRepositoryTC.get(i).getApellido()+" -\t\t "+"Trabajador Tiempo Completo" + " -\t\t$" +trabajadorRepositoryTC.get(i).getTotalPagar();

            LstString.add(tc);
        }

        for(int j=0;j<trabajadorRepositoryTH.size();j++)
        {
            String th=trabajadorRepositoryTH.get(j).getCodigo()+" - "+trabajadorRepositoryTH.get(j).getNombre()+" - "+trabajadorRepositoryTH.get(j).getApellido()+" -\t\t "+"Trabajador hora" + " -\t\t$" +trabajadorRepositoryTH.get(j).getTotalPagar();

            LstString.add(th);
        }

        this.lstVistaTrabajadores = (ListView) findViewById(R.id.lsvTrabajadores);

        ArrayAdapter<TrabajadorModel> adapterTrabajador = new ArrayAdapter(MostrarListaActivity.this, android.R.layout.simple_list_item_1,LstString);
        lstVistaTrabajadores.setAdapter(adapterTrabajador);
        adapterTrabajador.notifyDataSetChanged();


        // Eventos
        this.btnNuevoTrabajador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MostrarListaActivity.this, SeleccionarTrabajadorActivity.class));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
            }break;
        }
        return true;
    }
}