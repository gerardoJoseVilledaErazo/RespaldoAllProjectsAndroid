package com.example.alumnosqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ActivityLista : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        val rview=findViewById<RecyclerView>(R.id.lista_rv)
        val adapter=ListaAlumnoAdapter(this)
        rview.adapter=adapter

        rview.layoutManager= LinearLayoutManager(this) //Muestra los elementos en lista

        adapter.setStudentList(ListaEst())
    }
    fun ListaEst():List<Alumno>{
        var estudiante = ArrayList<Alumno>()
        val database = adminBD(this)
        val cursor = database.Consulta("select noControl, nomEst, Carrera, edadEst from Estudiante")
        if(cursor!!.moveToFirst())do{
            val stu = Alumno(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3))

            estudiante.add(stu)
        }
        while(cursor!!.moveToNext())
        cursor.close()
        return estudiante
    }
}