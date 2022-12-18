package com.example.agendacontactopreparcial

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
import com.example.agendacontactopreparcial.Model.Contacto
import com.example.agendacontactopreparcial.Provider.ContactoProvider.Companion.contactoList
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class AgregarContactoActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var contacto: Contacto

    private lateinit var txtNewContact: TextView

    //    Contact Name
    private lateinit var contact_name_edit_text: EditText
    private lateinit var contact_name_text_input_layout: TextInputLayout

    //    Contact phone Number
    private lateinit var contact_phone_edit_text: EditText
    private lateinit var contact_phone_text_input_layout: TextInputLayout

    //    botones
    private lateinit var btnGuardarContacto: Button
    private lateinit var btnCancelarContacto: Button

    private var estado: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_contacto)

        // Se agrega la flecha para salir de la actividad
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Se configura el nombre de la actividad
        title = "Agregar Contacto"

        //Enlazar componentes desde la lógica con la vista
        contact_name_edit_text = findViewById(R.id.contact_name_edit_text)
        contact_phone_edit_text = findViewById(R.id.contact_phone_edit_text)

        contact_name_text_input_layout = findViewById(R.id.contact_name_text_input_layout)
        contact_phone_text_input_layout = findViewById(R.id.contact_phone_text_input_layout)

        txtNewContact = findViewById(R.id.txtNewContact)

        btnGuardarContacto = findViewById(R.id.btnGuardarContacto)
        btnCancelarContacto = findViewById(R.id.btnCancelarContacto)

        cargarVE()

        // Llamado al procedimiento que configura los botones
        configuracionBotones()
    }

    // Método que permite configurar los botones
    fun configuracionBotones() {
        btnGuardarContacto.setOnClickListener(this)
        btnCancelarContacto.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.btnGuardarContacto->{
                // Se valida que todos los campos tengan valores
                if (verifyTextPersonName(contact_name_edit_text) && verifyEmpty(contact_phone_edit_text))
                {
                    if(estado == 0){
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
                                Toast.makeText(this.applicationContext, "Saved.", Toast.LENGTH_SHORT).show();
                            }).show()

                    }else{ /// estado ==1: update, es para actualizar o modificar
                        // Se actualiza el registro en la lista
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
                                    Intent(this, MainActivity2::class.java)
                                )
                                Toast.makeText(this.applicationContext, "Updated.", Toast.LENGTH_SHORT).show();
                            }
                            .setNegativeButton("Cancelar", null)
                            .show()
                    }
                }
            }
            R.id.btnCancelarContacto->{
                //Al dar clic en el botón “Cancelar”
                // debe borrar el texto o valor de todos los componentes.
                resetVE()
            }
        }
    }

    // Metodo que permite guardar un registro
    private fun guardarVE() {
        val nombre = contact_name_edit_text.text.toString()
        val numero = contact_phone_edit_text.text.toString()
        contacto = Contacto(nombreContacto = nombre, numeroTelefonico = numero)

        contactoList.add(contacto)
        resetVE()
    }

    // Metodo que permite actualizar un registro
    private fun actualizarVE() {
        val nombre = contact_name_edit_text.text.toString()
        val numero = contact_phone_edit_text.text.toString()
        contacto = Contacto(nombreContacto = nombre, numeroTelefonico = numero)

        contactoList.add(contacto)
    }

    @SuppressLint("SetTextI18n")
    fun cargarVE() {
        try {
            val intent = intent
            contacto = (intent.getSerializableExtra("contacto") as Contacto?)!!
            estado = intent.getIntExtra("estado", 0)
            contact_name_edit_text.setText(contacto.nombreContacto)
            contact_phone_edit_text.setText(contacto.numeroTelefonico)
            btnGuardarContacto.text = "Update"
            txtNewContact.text = "Update Contact"
        } catch (e: Exception) {
            estado = 0
        }
    }

    private fun resetVE()
    {
        contact_name_edit_text.setText("");
        contact_phone_edit_text.setText("");

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