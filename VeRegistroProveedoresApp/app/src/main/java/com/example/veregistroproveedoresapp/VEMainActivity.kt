package com.example.veregistroproveedoresapp

import android.content.DialogInterface
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.veregistroproveedoresapp.Model.ProveedorVe

class VEMainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnAgregarProveedor: Button
    private lateinit var btnMostrarLista: Button
    private lateinit var btnMostrarDatos: Button

    // Creacion de lista
    companion object {
        var lstProveedores: MutableList<ProveedorVe> = mutableListOf()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vemain)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        btnAgregarProveedor = findViewById(R.id.btnAgregar)
        btnMostrarLista = findViewById(R.id.btnMostrarLista)
        btnMostrarDatos = findViewById(R.id.btnMostrarDatos)

        configuracionBotones()
    }

    private fun configuracionBotones() {
        btnAgregarProveedor.setOnClickListener(this)
        btnMostrarLista.setOnClickListener(this)
        btnMostrarDatos.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.btnAgregar -> {
                // Permite ir a la vista para agregar un Proveedor
                startActivity(Intent(this, AgregarProveedorVeActivity::class.java))
            }
            R.id.btnMostrarLista -> {
                /// Validacion lista Proveedores se encuentra vacia
                if (lstProveedores.isEmpty() === false) {
                    startActivity(Intent(this, MostrarListaProveedoresVeActivity::class.java))
                } else {
                    AlertDialog.Builder(this).setTitle("¡Aviso!")
                        .setMessage("Lista de proveedores se encuentra vacía. Agregar al menos un proveedor para continuar...")
                        .setPositiveButton(
                            "Ok"
                        ) { dialogInterface: DialogInterface?, i: Int -> }.show()
                }
            }
            R.id.btnMostrarDatos -> {
                // Permite ir a la vista para mostrar los datos del desarrollador de la APP
                startActivity(Intent(this, VeMostrarDatosAlumnoActivity::class.java))
            }
        }
    }
}