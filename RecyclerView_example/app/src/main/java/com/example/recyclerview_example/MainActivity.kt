package com.example.recyclerview_example

import android.content.DialogInterface
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview_example.models.Contacto

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnAgregarContacto:Button
    private lateinit var btnMostrarLista:Button
    private lateinit var btnMostrarDatos:Button
    // Creacion de lista
    companion object {
        var lstContactos: MutableList<Contacto> = mutableListOf()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        btnAgregarContacto=findViewById(R.id.btnAgregar)
        btnMostrarLista=findViewById(R.id.btnMostrarLista)
        btnMostrarDatos=findViewById(R.id.btnMostrarDatos)

        configuracionBotones()
    }

    private fun configuracionBotones() {
        btnAgregarContacto.setOnClickListener(this)
        btnMostrarLista.setOnClickListener(this)
        btnMostrarDatos.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.btnAgregar->{
                // Permite ir a la vista para agregar un contacto
                startActivity(Intent(this, AgregarContactoActivity::class.java))
            }
            R.id.btnMostrarLista->{
                if (lstContactos.isEmpty() === false) {
                    startActivity(Intent(this, MostrarContactoActivity::class.java))
                } else {
                    AlertDialog.Builder(this).setTitle("¡Aviso!")
                        .setMessage("Lista de contactos se encuentra vacía.")
                        .setPositiveButton(
                            "Ok"
                        ) { dialogInterface: DialogInterface?, i: Int -> }.show()
                }
//                // Permite ir a la vista para mostrar la lista de contactos
//                startActivity(Intent(this,
//                    MostrarContactoActivity::class.java))
            }
            R.id.btnMostrarDatos->{
                // Permite ir a la vista para mostrar los datos del desarrollador de la APP
                startActivity(Intent(this, MostrarDatosActivity::class.java))
            }
        }
    }
}