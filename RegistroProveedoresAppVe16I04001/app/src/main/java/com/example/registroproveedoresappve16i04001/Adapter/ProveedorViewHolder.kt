package com.example.registroproveedoresappve16i04001.Adapter

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.registroproveedoresappve16i04001.Modelo.Proveedor
import com.example.registroproveedoresappve16i04001.R

class ProveedorViewHolder (view: View): RecyclerView.ViewHolder(view)
{
    val id = view.findViewById<TextView>(R.id.txtId)
    val nombre = view.findViewById<TextView>(R.id.txtNombre)
    val nit = view.findViewById<TextView>(R.id.txtNit)
    val tipo = view.findViewById<TextView>(R.id.txtTipoProveedor)
    val btnModificar = view.findViewById<Button>(R.id.btnModificar)
    val btnEliminar = view.findViewById<Button>(R.id.btnEliminar)

    fun render(proveedor: Proveedor)
    {
        id.text = proveedor.id.toString()
        nombre.text = proveedor.nombre
        nit.text = proveedor.nit
        tipo.text = proveedor.tipo_proveedor
    }
}