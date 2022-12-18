package com.example.calculadorakotlin

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
//import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.mozilla.javascript.Context
//import org.mozilla.javascript.Context.enter
import org.mozilla.javascript.Scriptable

class CalculadoraActivity : AppCompatActivity() {
    private lateinit var resultado: TextView
    private lateinit var total:TextView
    private lateinit var proceso: String
    private var bracket:Boolean = false
    private lateinit var cero: Button
    private lateinit var uno: Button
    private lateinit var dos: Button
    private lateinit var tres: Button
    private lateinit var cuatro: Button
    private lateinit var cinco: Button
    private lateinit var seis: Button
    private lateinit var siete: Button
    private lateinit var ocho: Button
    private lateinit var nueve: Button
    private lateinit var punto: Button
    private lateinit var dividir: Button
    private lateinit var restar: Button
    private lateinit var sumar: Button
    private lateinit var multiplicar: Button
    private lateinit var porcentaje: Button
//    lateinit var C: Button
    private lateinit var btnbracket: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)
        this.requestedOrientation =
            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT /// Unicamente Modo Vertical

        // Se agrega la flecha para salir de la actividad
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // Se configura el nombre de la actividad
        title = "Calculadora"

        Inicial();
    }

    @SuppressLint("SetTextI18n")
    fun Inicial() {
        resultado = findViewById(R.id.process)
        total = findViewById(R.id.result)
        cero = findViewById(R.id.cero)
        uno = findViewById(R.id.uno)
        dos = findViewById(R.id.dos)
        tres = findViewById(R.id.tres)
        cuatro = findViewById(R.id.cuatro)
        cinco = findViewById(R.id.cinco)
        seis = findViewById(R.id.seis)
        siete = findViewById(R.id.siete)
        ocho = findViewById(R.id.ocho)
        nueve = findViewById(R.id.nueve)
        sumar = findViewById(R.id.suma)
        multiplicar = findViewById(R.id.multiplicar)
        restar = findViewById(R.id.restar)
        btnbracket = findViewById(R.id.bracket)
        dividir = findViewById(R.id.dividir)
        punto = findViewById(R.id.punto)
        porcentaje = findViewById(R.id.porcentaje)
        cero.setOnClickListener(View.OnClickListener {
            proceso = resultado.getText().toString()
            resultado.setText(proceso + "0")
        })
        uno.setOnClickListener(View.OnClickListener {
            proceso = resultado.getText().toString()
            resultado.setText(proceso + "1")
        })
        dos.setOnClickListener(View.OnClickListener {
            proceso = resultado.getText().toString()
            resultado.setText(proceso + "2")
        })
        tres.setOnClickListener(View.OnClickListener {
            proceso = resultado.getText().toString()
            resultado.setText(proceso + "3")
        })
        cuatro.setOnClickListener(View.OnClickListener {
            proceso = resultado.getText().toString()
            resultado.setText(proceso + "4")
        })
        cinco.setOnClickListener(View.OnClickListener {
            proceso = resultado.getText().toString()
            resultado.setText(proceso + "5")
        })
        seis.setOnClickListener(View.OnClickListener {
            proceso = resultado.getText().toString()
            resultado.setText(proceso + "6")
        })
        siete.setOnClickListener(View.OnClickListener {
            proceso = resultado.getText().toString()
            resultado.setText(proceso + "7")
        })
        ocho.setOnClickListener(View.OnClickListener {
            proceso = resultado.getText().toString()
            resultado.setText(proceso + "8")
        })
        nueve.setOnClickListener(View.OnClickListener {
            proceso = resultado.getText().toString()
            resultado.setText(proceso + "9")
        })
        sumar.setOnClickListener(View.OnClickListener {
            proceso = resultado.getText().toString()
            resultado.setText("$proceso+")
        })
        multiplicar.setOnClickListener(View.OnClickListener {
            proceso = resultado.getText().toString()
            resultado.setText(proceso + "x")
        })
        dividir.setOnClickListener(View.OnClickListener {
            proceso = resultado.getText().toString()
            resultado.setText("$proceso/")
        })
        restar.setOnClickListener(View.OnClickListener {
            proceso = resultado.getText().toString()
            resultado.setText("$proceso-")
        })
        porcentaje.setOnClickListener(View.OnClickListener {
            proceso = resultado.getText().toString()
            resultado.setText("$proceso%")
        })
        punto.setOnClickListener(View.OnClickListener {
            proceso = resultado.getText().toString()
            resultado.setText("$proceso.")
        })
        btnbracket.setOnClickListener(View.OnClickListener {
            if (bracket) {
                proceso = resultado.getText().toString()
                resultado.setText("$proceso)")
                bracket = false
            } else {
                proceso = resultado.getText().toString()
                resultado.setText("$proceso(")
                bracket = true
            }
        })
    }


    fun igual(view: View?) {
        proceso = resultado!!.text.toString()
        proceso = proceso!!.replace("x".toRegex(), "*")
        proceso = proceso!!.replace("%".toRegex(), "/100")
        val context: Context = Context.enter()
        context.setOptimizationLevel(-1)
        var finalResut = ""
        try {
            val scriptable: Scriptable = context.initStandardObjects()
            finalResut = context.evaluateString(scriptable, proceso, "javascript", 1, null).toString()
        } catch (e: Exception) {
            finalResut = "0"
        }
        total.text = finalResut
    }


    fun clear(view: View?) {
        resultado!!.text = ""
        total.text = ""
    }

    //Cambio de signo
    fun CambioSigno(view: View?) {
        proceso = resultado!!.text.toString()
        resultado!!.text = "$proceso(-"
    }

    fun borrar(view: View?) {
        var string = resultado!!.text.toString()
        if (string.length >= 1) {
            string = string.substring(0, string.length - 1)
            resultado!!.text = string
        } else if (string.length < 1) {
            resultado!!.text = ""
        }
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