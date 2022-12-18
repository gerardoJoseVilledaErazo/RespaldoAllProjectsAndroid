package com.example.ejerciciocalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edt1, edt2;
    private Button btn;
    private TextView tvInteres, tvMontoNeto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.edt1 = (EditText) findViewById(R.id.edtMonto);
        this.edt2 = (EditText) findViewById(R.id.edtPorcentaje);
        this.btn = (Button) findViewById(R.id.btn);
        this.tvInteres = findViewById(R.id.tvInteres);
        this.tvMontoNeto = findViewById(R.id.tvMontoNeto);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Double monto = Double.parseDouble(String.valueOf(edt1.getText()));
                Double porcentaje = Double.parseDouble(String.valueOf(edt2.getText()));
                Double interes = monto*(porcentaje/100);
                Double montoNeto = monto+interes;
                tvInteres.setText("Interes: "+interes);
                tvMontoNeto.setText("Monto Neto: "+montoNeto);

            }
        });
    }
}