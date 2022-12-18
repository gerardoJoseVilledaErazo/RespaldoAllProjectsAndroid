package com.example.agendacontactopreparcial.Adapter

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.agendacontactopreparcial.AgregarContactoActivity
import com.example.agendacontactopreparcial.Interface.ItemClickListener
import com.example.agendacontactopreparcial.Model.Contacto
import com.example.agendacontactopreparcial.R
/**
 * Created by Gerardo Villeda on 10/29/2022.
 */
class ContactoAdapter(private var contactoList: MutableList<Contacto>
                      ,private val context: Context
                        ) : RecyclerView.Adapter<ContactoViewHolder>()
{
    private lateinit var listado_a_eliminar: String
    lateinit var itemClickListener: ItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ContactoViewHolder(layoutInflater.inflate(R.layout.item_contacto, parent, false))
    }

    override fun onBindViewHolder(holder: ContactoViewHolder, position: Int) {
        val item = contactoList[position]
        holder.render(item)

        holder.itemView.setOnClickListener { itemClickListener.OnItemClick(position, contacto = item) }

        holder.btnEliminar.setOnClickListener {
            eliminar(position)
            holder.render(item)
//            Toast.makeText(context,"Deleted", Toast.LENGTH_SHORT).show();
//            Toast.makeText(holder.itemView.context,"Eliminar NOMBRE:${item.nombreContacto} TEL.:${item.numeroTelefonico} ",Toast.LENGTH_SHORT).show()
        }

        holder.btnModificar.setOnClickListener { v->
            listado_a_eliminar = contactoList[position].toString()
            AlertDialog.Builder(context)
                .setTitle("Confirmacion")
                .setMessage("Esta seguro que desea modificar: $listado_a_eliminar")
                .setPositiveButton("Aceptar") { dialogInterface: DialogInterface?, i1: Int ->

                    val agregarContacto = Intent(context, AgregarContactoActivity::class.java)
                    agregarContacto.putExtra("estado",1) /// 1: Update
                    agregarContacto.putExtra("contacto",item)
                    v.context.startActivity(agregarContacto)
                    contactoList.removeAt(position)
                }
                .setNegativeButton("Cancelar", null)
                .show()
        }
    }

    override fun getItemCount(): Int = contactoList.size

    fun eliminar(position: Int){
        listado_a_eliminar = contactoList[position].toString()
        AlertDialog.Builder(context)
            .setTitle("Confirmacion")
            .setMessage("Esta seguro que desea eliminar: $listado_a_eliminar")
            .setPositiveButton("Aceptar") { dialogInterface: DialogInterface?, i1: Int ->
                contactoList.removeAt(position)
                notifyDataSetChanged()
                Toast.makeText(context,"Deleted", Toast.LENGTH_SHORT).show();
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    fun setOnItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    fun UpdateData(position: Int, contacto: Contacto?) {
        contactoList.removeAt(position)
        contactoList.add(contacto!!)
        notifyItemChanged(position)
        notifyDataSetChanged()
    }
}