package com.example.ejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView txtTexto1,txtTexto2,txtResultado1,txtResultado2;
    Button btnCapturar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTexto1=(TextView) findViewById(R.id.txtTexto1);
        txtTexto2=(TextView) findViewById(R.id.txtTexto2);
        txtResultado1=(TextView) findViewById(R.id.txtResultado1);
        txtResultado2=(TextView) findViewById(R.id.txtResultado2);

        btnCapturar= (Button) findViewById(R.id.btnCapturar);

        btnCapturar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtResultado1.setText(txtTexto1.getText());
                txtResultado2.setText(txtTexto2.getText());
            }
        });

    }
}