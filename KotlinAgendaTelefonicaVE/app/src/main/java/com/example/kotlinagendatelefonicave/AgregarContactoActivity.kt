package com.example.kotlinagendatelefonicave

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.kotlinagendatelefonicave.DataBaseVE.DataBaseRoomVE
import com.example.kotlinagendatelefonicave.ModelVE.Contacto
import com.example.kotlinagendatelefonicave.ModelVE.ContactoVE
import com.example.kotlinagendatelefonicave.daoVE.ContactoDaoImpRoomVe
import com.example.kotlinagendatelefonicave.daoVE.ContactoDaoVE
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class AgregarContactoActivity : AppCompatActivity(), View.OnClickListener   {
    //
    lateinit var txtNewContact: TextView
    //
//    Contact Name
    private lateinit var contact_name_edit_text: EditText
    private lateinit var contact_name_text_input_layout: TextInputLayout

    //    Contact phone Number
    private lateinit var contact_phone_edit_text: EditText
    private lateinit var contact_phone_text_input_layout: TextInputLayout
    //
//    botones
    lateinit var btnGuardarContacto: Button
    lateinit var btnCancelarContacto: Button
    //
//    Dao
    lateinit var contactoDaoVE: ContactoDaoVE /// No se recomienda crear objetos de la clase SINO de la interface
    lateinit var contactoVE: ContactoVE
    lateinit var contacto: Contacto
    lateinit var contactoDaoImpRoomVe: ContactoDaoImpRoomVe
    var dataBaseRoomVE: DataBaseRoomVE? = DataBaseRoomVE.getContactDatabase(this)
    var estado: Int = 0
    //
    //SharedPreferences
    lateinit var sharedPreferences: SharedPreferences
    var NAME_FILE:String="configuration"
    lateinit var user:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_contacto)

        // Se agrega la flecha para salir de la actividad
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Se configura el nombre de la actividad
        title = "Agregar Contacto"
//
        //Enlazar componentes desde la lógica con la vista
        contact_name_edit_text = findViewById(R.id.contact_name_edit_text)
        contact_phone_edit_text = findViewById(R.id.contact_phone_edit_text)

        contact_name_text_input_layout = findViewById(R.id.contact_name_text_input_layout)
        contact_phone_text_input_layout = findViewById(R.id.contact_phone_text_input_layout)
//
        btnGuardarContacto=findViewById(R.id.btnGuardarContacto)
        btnCancelarContacto=findViewById(R.id.btnCancelarContacto)
        txtNewContact=findViewById(R.id.txtNewContact)
//
        sharedPreferences = getSharedPreferences(NAME_FILE, MODE_PRIVATE)
        user = sharedPreferences.getString("USER","").toString()


//        contactoDaoVE = ContactoDaoImpRoomVe(this.applicationContext)
//
//        cargarVE()

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
                //al dar clic en boton guardar
                // Se configura el oyente del boton guardar
//                saveButton()
//            //se cierra la activity y se redirecciona a la vista del listado
//            intent= Intent(this.applicationContext,MostrarListaContactoVE::class.java)
//            startActivity(intent)
            }
            R.id.btnCancelarContacto->{
                //Al dar clic en el botón “Cancelar”
                // debe borrar el texto o valor de todos los componentes.
//            contact_name_edit_text.setText("");
//            contact_phone_edit_text.setText("");
                resetVE()
                /// ir a la vista MostrarListaContacto
                startActivity(Intent(this.applicationContext, MostrarListaContactoVE::class.java))
            }
        }
    }

    fun saveButton()
    {
        // Se valida que todos los campos tengan valores
        if (verifyTextPersonName(contact_name_edit_text) && verifyEmpty(contact_phone_edit_text))
        {
            if(estado == 0){
                // Se guarda el registro en la lista
///*esta defectuoso*/guardarVE(); /// ********************************************************************* esta malo
                Toast.makeText(this.applicationContext, "Saved.", Toast.LENGTH_SHORT).show();
            }else{
                // Se actualiza el registro en la lista
//                actualizarVE();
                Toast.makeText(this.applicationContext, "Updated.", Toast.LENGTH_SHORT).show();
            }
            resetVE()
            //se cierra la activity y se redirecciona a la vista del listado de contactos
//            val mostrarListaContactos:Intent
//            mostrarListaContactos = Intent(this.applicationContext, MostrarListaContactoVE::class.java)
//            startActivity(mostrarListaContactos)
            startActivity(Intent(this.applicationContext, MostrarListaContactoVE::class.java))
        }
    }

    private fun actualizarVE()
    {
        val nombre = contact_name_edit_text.text.toString()
        val numero = contact_phone_edit_text.text.toString()
        val propietario = user
        val contacto = Contacto(nombreContacto = nombre, numeroTelefonico = numero, propietario = propietario)
        dataBaseRoomVE?.contactoDaoVE()?.update(contacto)
    }

    // Metodo que permite guardar un registro
    private fun guardarVE() {
        val nombre = contact_name_edit_text.text.toString()
        val numero = contact_phone_edit_text.text.toString()
        val propietario = user
        val contacto = Contacto(nombreContacto = nombre, numeroTelefonico = numero, propietario = propietario)
        dataBaseRoomVE?.contactoDaoVE()?.save(contacto)
    }
    private fun resetVE()
    {
        contact_name_edit_text.setText("");
        contact_phone_edit_text.setText("");
        btnGuardarContacto.text = "Save";
    }
    //
    private fun cargarVE()
    {
        try {
            val intent:Intent = intent;
            contacto = intent.getSerializableExtra("contacto") as Contacto
            estado = intent.getIntExtra("estado",0);
            contact_name_edit_text.setText(contactoVE.nombreContacto);
            contact_phone_edit_text.setText(contactoVE.numeroTelefonico);
            btnGuardarContacto.text = "Update";
            txtNewContact.text = "Contact to Update";
        }catch (e: Exception){
            estado=0;
        }
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