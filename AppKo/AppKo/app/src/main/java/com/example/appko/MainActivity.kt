package com.example.appko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      //declaracion de variable
        var nombre:String
        var edad:Int

        //asignacion
        nombre="Juan Perez"
        edad=18

      //decalaracion y asignacion
       var isMayor:Boolean=true


      //-------------------------------------------------------------------
      //ESTRUCTURA CONDICIONAL
      //evaluar si es true
      if(isMayor){

        Toast.makeText(this,"es mayor",Toast.LENGTH_SHORT)

      }else{
        Toast.makeText(this,"es menor",Toast.LENGTH_SHORT);
      }

   //tarea estudiar la estructura When()
      //---------------------------------------------------------------------------------

      //ESTRUCTURA REPETITIVA INFINITA -WHILE
      var contador:Int=1
      var bandera:Boolean=false

      while (bandera==false){

        if (contador<10)
          Toast.makeText(this,"repeticon while",Toast.LENGTH_SHORT);
        else
          bandera=true

        contador=contador+1
      }

      //--------------------------------------------------------------------------------------
      //ESTRUCTURA REPETITIVA FINITA - FOR
      //inicio, fin, incremento

      for (i in 1..10){
        Toast.makeText(this,"repeticon for $i valor",Toast.LENGTH_SHORT);
      }
      //forEach
      for (item:Int in arrayOf(1,2,3)){
        Toast.makeText(this,"repeticon forEach $item valor",Toast.LENGTH_SHORT);
      }

   //-----------------------------------------------------------------------

        //creacion de objetos

        var persona1:Persona= Persona()
        persona1.nombre="Juan Perez"
        persona1.edad=20

        var persona2:Persona= Persona("Jose Lopez",20)

        Toast.makeText(this,"Objeto 1: ${persona1.nombre}",Toast.LENGTH_SHORT);
        Toast.makeText(this,"Objeto 2: ${persona2.nombre}",Toast.LENGTH_SHORT);


    }

  //funicones

  fun saludo(texto:String):String {
    return "valor texto: $texto"
  }



}