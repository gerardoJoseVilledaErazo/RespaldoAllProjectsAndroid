package com.example.spinnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerl ;
    private EditText etl , et2 ;
    private TextView tv1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Puente de comunicación entre la parte lógica y la parte gráfica de nuestro activity
        etl = ( EditText )findViewById(R.id.txt_valor1 ) ;
        et2 = ( EditText )findViewById(R.id.txt_valor2 ) ;
        tv1 = ( TextView )findViewById(R.id.tv_resultado) ;
        spinnerl = ( Spinner ) findViewById(R.id.spinner) ;
        // Crear arreglo o vector que nos permita agregar todos los textos al spinner
        String [] opciones = { "sumar" , "restar" , "multiplicar" , "dividir" } ;


        // Adaptador para comunicar a spinner
        ArrayAdapter<String> adapter = new ArrayAdapter <String> (this , R.layout.spinner_item_gerardo , opciones ) ;
        spinnerl.setAdapter ( adapter ) ;

    }

    // Método del botón
    public void Calcular ( View view ) {
        String valorl_String = etl.getText().toString();

        String valor2_String = et2.getText().toString();

        int valorl_int = Integer.parseInt(valorl_String);
        int valor2_int = Integer.parseInt(valor2_String);

        String seleccion = spinnerl.getSelectedItem().toString();
        if (seleccion.equals("sumar")) {
            int suma = valorl_int + valor2_int;
            String resultado = String.valueOf(suma);
            tv1.setText(resultado);

        } else if (seleccion.equals("restar")) {
            int resta = valorl_int - valor2_int;
            String resultado = String.valueOf(resta);
            tv1.setText(resultado);
        } else if (seleccion.equals("multiplicar")) {
            int multi = valorl_int * valor2_int;
            String resultado = String.valueOf(multi);
            tv1.setText(resultado);
        } else if ( seleccion.equals ( "dividir" ) ) {

            if(valor2_int != 0){
                int div = valorl_int / valor2_int;
                String resultado = String.valueOf(div);
                tv1.setText(resultado);
            } else {
                Toast.makeText(this, " No se puede dividir entre cero ", Toast.LENGTH_LONG).show();
            }
        }
    }
}