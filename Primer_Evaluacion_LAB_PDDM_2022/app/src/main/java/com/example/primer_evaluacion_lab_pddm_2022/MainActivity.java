package com.example.primer_evaluacion_lab_pddm_2022;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.primer_evaluacion_lab_pddm_2022.Modelos.Encuestado;
import static com.example.primer_evaluacion_lab_pddm_2022.ListaComidasActivity.encuestados;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAgregarEncuesta, btnMostrarLista, btnAcercade, btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(encuestados==null){
            encuestados= new ArrayList<Encuestado>();
        }


        // ******************* Instancias a los componentes graficos *********************
        this.btnAgregarEncuesta = (Button) findViewById(R.id.btnAgregarEncuesta);
        btnAgregarEncuesta.setOnClickListener(this);

        this.btnMostrarLista = (Button) findViewById(R.id.btnMostrarLista);
        btnMostrarLista.setOnClickListener(this);

        this.btnAcercade = (Button) findViewById(R.id.btnAcercade);
        btnAcercade.setOnClickListener(this);

        this.btnSalir = (Button) findViewById(R.id.btnSalir);
        btnSalir.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAgregarEncuesta: {
                startActivity(new Intent(MainActivity.this, SolicitarDatosActivity.class));
            }break;
            case R.id.btnMostrarLista: {
                if (encuestados.isEmpty() == false) {
                    startActivity(new Intent(MainActivity.this, MostrarListaActivity.class));
                } else {
                    new AlertDialog.Builder(MainActivity.this).setTitle("¡Aviso!")
                            .setMessage("Lista de encuestados se encuentra vacía.")
                            .setPositiveButton("Ok", (dialogInterface, i) -> {

                            }).show();
                }

            }break;
            case R.id.btnAcercade: {
                startActivity(new Intent(MainActivity.this, DatosActivity.class));
            }break;
            case R.id.btnSalir: {
                //
                finish();
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