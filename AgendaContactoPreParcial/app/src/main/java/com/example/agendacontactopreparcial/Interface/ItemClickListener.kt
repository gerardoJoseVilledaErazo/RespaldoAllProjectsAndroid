package com.example.agendacontactopreparcial.Interface
/**
 * Created by Gerardo Villeda on 10/29/2022.
 */
import com.example.agendacontactopreparcial.Model.Contacto

interface ItemClickListener {
    fun OnItemClick(position: Int, contacto: Contacto?)
}