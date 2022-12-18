package com.example.appregistro

import android.app.Person
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.appregistro.Data.Data
import com.example.appregistro.model.Persona
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegistroActivity : AppCompatActivity() {
    lateinit var txtId:TextInputLayout
    lateinit var txtNombre:TextInputLayout
    lateinit var txtDireccion:TextInputLayout

    lateinit var btnGuardar:Button
    lateinit var btnCancelar:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        txtId=findViewById(R.id.txtId)
        txtNombre=findViewById(R.id.txtNombre)
        txtDireccion=findViewById(R.id.txtDireccion)

        btnGuardar=findViewById(R.id.btnGuardar)
        btnCancelar=findViewById(R.id.btnCancelar)

        //al dar clic en boton cancelar se regresa al vista del listado
        btnCancelar.setOnClickListener(){
            intent= Intent(this.applicationContext,MainActivity::class.java)
            startActivity(intent)
            //this.onDestroy()
        }

        //al dar clic en boton guardar
        btnGuardar.setOnClickListener {

            //se crea objeto del modelo de persona
            var persona:Persona= Persona()

            //se asignan lo valores en los campos
            persona.id= txtId.editText?.text.toString().toInt()
            persona.nombre=txtNombre.editText?.text.toString()
            persona.direccion=txtDireccion.editText?.text.toString()

            //se guarda el objeto en la lista
            Data.lista_personas.add(persona)

            //se cierra la activity y se redirecciona a la vista del listado
            intent= Intent(this.applicationContext,MainActivity::class.java)
            startActivity(intent)
            //this.onDestroy()
        }

    }
}