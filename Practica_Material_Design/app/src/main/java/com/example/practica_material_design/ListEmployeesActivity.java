package com.example.practica_material_design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.practica_material_design.adapters.EmployeesAdapter;
import com.example.practica_material_design.models.EmployeeModel;

import java.util.ArrayList;
import java.util.List;

public class ListEmployeesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EmployeesAdapter employeesAdapter;
    public List<EmployeeModel> lstEmployees;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_employees);

        lstEmployees = new ArrayList<>();

        lstEmployees.add(new EmployeeModel(R.drawable.android_kotlin, "Juan", "Pedro"));
        lstEmployees.add(new EmployeeModel(R.drawable.android_kotlin, "Juan", "Pedro"));
        lstEmployees.add(new EmployeeModel(R.drawable.android_kotlin, "Juan", "Pedro"));
        lstEmployees.add(new EmployeeModel(R.drawable.android_kotlin, "Juan", "Pedro"));
        lstEmployees.add(new EmployeeModel(R.drawable.android_kotlin, "Juan", "Pedro"));
        lstEmployees.add(new EmployeeModel(R.drawable.android_kotlin, "Juan", "Pedro"));


        setRecyclerView(lstEmployees);
    }

    private void setRecyclerView(List<EmployeeModel> lstEmployees) {
        recyclerView = findViewById(R.id.rvEmployees);
        linearLayoutManager = new LinearLayoutManager(ListEmployeesActivity.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        employeesAdapter = new EmployeesAdapter(lstEmployees);
        recyclerView.setAdapter(employeesAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Toast.makeText(ListEmployeesActivity.this, "SE destruyó", Toast.LENGTH_SHORT).show();
    }
}