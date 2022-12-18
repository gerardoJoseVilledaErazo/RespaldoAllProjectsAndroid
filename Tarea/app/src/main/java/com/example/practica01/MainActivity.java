package com.example.practica01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnMultRusa;
    Button btnPalindrome;
    Button btnBisiesto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMultRusa=(Button) findViewById((R.id.btnMultRusa));
        btnPalindrome=(Button) findViewById((R.id.btnPalindrome));
        btnBisiesto=(Button) findViewById((R.id.btnBisiesto));

        btnMultRusa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),activity_MultiplicacionRusa.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getBaseContext().startActivity(intent);
            }
        });
        btnPalindrome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),activity_Palindrome.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getBaseContext().startActivity(intent);
            }
        });
        btnBisiesto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),activity_Bisiesto.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getBaseContext().startActivity(intent);
            }
        });
    }
}