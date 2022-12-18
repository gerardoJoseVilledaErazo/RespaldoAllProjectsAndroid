package com.example.appclientes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.appclientes.adapters.ClienteAdapter
import com.example.appclientes.data.Data
import com.example.appclientes.model.Cliente
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var listaClientes:ListView
    lateinit var btnNuevo:FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //obteniendo instancias de elementos graficos
        btnNuevo=findViewById(R.id.btnNuevo)
        listaClientes= findViewById(R.id.lista_clientes)

        //agregando datos o elementos a la lista
        Data.lista.add(Cliente(1,"Juan Perez","San Salvador","/01"))
        Data.lista.add(Cliente(2,"Maria Lopez","San Salvador","/01"))
        Data.lista.add(Cliente(3,"Jose Perez","San Salvador","/01"))
        Data.lista.add(Cliente(4,"Xiomara Perez","San Salvador","/01"))
        Data.lista.add(Cliente(5,"Marta Hernandez","San Salvador","/01"))
        Data.lista.add(Cliente(6,"Matias Lopez","San Salvador","/01"))

        var clienteAdapter:ClienteAdapter=ClienteAdapter(Data.lista,this.applicationContext)

        listaClientes.adapter=clienteAdapter

    }
}