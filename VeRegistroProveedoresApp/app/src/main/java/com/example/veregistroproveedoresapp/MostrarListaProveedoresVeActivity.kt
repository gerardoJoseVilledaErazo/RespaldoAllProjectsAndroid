package com.example.veregistroproveedoresapp

import android.content.DialogInterface
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.veregistroproveedoresapp.Adapter.ProveedorAdapterVe
import com.example.veregistroproveedoresapp.Interface.ItemClickListener
import com.example.veregistroproveedoresapp.Model.ProveedorVe
import com.example.veregistroproveedoresapp.VEMainActivity.Companion.lstProveedores
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MostrarListaProveedoresVeActivity : AppCompatActivity() {
    lateinit var builder: AlertDialog.Builder
    lateinit var dialog: AlertDialog

    private lateinit var proveedorVe: ProveedorVe

    //
    private lateinit var et_update_id: EditText
    private lateinit var et_update_name: EditText
    private lateinit var et_update_nit: EditText
    private lateinit var et_update_tipo: EditText
    private lateinit var btn_update: Button
    private lateinit var btn_cancel: Button

    //
//    private var id: Int = 0
    private lateinit var id: String
    private lateinit var nombre: String
    private lateinit var nit: String
    private lateinit var tipo: String

    private lateinit var btnNuevoProveedor: FloatingActionButton
    private lateinit var recyclerView: RecyclerView
    private lateinit var proveedorAdapterVe: ProveedorAdapterVe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_lista_proveedores_ve)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        // Se agrega la flecha para salir de la actividad
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Titulo para la actividad
        title = "Mostrar Lista"

        btnNuevoProveedor = findViewById(R.id.btnNuevoProveedor)

        // Llamada al configurador del recyclerView
        configRecyclerView()

        btnNuevoProveedor.setOnClickListener() {
            // Ir a Agregar contacto
            startActivity(Intent(this.applicationContext, AgregarProveedorVeActivity::class.java))
        }

        proveedorAdapterVe.setOnItemClickListener(object : ItemClickListener {
            override fun OnItemClick(position: Int, proveedorVe: ProveedorVe?) {
                builder = AlertDialog.Builder(this@MostrarListaProveedoresVeActivity)
                builder.setTitle("Update User Info");
                builder.setCancelable(false);
                val view = LayoutInflater.from(this@MostrarListaProveedoresVeActivity)
                    .inflate(R.layout.dialog_update, null, false);
                InitUpdateDialog(position, view);
                builder.setView(view);
                dialog = builder.create();
                dialog.show();
            }
        })
    }

    private fun InitUpdateDialog(position: Int, view: View) {
        et_update_id = view.findViewById(R.id.et_update_id);
        et_update_name = view.findViewById(R.id.et_update_name);
        et_update_nit = view.findViewById(R.id.et_update_nit)
        et_update_tipo = view.findViewById(R.id.et_update_tipo)

        btn_update = view.findViewById(R.id.btn_update_user);
        btn_cancel = view.findViewById(R.id.btn_update_cancel);

        et_update_id.setText(lstProveedores[position].id)
        et_update_name.setText(lstProveedores[position].nombre)
        et_update_nit.setText(lstProveedores[position].nit)
        et_update_tipo.setText(lstProveedores[position].tipo_proveedor)

        btn_update.setOnClickListener {
//            id = et_update_id.text.toString().toInt()
            id = et_update_id.text.toString()
            nombre = et_update_name.text.toString()
            nit = et_update_nit.text.toString()
            tipo = et_update_tipo.text.toString()

            proveedorVe = ProveedorVe(id = id, nombre = nombre, nit = nit, tipo_proveedor = tipo)

            proveedorAdapterVe.UpdateData(position, proveedorVe)

            // Se muestra un dialog indicando que el registro fué exitoso
            AlertDialog.Builder(this)
                .setTitle("¡Modificacion Exitosa!")
                .setMessage("El registro se modifico con éxito.")
                .setPositiveButton("Ok", DialogInterface.OnClickListener
                { dialogInterface, i ->

                    dialog.dismiss();
                }).show()
        }
        btn_cancel.setOnClickListener() {
            dialog.dismiss();
        }
    }

    // Metodo que permite configurar el RecyclerView
    private fun configRecyclerView() {
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
//        val recyclerView = findViewById<RecyclerView>(R.id.rcvContacto)
        recyclerView = findViewById(R.id.rcvContacto)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = manager

        // Se hace el import de la lista de proveedores y se le pasa al adaptador
        proveedorAdapterVe = ProveedorAdapterVe(lstProveedores, this)

        recyclerView.adapter = proveedorAdapterVe
        recyclerView.addItemDecoration(decoration)
    }

    // Configurar flechita de la barra
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Finalizar la actividad
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}