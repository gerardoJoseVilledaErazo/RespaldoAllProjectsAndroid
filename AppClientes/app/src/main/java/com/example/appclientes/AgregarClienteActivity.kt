package com.example.appclientes

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.appclientes.data.Data.Companion.clienteList
import com.example.appclientes.model.Cliente
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class AgregarClienteActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var cliente: Cliente

    private var estado: Int = 0

    private lateinit var txtTitulo: TextView

    // Customer ID
    private lateinit var customer_id_edit_text: EditText
    private lateinit var customer_id_text_input_layout: TextInputLayout

    //    Customer Name
    private lateinit var customer_name_edit_text: EditText
    private lateinit var customer_name_text_input_layout: TextInputLayout

    //    Customer Address
    private lateinit var customer_address_edit_text: EditText
    private lateinit var customer_address_text_input_layout: TextInputLayout
    //    botones
    private lateinit var btnGuardarCliente: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_cliente)

        // Se agrega la flecha para salir de la actividad
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Se configura el nombre de la actividad
        title = "Agregar Cliente"

        //Enlazar componentes desde la lógica con la vista
        customer_id_edit_text = findViewById(R.id.edtID)
        customer_name_edit_text = findViewById(R.id.edtNombre)
        customer_address_edit_text = findViewById(R.id.edtDireccion)

        customer_id_text_input_layout = findViewById(R.id.id_text_input_layout)
        customer_name_text_input_layout = findViewById(R.id.name_text_input_layout)
        customer_address_text_input_layout = findViewById(R.id.address_text_input_layout)

        txtTitulo = findViewById(R.id.txvTitulo)

        btnGuardarCliente = findViewById(R.id.btnRegistrar)

        cargarVE()
        estado = intent.getIntExtra("estado", 0)

        // Llamado al procedimiento que configura los botones
        configuracionBotones()
    }

    // Método que permite configurar los botones
    fun configuracionBotones() {
        btnGuardarCliente.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.btnRegistrar->{
                // Se valida que todos los campos tengan valores
                if (
                    verifyEmpty(customer_id_edit_text)
                    && verifyTextPersonName(customer_name_edit_text)
                    && verifyEmpty(customer_address_edit_text)
                )
                {
                    if(estado == 0)
                    {
                        Toast.makeText(this.applicationContext, "Estas en guardar.", Toast.LENGTH_SHORT).show();
                        // Se guarda el registro en la lista
                        guardarVE();
                        // Se guarda el registro en la lista
//                        guardarRegistro(customer_id_edit_text.text.toString().toInt()
//                            ,customer_name_edit_text.text.toString()
//                            ,customer_address_edit_text.text.toString())

                        // Se muestra un dialog indicando que el registro fué exitoso
                        AlertDialog.Builder(this)
                            .setTitle("¡Registro Exitoso!")
                            .setMessage("El registro se guardo con éxito")
                            .setPositiveButton("Ok", DialogInterface.OnClickListener
                            { dialogInterface, i ->
                                startActivity(
                                    Intent(this,
                                        MainActivity2::class.java)
                                )
                            }).show()
//                        Toast.makeText(this.applicationContext, "Saved.", Toast.LENGTH_SHORT).show();
                    }else /*if (estado == 1)*/{ /// estado ==1: update, es para actualizar o modificar

                        Toast.makeText(this.applicationContext, "estas en modificar.", Toast.LENGTH_SHORT).show();


                        // Se actualiza el registro en la lista
                        actualizarVE();

                        AlertDialog.Builder(this)
                            .setTitle("Confirmacion")
                            .setMessage("Esta seguro que desea actualizar")
                            .setPositiveButton("Aceptar")
                            { dialogInterface: DialogInterface?, i1: Int ->
                                // Permite ir a la vista para mostrar la lista de clientes
                                startActivity(
                                    Intent(this,
                                        MainActivity2::class.java)
                                )
                            }
                            .setNegativeButton("Cancelar", null)
                            .show()
//                        Toast.makeText(this.applicationContext, "Updated.", Toast.LENGTH_SHORT).show();
                    }
//                    resetVE()
//                    //se cierra la activity y se redirecciona a la vista del listado de clientes
//                    startActivity(Intent(this.applicationContext, MainActivity2::class.java))
                }
            }
        }
    }

    // Metodo que permite guardar un registro
    private fun guardarVE() {
        val id = customer_id_edit_text.text.toString().toInt()
        val nombre = customer_name_edit_text.text.toString()
        val direccion = customer_address_edit_text.text.toString()
        cliente = Cliente(id=id, nombre = nombre, direccion = direccion, rutaImg = "/01")
        clienteList.add(cliente)
        resetVE()

    }

    // Metodo que permite actualizar un registro
    private fun actualizarVE() {
        val id = customer_id_edit_text.text.toString().toInt()
        val nombre = customer_name_edit_text.text.toString()
        val direccion = customer_address_edit_text.text.toString()
        cliente = Cliente(id=id, nombre = nombre, direccion = direccion, rutaImg = "/01")
//        clienteList.add(cliente)
    }

    private fun resetVE()
    {
        customer_id_edit_text.setText("");
        customer_name_edit_text.setText("");
        customer_address_edit_text.setText("");
        btnGuardarCliente.text = "Save";
    }

    @SuppressLint("SetTextI18n")
    fun cargarVE()
    {
//        val intent = intent
//        cliente = (intent.getSerializableExtra("cliente") as Cliente?)!!
//        customer_id_edit_text.setText(cliente.id)
//        customer_name_edit_text.setText(cliente.nombre)
//        customer_address_edit_text.setText(cliente.direccion)
//        btnGuardarCliente.text = "Update"
//        txtTitulo.text = "Update Customer"
        try {
            val intent = intent
            cliente = (intent.getSerializableExtra("cliente") as Cliente?)!!
//            estado = intent.getIntExtra("estado", 0)
//            estado = (intent.getSerializableExtra("estado") as Int?)!!
            customer_id_edit_text.setText(cliente.id)
            customer_name_edit_text.setText(cliente.nombre)
            customer_address_edit_text.setText(cliente.direccion)
            btnGuardarCliente.text = "Update"
            txtTitulo.text = "Update Customer"
        } catch (e: Exception) {
//            estado = 0
        }
    }

    // Metodo que permite guardar un registro
    private fun guardarRegistro(idCliente: Int, nombreCliente: String, direccionCliente: String)
    {
        val cliente: Cliente = Cliente(idCliente,nombreCliente, direccionCliente,"/01")
        // Se hace el import de la lista declarada en el MainActivity.kt
        // y se añaden registros
        clienteList.add(cliente)
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