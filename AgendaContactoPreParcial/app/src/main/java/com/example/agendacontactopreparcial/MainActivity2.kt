package com.example.agendacontactopreparcial

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
import com.example.agendacontactopreparcial.Adapter.ContactoAdapter
import com.example.agendacontactopreparcial.Interface.ItemClickListener
import com.example.agendacontactopreparcial.Model.Contacto
import com.example.agendacontactopreparcial.Provider.ContactoProvider.Companion.contactoList

class MainActivity2 : AppCompatActivity() {

    private lateinit var contacto: Contacto

    private lateinit var et_name: EditText
    private lateinit var et_number: EditText

    lateinit var et_update_name: EditText
    lateinit var et_update_number: EditText

    lateinit var add: Button
    lateinit var btn_update: Button
    lateinit var btn_cancel: Button

    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: ContactoAdapter

    lateinit var builder: AlertDialog.Builder

    lateinit var dialog: AlertDialog

    lateinit var name: String
    lateinit var number: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        et_name = findViewById(R.id.et_name);
        et_number = findViewById(R.id.et_number);

        add = findViewById(R.id.btn_add);

        configRecyclerView()

        add.setOnClickListener(){
            name = et_name.text.toString()
            number = et_number.text.toString()

            contacto = Contacto(nombreContacto = name, numeroTelefonico = number)

            contactoList.add(contacto)
            myAdapter.notifyDataSetChanged()
            Toast.makeText(this.applicationContext, "User Add Success...", Toast.LENGTH_SHORT).show()

            et_name.setText("")
            et_number.setText("")
        }
        myAdapter.setOnItemClickListener(object : ItemClickListener {
            override fun OnItemClick(position: Int, contacto: Contacto?) {
                builder = AlertDialog.Builder(this@MainActivity2)
                builder.setTitle("Update User Info");
                builder.setCancelable(false);
                val view = LayoutInflater.from(this@MainActivity2).inflate(R.layout.dialog_update,null,false);
                InitUpdateDialog(position,view);
                builder.setView(view);
                dialog = builder.create();
                dialog.show();
            }
        })
    }


    private fun InitUpdateDialog(position:Int, view: View) {
        et_update_name = view.findViewById(R.id.et_update_name);
        et_update_number = view.findViewById(R.id.et_update_numero);

        btn_update = view.findViewById(R.id.btn_update_user);
        btn_cancel = view.findViewById(R.id.btn_update_cancel);

        et_update_name.setText(name)
        et_update_number.setText(number)

        btn_update.setOnClickListener(){
            name = et_update_name.text.toString()
            number = et_update_number.text.toString()

            contacto = Contacto(nombreContacto = name, numeroTelefonico = number)

            myAdapter.UpdateData(position,contacto);
            Toast.makeText(this.applicationContext,"User Updated..",Toast.LENGTH_SHORT).show();

        }

        btn_cancel.setOnClickListener(){
            dialog.dismiss();
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
        myAdapter = ContactoAdapter(contactoList,this)

        //asignando adaptador a recyclerView
        recyclerView.adapter = myAdapter
        recyclerView.addItemDecoration(decoration)
    }
}