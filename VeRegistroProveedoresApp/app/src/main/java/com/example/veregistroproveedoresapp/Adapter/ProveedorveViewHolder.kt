package com.example.veregistroproveedoresapp.Adapter

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.veregistroproveedoresapp.Model.ProveedorVe
import com.example.veregistroproveedoresapp.R

class ProveedorveViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    // Clase que permite enlazar el contenido del archivo item_proveedor_ve Con la lógica
    private val txvId: TextView = view.findViewById(R.id.txvId)
    private val txvNombre: TextView = view.findViewById(R.id.txvNombre)
    private val txvNit: TextView = view.findViewById(R.id.txvNit)
    private val txvTipoProveedor: TextView = view.findViewById(R.id.txvTipoProveedor)

    val tv_delete: TextView = view.findViewById(R.id.tv_delete_item)
    val tv_update: TextView = view.findViewById(R.id.tv_update_item)

    fun render(proveedorVe: ProveedorVe) {
        // Se le asignan valores desde la lógica a la vista
        txvId.text = proveedorVe.id.toString()
        txvNombre.text = proveedorVe.nombre
        txvNit.text = proveedorVe.nit
        txvTipoProveedor.text = proveedorVe.tipo_proveedor
    }
}