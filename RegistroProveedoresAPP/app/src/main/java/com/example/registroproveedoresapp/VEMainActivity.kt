package com.example.registroproveedoresapp

import android.annotation.SuppressLint
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
import com.example.registroproveedoresapp.Adapter.VEProveedorAdapter
import com.example.registroproveedoresapp.Interface.ItemClickListener
import com.example.registroproveedoresapp.Model.VEProveedorModel
import com.example.registroproveedoresapp.Provider.VEProveedorProvider.Companion.proveedorList

class VEMainActivity : AppCompatActivity() {
//
    private lateinit var veProveedorModel: VEProveedorModel

    private lateinit var et_id: EditText
    private lateinit var et_nombre: EditText
    private lateinit var et_nit: EditText
    private lateinit var et_tipo_proveedor: EditText

    private lateinit var et_update_id: EditText
    private lateinit var et_update_nombre: EditText
    private lateinit var et_update_nit: EditText
    private lateinit var et_update_tipo_proveedor: EditText

    private lateinit var add: Button
    private lateinit var btnUpdate: Button
    private lateinit var btnRegresar: Button

    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: VEProveedorAdapter

    lateinit var builder: AlertDialog.Builder

    lateinit var dialog: AlertDialog

    private var id: Int = 0
    private lateinit var nombre: String
    private lateinit var nit: String
    private lateinit var tipoProveedor: String

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vemain)
//
        et_id = findViewById(R.id.et_id)
        et_nombre = findViewById(R.id.et_nombre)
        et_nit = findViewById(R.id.et_nit)
        et_tipo_proveedor = findViewById(R.id.et_tipo_proveedor)

        add = findViewById(R.id.btn_add)
//
        configRecyclerView()

//        add.setOnClickListener {
//            id = et_id.text.toString().toInt()
//            nombre = et_nombre.text.toString()
//            nit = et_nit.text.toString()
//            tipoProveedor = et_tipo_proveedor.text.toString()
//
//            veProveedorModel = VEProveedorModel(id, nombre, nit, tipoProveedor)
//
//            proveedorList.add(veProveedorModel)
//            myAdapter.notifyDataSetChanged()
//            Toast.makeText(this.applicationContext, "Proveedor Add Success...", Toast.LENGTH_SHORT).show()
//
//            et_id.setText("")
//            et_nombre.setText("")
//            et_nit.setText("")
//            et_tipo_proveedor.setText("")
//        }
//        myAdapter.setOnItemClickListener(object : ItemClickListener {
//            override fun OnItemClick(position: Int, veProveedorModel: VEProveedorModel?) {
//                builder = AlertDialog.Builder(this@VEMainActivity)
//                builder.setTitle("Update Proveedor Info")
//                builder.setCancelable(false)
//                val view = LayoutInflater.from(this@VEMainActivity).inflate(R.layout.vedialog_update,null,false)
//                initUpdateDialog(position,view)
//                builder.setView(view)
//                dialog = builder.create()
//                dialog.show()
//            }
//        })
    }


    private fun initUpdateDialog(position:Int, view: View) {
        et_update_id = view.findViewById(R.id.et_update_id)
        et_update_nombre = view.findViewById(R.id.et_update_nombre)
        et_update_nit = view.findViewById(R.id.et_update_nit)
        et_update_tipo_proveedor = view.findViewById(R.id.et_update_tipo_proveedor)

        btnUpdate = view.findViewById(R.id.btn_update_proveedor)
        btnRegresar = view.findViewById(R.id.btn_update_regresar)

        et_update_id.setText(id)
        et_update_nombre.setText(nombre)
        et_update_nit.setText(nit)
        et_update_tipo_proveedor.setText(tipoProveedor)

        btnUpdate.setOnClickListener {

            id = et_update_id.text.toString().toInt()
            nombre = et_update_nombre.text.toString()
            nit = et_update_nit.text.toString()
            tipoProveedor = et_update_tipo_proveedor.text.toString()

            veProveedorModel = VEProveedorModel(id, nombre, nit, tipoProveedor)

            myAdapter.UpdateData(position,veProveedorModel)
            Toast.makeText(this.applicationContext,"Proveedor Updated..",Toast.LENGTH_SHORT).show()

        }

        btnRegresar.setOnClickListener {
            dialog.dismiss()
        }

    }


    // Metodo que permite configurar el RecyclerView
    private fun configRecyclerView(){
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = manager

        //instanciando adaptador
        myAdapter = VEProveedorAdapter(proveedorList,this)

        //asignando adaptador a recyclerView
        recyclerView.adapter = myAdapter
        recyclerView.addItemDecoration(decoration)
    }
}