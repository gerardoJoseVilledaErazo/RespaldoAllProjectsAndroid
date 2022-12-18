package com.example.calculadorakotlin

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class datos_alumno : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_alumno)
        this.requestedOrientation =
            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT /// Unicamente Modo Vertical

        // Se agrega la flecha para salir de la actividad
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // Se configura el nombre de la actividad
        title = "Datos del Alumno"
    }

    // Se configura la flecha para salir de la actividad
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                // Finalizar la actividad
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}