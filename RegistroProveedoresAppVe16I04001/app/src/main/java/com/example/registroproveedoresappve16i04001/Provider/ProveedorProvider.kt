package com.example.registroproveedoresappve16i04001.Provider

import com.example.registroproveedoresappve16i04001.Modelo.Proveedor

class ProveedorProvider {
    companion object {
        var proveedorList = mutableListOf<Proveedor>(
            Proveedor(
//                id = 1,
                nombre = "Jose",
                nit = "04978266-4",
                tipo_proveedor = "1"
            )
        /*
        *
        * ,
            Proveedor(
                id = 2,
                nombre = "Pedro",
                nit = "04978266-5",
                tipo_proveedor = "2"
            ),
            Proveedor(
                id = 3,
                nombre = "Juan",
                nit = "04978266-6",
                tipo_proveedor = "3"
            )*/
        )
    }
}