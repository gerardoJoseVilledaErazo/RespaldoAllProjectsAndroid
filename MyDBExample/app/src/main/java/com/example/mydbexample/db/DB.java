package com.example.mydbexample.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mydbexample.db.helper.DBHelper;
import com.example.mydbexample.model.Category;
import com.example.mydbexample.model.Product;

import java.util.ArrayList;


public class DB {
    private DBHelper dbHelper;
    public DB(Context context) {
        //definimos el nombre de la BD
        dbHelper = new DBHelper(context, "BD_inventario", null, 1);
    }
    //consulta simple
    public Cursor getCursorCategoria(){
        return dbHelper.getReadableDatabase().rawQuery(
                "select * from categoria",null);
    }
    //consulta multitabla
    public Cursor getCursorProducto(){
        return dbHelper.getReadableDatabase().rawQuery(
                "select p.id_producto ,p.nombre ,p.descripcion ,p.id_categoria " +
                        "from producto p,categoria c where p.id_categoria=c.id_categoria",null);
    }
    //consulta multitabla con parametro
    public Cursor getCursorProducto(String id_categoria){
        return dbHelper.getReadableDatabase().rawQuery(
                "select p.id_producto ,p.nombre ,p.descripcion ,p.id_categoria " +
                        "from producto p,categoria c where p.id_categoria=c.id_categoria and " +
                        "p.id_categoria=?"
                ,new String[]{id_categoria});
    }
    public ArrayList<Category> getArrayCategoria(Cursor cursor){
        cursor.moveToFirst();//moverse al principio
        ArrayList<Category> lstCategoria = new ArrayList<>();
        if(cursor != null && cursor.getCount() > 0){//si hay datos
            do{
                lstCategoria.add(new Category(
                        cursor.getString(0),//id
                        cursor.getString(1)//nombre
                ));//se agregan a la lista
            }while (cursor.moveToNext());
            return lstCategoria;
        }
        return null;//si no entro en el if
    }
    public ArrayList<Product> getArrayProducto(Cursor cursor){
        cursor.moveToFirst();//moverse al principio
        ArrayList<Product> lstProducto = new ArrayList<>();
        if(cursor != null && cursor.getCount() > 0){//si hay datos
            do{
                lstProducto.add(new Product(
                        cursor.getString(0),//id
                        cursor.getString(1),//nombre
                        cursor.getString(2),//descripcion
                        cursor.getString(3)//id_categoria
                ));//se agregan a la lista
            }while (cursor.moveToNext());
            return lstProducto;
        }
        return null;//si no entro en el if
    }

    public boolean guardar_O_ActualizarCategoria(Category categoria) {
        ContentValues initialValues = new ContentValues();
        if(!categoria.getId_categoria().isEmpty())
            initialValues.put("id_categoria", Integer.parseInt(categoria.getId_categoria()));
        initialValues.put("nombre",categoria.getNombre());
        int id = (int) dbHelper.getWritableDatabase().insertWithOnConflict(
                "categoria",
                null,
                initialValues,
                SQLiteDatabase.CONFLICT_REPLACE);
        return id>0;
    }
    public boolean guardar_O_ActualizarProducto(Product producto) {
        ContentValues initialValues = new ContentValues();
        if(!producto.getId_producto().isEmpty())
            initialValues.put("id_producto", Integer.parseInt(producto.getId_producto()));
        initialValues.put("nombre",producto.getNombre());
        initialValues.put("descripcion",producto.getDescripcion());
        initialValues.put("id_categoria",producto.getId_categoria());
        int id = (int) dbHelper.getWritableDatabase().insertWithOnConflict(
                "producto",
                null,
                initialValues,
                SQLiteDatabase.CONFLICT_REPLACE);
        return id>0;
    }
    public void  borrarCategoria(String id){
        dbHelper.getWritableDatabase().execSQL(String.format("delete from categoria where id_categoria='%s'",id));
    }
    public void  borrarProducto(String id){
        dbHelper.getWritableDatabase().execSQL(String.format("delete from producto where id_producto='%s'",id));
    }


}
