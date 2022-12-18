package com.example.agendacontactopreparcial.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable


@Entity(tableName = "contacto")
data class Contacto (
    @PrimaryKey(autoGenerate = true)
    @NotNull
//    @ColumnInfo(name = "contactoId")
    var id:Int = 0,

    @ColumnInfo(name = "nombreContacto")
    var nombreContacto:String,

    @ColumnInfo(name = "numeroTelefonico")
    var numeroTelefonico:String,
) : Serializable