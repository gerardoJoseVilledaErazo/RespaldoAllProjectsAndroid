package com.example.aplicacionderegistrove16i04001;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Locale;

public class ValidacionActivity extends AppCompatActivity {

    private TextView tvMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validacion);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // ******************* Instancias a los componentes graficos *********************
        this.tvMensaje = findViewById(R.id.tvMensaje);

        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("NOMBRE");
        Integer edad = bundle.getInt("EDAD");
        if (edad>=18){
            // Se puede registrar
            tvMensaje.setTextColor(getResources().getColor(R.color.purple_700));
            tvMensaje.setText("BIENVENIDO "+nombre.toUpperCase(Locale.ROOT)+".");
        } else {
            // No se puede registrar
            tvMensaje.setTextColor(getResources().getColor(R.color.myred));
            tvMensaje.setText("Usted es menor de edad. No se puede registrar");
        }
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