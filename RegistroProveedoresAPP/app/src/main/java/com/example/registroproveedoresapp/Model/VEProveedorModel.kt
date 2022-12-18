package com.example.registroproveedoresapp.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable
/**
 * Created by Gerardo Villeda on 10/29/2022.
 */

data class VEProveedorModel (
    var id:Int = 0,
    var nombre:String,
    var nit:String,
    var tipo_proveedor:String

): Serializable