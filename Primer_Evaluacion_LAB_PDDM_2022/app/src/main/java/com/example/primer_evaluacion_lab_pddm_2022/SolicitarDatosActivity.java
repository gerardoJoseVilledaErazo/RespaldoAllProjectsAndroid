package com.example.primer_evaluacion_lab_pddm_2022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.primer_evaluacion_lab_pddm_2022.Utiles.UtilesVerificaciones;

public class SolicitarDatosActivity extends AppCompatActivity {

    private EditText edtNombres, edtEdad;
    RadioGroup rgGenero;
    RadioButton rbGeneroSeleccionado;
    private Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_datos);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); /// Unicamente Modo Vertical

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // ******************* Instancias a los componentes graficos *********************
        this.edtNombres = (EditText) findViewById(R.id.edtNombres);
        this.rgGenero = (RadioGroup) findViewById(R.id.rgGenero);
        this.edtEdad = (EditText) findViewById(R.id.edtEdad);
        this.btnSiguiente = (Button) findViewById(R.id.btnSiguiente);


        int id=rgGenero.getCheckedRadioButtonId();

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (UtilesVerificaciones.verificaTextPersonName(edtNombres) &&
                        UtilesVerificaciones.verificaVacio(edtEdad)
//                        UtilesVerificaciones.estaCheckeado(rgGenero)
//                        id>0
                ){
                    int id=rgGenero.getCheckedRadioButtonId();

                    if (id>0){

                        rbGeneroSeleccionado = (RadioButton) findViewById(id);
                        Intent intent = new Intent(SolicitarDatosActivity.this, CategoriaComidasActivity.class);
                        intent.putExtra("Nombre",edtNombres.getText().toString());
                        intent.putExtra("Edad",edtEdad.getText().toString());
                        intent.putExtra("Genero",rbGeneroSeleccionado.getText().toString());
                        startActivity(intent);

                    } else {
                        Toast.makeText(SolicitarDatosActivity.this, "Seleccione un genero!",
                                Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(SolicitarDatosActivity.this, "Complete todos los campos para seguir!",
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