package com.example.guia1_2022_prueba;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {
    public static int SPLAH_TIME_OUT = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*setContentView(R.layout.activity_splash_screen);
        startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));*/

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                finish();
            }
        }, SPLAH_TIME_OUT);
    }
}
