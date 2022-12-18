package com.example.encuestassv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;//
import android.widget.Toast;

import com.example.encuestassv.modelo.Persona;//

import java.util.ArrayList;//

public class RegistrarActivity extends AppCompatActivity {
    EditText edtName,edtOld;
    RadioButton rbFem,rbMasc,rbOth;
    private CheckBox seleccion;
    //public static ArrayList<Persona> personas;//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        edtName = (EditText) findViewById(R.id.edtName);
        rbMasc = (RadioButton) findViewById(R.id.rbMasc);
        rbFem = (RadioButton) findViewById(R.id.rbFem);
        rbOth = (RadioButton) findViewById(R.id.rbOth);
        edtOld = (EditText) findViewById(R.id.edtOld);
        seleccion = (CheckBox) findViewById(R.id.cbCondiciones);
        //personas = new ArrayList<>();//
    }

    //Al dar clic en el botón “Cancelar”
    // debe borrar el texto o valor de todos los componentes del formulario.
    public void Cancel(View view) {
        edtName.setText("");
        edtOld.setText("");
    }

    public void RegistrarNext(View view){

        String g;

        if(rbFem.isChecked()){
            g = rbFem.getText().toString();
        }else{
            if(rbMasc.isChecked()){
                g = rbMasc.getText().toString();
            }else{
                g = rbOth.getText().toString();
            }
        }

        if(edtName.getText().toString().isEmpty()==true ){
            edtName.setError("campo obligatorio");
            edtName.requestFocus();
            return;
        }else{
            if(rbFem.isChecked() || rbMasc.isChecked() || rbOth.isChecked() ){

                if(edtOld.getText().toString().isEmpty() ){
                    edtOld.setError("campo obligatorio");
                    edtOld.requestFocus();
                    return;
                }else{
                    if(!seleccion.isChecked()){
                        String s = "Estado: " + (seleccion.isChecked() ? "Terminos y condiciones aceptados" : "Acepte terminos y condiciones");
                        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
                        seleccion.requestFocus();
                        return;
                    }
                    else{
                        Intent intent = new Intent(this, FoodCategoryActivity.class);
                        String name = edtName.getText().toString();
                        String gender;
                        if(rbFem.isChecked()){
                            gender = rbFem.getText().toString();
                        }else{
                            if(rbMasc.isChecked()){
                                gender = rbMasc.getText().toString();
                            }else{
                                gender = rbOth.getText().toString();
                            }
                        }
                        int edad = Integer.parseInt(String.valueOf(edtOld.getText()));
                        Bundle extras = new Bundle();
                        extras.putString("NAME",name);
                        extras.putString("GENDER",gender);
                        extras.putInt("EDAD", edad);
                        //Agrega el objeto bundle a el Intent
                        intent.putExtras(extras);
                        //Inicia Activity
                        startActivity(intent);
                    }
                }
            }else{
                Toast.makeText(getApplicationContext(), "Por favor seleccione un genero", Toast.LENGTH_LONG).show();
                return;
            }
        }
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