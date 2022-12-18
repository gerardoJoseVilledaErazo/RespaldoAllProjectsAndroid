package com.example.kotlinagendatelefonicave.ModelVE

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "contactos")
data class Contacto (
    @PrimaryKey(autoGenerate = true)
    @NotNull ///
    var id:Int=0,

    @ColumnInfo(name = "nombreContacto")
    var nombreContacto:String,

    @ColumnInfo(name = "numeroTelefonico")
    var numeroTelefonico:String,

    @ColumnInfo(name = "propietario")
    var propietario:String
 ) : Serializable