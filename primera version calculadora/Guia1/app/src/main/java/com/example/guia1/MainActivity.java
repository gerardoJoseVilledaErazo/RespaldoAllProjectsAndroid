package com.example.guia1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity; //no se ocupo
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //public static final int REQUEST_CODE = 1; NOTA. Ya no se ocupo

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            Button login = findViewById(R.id.btnLogin);
                login.setOnClickListener(v -> {
                    Intent intent = new Intent (v.getContext(), Login.class);
                    /* startActivityForResult(intent, 0); (no funciona)*/
                    //startActivityForResult(intent,REQUEST_CODE); no funciona
                    startActivity(intent);
                });

            Button calc = findViewById(R.id.btnCalc);
            //calc.setOnClickListener(new View.OnClickListener() { Esta linea se reemplazara
            calc.setOnClickListener(v -> {
                Intent intent = new Intent (v.getContext(),Calculadora.class);
                startActivity(intent);
            });

            Button dat = findViewById(R.id.btnDatos);
            dat.setOnClickListener(v -> {
                Intent intent = new Intent(v.getContext(),Datos.class);
                startActivity(intent);
            });
        }
}