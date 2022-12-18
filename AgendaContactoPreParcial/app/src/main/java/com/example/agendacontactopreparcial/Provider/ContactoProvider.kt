package com.example.agendacontactopreparcial.Provider

import com.example.agendacontactopreparcial.Model.Contacto

class ContactoProvider {
    companion object {
        var contactoList = mutableListOf<Contacto>(
            Contacto(
                nombreContacto = "Jose",
                numeroTelefonico = "7777-7777"
            ),
            Contacto(
                nombreContacto = "JoseJose",
                numeroTelefonico = "7777-7777"
            ),
            Contacto(
                nombreContacto = "JoseJoseJose",
                numeroTelefonico = "7777-7777"
            )
        )
    }
}