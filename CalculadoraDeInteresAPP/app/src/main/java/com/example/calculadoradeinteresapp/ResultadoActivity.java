package com.example.calculadoradeinteresapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultadoActivity extends AppCompatActivity {

    private TextView tvMontoResultado, tvPorcentajeResultado, tvInteres, tvMontoNeto;
    private Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // ******************* Instancias a los componentes graficos *********************
        this.tvMontoResultado = findViewById(R.id.tvMontoResultado);
        this.tvPorcentajeResultado = findViewById(R.id.tvPorcentajeResultado);
        this.tvInteres = findViewById(R.id.tvInteres);
        this.tvMontoNeto = findViewById(R.id.tvMontoNeto);
        this.btnRegresar = findViewById(R.id.btnRegresar);

        Bundle bundle = getIntent().getExtras();
        Double monto = bundle.getDouble("MONTO");
        Double porcentaje = bundle.getDouble("PORCENTAJE");
        Double interes = bundle.getDouble("INTERES");
        Double montoNeto = bundle.getDouble("MONTONETO");
        tvMontoResultado.setText("Monto: $"+monto);
        tvPorcentajeResultado.setText("Porcentaje: "+porcentaje+"%");
        tvInteres.setText("Interes: $"+obtieneDosDecimales(interes));
        tvMontoNeto.setText("Monto Neto: $"+obtieneDosDecimales(montoNeto));

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                // Inicia Activity
                startActivity(intent);
            }
        });
    }

    private String obtieneDosDecimales(Double valor){
        DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits(2); // Define 2 decimales.
        return format.format(valor);
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
}