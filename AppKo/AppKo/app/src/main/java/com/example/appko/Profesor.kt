package com.example.appko

class Profesor:Persona {

    constructor(nombre: String, edad: Int, especialidad: String) : super(nombre, edad) {
        this.especialidad = especialidad

    }

    constructor(especialidad: String) : super() {
        this.especialidad = especialidad
    }

    var especialidad:String
        get() {
           return this.especialidad
        }
        set(value:String) {
            this.especialidad=value
        }
}