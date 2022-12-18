package com.example.guia1_2022_prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();
        // La actividad está creada.

        Button calc = findViewById(R.id.btnCalc);
        //calc.setOnClickListener(new View.OnClickListener() { Esta linea se reemplazara
        calc.setOnClickListener(v -> {
            Intent intent = new Intent (v.getContext(),CalculadoraActivity.class);
            startActivity(intent);
        });

        Button login = findViewById(R.id.btnLogin);
        login.setOnClickListener(v -> {
            Intent intent = new Intent (v.getContext(), LoginActivity.class);
            startActivity(intent);
        });


        Button dat = findViewById(R.id.btnDatosAlumno);
        dat.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(),datos_alumno.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show();
        // La actividad está a punto de hacerse visible.
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();
        // La actividad se ha vuelto visible (ahora se "reanuda").
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
        // Enfocarse en otra actividad  (esta actividad está a punto de ser "detenida").
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show();
        // La actividad ya no es visible (ahora está "detenida")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();
        // La actividad está a punto de ser destruida.
    }
}