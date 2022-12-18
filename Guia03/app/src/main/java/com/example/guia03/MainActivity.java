package com.example.guia03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

//import com.example.guia03.Repository.TrabajadorRepository;
import com.example.guia03.Model.TrabajadorTiempoCompletoModel;
import static com.example.guia03.TrabajadorTiempoCompletoActivity.trabajadorRepositoryTC;

import com.example.guia03.Model.TrabajadorHoraModel;
import static com.example.guia03.TrabajadorHoraActivity.trabajadorRepositoryTH;

import java.util.ArrayList;
//import static com.example.guia03.TrabajadorHoraActivity.trabajadorRepositoryTH;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAgregarTrabajador, btnMostrarLista, btnAcercade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(trabajadorRepositoryTC==null){
            trabajadorRepositoryTC= new ArrayList<TrabajadorTiempoCompletoModel>();
        }

        if(trabajadorRepositoryTH==null){
            trabajadorRepositoryTH= new ArrayList<TrabajadorHoraModel>();
        }

        btnAgregarTrabajador = findViewById(R.id.btnAgregarTrabajador);
        btnAgregarTrabajador.setOnClickListener(this);

        btnMostrarLista = findViewById(R.id.btnMostrarLista);
        btnMostrarLista.setOnClickListener(this);

        btnAcercade = findViewById(R.id.btnAcercade);
        btnAcercade.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAgregarTrabajador: {
                startActivity(new Intent(MainActivity.this, SeleccionarTrabajadorActivity.class));
            }break;
            case R.id.btnMostrarLista: {

                if (trabajadorRepositoryTC.isEmpty() == false || trabajadorRepositoryTH.isEmpty() == false) {
                    startActivity(new Intent(MainActivity.this, MostrarListaActivity.class));
                } else {
                    new AlertDialog.Builder(MainActivity.this).setTitle("¡Aviso!")
                            .setMessage("Lista de trabajadores se encuentra vacía.")
                            .setPositiveButton("Ok", (dialogInterface, i) -> {

                            }).show();
                }

            }break;
            case R.id.btnAcercade: {
                startActivity(new Intent(MainActivity.this, DatosActivity.class));
            }break;
        }
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