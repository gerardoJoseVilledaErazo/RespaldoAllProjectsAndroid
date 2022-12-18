package com.example.registroproveedoresappve16i04001

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
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
import com.example.registroproveedoresappve16i04001.Modelo.Proveedor
import com.example.registroproveedoresappve16i04001.Provider.ProveedorProvider.Companion.proveedorList
import java.util.regex.Pattern

class AgregarProveedorActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var proveedor: Proveedor

    private lateinit var txtNuevoProveedor: TextView

    lateinit var et_update_id2: EditText
    lateinit var et_update_nombre2: EditText
    lateinit var et_update_nit2: EditText
    lateinit var et_update_tipo2: EditText

    //    botones
    private lateinit var btnModificar: Button
    private lateinit var btnSalir: Button

    private var estado: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_proveedor)

        // Se agrega la flecha para salir de la actividad
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Se configura el nombre de la actividad
        title = "Modificar Proveedor"

        et_update_id2 = findViewById(R.id.et_update_id2)
        et_update_nombre2 = findViewById(R.id.et_update_nombre2)
        et_update_nit2 = findViewById(R.id.et_update_nit2)
        et_update_tipo2 = findViewById(R.id.et_update_tipo2)

        btnModificar = findViewById(R.id.btn_update_proveedor2)
        btnSalir = findViewById(R.id.btn_update_cancel2)

        txtNuevoProveedor = findViewById(R.id.txtNewContact)

//        cargarVE()
        try {
            Toast.makeText(this.applicationContext, "Proveedor cargado.", Toast.LENGTH_SHORT).show();
            val intent = intent
            proveedor = (intent.getSerializableExtra("proveedor") as Proveedor?)!!
            estado = intent.getIntExtra("estado", 0)
            et_update_id2.setText(proveedor.id)
            et_update_nombre2.setText(proveedor.nombre)
            et_update_nit2.setText(proveedor.nit)
            et_update_tipo2.setText(proveedor.tipo_proveedor)
            btnModificar.text = "Update"
            txtNuevoProveedor.text = "Modificar Proveedor"
        } catch (e: Exception) {
            estado = 0
        }

        // Llamado al procedimiento que configura los botones
        configuracionBotones()
    }

    // Método que permite configurar los botones
    fun configuracionBotones() {
        btnModificar.setOnClickListener(this)
        btnSalir.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.btn_update_proveedor->{
                // Se valida que todos los campos tengan valores
                if (verifyEmpty(et_update_id2)
                    && verifyTextPersonName(et_update_nombre2)
                    && verifyEmpty(et_update_nit2)
                    && verifyEmpty(et_update_tipo2)
                )
                {
                    if(estado == 0){
                        Toast.makeText(this.applicationContext, "estas en guardar.", Toast.LENGTH_SHORT).show();
                        // Se guarda el registro en la lista
                        guardarVE();
                        // Se muestra un dialog indicando que el registro fué exitoso
                        AlertDialog.Builder(this)
                            .setTitle("¡Registro Exitoso!")
                            .setMessage("El registro se guardo con éxito")
                            .setPositiveButton("Ok", DialogInterface.OnClickListener
                            { dialogInterface, i ->

                                // Llamado al dialog
                                configProgressDialog()
                                startActivity(
                                    Intent(this, MainActivity::class.java)
                                )
                                Toast.makeText(this.applicationContext, "Registrado.", Toast.LENGTH_SHORT).show();
                            }).show()

                    }else{ /// estado ==1: update, es para actualizar o modificar
                        // Se actualiza el registro en la lista
                        Toast.makeText(this.applicationContext, "estas en modificar.", Toast.LENGTH_SHORT).show();
                        actualizarVE();

                        AlertDialog.Builder(this)
                            .setTitle("Confirmacion")
                            .setMessage("Desea continuar")
                            .setPositiveButton("Aceptar")
                            { dialogInterface: DialogInterface?, i1: Int ->

                                // Llamado al dialog
                                configProgressDialog()
                                // Permite ir a la vista para mostrar la lista de clientes
                                startActivity(
                                    Intent(this, MainActivity::class.java)
                                )
                                Toast.makeText(this.applicationContext, "Modificado.", Toast.LENGTH_SHORT).show();
                            }
                            .setNegativeButton("Cancelar", null)
                            .show()
                    }
                }
            }
            R.id.btn_update_cancel->{
                //Al dar clic en el botón “Cancelar”
                // debe borrar el texto o valor de todos los componentes.
                resetVE()
            }
        }
    }

    // Metodo que permite guardar un registro
    private fun guardarVE() {
        val id = et_update_id2.text.toString().toInt()
        val nombre = et_update_nombre2.text.toString()
        val nit = et_update_nit2.text.toString()
        val tipo = et_update_tipo2.text.toString()
        proveedor = Proveedor(id = id, nombre = nombre, nit = nit, tipo_proveedor = tipo)

        proveedorList.add(proveedor)
        resetVE()
    }

    // Metodo que permite actualizar un registro
    private fun actualizarVE() {
        val id = et_update_id2.text.toString().toInt()
        val nombre = et_update_nombre2.text.toString()
        val nit = et_update_nit2.text.toString()
        val tipo = et_update_tipo2.text.toString()
        proveedor = Proveedor(id = id, nombre = nombre, nit = nit, tipo_proveedor = tipo)

        proveedorList.add(proveedor)
    }

    @SuppressLint("SetTextI18n")
    fun cargarVE() {
        try {
            Toast.makeText(this.applicationContext, "Proveedor cargado.", Toast.LENGTH_SHORT).show();
            val intent = intent
            proveedor = (intent.getSerializableExtra("proveedor") as Proveedor?)!!
            estado = intent.getIntExtra("estado", 0)
            et_update_id2.setText(proveedor.id)
            et_update_nombre2.setText(proveedor.nombre)
            et_update_nit2.setText(proveedor.nit)
            et_update_tipo2.setText(proveedor.tipo_proveedor)
            btnModificar.text = "Update"
            txtNuevoProveedor.text = "Modificar Proveedor"
        } catch (e: Exception) {
            estado = 0
        }
    }

    private fun resetVE()
    {
        et_update_id2.setText("")
        et_update_nombre2.setText("")
        et_update_nit2.setText("")
        et_update_tipo2.setText("")

    }

    private fun verifyTextPersonName(editText: EditText): Boolean {
        if (editText.text.toString().isEmpty()){
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

    fun verifyChars(editText: EditText): Boolean
    {
        //Validamos solo caracteres Expresion regular
//        Pattern.compile("^[a-zA-Z ]+$").matcher(editText.text.toString()).matches()

        return Pattern.compile("^[a-zA-Z ]+$").matcher(editText.text.toString()).matches()
    }
    fun verifyEmpty(editText: EditText): Boolean
    {
        if (editText.text.toString().isEmpty()){
            editText.error = "Required field"
            editText.requestFocus()
            return false
        }
        return true
    }

    // Se configura la flecha para salir de la actividad
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                // Finalizar la actividad
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
    // Configurador del progress dialog
    fun configProgressDialog(){
        val alertBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.progress_dialog,
            null)
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