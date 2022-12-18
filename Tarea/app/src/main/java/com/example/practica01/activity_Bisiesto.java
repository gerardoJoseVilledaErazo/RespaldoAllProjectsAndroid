package com.example.practica01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_Bisiesto extends AppCompatActivity {

    TextView txtAnio;
    TextView lblBisiesto;
    Button btnAnio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bisiesto);

        // INICIALIZACIÓN DE VARIABLES

        txtAnio = (TextView) findViewById(R.id.txtAnio);
        lblBisiesto = (TextView) findViewById(R.id.lblBisiesto);
        btnAnio = (Button) findViewById(R.id.btnAnio);


        // EVALUAR SI ES BISIESTO O NO ES BISIESTO

        btnAnio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int anio=Integer.valueOf(txtAnio.getText().toString());

                if ((((anio%100)!=0)&&((anio%4)==0))||((anio%400)==0))
                {
                    lblBisiesto.setText("El año es bisiesto.");
                }
                else                {
                    lblBisiesto.setText("El año no es bisiesto");
                }

            }
        });
    }
}