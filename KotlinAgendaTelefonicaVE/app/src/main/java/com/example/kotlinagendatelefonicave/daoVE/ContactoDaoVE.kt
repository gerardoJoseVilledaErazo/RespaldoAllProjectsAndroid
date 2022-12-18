package com.example.kotlinagendatelefonicave.daoVE

import androidx.room.*
import com.example.kotlinagendatelefonicave.ModelVE.Contacto
import com.example.kotlinagendatelefonicave.ModelVE.ContactoVE

// https://github.com/andob/ROOM-Dynamic-Dao

@Dao
interface ContactoDaoVE
{
    @Query("select * from contactos")
    fun getAll() : MutableList<Contacto>
//    fun getAll() : List<ContactoVE> ***************************
//    fun getAll() : MutableList<ContactoVE> ***************************

    @Query("select * from contactos where id = :id")
    fun get(id : Int) : Contacto
//    fun get(id : Int) : List<ContactoVE> ///
//    fun get(id : Int) : MutableList<ContactoVE> ///

    @Insert
    fun save(entity: Contacto)
//    fun save(entity: List<ContactoVE>)

    @Delete
    fun delete(entity: Contacto)

    @Update
    fun update(entity: Contacto)

}