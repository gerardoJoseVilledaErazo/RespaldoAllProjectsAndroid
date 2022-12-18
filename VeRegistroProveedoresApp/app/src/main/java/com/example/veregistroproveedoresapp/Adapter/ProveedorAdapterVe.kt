package com.example.veregistroproveedoresapp.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.veregistroproveedoresapp.AgregarProveedorVeActivity
import com.example.veregistroproveedoresapp.Interface.ItemClickListener
import com.example.veregistroproveedoresapp.Model.ProveedorVe
import com.example.veregistroproveedoresapp.R

/**
 * Created by Gerardo Villeda on 10/29/2022.
 */
class ProveedorAdapterVe(
    private var lstProveedor: MutableList<ProveedorVe> /*= ArrayList()*/,
    private val context: Context
) : RecyclerView.Adapter<ProveedorveViewHolder>() {
    private lateinit var listado_a_eliminar: String
    lateinit var itemClickListener: ItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProveedorveViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProveedorveViewHolder(
            layoutInflater.inflate(
                R.layout.item_proveedor_ve,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProveedorveViewHolder, position: Int) {
        val item = lstProveedor[position]
        holder.render(item)

        holder.itemView.setOnClickListener {
            itemClickListener.OnItemClick(
                position,
                proveedorVe = item
            )
        }

        holder.tv_delete.setOnClickListener {
            eliminar(position)
            holder.render(item)
        }

        holder.tv_update.setOnClickListener { v ->
            listado_a_eliminar = lstProveedor[position].toString()
            AlertDialog.Builder(context)
                .setTitle("Confirmacion")
                .setMessage("Esta seguro que desea modificar: $listado_a_eliminar")
                .setPositiveButton("Aceptar") { dialogInterface: DialogInterface?, i1: Int ->

                    val modificar: Intent =
                        Intent(holder.itemView.context, AgregarProveedorVeActivity::class.java)
                    modificar.putExtra("estado", 1) /// 1: Update
//                    modificar.putExtra("id",item.id.toString())
//                    modificar.putExtra("nombre", item.nombre)
//                    modificar.putExtra("nit", item.nit)
//                    modificar.putExtra("tipo_proveedor", item.tipo_proveedor)
                    modificar.putExtra("proveedorVe", item)
                    holder.itemView.context.startActivity(modificar)
                    lstProveedor.removeAt(position)
                }
                .setNegativeButton("Cancelar", null)
                .show()
        }
    }

    override fun getItemCount(): Int = lstProveedor.size

    fun eliminar(position: Int) {
        /////////////////////////////////////////////////////////////////////////////////////////////////////
        listado_a_eliminar = lstProveedor[position].toString()
        AlertDialog.Builder(context)
            .setTitle("Confirmacion")
            .setMessage("Esta seguro que desea eliminar: $listado_a_eliminar")
            .setPositiveButton("Aceptar") { dialogInterface: DialogInterface?, i1: Int ->
                lstProveedor.removeAt(position)
                updateState(position)
                Toast.makeText(context, "Registro Eliminado.", Toast.LENGTH_SHORT).show();
            }
            .setNegativeButton("Cancelar", null)
            .show()
        /////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    fun updateState(position: Int) {
        notifyItemChanged(position)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateDataSetChanged() {
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    fun UpdateData(position: Int, proveedorVe: ProveedorVe?) {
        lstProveedor.removeAt(position)
        lstProveedor.add(proveedorVe!!)
        updateState(position)
        updateDataSetChanged()
    }
}