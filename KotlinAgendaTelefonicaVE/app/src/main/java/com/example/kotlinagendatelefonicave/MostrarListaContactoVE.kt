package com.example.kotlinagendatelefonicave

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinagendatelefonicave.AdapterVE.ContactoAdapterVE
import com.example.kotlinagendatelefonicave.Data.Data
import com.example.kotlinagendatelefonicave.Data.DataVE
import com.example.kotlinagendatelefonicave.daoVE.ContactoDaoImpRoomVe
import com.example.kotlinagendatelefonicave.daoVE.ContactoDaoVE
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MostrarListaContactoVE : AppCompatActivity()
{

    private lateinit var btnNuevoContacto: FloatingActionButton
//    private lateinit var rcvContacto: RecyclerView
    private lateinit var recyclerView: RecyclerView
    lateinit var contactoDaoVE: ContactoDaoVE
    private lateinit var contactosAdapter: ContactoAdapterVE
//lateinit var contactoDaoImpRoomVe: ContactoDaoImpRoomVe


//    // Creacion de lista
//    companion object{
//        var contactoVEList: MutableList<ContactoVE> = mutableListOf()
////        private var contactoVEList: MutableList<ContactoVE> = mutableListOf()
//    }
//    private var contactoVEList: MutableList<ContactoVE> = mutableListOf()
//    private lateinit var lstContacto: MutableList<ContactoVE>


//    private lateinit var txtNumberOfContacts: TextView
//    var n: Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_lista_contacto_ve)

        // Se agrega la flecha para salir de la actividad
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // Se configura el nombre de la actividad
        title = "Mostrar Lista de Contactos"

        btnNuevoContacto = findViewById(R.id.btnNuevoContacto)

//        contactoDaoVE = ContactoDaoImpRoomVe(applicationContext)
//        contactoDaoVE = ContactoDaoImpRoomVe(this.applicationContext)

        // Llamada al configurador del recyclerView
//        configRecyclerView()
//        rcvContacto = findViewById(R.id.rcvContacto)
/*

        contactoDaoVE = ContactoDaoImpRoomVe(applicationContext)

        /// Cargando Datos
        this.cargarDatosVE()


        /// Config. Recycler View
/// Instancing AdapterVE
    val contactoAdapterVE = ContactoAdapterVE(contactoVEList, applicationContext, contactoDaoVE)

        rcvContacto.layoutManager = LinearLayoutManager(this)

        // Config. AdapterVE
        rcvContacto.adapter = contactoAdapterVE;
*/


        btnNuevoContacto.setOnClickListener(){
            // Ir a Agregar contacto
            startActivity(Intent(this.applicationContext, AgregarContactoActivity::class.java))
//            startActivity(Intent(this.applicationContext, MainActivity::class.java))
        }
    }

    private fun cargarDatosVE(){
        //        contactoVEList.add(ContactoVE(1,"juan","24517777","a"))
//        var contactoVEList: MutableList<ContactoVE> = contactoDaoVE.getAll()

//        var contactoVEList = DataVE.lista_contactos
//        contactoVEList= contactoDaoVE.getAll()
        Data.lista_contactos = contactoDaoVE.getAll()
//        DataVE.lista_contactos = contactoDaoVE.getAll()
    }

    // Metodo que permite configurar el RecyclerView
    private fun configRecyclerView(){
        recyclerView = findViewById(R.id.rcvContacto)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        // Se hace el import de la lista de contactos y se le pasa al adaptador
        contactosAdapter = ContactoAdapterVE(Data.lista_contactos, applicationContext, contactoDaoVE)
        recyclerView.adapter = ContactoAdapterVE(Data.lista_contactos)
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