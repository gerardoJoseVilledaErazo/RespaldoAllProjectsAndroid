package com.example.recyclerviewcrud.Adapter

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewcrud.Interface.ItemClickListener
import com.example.recyclerviewcrud.Model.UserData
import com.example.recyclerviewcrud.R

/**
 * Created by Gerardo Villeda on 10/28/2022.
 */

class MyAdapter(private var list:MutableList<UserData> = ArrayList()
                , var context: Context
                ): RecyclerView.Adapter<MyAdapter.MyHolder>()
{
    private var listado_a_eliminar: String? = null
    var itemClickListener: ItemClickListener? = null

    //clase para la manipulacion de la vista de los item de la lista
    inner class MyHolder(view: View):RecyclerView.ViewHolder(view){
        val tv_name = view.findViewById<TextView>(R.id.tv_name_item)
        val tv_email = view.findViewById<TextView>(R.id.tv_email_item)
        val tv_delete  = view.findViewById<Button>(R.id.tv_delete_item)

        fun render(userData: UserData)
        {
            tv_name.text = userData.name
            tv_email.text = userData.email
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val viewHolder = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row,parent,false)
        return MyHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        //holder , instancia de la vista de la plantilla

        //objeto Item (userData) segun la posicion recorrida
        val userData = list[position]
        holder.render(userData)

        holder.itemView.setOnClickListener { itemClickListener!!.OnItemClick(position, userData) }

        holder.tv_delete.setOnClickListener(View.OnClickListener {
            eliminar(position)
            holder.render(userData)
            Toast.makeText(holder.itemView.context,"Eliminar NOMBRE:${userData.name} EMAIL:${userData.email} ",
                Toast.LENGTH_SHORT).show()
        })
    }

    override fun getItemCount(): Int = list.size


    fun eliminar(position: Int){
        /////////////////////////////////////////////////////////////////////////////////////////////////////
        listado_a_eliminar = list[position].toString()
        AlertDialog.Builder(context)
            .setTitle("Confirmacion")
            .setMessage("Esta seguro que desea eliminar: $listado_a_eliminar")
            .setPositiveButton("Aceptar") { dialogInterface: DialogInterface?, i1: Int ->
                list.removeAt(position)
                notifyDataSetChanged()
            }
            .setNegativeButton("Cancelar", null)
            .show()
        /////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    fun setOnItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    fun UpdateData(position: Int, userData: UserData?) {
        list.removeAt(position)
        list.add(userData!!)
        notifyItemChanged(position)
        notifyDataSetChanged()
    }
}