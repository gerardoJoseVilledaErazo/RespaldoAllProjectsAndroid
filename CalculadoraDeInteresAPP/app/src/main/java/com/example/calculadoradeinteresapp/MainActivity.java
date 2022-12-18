package com.example.calculadoradeinteresapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.calculadoradeinteresapp.ValidacionesVE.ValidacionesVE;

public class MainActivity extends AppCompatActivity {

    private EditText edtMonto, edtPorcentaje;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ******************* Instancias a los componentes graficos *********************
        this.edtMonto = (EditText) findViewById(R.id.edtMonto);
        this.edtPorcentaje = (EditText) findViewById(R.id.edtPorcentaje);
        this.btnCalcular = (Button) findViewById(R.id.btnRegresar);

        /**
         * Al dar clic en el boton "Calcular"
         * Se realizara el debido calculo, interes=monto*( porcentaje/100),
         * mostrar como resultado el interes y el monto neto(la suma del monto más el interés)
         * como una salida de con texto(TextView).
         */
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ValidacionesVE.esEditTextVacio(edtMonto) && ValidacionesVE.esEditTextVacioPorcentaje(edtPorcentaje)){

                    Toast.makeText(getApplicationContext(),"Llenado exitosamente!",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getBaseContext(), ResultadoActivity.class);
                    // Envio de parametros a otra vista
                    Double monto = Double.parseDouble(String.valueOf(edtMonto.getText()));
                    Double porcentaje = Double.parseDouble(String.valueOf(edtPorcentaje.getText()));
                    Double interes = monto*(porcentaje/100);
                    Double montoNeto = monto+interes;
                    Bundle bundle = new Bundle();
                    bundle.putDouble("MONTO",monto);
                    bundle.putDouble("PORCENTAJE",porcentaje);
                    bundle.putDouble("INTERES",interes);
                    bundle.putDouble("MONTONETO",montoNeto);
                    // Agrega el objeto bundle a el Intent
                    intent.putExtras(bundle);
                    // Inicia Activity
                    startActivity(intent);
                }
            }
        });
    }
}