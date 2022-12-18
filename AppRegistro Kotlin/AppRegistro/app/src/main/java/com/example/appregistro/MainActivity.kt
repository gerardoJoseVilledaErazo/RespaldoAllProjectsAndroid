package com.example.appregistro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.appregistro.Data.Data
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var txtLista:TextView
    lateinit var btnNuevo:FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtLista=findViewById(R.id.txtListado)
        btnNuevo=findViewById(R.id.btnNuevo)

        //abrir vista para nuevo registro
        btnNuevo.setOnClickListener(){
            intent= Intent(this.applicationContext,RegistroActivity::class.java)
            startActivity(intent)
        }

        //cargar datos del listado
        if(Data.lista_personas.size>0){
            var texto:String=""
            for (item in Data.lista_personas){

                texto=texto+ "ID:${item.id} Nombre:${item.nombre}  Direccion:${item.direccion}  \n\n"
            }
            txtLista.text=texto
        }else
            txtLista.text="No existen registros..."

    }
}