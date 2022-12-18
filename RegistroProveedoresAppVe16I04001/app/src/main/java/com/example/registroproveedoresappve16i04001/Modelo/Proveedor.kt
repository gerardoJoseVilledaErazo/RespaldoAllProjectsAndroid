package com.example.registroproveedoresappve16i04001.Modelo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "proveedor")
data class Proveedor (
    @PrimaryKey(autoGenerate = true)
    @NotNull
//    @ColumnInfo(name = "id")
    var id:Int = 0,

    @ColumnInfo(name = "nombre")
    var nombre:String,

    @ColumnInfo(name = "nit")
    var nit:String,

    @ColumnInfo(name = "tipo_proveedor")
    var tipo_proveedor:String,
) : Serializable