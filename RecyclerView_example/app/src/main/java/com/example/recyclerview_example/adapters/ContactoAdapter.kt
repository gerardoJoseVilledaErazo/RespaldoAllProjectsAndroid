package com.example.recyclerview_example.adapters

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_example.MainActivity
import com.example.recyclerview_example.R
import com.example.recyclerview_example.models.Contacto

class ContactoAdapter (var lstContacto: MutableList<Contacto> = ArrayList()
                       , var context: Context)
    : RecyclerView.Adapter<ContactoAdapter.ViewHolder>(){

    private var listado_a_eliminar: String? = null //////////////////////////////////////////////////////

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(
            R.layout.item_contacto_list,
            parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = lstContacto[position]
//        holder.bind(item, context) /// *****************************
        holder.bind(item, position)
    }

    override fun getItemCount(): Int {
        return lstContacto.size
    }

    // Clase que permite enlazar el contenido del archivo item_contactos_list
    // Con la lógica
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        private val txvNombre: TextView = view.findViewById(R.id.txvNombre)
        private val txvNumeroTelefonico: TextView = view.findViewById(R.id.txvNumTel)

//        fun bind(contacto: Contacto, context: Context){ /// *****************************
        fun bind(contacto: Contacto, index: Int){
            // Se le asignan valores desde la lógica a la vista
            txvNombre.text = contacto.nombreContacto
            txvNumeroTelefonico.text = contacto.numeroTelefonico.toString()

            itemView.setOnClickListener(View.OnClickListener {
                eliminar(index)
            })
        }
    }

    fun eliminar(position: Int)
    {
//        lstContacto.removeAt(position)
        /////////////////////////////////////////////////////////////////////////////////////////////////////
        listado_a_eliminar = lstContacto.get(position).toString()
        AlertDialog.Builder(context)
            .setTitle("Confirmacion")
            .setMessage("Esta seguro que desea eliminar: $listado_a_eliminar")
            .setPositiveButton("Aceptar") { dialogInterface: DialogInterface?, i1: Int ->
                lstContacto.removeAt(position)
                notifyDataSetChanged()
            }
            .setNegativeButton("Cancelar", null)
            .show()
        /////////////////////////////////////////////////////////////////////////////////////////////////////
    }

}