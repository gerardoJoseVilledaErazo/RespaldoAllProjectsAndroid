package com.example.veregistroproveedoresapp.Interface
/**
 * Created by Gerardo Villeda on 10/29/2022.
 */
import com.example.veregistroproveedoresapp.Model.ProveedorVe

interface ItemClickListener {
    fun OnItemClick(position: Int, proveedorVe: ProveedorVe?)
}