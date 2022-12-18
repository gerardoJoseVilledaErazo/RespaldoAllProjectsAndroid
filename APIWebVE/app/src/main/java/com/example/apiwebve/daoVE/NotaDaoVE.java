package com.example.apiwebve.daoVE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.apiwebve.modelVE.NotaVE;

import java.util.List;

@Dao
public interface NotaDaoVE {

    @Query("select * from notas")
    public List<NotaVE> getAll();

    @Query("select * from notas where id = :id")
    public NotaVE get(int id);

    @Insert
    public void save(NotaVE entity);

    @Delete
    public void delete(NotaVE entity);

    @Update
    public void update(NotaVE entity);

}
