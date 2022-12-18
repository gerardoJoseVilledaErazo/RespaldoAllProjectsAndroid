package com.example.mydb.db.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private String crearCategoria = "create table categoria"+
            "("+
            "id_categoria INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "nombre VARCHAR(250)"+
            ")";
    private String crearProducto="create table producto"+
            "("+
            "id_producto INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "nombre VARCHAR(250),"+
            "descripcion TEXT,"+
            "id_categoria INTEGER,"+
            "foreign key (id_categoria) references categoria (id_categoria)" +
            ")";
    //
    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //primero se crean las tablas maestro, es decir, aquellas que no tengan llave foránea
        db.execSQL(crearCategoria);
        db.execSQL(crearProducto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //primero borrar las Maestro-Detalle
        db.execSQL("DROP TABLE IF EXISTS producto");
        db.execSQL("DROP TABLE IF EXISTS categoria");
    }
}
