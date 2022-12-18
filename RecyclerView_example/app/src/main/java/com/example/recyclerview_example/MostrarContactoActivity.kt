package com.example.recyclerview_example

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_example.MainActivity.Companion.lstContactos
import com.example.recyclerview_example.adapters.ContactoAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MostrarContactoActivity : AppCompatActivity() {

    private lateinit var btnNuevoContacto: FloatingActionButton
    private lateinit var recyclerView: RecyclerView
    private lateinit var contactosAdapter: ContactoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_contacto)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        // Se agrega la flecha para salir de la actividad
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // Titulo para la actividad
        title = "Mostrar Lista"

        btnNuevoContacto = findViewById(R.id.btnNuevoContacto)

        // Llamada al configurador del recyclerView
        configRecyclerView()

        btnNuevoContacto.setOnClickListener(){
            // Ir a Agregar contacto
            startActivity(Intent(this.applicationContext, AgregarContactoActivity::class.java))

        }
    }

    // Configurar flechita de la barra
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                // Finalizar la actividad
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    // Metodo que permite configurar el RecyclerView
    private fun configRecyclerView(){
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
//        val recyclerView = findViewById<RecyclerView>(R.id.rcvContacto)
        recyclerView = findViewById(R.id.rcvContacto)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = manager
//        recyclerView.layoutManager = LinearLayoutManager(this)
        // Se hace el import de la lista de contactos y se le pasa al adaptador
        contactosAdapter = ContactoAdapter(lstContactos, this)
        recyclerView.adapter = contactosAdapter
        recyclerView.addItemDecoration(decoration)
    }
}