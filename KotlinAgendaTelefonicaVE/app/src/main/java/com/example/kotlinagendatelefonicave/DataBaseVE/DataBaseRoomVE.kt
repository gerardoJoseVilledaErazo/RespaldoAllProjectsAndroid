package com.example.kotlinagendatelefonicave.DataBaseVE

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlinagendatelefonicave.ModelVE.ContactoVE
import com.example.kotlinagendatelefonicave.daoVE.ContactoDaoVE

@Database(entities = [ContactoVE::class],
    version = 1)
abstract class DataBaseRoomVE : RoomDatabase()
{
    abstract fun contactoDaoVE(): ContactoDaoVE
    companion object {
        private var instance: DataBaseRoomVE? = null

        fun getContactDatabase(context: Context): DataBaseRoomVE? {

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    DataBaseRoomVE::class.java,
                    "dbVE.db"
//        "dbVE"
                ).allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}