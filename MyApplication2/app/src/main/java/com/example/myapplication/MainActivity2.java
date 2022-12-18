package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private EditText nombres, edad;
    RadioGroup rg;
    RadioButton rb;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.nombres = findViewById(R.id.editTextTextPersonName);
        this.rg =  findViewById(R.id.radiogroup);
        this.edad =  findViewById(R.id.editTextTextPersonName2);
        this.button =  findViewById(R.id.button);
        int id=rg.getCheckedRadioButtonId();
        button.setOnClickListener(view -> {
            rb =  findViewById(id);
            Intent i = new Intent(MainActivity2.this, MainActivity3.class);
            i.putExtra("Nombre",nombres.getText().toString());
            i.putExtra("Edad",edad.getText().toString());
            i.putExtra("Genero",rb.getText().toString());
            startActivity(i);
        });
    }
}