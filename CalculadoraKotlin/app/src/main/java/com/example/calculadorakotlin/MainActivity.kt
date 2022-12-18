package com.example.calculadorakotlin

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnCalc: Button
    private lateinit var btnDatosAlumno: Button
    private lateinit var btnSalir: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.requestedOrientation =
            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT /// Unicamente Modo Vertical


        btnCalc = findViewById(R.id.btnCalc)
        btnDatosAlumno = findViewById(R.id.btnDatosAlumno)
        btnSalir = findViewById(R.id.btnSalir)

        btnCalc.setOnClickListener(this)
        btnDatosAlumno.setOnClickListener(this)
        btnSalir.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.btnCalc -> {
                // Ir a Calculadora Activity
                startActivity(Intent(this.applicationContext, CalculadoraActivity::class.java))
            }
            R.id.btnDatosAlumno -> {
                // Ir a Datos del Alumno
                startActivity(Intent(this.applicationContext, datos_alumno::class.java))
            }
            R.id.btnSalir -> {
                // Salir
                finish();
            }
        }
    }
}