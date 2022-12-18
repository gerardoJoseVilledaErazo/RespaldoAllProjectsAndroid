package com.example.appclientes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appclientes.adapters.ClienteRecyclerAdapter
import com.example.appclientes.data.Data
import com.example.appclientes.model.Cliente
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity2 : AppCompatActivity() {

    lateinit var recyclerViewClientes:RecyclerView
    lateinit var btnNuevo:FloatingActionButton
    private lateinit var recyclerAdaterCliente:ClienteRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btnNuevo=findViewById(R.id.btnNuevoR)


        //agregando datos o elementos a la lista
        Data.lista.add(Cliente(1,"Juan Perez","San Salvador","/01"))
        Data.lista.add(Cliente(2,"Maria Lopez","San Salvador","/01"))
        Data.lista.add(Cliente(3,"Jose Perez","San Salvador","/01"))
        Data.lista.add(Cliente(4,"Xiomara Perez","San Salvador","/01"))
        Data.lista.add(Cliente(5,"Marta Hernandez","San Salvador","/01"))
        Data.lista.add(Cliente(6,"Matias Lopez","San Salvador","/01"))

        configRecyclerView()

        btnNuevo.setOnClickListener(){
            // Ir a Agregar contacto
            startActivity(Intent(this.applicationContext, AgregarClienteActivity::class.java))
        }

    }

    // Metodo que permite configurar el RecyclerView
    private fun configRecyclerView(){
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
        recyclerViewClientes = findViewById(R.id.recycler_view_clientes)
        recyclerViewClientes.setHasFixedSize(true)
        recyclerViewClientes.layoutManager = manager
        //instanciando adaptador
//        recyclerAdaterCliente =ClienteRecyclerAdapter(Data.lista)
        recyclerAdaterCliente = ClienteRecyclerAdapter(Data.clienteList,this)
//        recyclerAdaterCliente = ClienteRecyclerAdapter(Data.clienteList as ArrayList<Cliente>,this)
        //asignando adaptador a recyclerView
        recyclerViewClientes.adapter = recyclerAdaterCliente
        recyclerViewClientes.addItemDecoration(decoration)
    }

}