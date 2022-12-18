package com.example.introduccionkotlinlabpddm

class Persona(var nombre:String,var apellido:String) /// constructor

//data class Persona2(var nombre:String, var apellido: String) /// data class no se hereda
class Person(protected var nombre:String,protected var apellido:String) {
    //
}

fun main(){

    val trabajador: Trabajador = Trabajador("Juan","Perez",300f)

    val persona:Persona=Persona("juan","perez")

    /// funciones de alcance
    with(persona){
        nombre="pepito"
    }

    persona.nombre="pedro"
    println("el nombre es ${persona.nombre}")

}

/// funciones de alcance