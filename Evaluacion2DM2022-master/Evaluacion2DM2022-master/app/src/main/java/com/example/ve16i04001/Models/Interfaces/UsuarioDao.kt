package com.example.ve16i04001.Models.Interfaces

import androidx.room.*
import com.example.ve16i04001.Models.UsuarioEntity
import org.jetbrains.annotations.NotNull

@Dao
interface UsuarioDao {

    @Query("SELECT * FROM UsuarioEntity WHERE nickname=:nickname")
    fun login(nickname: String): Boolean

    @Query("SELECT puntaje FROM UsuarioEntity WHERE nickname=:nickname")
    fun valorPuntaje(nickname: String): Int

    @Update
    fun UpdateUser(entityUser: UsuarioEntity)
    @Query("UPDATE UsuarioEntity SET puntaje=:puntaje,  intentos=:intentos WHERE nickname=:nickname")
    fun update(puntaje:String, intentos:String, nickname: String)

    @Query("SELECT * FROM UsuarioEntity where intentos <=5  ORDER by intentos limit 3" )
    fun getAllUsuariosByPuntaje(): List<UsuarioEntity>

    @Query("SELECT * FROM UsuarioEntity")
    fun getAll(): List<UsuarioEntity>

    @Insert
    fun addUsuario(usuarioEntity: UsuarioEntity)

    @Query("DELETE FROM UsuarioEntity")
    fun deleteAllUsuarios()

    @Delete
    fun delete(usuarioEntity: UsuarioEntity)





}