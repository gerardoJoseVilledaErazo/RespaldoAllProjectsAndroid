package com.example.agendacontactopreparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agendacontactopreparcial.Adapter.ContactoAdapter
import com.example.agendacontactopreparcial.Provider.ContactoProvider.Companion.contactoList
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var btnNuevoContacto: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Se configura el nombre de la actividad
        title = "Mostrar Lista de Contactos"

        btnNuevoContacto = findViewById(R.id.btnNuevoContacto)

        btnNuevoContacto.setOnClickListener(){
            // Ir a Agregar contacto
            startActivity(Intent(this.applicationContext, AgregarContactoActivity::class.java))
        }

        configRecyclerView()
    }


    // Metodo que permite configurar el RecyclerView
    private fun configRecyclerView(){
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
        val recyclerView = findViewById<RecyclerView>(R.id.rcvContacto)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = manager
        recyclerView.adapter = ContactoAdapter(contactoList,this)
        recyclerView.addItemDecoration(decoration)

    }
}