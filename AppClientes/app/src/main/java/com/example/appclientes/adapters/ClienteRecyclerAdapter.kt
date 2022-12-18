package com.example.appclientes.adapters

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.appclientes.AgregarClienteActivity
import com.example.appclientes.R
import com.example.appclientes.model.Cliente

class ClienteRecyclerAdapter(
                                private var datos: MutableList<Cliente>
//                                private var datos: ArrayList<Cliente>
                                , var context: Context
                            ) : RecyclerView.Adapter<ClienteRecyclerAdapter.ClienteViewHolder>()
{

    private var listado_a_eliminar: String? = null


    //clase para la manipulacion de la vista de los item de la lista
    inner class ClienteViewHolder(view: View):RecyclerView.ViewHolder(view){
        var txtId:TextView
        var txtNombre:TextView
        var txtDireccion:TextView
        var imgRuta:ImageView

        var btnEliminar:Button
        var btnModificar:Button


        init {
            txtId=view.findViewById(R.id.txtId)
            txtNombre=view.findViewById(R.id.txtNombre)
            txtDireccion=view.findViewById(R.id.txtDireccion)
            imgRuta=view.findViewById(R.id.img_cliente)
            btnEliminar=view.findViewById(R.id.btnEliminar)
            btnModificar=view.findViewById(R.id.btnModificar)
        }

        fun render(clienteModel: Cliente)
        {
            txtId.text = clienteModel.id.toString()
            txtNombre.text = clienteModel.nombre
            txtDireccion.text = clienteModel.direccion

            //imagen por defecto
            imgRuta.setImageResource(R.mipmap.ic_launcher)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClienteViewHolder {
        val viewHolder=LayoutInflater.from(parent.context)
            .inflate(R.layout.cliente_item,parent,false)
        return ClienteViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: ClienteViewHolder, position: Int) {
        //holder , onstancia de la vista de la plantilla

        //objeto Item (Cliente) segun la posicion recorrida
        val itemCliente = datos[position]
        holder.render(itemCliente)

//        //sustituirlos la vista del holder
//        holder.txtId.text=itemCliente.id.toString()
//        holder.txtNombre.text=itemCliente.nombre
//        holder.txtDireccion.text=itemCliente.direccion
//
//        //imagen por defecto
//        holder.imgRuta.setImageResource(R.mipmap.ic_launcher)

        holder.btnEliminar.setOnClickListener(View.OnClickListener {
            eliminar(position)
            holder.render(itemCliente)
            Toast.makeText(holder.itemView.context,"Eliminar ID:${itemCliente.id} NOMBRE:${itemCliente.nombre} ",Toast.LENGTH_SHORT).show()
        })

        holder.btnModificar.setOnClickListener { v->
            val agregarCliente = Intent(context, AgregarClienteActivity::class.java)
            agregarCliente.putExtra("estado",1) /// 1: Update
            agregarCliente.putExtra("cliente",itemCliente)
            v.context.startActivity(agregarCliente)
            Toast.makeText(holder.itemView.context,"Modificar ID:${itemCliente.id} NOMBRE:${itemCliente.nombre} ",Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int = datos.size


    fun eliminar(position: Int){
//        datos.removeAt(position)
        /////////////////////////////////////////////////////////////////////////////////////////////////////
        listado_a_eliminar = datos[position].toString()
        AlertDialog.Builder(context)
            .setTitle("Confirmacion")
            .setMessage("Esta seguro que desea eliminar: $listado_a_eliminar")
            .setPositiveButton("Aceptar") { dialogInterface: DialogInterface?, i1: Int ->
                datos.removeAt(position)
                notifyDataSetChanged()
            }
            .setNegativeButton("Cancelar", null)
            .show()
        /////////////////////////////////////////////////////////////////////////////////////////////////////
    }
}