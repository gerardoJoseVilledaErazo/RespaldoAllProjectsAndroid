package com.example.veregistroproveedoresapp

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class VeMostrarDatosAlumnoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ve_mostrar_datos_alumno)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        // Se agrega la flecha para salir de la actividad
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Se configura el nombre de la actividad
        title = "Mostrar Datos Alumno"
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