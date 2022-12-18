package com.example.kotlinagendatelefonicave.ModelVE

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "contactos")
class ContactoVE : Serializable
{
    @PrimaryKey(autoGenerate = true)
    @NotNull ///
    var id:Int=0
        //Getters & Setters correspondientes
//        get() {
//            return field
//        }
//        set(value) {
//            field=value
//        }

    @ColumnInfo
    var nombreContacto:String=""

    @ColumnInfo
    var numeroTelefonico:String=""

    @ColumnInfo
    var propietario:String="" /// el nombre almanecado con shared prefences del proietario (UserName)

    //constructor vacio
    constructor()

    //constructor
    @Ignore ///
    constructor(id: Int, nombre: String, numero: String, propietario: String) {
        this.id = id
        this.nombreContacto = nombre
        this.numeroTelefonico = numero
        this.propietario = propietario
    }

    fun getNombre():String{
        return nombreContacto
    }

    fun setNombre(pNombre:String){
        this.nombreContacto=pNombre
    }

    fun getNumero():String{
        return numeroTelefonico
    }

    fun setNumero(pNumero:String){
        this.numeroTelefonico=pNumero
    }

    fun getPropietari():String{
        return propietario
    }

    fun setPropietari(pPropietario:String){
        this.propietario=pPropietario
    }
}
//data class ContactoVE(
//    @PrimaryKey(autoGenerate = true)
//    @NotNull ///
//    var id:Int=0,
//
//    @ColumnInfo(name = "nombreContacto")
//    var nombreContacto:String,
//
//    @ColumnInfo(name = "numeroTelefonico")
//    var numeroTelefonico:String,
//
//    @ColumnInfo(name = "propietario")
//    var propietario:String
// ) : Serializable


//class ContactoVE/*(var id:Int, var nombreContacto:String, var numeroTelefonico:String, var propietario:String)*/{
//    var nombreContacto:String=""
//        //Getters & Setters correspondientes
//        get() {
//            return field
//        }
//        set(value) {
//            field=value
//        }
//    var numeroTelefonico:String=""
//        //Getters & Setters correspondientes
//        get() {
//            return field
//        }
//        set(value) {
//            field=value
//        }
//}
