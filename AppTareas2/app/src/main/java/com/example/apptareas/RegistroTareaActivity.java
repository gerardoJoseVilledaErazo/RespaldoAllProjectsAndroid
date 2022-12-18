package com.example.apptareas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.apptareas.data.Data;
import com.example.apptareas.model.Tarea;

public class RegistroTareaActivity extends AppCompatActivity {

    Button btnCancelar,btnGuardar;

    TextView txtId,txtTexto,txtDescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_tarea);

        btnCancelar=(Button)findViewById(R.id.btnCancelar);
        btnGuardar=(Button)findViewById(R.id.btnGuardar);

        txtId=(TextView) findViewById(R.id.txtId);

        txtTexto=(TextView) findViewById(R.id.txtTexto);

        txtDescripcion=(TextView) findViewById(R.id.txtDescripcion);


        //eventos
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tarea tarea=new Tarea();

                tarea.setId(Integer.valueOf(txtId.getText().toString()));
                tarea.setTitulo(txtTexto.getText().toString());
                tarea.setDescripcion(txtDescripcion.getText().toString());

                Data.tareas.add(tarea);

                regresarMain(view,tarea);
            }
        });

        btnCancelar.setOnClickListener(view -> {
            regresarMain(view,null);

        });
    }

    public void regresarMain(View view, Tarea parametro){

        Intent intent=new Intent(view.getContext(),MainActivity.class);


        //PASO DE PARAMETRO A LA OTRA ACTIVITY
        /*
        Bundle bundle=new Bundle();  //equivalente a un LIST

        bundle.putSerializable("tarea",parametro); // se agrega elemento , llave,valor

        bundle.putString("PruebaLLave","Prueba de texto");


        intent.putExtras(bundle);
        */

        startActivity(intent);

    }
}