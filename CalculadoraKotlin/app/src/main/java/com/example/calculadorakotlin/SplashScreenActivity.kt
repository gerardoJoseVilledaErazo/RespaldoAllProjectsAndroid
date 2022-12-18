package com.example.calculadorakotlin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
    private var SPLAHTIMEOUT: Long = 100
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        Handler().postDelayed(
            {
                fun run() {
                    startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
                    finish()
                }
            },   SPLAHTIMEOUT     )

    }
}