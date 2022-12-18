package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    private Button button3;
    String nombre, edad, genero;
    RadioGroup rg;
    RadioButton rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        this.button3 =  findViewById(R.id.button3);
        nombre = getIntent().getStringExtra("Nombre");
        edad = getIntent().getStringExtra("Edad");
        genero = getIntent().getStringExtra("Genero");
        rg = findViewById(R.id.radiogroup2);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = rg.getCheckedRadioButtonId();
                rb =  findViewById(id);
                    Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                    intent.putExtra("Nombre", nombre);
                    intent.putExtra("Edad", edad);
                    intent.putExtra("Genero", genero);
                    intent.putExtra("Categoria", rb.getText().toString());
                    startActivity(intent);
            }
        });
    }
}