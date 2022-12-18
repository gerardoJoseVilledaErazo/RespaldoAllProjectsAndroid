package com.example.registroproveedoresappve16i04001

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.registroproveedoresappve16i04001.Adapter.ProveedorAdapter
import com.example.registroproveedoresappve16i04001.Interface.ItemClickListener
import com.example.registroproveedoresappve16i04001.Modelo.Proveedor
import com.example.registroproveedoresappve16i04001.Provider.ProveedorProvider.Companion.proveedorList

class MainActivity : AppCompatActivity() {

    private lateinit var proveedor: Proveedor

    private lateinit var et_id: EditText
    private lateinit var et_nombre: EditText
    private lateinit var et_nit: EditText
    private lateinit var et_tipo: EditText

    private lateinit var et_update_id: EditText
    private lateinit var et_update_nombre: EditText
    private lateinit var et_update_nit: EditText
    private lateinit var et_update_tipo: EditText

    private lateinit var add: Button
    private lateinit var btn_update: Button
    private lateinit var btn_cancel: Button

    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: ProveedorAdapter

    private lateinit var builder: AlertDialog.Builder

    private lateinit var dialog: AlertDialog

    private var id: Int=0
    private lateinit var nombre: String
    private lateinit var nit: String
    private lateinit var tipo: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_id = findViewById(R.id.et_id)
        et_nombre = findViewById(R.id.et_nombre)
        et_nit = findViewById(R.id.et_nit)
        et_tipo = findViewById(R.id.et_tipo_proveedor)

        add = findViewById(R.id.btn_add)

        configRecyclerView()

        add.setOnClickListener {
            id = et_id.text.toString().toInt()
            nombre = et_nombre.text.toString()
            nit = et_nit.text.toString()
            tipo = et_tipo.text.toString()

            proveedor = Proveedor(id = id, nombre = nombre, nit= nit, tipo_proveedor = tipo)

            proveedorList.add(proveedor)
            myAdapter.notifyDataSetChanged()
            Toast.makeText(this.applicationContext, "Proveedor Registrado Exitosamente...", Toast.LENGTH_SHORT).show()

            et_id.setText("")
            et_nombre.setText("")
            et_nit.setText("")
            et_tipo.setText("")
        }
        myAdapter.setOnItemClickListener(object : ItemClickListener {
            override fun OnItemClick(position: Int, proveedor: Proveedor?) {
                builder = AlertDialog.Builder(this@MainActivity)
                builder.setTitle("Modificar Info Proveedor")
                builder.setCancelable(false)
                val view = LayoutInflater.from(this@MainActivity).inflate(R.layout.dialog_update,null,false)
                InitUpdateDialog(position,view)
                builder.setView(view)
                dialog = builder.create()
                dialog.show()
            }
        })
    }


    private fun InitUpdateDialog(position:Int, view: View) {
        et_update_id = view.findViewById(R.id.et_update_id)
        et_update_nombre = view.findViewById(R.id.et_update_nombre)
        et_update_nit = view.findViewById(R.id.et_update_nit)
        et_update_tipo = view.findViewById(R.id.et_update_tipo)

        btn_update = view.findViewById(R.id.btn_update_proveedor)
        btn_cancel = view.findViewById(R.id.btn_update_cancel)

        et_update_id.setText(id)
        et_update_nombre.setText(nombre)
        et_update_nit.setText(nit)
        et_update_tipo.setText(tipo)

        btn_update.setOnClickListener(){
            id = et_update_id.text.toString().toInt()
            nombre = et_update_nombre.text.toString()
            nit = et_update_nit.text.toString()
            tipo = et_update_tipo.text.toString()

            proveedor = Proveedor(id = id, nombre = nombre, nit= nit, tipo_proveedor = tipo)

            myAdapter.UpdateData(position,proveedor)
            Toast.makeText(this.applicationContext,"Proveedor Modificado..",Toast.LENGTH_SHORT).show()

        }

        btn_cancel.setOnClickListener(){
            dialog.dismiss();
        }
    }

    // Metodo que permite configurar el RecyclerView
    private fun configRecyclerView(){
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
        recyclerView = findViewById(R.id.recycler_view2)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = manager

        //instanciando adaptador
        myAdapter = ProveedorAdapter(proveedorList,this)

        //asignando adaptador a recyclerView
        recyclerView.adapter = myAdapter
        recyclerView.addItemDecoration(decoration)
    }
}