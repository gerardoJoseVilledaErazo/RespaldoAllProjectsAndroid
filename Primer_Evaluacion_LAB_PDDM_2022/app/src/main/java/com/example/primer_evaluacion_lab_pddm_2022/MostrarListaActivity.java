package com.example.primer_evaluacion_lab_pddm_2022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import static com.example.primer_evaluacion_lab_pddm_2022.ListaComidasActivity.encuestados;

import com.example.primer_evaluacion_lab_pddm_2022.Modelos.Encuestado;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MostrarListaActivity extends AppCompatActivity {

    ListView lstEncuestados;

    FloatingActionButton btnNuevoEncuestado;
    
    String listado_a_eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_lista);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); /// Unicamente Modo Vertical

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        lstEncuestados = (ListView) findViewById(R.id.lstEncuestados);

        this.btnNuevoEncuestado =(FloatingActionButton)findViewById(R.id.btnNuevoEncuestado);

        ArrayList<String> listado = new ArrayList<String>();

        for (int i=0; i<encuestados.size();i++) {
            String encuestado = encuestados.get(i).getNombres()+" - "+encuestados.get(i).getComidaFavorita();
            listado.add(encuestado);
        }

        ArrayAdapter<Encuestado> adapterEncuestado = new ArrayAdapter(MostrarListaActivity.this, android.R.layout.simple_list_item_1,listado);
        lstEncuestados.setAdapter(adapterEncuestado);
        adapterEncuestado.notifyDataSetChanged();



        lstEncuestados.setOnItemClickListener((adapterView, view, i, l) -> {

            listado_a_eliminar = lstEncuestados.getItemAtPosition(i).toString(); /// Esto es un String

            new AlertDialog.Builder(MostrarListaActivity.this)
                    .setTitle("Confirmacion")
                    .setMessage("Esta seguro que desea eliminar: "+listado_a_eliminar)
                    .setPositiveButton("Aceptar", (dialogInterface, i1) -> {
//                        @Override
//                        public void OnClick(DialogInterface dialogInterface, int i2){
//                            lstEncuestados.remove(i);
//                        }
                        encuestados.remove(i);
                        finish();
                        startActivity(getIntent());
                    })
                    .setNegativeButton("Cancelar", null)
                    .show();
        });



        // Eventos
        this.btnNuevoEncuestado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MostrarListaActivity.this, SolicitarDatosActivity.class));
            }
        });
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

    @Override
    protected void onStart() {
        super.onStart();
//        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show();
        // La actividad está a punto de hacerse visible.
    }
    @Override
    protected void onResume() {
        super.onResume();
//        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();
        // La actividad se ha vuelto visible (ahora se "reanuda").
    }
    @Override
    protected void onPause() {
        super.onPause();
//        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
        // Enfocarse en otra actividad  (esta actividad está a punto de ser "detenida").
    }
    @Override
    protected void onStop() {
        super.onStop();
//        Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show();
        // La actividad ya no es visible (ahora está "detenida")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();
        // La actividad está a punto de ser destruida.
    }
}