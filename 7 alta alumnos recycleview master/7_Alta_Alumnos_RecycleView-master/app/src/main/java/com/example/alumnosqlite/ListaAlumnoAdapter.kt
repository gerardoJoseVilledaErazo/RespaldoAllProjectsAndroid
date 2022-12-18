package com.example.alumnosqlite

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListaAlumnoAdapter internal  constructor(
    context:Context
): RecyclerView.Adapter<ListaAlumnoAdapter.StudentViewHolder>(){
    private val inflater:LayoutInflater= LayoutInflater.from(context)
    private var estudiante= emptyList<Alumno>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val itemView=inflater.inflate(R.layout.alumno_item,parent,false)
        return StudentViewHolder(itemView)
    }

    override fun getItemCount()=estudiante.size

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val current=estudiante[position]
        holder.edNombre.text=current.Nombre
        holder.edControl.text=current.noControl
        holder.edCarrera.text=current.Carrera
        holder.edEdad.text=current.Edad+" años"
    }

    inner class StudentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val edControl:TextView =itemView.findViewById(R.id.item_control)
        val edNombre:TextView=itemView.findViewById(R.id.item_nombres)
        val edCarrera:TextView=itemView.findViewById(R.id.item_carrera)
        val edEdad:TextView=itemView.findViewById(R.id.item_edad)
    }

    fun setStudentList(studentList: List<Alumno>){
        this.estudiante=studentList
        notifyDataSetChanged()
    }
}