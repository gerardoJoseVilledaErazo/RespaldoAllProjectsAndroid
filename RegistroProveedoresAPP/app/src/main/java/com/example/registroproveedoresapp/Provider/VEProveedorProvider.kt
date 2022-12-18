package com.example.registroproveedoresapp.Provider

import com.example.registroproveedoresapp.Model.VEProveedorModel
/**
 * Created by Gerardo Villeda on 10/29/2022.
 */
class VEProveedorProvider {
    companion object {
        var proveedorList = mutableListOf<VEProveedorModel>(
            VEProveedorModel(
                1,
                "Jose",
                "7777777-7",
                "1"
            ),
            VEProveedorModel(
                2,
                "Pedro",
                "7777777-5",
                "1"
            ),
            VEProveedorModel(
                3,
                "Ana",
                "7777777-6",
                "2"
            )
        )
    }
}