package com.example.appko

open class Persona {
    //contructor
    /* public Persona(){}----JAVA*/
    constructor(nombre: String, edad: Int) {
        this.nombre = nombre
        this.edad = edad
    }

    constructor(){

    }
    //atributos

    //propiedad
    lateinit var nombre:String


    var edad:Int = 0


    // metdodos
    public fun correr(){
        println("Esta corriendo...")
    }

}