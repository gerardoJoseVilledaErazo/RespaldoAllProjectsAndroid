package com.example.recyclerviewcrud.Interface
/**
 * Created by Gerardo Villeda on 10/28/2022.
 */
import com.example.recyclerviewcrud.Model.UserData

interface ItemClickListener {
    fun OnItemClick(position: Int, userData: UserData?)
}