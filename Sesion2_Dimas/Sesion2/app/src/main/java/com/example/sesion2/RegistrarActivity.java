package com.example.sesion2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sesion2.model.SuperHeroe;

import java.util.ArrayList;

public class RegistrarActivity extends AppCompatActivity {

    EditText edtNombre, edtSkill;
    Button btnGuardar;

    public static ArrayList<SuperHeroe> superHeroe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        if ( getSupportActionBar() != null ) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        edtNombre = findViewById(R.id.edtNombre);
        edtSkill  = findViewById(R.id.edtSkill);
        btnGuardar = findViewById(R.id.btnGuardar);

        superHeroe = new ArrayList<>();

    }

    public void guardarRegistro(View view) {
        superHeroe.add(new SuperHeroe(edtNombre.getText().toString(), edtSkill.getText().toString()));
        Toast.makeText(RegistrarActivity.this, "Guardado con éxito", Toast.LENGTH_SHORT).show();
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