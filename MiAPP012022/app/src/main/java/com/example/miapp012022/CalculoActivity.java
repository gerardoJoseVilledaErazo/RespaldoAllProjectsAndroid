package com.example.miapp012022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculoActivity extends AppCompatActivity {


    TextView txtNum1,txtNum2,txtTotal;
    Button btnSumar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        //instanciando componentes graficos
        txtNum1=(TextView) findViewById(R.id.txtNum1);
        txtNum2=(TextView) findViewById(R.id.txtNum2);
        txtTotal=(TextView) findViewById(R.id.txtTotal);

        btnSumar=(Button) findViewById(R.id.btnSumar);

        //creando evento click
        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //conviertiendo a decimal el texto
                Double num1=Double.parseDouble(txtNum1.getText().toString());
                Double num2=Double.parseDouble(txtNum2.getText().toString());

                Double total= num1+num2;

                //imprimiendo total
                txtTotal.setText(total.toString());

                //reset
                txtNum1.setText("");
                txtNum2.setText("");
            }
        });
    }
}