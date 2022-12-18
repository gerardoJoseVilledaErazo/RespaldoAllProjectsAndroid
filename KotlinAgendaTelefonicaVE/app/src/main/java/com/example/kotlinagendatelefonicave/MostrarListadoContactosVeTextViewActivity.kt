package com.example.kotlinagendatelefonicave

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.kotlinagendatelefonicave.Data.Data
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MostrarListadoContactosVeTextViewActivity : AppCompatActivity() {

    lateinit var txtLista: TextView
    lateinit var btnNuevo: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_listado_contactos_ve_text_view)

        txtLista=findViewById(R.id.txtListado)
        btnNuevo=findViewById(R.id.btnNuevo)

        //abrir vista para nuevo registro
        btnNuevo.setOnClickListener(){
            intent= Intent(this.applicationContext,AgregarContactoVeActivity::class.java)
            startActivity(intent)
        }

        //cargar datos del listado
        if(Data.lista_contactos.size>0){
            var texto:String=""
            for (item in Data.lista_contactos){

                texto=texto+ "Nombre:${item.nombreContacto}  Numero Tel.:${item.numeroTelefonico}  \n\n"
            }
            txtLista.text=texto
        }else
            txtLista.text="No existen registros..."

    }
}