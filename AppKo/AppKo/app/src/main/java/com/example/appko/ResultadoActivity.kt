package com.example.appko

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {

    lateinit var txtResultado:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)


        val resultado:Int= intent.getIntExtra("resultado",0)
        txtResultado=findViewById(R.id.txtResultado)

        txtResultado.text="Resultado: $resultado"

    }

}