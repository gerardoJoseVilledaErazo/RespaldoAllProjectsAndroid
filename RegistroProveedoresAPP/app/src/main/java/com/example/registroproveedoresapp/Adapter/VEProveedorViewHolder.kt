package com.example.registroproveedoresapp.Adapter

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.registroproveedoresapp.Model.VEProveedorModel
import com.example.registroproveedoresapp.R

/**
 * Created by Gerardo Villeda on 10/29/2022.
 */
class VEProveedorViewHolder (view: View): RecyclerView.ViewHolder(view)
{
    val id = view.findViewById<TextView>(R.id.txtId)
    val nombre = view.findViewById<TextView>(R.id.txtNombre)
    val nit = view.findViewById<TextView>(R.id.txtNit)
    val tipo_proveedor = view.findViewById<TextView>(R.id.txtTipoProveedor)

    val btnModificar = view.findViewById<Button>(R.id.btnModificar)
    val btnEliminar = view.findViewById<Button>(R.id.btnEliminar)



//    val id = view.findViewById<TextView>(R.id.tv_id_item)
//    val nombre = view.findViewById<TextView>(R.id.tv_nombre_item)
//    val nit = view.findViewById<TextView>(R.id.tv_nit_item)
//    val tipo_proveedor = view.findViewById<TextView>(R.id.tv_tipo_proveedor_item)
//    val tv_delete  = view.findViewById<Button>(R.id.tv_delete_item)

    fun render(veProveedorModel: VEProveedorModel)
    {
        id.text = veProveedorModel.id.toString()
        nombre.text = veProveedorModel.nombre
        nit.text = veProveedorModel.nit
        tipo_proveedor.text = veProveedorModel.tipo_proveedor
    }
}