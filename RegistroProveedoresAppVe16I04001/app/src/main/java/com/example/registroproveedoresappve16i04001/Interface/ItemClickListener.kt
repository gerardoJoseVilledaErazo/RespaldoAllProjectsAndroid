package com.example.registroproveedoresappve16i04001.Interface

/**
 * Created by Gerardo Villeda on 10/29/2022.
 */
import com.example.registroproveedoresappve16i04001.Modelo.Proveedor

interface ItemClickListener {
    fun OnItemClick(position: Int, proveedor: Proveedor?)
}