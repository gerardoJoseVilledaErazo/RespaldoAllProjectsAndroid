package com.example.guia03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import static com.example.guia03.MainActivity.trabajadorRepository;
//import com.example.guia03.Repository.TrabajadorRepository;
import com.example.guia03.Model.TrabajadorTiempoCompletoModel;
import com.example.guia03.Utils.Utils;

import java.util.ArrayList;

public class TrabajadorTiempoCompletoActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtID_TrabajadorTC, edtNombre_TrabajadorTC, edtApellido_TrabajadorTC, edtEdad_TrabajadorTC, edtSalarioMensual_TrabajadorTC;

    private Button btnAgregar_TrabajadorTC;

    public static ArrayList<TrabajadorTiempoCompletoModel> trabajadorRepositoryTC;

    String codigo;
    String nombre;
    String apellido;
    float sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabajador_tiempo_completo);
        if ( getSupportActionBar() != null ) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        if(trabajadorRepositoryTC==null){
            trabajadorRepositoryTC= new ArrayList<TrabajadorTiempoCompletoModel>();
        }

        btnAgregar_TrabajadorTC = (Button) findViewById(R.id.btnAgregarTC);
        btnAgregar_TrabajadorTC.setOnClickListener(this);

        edtID_TrabajadorTC = (EditText) findViewById(R.id.edtID_TrabajadorTC);
        edtNombre_TrabajadorTC = (EditText) findViewById(R.id.edtNombre_TrabajadorTC);
        edtApellido_TrabajadorTC = (EditText) findViewById(R.id.edtApellido_TrabajadorTC);
        edtEdad_TrabajadorTC = (EditText) findViewById(R.id.edtEdad_TrabajadorTC);
        edtSalarioMensual_TrabajadorTC = (EditText) findViewById(R.id.edtSalarioMensual_TrabajadorTC);

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


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAgregarTC: {
                if (Utils.verifyEmpty(edtID_TrabajadorTC) &&
                        Utils.verifyTextPersonName(edtNombre_TrabajadorTC) &&
                        Utils.verifyTextPersonName(edtApellido_TrabajadorTC) &&
                        Utils.verifyEmpty(edtEdad_TrabajadorTC) &&
                        Utils.verifyEmpty(edtSalarioMensual_TrabajadorTC)
                ){
                    new AlertDialog.Builder(this)
                            .setTitle("¡Registrado!")
                            .setMessage("Registrado con éxito")
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    codigo = edtID_TrabajadorTC.getText().toString();
                                    nombre = edtNombre_TrabajadorTC.getText().toString();
                                    apellido = edtApellido_TrabajadorTC.getText().toString();
                                    sm = Float.parseFloat(edtSalarioMensual_TrabajadorTC.getText().toString());

                                    agregar(codigo,nombre,apellido,sm);

                                    finish();
                                }
                            })
//                            .setNegativeButton("Cancelar",null )
                            .show();
                }
            }break;
        }
    }

    public void agregar(String codigo,
                        String nombre,
                        String apellido,
                        float sm){

        trabajadorRepositoryTC.add(new TrabajadorTiempoCompletoModel(codigo, nombre, apellido, sm));

        Toast.makeText(TrabajadorTiempoCompletoActivity.this, "Registro añadido ",Toast.LENGTH_LONG).show();
        startActivity(new Intent(TrabajadorTiempoCompletoActivity.this, MainActivity.class));

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
            }break;
        }
        return true;
    }
}