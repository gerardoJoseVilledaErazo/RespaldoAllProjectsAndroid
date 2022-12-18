package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button1, button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.button1 =  findViewById(R.id.button1);
        button1.setOnClickListener(this);
        this.button2 =  findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1: {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }break;
            case R.id.button2: {
                    startActivity(new Intent(MainActivity.this, MainActivity5.class));
            }break;
        }
    }
}