package com.example.evaluacion1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Registrar extends AppCompatActivity {
    EditText Edad,Nombre;
    RadioGroup Sexo;
    RadioButton SexSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        Sexo=(RadioGroup) findViewById(R.id.rdb_group);
        Edad=(EditText)findViewById(R.id.edt_edad);
        Nombre=(EditText)findViewById(R.id.edt_nombre);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    public void siguiente(View view)
    {
        if(Edad.getText().toString().length()>0 && Nombre.getText().toString().length()>0)
        {
            int id=Sexo.getCheckedRadioButtonId();

            if(id>0)
            {
                SexSelect=(RadioButton) findViewById(id);
                Intent i = new Intent(this,Categoria.class);
                i.putExtra("Nombre",Nombre.getText().toString());
                i.putExtra("Edad",Edad.getText().toString());
                i.putExtra("Genero",SexSelect.getText().toString());
                startActivity(i);
            }
            else {
                Toast.makeText(Registrar.this, "Rellene los campos para seguir!",
                        Toast.LENGTH_LONG).show();
            }

        }else
            {
                Toast.makeText(Registrar.this, "Rellene los campos para seguir!",
                        Toast.LENGTH_LONG).show();
            }
    }
}