package com.example.guia03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class SeleccionarTrabajadorActivity extends AppCompatActivity implements View.OnClickListener{

    private RadioButton btTH, btTC;
    private Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_trabajador);
        if ( getSupportActionBar() != null ) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btTH = findViewById(R.id.rbtTH);
        btTH.setOnClickListener(this);

        btTC = findViewById(R.id.rbtTC);
        btTC.setOnClickListener(this);

        btnSiguiente = findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSiguiente:{
                    if(!btTH.isChecked() && !btTC.isChecked()){
                        new AlertDialog.Builder(this).setTitle("¡Aviso!")
                                .setMessage("Debe seleccionar una opción")
                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                }).show();
                    } else {
                        // Continuar con el flujo
                        if(btTH.isChecked()){
                            // Llevar a trabajador hora
                            startActivity(new Intent(this, TrabajadorHoraActivity.class));
                        } else {
                            // Llevar a trabajador tiempo completo
                            startActivity(new Intent(this, TrabajadorTiempoCompletoActivity.class));
                        }
                    }
            }break;
        }
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