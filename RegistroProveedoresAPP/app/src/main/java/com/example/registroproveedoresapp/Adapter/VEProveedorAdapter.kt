package com.example.registroproveedoresapp.Adapter

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.registroproveedoresapp.Interface.ItemClickListener
import com.example.registroproveedoresapp.Model.VEProveedorModel
import com.example.registroproveedoresapp.R

/**
 * Created by Gerardo Villeda on 10/29/2022.
 */
class VEProveedorAdapter(private var proveedorList: MutableList<VEProveedorModel>
                          ,private val context: Context
                            ) : RecyclerView.Adapter<VEProveedorViewHolder>()
{
    private lateinit var listado_a_eliminar: String
    lateinit var itemClickListener: ItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VEProveedorViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return VEProveedorViewHolder(layoutInflater.inflate(R.layout.veitem_proveedor, parent, false))
    }

    override fun onBindViewHolder(holder: VEProveedorViewHolder, position: Int) {
        val item = proveedorList[position]
        holder.render(item)

        holder.itemView.setOnClickListener { itemClickListener.OnItemClick(position, item) }

        holder.btnEliminar.setOnClickListener {
            eliminar(position)
            holder.render(item)
        }
    }

    override fun getItemCount(): Int = proveedorList.size

    fun eliminar(position: Int){
        listado_a_eliminar = proveedorList[position].toString()
        AlertDialog.Builder(context)
            .setTitle("Confirmacion")
            .setMessage("Esta seguro que desea eliminar: $listado_a_eliminar")
            .setPositiveButton("Aceptar") { dialogInterface: DialogInterface?, i1: Int ->
                proveedorList.removeAt(position)
                notifyDataSetChanged()
                Toast.makeText(context,"Deleted", Toast.LENGTH_SHORT).show();
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    fun setOnItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    fun UpdateData(position: Int, veProveedorModel: VEProveedorModel?) {
        proveedorList.removeAt(position)
        proveedorList.add(veProveedorModel!!)
        notifyItemChanged(position)
        notifyDataSetChanged()
    }
}