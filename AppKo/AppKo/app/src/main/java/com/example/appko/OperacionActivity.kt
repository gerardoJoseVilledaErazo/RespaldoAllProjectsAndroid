package com.example.appko

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class OperacionActivity : AppCompatActivity() {

    lateinit var txtNum1:TextView
    lateinit var txtNum2:TextView
    lateinit var btnCalcular:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operacion)

        txtNum1= findViewById(R.id.txtNum1)
        txtNum2= findViewById(R.id.txtNum2)
        btnCalcular= findViewById(R.id.btnCalcular)
      //  var resultadoActivity = 0
      //  var resultado=  txtNum1.text.toString().toInt() + txtNum2.text.toString().toInt()

        btnCalcular.setOnClickListener {
            var resultado:Int= ( txtNum1.text.toString().toInt()) + (txtNum2.text.toString().toInt())
            Toast.makeText(this.applicationContext,"valor: $resultado",Toast.LENGTH_LONG).show()

            intent= Intent(this.applicationContext,ResultadoActivity::class.java)
            intent.putExtra("resultado", resultado)

            startActivity(intent)
        }
    }
}