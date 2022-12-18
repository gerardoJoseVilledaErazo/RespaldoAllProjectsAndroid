package com.example.alumnosqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var no: String=""
    var nomb: String=""
    var car: String=""
    var edad: String="0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun Buscar(v: View){
        if(etControl.text.isEmpty()){
            Toast.makeText(this, "Llene el No. Control",Toast.LENGTH_LONG).show()
            etControl.requestFocus()

        }
        else{
            no =etControl.text.toString()
            val  admin = adminBD(this)
            //                                  campo 0         1       2           3
            val tupla = admin.Consulta("select noControl, nomEst, Carrera, edadEst from Estudiante where noControl='$no'")

            if(tupla!!.moveToFirst()){
                etNombre.setText(tupla.getString(1))
                etCarrera.setText(tupla.getString(2))
                etEdad.setText(tupla.getString(3))
                btnAgregar.isEnabled = false
                btnModificar.isEnabled = true
                btnEliminar.isEnabled = true

            }
            else{
                Toast.makeText(this, "No existe No. Control", Toast.LENGTH_LONG).show()
                etControl.requestFocus()
            }
        }

    }
    fun Agregar(v: View){
        if(etControl.text.isEmpty() || etNombre.text.isEmpty() || etCarrera.text.isEmpty() || etEdad.text.isEmpty()){
            Toast.makeText(this, "Llene todos los campos",Toast.LENGTH_LONG).show()
            etControl.requestFocus()
        }
        else{
            leerCajas()
            val sentencia = "INSERT INTO Estudiante(noControl, nomEst, Carrera, edadEst) values ('$no','$nomb','$car',$edad)"
            val admin= adminBD(this)
            if(admin.Ejecuta(sentencia)==1){
                Toast.makeText(this, "Estudiante Agregado", Toast.LENGTH_LONG).show()
                limpiarCajas()

            }
            else{
                Toast.makeText(this, "Estudiante NO agregado", Toast.LENGTH_LONG).show()
                etControl.requestFocus()
            }
        }

    }
    fun Actualizar(v: View){
        if(etControl.text.isEmpty() || etNombre.text.isEmpty() || etCarrera.text.isEmpty() || etEdad.text.isEmpty()){
            Toast.makeText(this, "Llene todos los campos",Toast.LENGTH_LONG).show()
            etControl.requestFocus()
        }
        else{
            leerCajas()
            val sentencia = "UPDATE Estudiante SET nomEst='$nomb', Carrera='$car', edadEst=$edad WHERE noControl='$no'"
            val admin= adminBD(this)
            if(admin.Ejecuta(sentencia)==1){
                Toast.makeText(this, "Estudiante Actualizado", Toast.LENGTH_LONG).show()
                limpiarCajas()

            }
            else{
                Toast.makeText(this, "Estudiante NO Actualizado", Toast.LENGTH_LONG).show()
                etControl.requestFocus()
            }
        }
    }
    fun Eliminar(v: View){
        if(etControl.text.isEmpty()){
            Toast.makeText(this, "Llene el campo", Toast.LENGTH_SHORT).show();
        }
        else{
            val sentencia="DELETE FROM Estudiante where noControl='$no'"
            val admin= adminBD(this)

            if(admin.Ejecuta(sentencia)==1){
                Toast.makeText(this, "Estudiante Eliminado", Toast.LENGTH_LONG).show()
                limpiarCajas()

            }
            else{
                Toast.makeText(this, "Estudiante NO eliminado", Toast.LENGTH_LONG).show()
                etControl.requestFocus()
            }
        }

    }

    fun leerCajas(){
        no = etControl.text.toString()
        nomb = etNombre.text.toString()
        car = etCarrera.text.toString()
        edad = etEdad.text.toString()

    }

    fun limpiarCajas(){
        no = ""
        nomb = ""
        car = ""
        edad = "0"
        etControl.setText("")
        etNombre.setText("")
        etCarrera.setText("")
        etEdad.setText("0")
        btnAgregar.isEnabled = true
        btnModificar.isEnabled = false
        btnEliminar.isEnabled = false
        etControl.requestFocus()
    }
    fun VerLista(v: View){
        startActivity(Intent(this,ActivityLista::class.java))
    }
}
