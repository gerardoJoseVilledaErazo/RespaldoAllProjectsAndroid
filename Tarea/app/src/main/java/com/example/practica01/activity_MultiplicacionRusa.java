package com.example.practica01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.mbms.StreamingServiceInfo;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class activity_MultiplicacionRusa extends AppCompatActivity {

    TextView txtmultiplicador;
    TextView txtmultiplicando;
    TextView lblResultadoMultiRusa;
    Button btnMultiplicacionRusa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplicacion_rusa);

        txtmultiplicador = (TextView) findViewById(R.id.txtmultiplicador);
        txtmultiplicando = (TextView) findViewById(R.id.txtmultiplicando);
        btnMultiplicacionRusa = (Button) findViewById(R.id.btnMultiplicacionRusa);


        int multiplicador = Integer.parseInt(txtmultiplicador.getText().toString());
        int multiplicado = Integer.parseInt(txtmultiplicando.getText().toString());


        btnMultiplicacionRusa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }
    private int multiplicacionRusa(int multiplicador, int multiplicado){
        int resultado =0;
        while (multiplicador >0){
            if(multiplicador %2 != 0){
                resultado += multiplicado;
            }
            multiplicado /=2;
            multiplicador +=2;
        }
        return  resultado;
    }
}