package com.example.guia03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guia03.Model.TrabajadorHoraModel;
import com.example.guia03.Utils.Utils;

import java.util.ArrayList;

public class TrabajadorHoraActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtID, edtNombre, edtApellido, edtEdad, edtValorHora, edtNumHoras;

    private Button btnAgregar_TrabajadorHora;

    public static ArrayList<TrabajadorHoraModel> trabajadorRepositoryTH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabajador_hora);
        if ( getSupportActionBar() != null ) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        if(trabajadorRepositoryTH==null){
            trabajadorRepositoryTH= new ArrayList<TrabajadorHoraModel>();
        }

        btnAgregar_TrabajadorHora = (Button) findViewById(R.id.btnAgregarTH);
        btnAgregar_TrabajadorHora.setOnClickListener(this);

        edtID = (EditText) findViewById(R.id.edtID);
        edtNombre = (EditText) findViewById(R.id.edtNombre);
        edtApellido = (EditText) findViewById(R.id.edtApellido);
        edtEdad = (EditText) findViewById(R.id.edtEdad);
        edtValorHora = (EditText) findViewById(R.id.edtValorHora);
        edtNumHoras = (EditText) findViewById(R.id.edtNumHoras);
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
            case R.id.btnAgregarTH: {
                if (Utils.verifyEmpty(edtID) &&
                        Utils.verifyTextPersonName(edtNombre) &&
                        Utils.verifyTextPersonName(edtApellido) &&
                        Utils.verifyEmpty(edtEdad) &&
                        Utils.verifyEmpty(edtNumHoras) &&
                        Utils.verifyEmpty(edtValorHora)
                ){

                    new AlertDialog.Builder(this).setTitle("¡Registrado!")
                            .setMessage("Registrado con éxito")
                            .setPositiveButton("Aceptar", (dialogInterface, i) -> {

                                agregar(edtID.getText().toString(),
                                        edtNombre.getText().toString(),
                                        edtApellido.getText().toString(),
                                        Integer.parseInt(edtNumHoras.getText().toString()),
                                        Float.parseFloat(edtValorHora.getText().toString()));

                                finish();
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
                         int nh,
                         float vh){
        trabajadorRepositoryTH.add(new TrabajadorHoraModel(codigo, nombre, apellido, nh, vh));

        Toast.makeText(TrabajadorHoraActivity.this, "Registro añadido ",Toast.LENGTH_LONG).show();
        startActivity(new Intent(TrabajadorHoraActivity.this, MainActivity.class));
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