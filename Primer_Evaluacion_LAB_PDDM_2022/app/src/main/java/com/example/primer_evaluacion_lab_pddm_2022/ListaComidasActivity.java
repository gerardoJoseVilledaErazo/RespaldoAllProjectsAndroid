package com.example.primer_evaluacion_lab_pddm_2022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.primer_evaluacion_lab_pddm_2022.Modelos.Comida;
import com.example.primer_evaluacion_lab_pddm_2022.Modelos.Encuestado;

import java.util.ArrayList;

public class ListaComidasActivity extends AppCompatActivity {

    private Button btnGuardar;

    private ProgressBar progressBar;
    boolean isActivo = false;
    int indice = 0;
    Handler h = new Handler();
    TextView tvPorcentaje;
    Intent x;

    ListView lstComidaFavorita;
    String nombre, edad, genero, categoria;

    public static ArrayList<Encuestado> encuestados;
    String comidaFavorita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_comidas);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); /// Unicamente Modo Vertical

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // ******************* Instancias a los componentes graficos *********************
        this.btnGuardar = (Button) findViewById(R.id.btnGuardar);
        this.tvPorcentaje = (TextView) findViewById(R.id.porcentaje);
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar);

        nombre = getIntent().getStringExtra("Nombre");
        edad = getIntent().getStringExtra("Edad");
        genero = getIntent().getStringExtra("Genero");
        categoria = getIntent().getStringExtra("Categoria");

//        ArrayList<String> lstComidas = new ArrayList<>();
//
//        lstComidas.add("Manzana");
//        lstComidas.add("Pera");
//        lstComidas.add("Melocoton");
//
//        lstComidas.add("Carne asada");
//        lstComidas.add("Carne guisada");
//        lstComidas.add("Carne adobada");
//
//        lstComidas.add("Ensalada de papa");
//        lstComidas.add("Ensalada cesar");
//        lstComidas.add("Ensalada fresca");
//
//        lstComidas.subList(0,3);
//
//        lstComidas.subList(3,6);
//
//        lstComidas.subList(6,9);

        ArrayList<String> lstFrutas = new ArrayList<>();
        lstFrutas.add("Manzana");
        lstFrutas.add("Pera");
        lstFrutas.add("Melocoton");

        ArrayList<String> lstCarnes = new ArrayList<>();
        lstCarnes.add("Carne asada");
        lstCarnes.add("Carne guisada");
        lstCarnes.add("Carne adobada");

        ArrayList<String> lstEnsaladas = new ArrayList<>();
        lstEnsaladas.add("Ensalada de papa");
        lstEnsaladas.add("Ensalada cesar");
        lstEnsaladas.add("Ensalada fresca");

        if (categoria.equals("Frutas")){
            lstComidaFavorita = (ListView) findViewById(R.id.lstComidaFavorita);
            ArrayAdapter<Comida> adapterComida = new ArrayAdapter(ListaComidasActivity.this, android.R.layout.simple_list_item_1, lstFrutas);
            lstComidaFavorita.setAdapter(adapterComida);
            adapterComida.notifyDataSetChanged();
        }

        if (categoria.equals("Carnes")){
            lstComidaFavorita = (ListView) findViewById(R.id.lstComidaFavorita);
            ArrayAdapter<Comida> adapterComida = new ArrayAdapter(ListaComidasActivity.this, android.R.layout.simple_list_item_1, lstCarnes);
            lstComidaFavorita.setAdapter(adapterComida);
            adapterComida.notifyDataSetChanged();
        }

        if (categoria.equals("Ensaladas")){
            lstComidaFavorita = (ListView) findViewById(R.id.lstComidaFavorita);
            ArrayAdapter<Comida> adapterComida = new ArrayAdapter(ListaComidasActivity.this, android.R.layout.simple_list_item_1, lstEnsaladas);
            lstComidaFavorita.setAdapter(adapterComida);
            adapterComida.notifyDataSetChanged();
        }

        if (encuestados==null) {
            encuestados = new ArrayList<Encuestado>();
        }

        lstComidaFavorita.setOnItemClickListener((adapterView, view, i, l) -> {

            comidaFavorita = lstComidaFavorita.getItemAtPosition(i).toString(); /// Esto es un String

            new android.app.AlertDialog.Builder(ListaComidasActivity.this).setTitle("Confirmacion")
                    .setMessage("Seguro que desea elegir: "+comidaFavorita)
                    .setPositiveButton("Aceptar", (dialogInterface, i1) -> {
                        agregar(comidaFavorita);
//                        finish();
                    })
                    .setNegativeButton("Cancelar", null)
                    .show();
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (comidaFavorita != null) {

                            Thread hilo = new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    while (indice<100){
                                        /// h es un handler
                                        h.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                tvPorcentaje.setText(indice + " %");
                                                /// ProgressBar
                                                progressBar.setProgress(indice);
                                            }
                                        });
                                        try {
                                            Thread.sleep(10);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        if (indice==100){
                                            /// x es un Intent
//                                            x = new Intent(ListaComidasActivity.this,MainActivity.class);
//                                            startActivity(x);

//                                            new AlertDialog.Builder(ListaComidasActivity.this).setTitle("¡Registro Exitoso!")
//                                                    .setMessage("Registro agregado con éxito")
//                                                    .setPositiveButton("Ok", (dialogInterface, i) -> {
////                                                        startActivity(new Intent(ListaComidasActivity.this, MainActivity.class)); /// **********
//                                                    }).show();
//                                            startActivity(new Intent(ListaComidasActivity.this, MainActivity.class)); /// **********

                                        }
                                        indice++;
                                        isActivo=true;
                                    }
                                }
                            });
                            Toast.makeText(ListaComidasActivity.this,"Guardado con éxito",Toast.LENGTH_SHORT).show();

                                            new AlertDialog.Builder(ListaComidasActivity.this).setTitle("¡Registro Exitoso!")
                                                    .setMessage("Registro agregado con éxito")
                                                    .setPositiveButton("Ok", (dialogInterface, i) -> {
                                                        startActivity(new Intent(ListaComidasActivity.this, MainActivity.class)); /// **********
                                                    }).show();
                            //Thread
                            hilo.start();





//                                if(v.getId()==R.id.btnGuardar){
//                                    /// isActivo comienza en false
//                                    if(!isActivo){                 //Si -> No es falso = es verdadero
//
//                                        Thread hilo = new Thread(new Runnable() {
//                                            @Override
//                                            public void run() {
//                                                while (indice<=100){
//                                                    /// h es un handler
//                                                    h.post(new Runnable() {
//                                                        @Override
//                                                        public void run() {
//                                                            //t es un textview
//                                                            t.setText(indice + " %");
//                                                            /// ProgressBar
//                                                            progressBar.setProgress(indice);
//                                                        }
//                                                    });
//                                                    try {
//                                                        Thread.sleep(10);
//                                                    } catch (InterruptedException e) {
//                                                        e.printStackTrace();
//                                                    }
//                                                    if (indice==100){
//                                                        /// x es un Intent
//                                                        x = new Intent(ListaComidasActivity.this,MainActivity.class);
//                                                        startActivity(x);
//                                                    }
//                                                    indice++;
//                                                    isActivo=true;
//                                                }
//                                            }
//                                        });
//                                        Toast.makeText(ListaComidasActivity.this,"Guardado con éxito",Toast.LENGTH_SHORT).show();
//                                        //Thread
//                                        hilo.start();
//                                    }
//                                }

/*
                    new AlertDialog.Builder(ListaComidasActivity.this).setTitle("¡Registro Exitoso!")
                            .setMessage("Registro agregado con éxito")
                            .setPositiveButton("Ok", (dialogInterface, i) -> {
                                startActivity(new Intent(ListaComidasActivity.this, MainActivity.class)); /// **********
                            }).show();
                    */
//                    startActivity(new Intent(ListaComidasActivity.this, MainActivity.class));


//
//                    /// isActivo comienza en false
//                    if(!isActivo){                //Si -> No es falso = es verdadero
//                        Thread hilo = new Thread(new Runnable() {
//                            @Override
//                            public void run() {
//                                while (indice<=100){
//                                    /// h es un handler
//                                    h.post(new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            //t es un textview
//                                            t.setText(indice + " %");
//                                            /// ProgressBar
//                                            progressBar.setProgress(indice);
//                                        }
//                                    });
//                                    try {
//                                        Thread.sleep(10);
//                                    } catch (InterruptedException e) {
//                                        e.printStackTrace();
//                                    }
//                                    if (indice==100){
//                                        /// x es un Intent
//                                        x = new Intent(ListaComidasActivity.this,MainActivity.class);
//                                        startActivity(x);
//                                    }
//                                    indice++;
//                                    isActivo=true;
//                                }
//                            }
//                        });
//                        Toast.makeText(ListaComidasActivity.this,"Guardado con éxito",Toast.LENGTH_SHORT).show();
//                        //Thread
//                        hilo.start();
//                    }


                } else {
                    new AlertDialog.Builder(ListaComidasActivity.this).setTitle("¡Aviso!")
                            .setMessage("Seleccione una opción.")
                            .setPositiveButton("Ok", (dialogInterface, i) -> {

                            }).show();
                }
//                startActivity(new Intent(ListaComidasActivity.this, MainActivity.class));
//                startActivity(new Intent(ListaComidasActivity.this, MostrarListaActivity.class));

            }
        });
    }

    public void agregar(String comidaFavorita){
        encuestados.add(new Encuestado(nombre,genero,Integer.parseInt(edad),comidaFavorita));
        Toast.makeText(ListaComidasActivity.this,"Presione Guardar. Para Registrar: "+nombre+" - "+edad+" - "+genero+" - "+comidaFavorita+".",Toast.LENGTH_LONG).show();
//        startActivity(new Intent(ListaComidasActivity.this, MainActivity.class));
//        startActivity(new Intent(ListaComidasActivity.this, MostrarListaActivity.class));
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