package com.example.recyclerview_example

import android.content.DialogInterface
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview_example.MainActivity.Companion.lstContactos
import com.example.recyclerview_example.models.Contacto
import java.util.regex.Pattern

class AgregarContactoActivity : AppCompatActivity(), View.OnClickListener {
    // Declaración de componentes necesarios
    private lateinit var edtNombre: EditText
    private lateinit var edtNumeroTelefonico: EditText
    private lateinit var btnRegistrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_contacto)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
//        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT /// Unicamente Modo Vertical

        // Se agrega la flecha para salir de la actividad
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // Se configura el nombre de la actividad
        title = "Agregar Contacto"

        //Enlazar componentes desde la lógica con la vista
        edtNombre = findViewById(R.id.edtNombre)
        edtNumeroTelefonico = findViewById(R.id.edtNumero)
        btnRegistrar = findViewById(R.id.btnRegistrar)

        // Se configura el oyente del boton registrar
        btnRegistrar.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.btnRegistrar -> {
                // Se valida que todos los campos tengan valores y que el nombre no tenga numeros, solo letras
                if (verifyTextPersonName(edtNombre) && verifyEmpty(edtNumeroTelefonico))
//                if(edtNombre.text.toString().isNotEmpty() &&
//                    edtNumeroTelefonico.text.toString().isNotEmpty())
                {
                    // Se guarda el registro en la lista
                    guardarRegistro(edtNombre.text.toString(),edtNumeroTelefonico.text.toString()
                        .toInt())
                    // Se muestra un dialog indicando que el registro fué exitoso
                    AlertDialog.Builder(this).setTitle("¡Registro Exitoso!")
                        .setMessage("El registro se guardo con éxito")
                        .setPositiveButton("Ok", DialogInterface.OnClickListener
                        { dialogInterface, i ->
                            // Se saca la actividad de la pila
//                            finish()
                            // Permite ir a la vista para mostrar la lista de contactos
                            startActivity(
                                Intent(this,
                                    MainActivity::class.java)
                            )
                        }).show()
                }
//                else {
//                    edtNombre.error = "El campo no puede quedar vacio"
//                    edtNumeroTelefonico.error = "El campo no puede quedar vacio"
//                }
            }
        }
    }

    // Metodo que permite guardar un registro
    private fun guardarRegistro(nombreContacto: String, telefonoContacto: Int)
    {
        val contacto: Contacto = Contacto(nombreContacto, telefonoContacto)
        // Se hace el import de la lista declarada en el MainActivity.kt
        // y se añaden registros
        lstContactos.add(contacto)
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
}