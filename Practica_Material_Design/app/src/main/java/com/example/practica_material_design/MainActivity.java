package com.example.practica_material_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnAddEmployee, btnLstEmployees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddEmployee  = findViewById(R.id.btnAddEmployee);
        btnLstEmployees = findViewById(R.id.btnLstEmployees);


        btnAddEmployee.setOnClickListener(v -> {
                startActivity(new Intent(MainActivity.this, AddEmployeeActivity.class));
        });

        btnLstEmployees.setOnClickListener( v -> {
            startActivity(new Intent(MainActivity.this, ListEmployeesActivity.class));
        });
    }
}