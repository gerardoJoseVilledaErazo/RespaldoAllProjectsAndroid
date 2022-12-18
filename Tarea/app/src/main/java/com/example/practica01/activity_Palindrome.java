package com.example.practica01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class activity_Palindrome extends AppCompatActivity {

    TextView txtPalabra;
    Button  btnPalindroma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palindrome);

        // INICIALIZAR VARIABLES

        txtPalabra = (TextView) findViewById(R.id.txtPalabra);
        btnPalindroma = (Button) findViewById(R.id.btnPalindroma);



        btnPalindroma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                char[] charInput = txtPalabra.getText().toString().toCharArray();
                int intLength = charInput.length;
                boolean Palindrome = true;

                for (int i=0; i<intLength/2; i++){
                    if (charInput[i] != charInput[intLength-1-i]){
                        Palindrome = false;
                        break;
                    }
                }
                if (Palindrome){
                    Toast.makeText(getApplicationContext(), "Es palindroma!!", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "No es palindroma!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
