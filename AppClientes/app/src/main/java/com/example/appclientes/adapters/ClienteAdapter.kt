package com.example.appclientes.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.appclientes.R
import com.example.appclientes.model.Cliente

class ClienteAdapter:BaseAdapter{

    lateinit var datos:ArrayList<Cliente>
    lateinit var  context: Context

    constructor(datos:ArrayList<Cliente>){
        this.datos=datos
    }

    constructor(datos:ArrayList<Cliente>,context: Context){
        this.datos=datos
        this.context=context
    }


    //saber cuantos elementos o item se cargan en la vista
    override fun getCount(): Int {
        return datos.size
    }

    //obtener el objeto del item en seleccion
    override fun getItem(p0: Int): Cliente {
        return datos.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return datos.get(p0).id.toLong()
    }


    //creacion de vista de la plantilla para cada item
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        //obteniendo vista a cargarse/inflarce en el ListView(ViewGroup Parent)
        var vistaItem:View=LayoutInflater.from(context).inflate(R.layout.cliente_item,p2,false)

        //obteniendo elemento actual de la lista de datos
        var itemCliente:Cliente=getItem(p0)

        //instamciamos los elementos graficos de segun plantilla
        val txtId=vistaItem.findViewById<TextView>(R.id.txtId)
        val txtNombre=vistaItem.findViewById<TextView>(R.id.txtNombre)
        val txtDireccion=vistaItem.findViewById<TextView>(R.id.txtDireccion)
        val imagenCliente=vistaItem.findViewById<ImageView>(R.id.img_cliente)
        val btnEliminar=vistaItem.findViewById<Button>(R.id.btnEliminar)
        val btnModificar=vistaItem.findViewById<Button>(R.id.btnModificar)

        //asignacion de valores a los componentes graficos
        txtId.text=itemCliente.id.toString()
        txtNombre.text=itemCliente.nombre.toString()
        txtDireccion.text=itemCliente.direccion.toString()

        //imagen por defecto
        imagenCliente.setImageResource(R.mipmap.ic_launcher)

        btnEliminar.setOnClickListener(View.OnClickListener {

            Toast.makeText(context,"Registro a eliminar: ID:${itemCliente.id}  Nombre:${itemCliente.nombre}",Toast.LENGTH_SHORT).show()

        })
        btnModificar.setOnClickListener(View.OnClickListener {

            Toast.makeText(context,"Registro a modificar: ID:${itemCliente.id}  Nombre:${itemCliente.nombre}",Toast.LENGTH_SHORT).show()

        })

        return vistaItem
    }

}