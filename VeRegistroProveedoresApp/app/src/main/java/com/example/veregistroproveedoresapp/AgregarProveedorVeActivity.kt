package com.example.veregistroproveedoresapp

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.veregistroproveedoresapp.Model.ProveedorVe
import com.example.veregistroproveedoresapp.VEMainActivity.Companion.lstProveedores
import com.google.android.material.textfield.TextInputLayout
import java.lang.Exception
import java.util.regex.Pattern

class AgregarProveedorVeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var proveedorVe: ProveedorVe

    private lateinit var txvTitulo: TextView

    // Declaración de componentes necesarios
    private lateinit var et_id: EditText
    private lateinit var id_text_input_layout: TextInputLayout

    private lateinit var et_nombre: EditText
    private lateinit var nombre_text_input_layout: TextInputLayout

    private lateinit var et_nit: EditText
    private lateinit var nit_text_input_layout: TextInputLayout

    private lateinit var et_tipo_proveedor: EditText
    private lateinit var tipo_proveedor_text_input_layout: TextInputLayout

    private lateinit var btnRegistrar: Button

    private var estado: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_proveedor_ve)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        // Se agrega la flecha para salir de la actividad
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Se configura el nombre de la actividad
        title = "Agregar Proveedor"

        //Enlazar componentes desde la lógica con la vista
        et_id = findViewById(R.id.et_id)
        et_nombre = findViewById(R.id.et_nombre)
        et_nit = findViewById(R.id.et_nit)
        et_tipo_proveedor = findViewById(R.id.et_tipo_proveedor)

        id_text_input_layout = findViewById(R.id.id_text_input_layout)
        nombre_text_input_layout = findViewById(R.id.nombre_text_input_layout)
        nit_text_input_layout = findViewById(R.id.nit_text_input_layout)
        tipo_proveedor_text_input_layout = findViewById(R.id.tipo_proveedor_text_input_layout)

        txvTitulo = findViewById(R.id.txvTitulo)

        btnRegistrar = findViewById(R.id.btnRegistrar)

        cargar()

        // Se configura el oyente del boton registrar
        btnRegistrar.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.btnRegistrar -> {
//                cargar()
                // Se valida que todos los campos tengan valores y que el nombre no tenga numeros, solo letras
                if (verifyEmpty(et_id)
                    && verifyTextPersonName(et_nombre)
                    && verifyEmpty(et_nit)
                    && verifyEmpty(et_tipo_proveedor)
                ) {
                    if (estado == 0) {
                        // Se guarda el registro en la lista
//                        guardarRegistro(et_id.text.toString().toInt()
                        guardarRegistro(
                            et_id.text.toString(),
                            et_nombre.text.toString(),
                            et_nit.text.toString(),
                            et_tipo_proveedor.text.toString()
                        )
                        // Se muestra un dialog indicando que el registro fué exitoso
                        AlertDialog.Builder(this)
                            .setTitle("¡Registro Exitoso!")
                            .setMessage("El registro se guardo con éxito")
                            .setPositiveButton("Ok", DialogInterface.OnClickListener
                            { dialogInterface, i ->

                                // Llamado al dialog
                                configProgressDialog()

                                startActivity(
                                    Intent(
                                        this,
                                        VEMainActivity::class.java
                                    )
                                )
                            }).show()
                    } else {
                        // Se guarda el registro en la lista
//                        guardarRegistro(et_id.text.toString().toInt()
                        guardarRegistro(
                            et_id.text.toString(),
                            et_nombre.text.toString(),
                            et_nit.text.toString(),
                            et_tipo_proveedor.text.toString()
                        )

                        // Se muestra un dialog indicando que el registro fué exitoso
                        AlertDialog.Builder(this)
                            .setTitle("¡Modificacion Exitosa!")
                            .setMessage("El registro se modifico con éxito")
                            .setPositiveButton("Aceptar")
                            { dialogInterface: DialogInterface?, i1: Int ->

                                // Llamado al dialog
                                configProgressDialog()

                                startActivity(
                                    Intent(
                                        this,
                                        VEMainActivity::class.java
                                    )
                                )
                            }
                            .setNegativeButton("Cancelar", null)
                            .show()
                    }
                }
            }
        }
    }

    // Metodo que permite guardar un registro
    private fun guardarRegistro(id: String, nombre: String, nit: String, tipo_proveedor: String) {
        val proveedorVe =
            ProveedorVe(id, nombre = nombre, nit = nit, tipo_proveedor = tipo_proveedor)
        // Se hace el import de la lista declarada en el VEMainActivity.kt
        // y se añaden registros
        lstProveedores.add(proveedorVe)
    }

    @SuppressLint("SetTextI18n")
    fun cargar() {
        try {
//            val bundle = intent.extras
//            val id = bundle?.getString("id")
//            et_id.setText(id.toString())
//
//            val nombre = bundle?.getString("nombre")
//            et_nombre.setText(nombre.toString())
//
//            val nit = bundle?.getString("nit")
//            et_nit.setText(nit.toString())
//
//            val tipo_proveedor = bundle?.getString("tipo_proveedor")
//            et_tipo_proveedor.setText(tipo_proveedor.toString())

//            estado = bundle?.getInt("estado",0)!!

            val intent = intent
            proveedorVe = (intent.getSerializableExtra("proveedorVe") as ProveedorVe?)!!
//            proveedorVe = intent.getSerializableExtra("proveedorVe") as ProveedorVe
            estado = intent.getIntExtra("estado", 0)
//            estado = intent.extras!!.getInt("estado")
            et_id.setText(proveedorVe.id)
            et_nombre.setText(proveedorVe.nombre)
            et_nit.setText(proveedorVe.nit)
            et_tipo_proveedor.setText(proveedorVe.tipo_proveedor)

            btnRegistrar.text = "Modificar"
            txvTitulo.text = "Modificar Proveedor"
        } catch (e: Exception) {
            estado = 0
        }
    }


    private fun verifyTextPersonName(editText: EditText): Boolean {
        if (editText.text.toString().isEmpty()) {
            editText.error = "Required field"
            editText.requestFocus()
            return false
        } else if (!verifyChars(editText)) {
            editText.error = "Just letters are allowed"
            editText.requestFocus()
            return false
        }
        return true
    }

    fun verifyChars(editText: EditText): Boolean {
        //Validamos solo caracteres Expresion regular
//        Pattern.compile("^[a-zA-Z ]+$").matcher(editText.text.toString()).matches()

        return Pattern.compile("^[a-zA-Z ]+$").matcher(editText.text.toString()).matches()
    }

    fun verifyEmpty(editText: EditText): Boolean {
        if (editText.text.toString().isEmpty()) {
            editText.error = "Required field"
            editText.requestFocus()
            return false
        }
        return true
    }

    // Se configura la flecha para salir de la actividad
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Finalizar la actividad
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    // Configurador del progress dialog
    fun configProgressDialog() {
        val alertBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(
            R.layout.progress_dialog,
            null
        )
        alertBuilder.setView(dialogView)
        alertBuilder.setCancelable(false)
        val dialog = alertBuilder.create()
        dialog.show()
        // Configurando hilo, para asignar tiempo
        Handler(Looper.getMainLooper()).postDelayed({
            dialog.dismiss()
            finish()
        }, 3000)
    }
}