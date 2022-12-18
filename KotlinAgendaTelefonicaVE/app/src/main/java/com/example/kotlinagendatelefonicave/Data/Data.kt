package com.example.kotlinagendatelefonicave.Data

import com.example.kotlinagendatelefonicave.ModelVE.Contacto
import com.example.kotlinagendatelefonicave.ModelVE.ContactoVE

class Data {

    //static
    companion object{
        var lista_contactos: MutableList<Contacto> = mutableListOf()
    }
}