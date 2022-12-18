package com.example.veregistroproveedoresapp.Model

import java.io.Serializable

data class ProveedorVe(
    var id: String,
//    var id: Int = 0,
    var nombre: String,
    var nit: String,
    var tipo_proveedor: String
) : Serializable

/*
*
@Entity(tableName = "proveedorVe")
data class ProveedorVe(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    var id: Int = 0,

    @ColumnInfo(name = "nombre")
    var nombre: String,

    @ColumnInfo(name = "nit")
    var nit: String,

    @ColumnInfo(name = "tipo_proveedor")
    var tipo_proveedor: String
) : Serializable*/