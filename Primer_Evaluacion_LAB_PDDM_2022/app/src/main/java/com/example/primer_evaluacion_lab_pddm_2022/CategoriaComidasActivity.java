package com.example.primer_evaluacion_lab_pddm_2022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CategoriaComidasActivity extends AppCompatActivity {

    private Button btnSiguiente2;
    String nombre, edad, genero;
    RadioGroup rgCategorias;
    RadioButton rbCategoriaSeleccionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_comidas);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); /// Unicamente Modo Vertical

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        this.btnSiguiente2 = (Button) findViewById(R.id.btnSiguiente2);

        nombre = getIntent().getStringExtra("Nombre");
        edad = getIntent().getStringExtra("Edad");
        genero = getIntent().getStringExtra("Genero");

        rgCategorias = findViewById(R.id.rgCategorias);


        btnSiguiente2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id = rgCategorias.getCheckedRadioButtonId();
                rbCategoriaSeleccionada = (RadioButton) findViewById(id);

                if (id>0) {
                    Intent intent = new Intent(CategoriaComidasActivity.this, ListaComidasActivity.class);
                    intent.putExtra("Nombre", nombre);
                    intent.putExtra("Edad", edad);
                    intent.putExtra("Genero", genero);
                    intent.putExtra("Categoria", rbCategoriaSeleccionada.getText().toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(CategoriaComidasActivity.this, "Seleccione una categoria!",
                            Toast.LENGTH_LONG).show();
                }
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