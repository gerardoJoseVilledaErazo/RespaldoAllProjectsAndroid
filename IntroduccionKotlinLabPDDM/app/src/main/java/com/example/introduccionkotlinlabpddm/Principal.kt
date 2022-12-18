package com.example.introduccionkotlinlabpddm

import kotlin.math.abs

fun main(){ // : unit | esto es un procedimiento como si fuese un void
    /*
    /// primer
//    print("Hola \n")
//    println("hola mundo")
//    println("bienvenido")
    var cadena:String = "ana"
    var cadenaTemporal: String = ""
    for (index in cadena.length -1 downTo 0){// bajar hasta cero
        cadenaTemporal += cadena[index]
    }
//    println(cadenaTemporal)
    if (cadenaTemporal == cadena) {
        println("palindromo")
    } else {
        println("no es palindromo")
    }

    for (index in 1.rangeTo(10)){
        println(index)
    }
    */

    /*
    /// segundo uso del when
    println("uso del when")
//    var diaSemana: Int =  /// mejor usar val
    val diaSemana: Int = 1
    when(diaSemana){
        1-> println("lunes")
        2-> println("martes")
        3-> println("miercoles")
        4-> println("jueves")
        5-> println("viernes")
        6-> println("sabado")
        7-> println("domingo")
        else-> println("no se encontro el dia")
    }*/

    /*
    /// uso del ciclo while
    println("uso del ciclo while")
//    var multiplicador: Int = 0
//    var multiplicando: Int = 0
    var multiplicador: Int = 9
    var multiplicando: Int = 13 /// 117 es el resultado
    var resultado: Int = 0
    while (multiplicador>0){
        if (multiplicador%2 !=0){ /// es par
            //
            resultado+=multiplicando
        }
        multiplicador/=2
        multiplicando*=2
    }
    println("el resultado es: $resultado") /// interpolacion de strings
    */

    //
    println("funcion infix - extensiones")
//    infix
//    var numero: Int = -10 /// marca amarillo porque hay que pasarlo a val
    val numero: Int = -10
    println("${numero.enableAbs(true)}") /// ${} cuando quiera acceder

    println("uso de funciones con argumentos")

    println("resultado de la suma: ${suma(5,10)}")
}
//infix
infix  fun Int.enableAbs(enable: Boolean) =// absoluto
    ///
    if (enable) abs(this) else this

fun suma(valor1:Int, valor2:Int):Int {
    return valor1+valor2
}


fun suma2(valor1:Int, valor2:Int):Int = valor1+valor2 /// definir el Int sino el programa lo entendera como unit






// lista mutable tablelist e inmutable
/*
* lista como un val referencia no cambia aunque el contenido si
* */