package com.example.apptareas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apptareas.data.Data;
import com.example.apptareas.model.Tarea;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton btnNuevo;
    TextView txtTareas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNuevo=(FloatingActionButton) findViewById(R.id.btnNuevo);

        txtTareas=(TextView)findViewById(R.id.txtTareas);


        btnNuevo.setOnClickListener(view -> {
            Intent intent=new Intent(view.getContext(), RegistroTareaActivity.class);

            startActivity(intent);
        });

        //SI ES SOLO UN DATO A LA VEZ
        //validando intent o tarea del registro
       // Intent intent=getIntent();

        //obteniendo datos del intent de registro
       // Bundle bundle=intent.getExtras();

        //validando si hay datos traidos por el intent
       /* try {
            Tarea tarea=(Tarea) bundle.getSerializable("tarea");
            if(tarea!=null) {
                Toast.makeText(this, "tarea: " + tarea.getTitulo() + " descripcion: " + tarea.getDescripcion(), Toast.LENGTH_SHORT).show();
                String textoActual= txtTareas.getText().toString();
                textoActual=textoActual+ "ID:"+tarea.getId()+"\n"
                                        +"TITULO:"+tarea.getTitulo()+"\n"
                                        +"DESCRIPCION:"+tarea.getDescripcion()+"\n\n";
                txtTareas.setText(textoActual);
            }

        }
        catch (NullPointerException ex){

        }*/

        //CARGANDO CON PRESISTENCIA EN MEMORIA EN EJECUCION
       cargarDatos();
    }

    private void cargarDatos(){
        for (Tarea tarea :
                Data.tareas) {
            String textoActual= txtTareas.getText().toString();
            textoActual=textoActual+ "ID:"+tarea.getId()+"\n"
                    +"TITULO:"+tarea.getTitulo()+"\n"
                    +"DESCRIPCION:"+tarea.getDescripcion()+"\n\n";
            txtTareas.setText(textoActual);
        }
    }
}