package com.example.registroproveedoresapp.Interface

import com.example.registroproveedoresapp.Model.VEProveedorModel
/**
 * Created by Gerardo Villeda on 10/29/2022.
 */
interface ItemClickListener {
    fun OnItemClick(position: Int, veProveedorModel: VEProveedorModel?)
}