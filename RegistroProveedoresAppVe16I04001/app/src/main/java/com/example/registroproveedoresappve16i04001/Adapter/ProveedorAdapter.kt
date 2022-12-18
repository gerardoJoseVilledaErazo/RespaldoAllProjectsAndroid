package com.example.registroproveedoresappve16i04001.Adapter

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.registroproveedoresappve16i04001.AgregarProveedorActivity
import com.example.registroproveedoresappve16i04001.Interface.ItemClickListener
import com.example.registroproveedoresappve16i04001.Modelo.Proveedor
import com.example.registroproveedoresappve16i04001.R

class ProveedorAdapter(private var proveedorList: MutableList<Proveedor>
                       ,private val context: Context
                        ) : RecyclerView.Adapter<ProveedorViewHolder>()
{
    private lateinit var listado_a_eliminar: String
    lateinit var itemClickListener: ItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProveedorViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProveedorViewHolder(layoutInflater.inflate(R.layout.item_proveedor, parent, false))
    }

    override fun onBindViewHolder(holder: ProveedorViewHolder, position: Int) {
        val item = proveedorList[position]
        holder.render(item)

        holder.itemView.setOnClickListener { itemClickListener.OnItemClick(position, proveedor = item) }

        holder.btnEliminar.setOnClickListener {
            eliminar(position)
            holder.render(item)
        }

        holder.btnModificar.setOnClickListener { v->
            listado_a_eliminar = proveedorList[position].toString()
            AlertDialog.Builder(context)
                .setTitle("Confirmacion")
                .setMessage("Esta seguro que desea modificar: $listado_a_eliminar")
                .setPositiveButton("Aceptar") { dialogInterface: DialogInterface?, i1: Int ->

                    val modificar = Intent(context, AgregarProveedorActivity::class.java)
                    modificar.putExtra("estado",1) /// 1: Update
                    modificar.putExtra("proveedor",item)
                    v.context.startActivity(modificar)
                    proveedorList.removeAt(position)
                }
                .setNegativeButton("Cancelar", null)
                .show()
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
                Toast.makeText(context,"Eliminado", Toast.LENGTH_SHORT).show();
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    fun setOnItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    fun UpdateData(position: Int, proveedor: Proveedor?) {
        proveedorList.removeAt(position)
        proveedorList.add(proveedor!!)
        notifyItemChanged(position)
        notifyDataSetChanged()
    }
}