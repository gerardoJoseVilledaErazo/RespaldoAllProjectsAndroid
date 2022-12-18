package com.example.practica_material_design;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practica_material_design.utils.Utils;

public class AddEmployeeActivity extends AppCompatActivity {

    private Button btnAdd;
    private EditText edtName, edtLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        btnAdd = findViewById(R.id.btnAdd);
        edtName = findViewById(R.id.edtName);
        edtLastName = findViewById(R.id.edtLastName);

        btnAdd.setOnClickListener( v -> {
            if(Utils.verifyEditText(edtName) && Utils.verifyEditText(edtLastName)) {
                Toast.makeText(AddEmployeeActivity.this, "Agregado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}