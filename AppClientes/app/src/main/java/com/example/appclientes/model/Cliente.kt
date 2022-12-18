package com.example.appclientes.model

import androidx.room.Entity
import java.io.Serializable

@Entity(tableName = "cliente")
data class Cliente (
    var id:Int = 0,
    var nombre:String,
    var direccion:String,
    var rutaImg:String
) : Serializable
/**
class Cliente {

    constructor()

    constructor(id: Int, nombre: String, direccion: String, rutaImg: String) {
        this.id = id
        this.nombre = nombre
        this.direccion = direccion
        this.rutaImg = rutaImg
    }


    var id:Int = 0
        set(value) { field=value}
        get()  {return field}

    var nombre:String = ""
        set(value) { field=value}
        get()  {return field}

    var direccion:String = ""
        set(value) { field=value}
        get()  {return field}

    var rutaImg:String = ""
        set(value) { field=value}
        get()  {return field}

}
        */