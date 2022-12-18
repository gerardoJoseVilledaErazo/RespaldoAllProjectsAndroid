package com.example.radiobuttonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv;
    private RadioButton rb_sumar,rb_restar,rb_multi,rb_div;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Relacion para poder comunicar parte logica
        et1 = (EditText)findViewById(R.id.txt_valor1);
        et2 = (EditText)findViewById(R.id.txt_valor2);
        tv = (TextView)findViewById(R.id.txt_resultado);
        rb_sumar = (RadioButton)findViewById(R.id.rb_sumar);
        rb_restar = (RadioButton)findViewById(R.id.rb_restar);
        rb_multi = (RadioButton)findViewById(R.id.rb_multi);
        rb_div = (RadioButton)findViewById(R.id.rb_div);
    }

    // Metodo para el boton calcular
    public void calcular(View view){
        String valor1_string = et1.getText().toString();
        String valor2_string = et2.getText().toString();

        int valor1_int = Integer.parseInt(valor1_string);
        int valor2_int = Integer.parseInt(valor2_string);

        if(rb_sumar.isChecked() == true){
            int suma = valor1_int + valor2_int ;
            String resultado = String.valueOf ( suma ) ;
            tv.setText ( resultado ) ;
        } else if(rb_restar.isChecked() == true){
            int resta = valor1_int - valor2_int ;
            String resultado = String.valueOf ( resta ) ;
            tv.setText ( resultado ) ;
        } else if(rb_multi.isChecked() == true){
            int multi = valor1_int * valor2_int ;
            String resultado = String.valueOf ( multi ) ;
            tv.setText ( resultado ) ;
        }else if (rb_div.isChecked() == true) {

            if(valor2_int != 0){
                int div = valor1_int / valor2_int;
                String resultado = String.valueOf(div);
                tv.setText(resultado);
            } else {
                Toast.makeText(this, " No se puede dividir entre cero ", Toast.LENGTH_LONG).show();
            }
        }
    }
}