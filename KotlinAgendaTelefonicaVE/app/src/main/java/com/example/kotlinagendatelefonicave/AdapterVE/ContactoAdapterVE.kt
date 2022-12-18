package com.example.kotlinagendatelefonicave.AdapterVE

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinagendatelefonicave.AgregarContactoVeActivity
import com.example.kotlinagendatelefonicave.ModelVE.Contacto
import com.example.kotlinagendatelefonicave.ModelVE.ContactoVE
import com.example.kotlinagendatelefonicave.R
import com.example.kotlinagendatelefonicave.daoVE.ContactoDaoVE

class ContactoAdapterVE (var lstContacto: MutableList<Contacto> = ArrayList()
                         , var context: Context /// context -> Para saber de donde viene la llamada de esa accion
                         , var daoVE: ContactoDaoVE
                         ): RecyclerView.Adapter<ContactoAdapterVE.ViewHolder>()
{
//    private var lstContacto: MutableList<ContactoVE> = ArrayList()
    private var contacto: Contacto? = null

//    init {
//        lstContacto =  listaContacto
//    }

    // Manipulation de vista(xml)
    inner class ViewHolder(view: View, context: Context): RecyclerView.ViewHolder(view)
    {
        val txtId: TextView = view.findViewById(R.id.txtId)
        val txtNombre: TextView = view.findViewById(R.id.txtNombre)
        //        val txvNombre: TextView = view.findViewById(R.id.txvNombre)
        val txtNumero: TextView = view.findViewById(R.id.txtNumero)
        val txtPropietario: TextView = view.findViewById(R.id.txtPropietario)
        val btnEliminar: Button = view.findViewById(R.id.btnEliminar)
        val btnModificar: Button = view.findViewById(R.id.btnModificar)

////        fun bind(contacto: ContactoVE, index: Int)
//        fun bind(contacto: ContactoVE, context: Context)
//        {
//            // Se le asignan valores desde la lógica a la vista
//            txtId.text = contacto.id.toString()
//            txtNombre.text = contacto.nombreContacto
//            txtNumero.text = contacto.numeroTelefonico
//            txtPropietario.text = contacto.propietario
//
////            itemView.setOnClickListener(View.OnClickListener {
////                eliminar(index)
////            })
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_contacto_ve,parent, false)
        return ViewHolder(view, context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {

//        contactoVE = lstContacto[position]
        val item = lstContacto[position]
//        holder.bind(item, position)
//        holder.bind(item, context)
        holder.txtId.text = item.id.toString();
        holder.txtNombre.text = item.nombreContacto;
        holder.txtNumero.text = item.numeroTelefonico;
        holder.txtPropietario.text = item.propietario;

        holder.btnEliminar.setOnClickListener {
            daoVE.delete(item)
            lstContacto = daoVE.getAll()
//            notifyDataSetChanged()
            Toast.makeText(context.applicationContext,"Deleted",Toast.LENGTH_SHORT).show();
        }

        holder.btnModificar.setOnClickListener { v->
            val agregarContacto:Intent = Intent(context, AgregarContactoVeActivity::class.java)
            agregarContacto.putExtra("estado",1) /// 1: Update
            agregarContacto.putExtra("contacto",item)
            v.context.startActivity(agregarContacto)

        }
    }

    override fun getItemCount(): Int {
        return lstContacto.size
    }

//    fun eliminar(position: Int){
//        lstContacto.removeAt(position)
//    }
}