package com.example.kotlinagendatelefonicave.daoVE

import android.content.Context
import androidx.room.Room
import com.example.kotlinagendatelefonicave.DataBaseVE.DataBaseRoomVE
import com.example.kotlinagendatelefonicave.ModelVE.Contacto
import com.example.kotlinagendatelefonicave.ModelVE.ContactoVE

class ContactoDaoImpRoomVe(context: Context) : ContactoDaoVE
{
    private var dataBaseRoomVE: DataBaseRoomVE = Room.databaseBuilder(
        context,
        DataBaseRoomVE::class.java,
        "dbVE.db"
//        "dbVE"
    ).allowMainThreadQueries()
        .build()

    var contactoDaoVE: ContactoDaoVE = dataBaseRoomVE.contactoDaoVE()

//    @SuppressLint("NotConstructor")
//    fun ContactoDaoImpRoomVe(context: Context?)
//    {
//        dataBaseRoomVE = Room.databaseBuilder(context!!, DataBaseRoomVE::class.java, "dbVE").allowMainThreadQueries().build()
//        contactoDaoVE = dataBaseRoomVE!!.contactoDaoVE()
//    }

    override fun getAll(): MutableList<Contacto> = contactoDaoVE.getAll()

//    override fun getAll(): MutableList<ContactoVE> {
//        return contactoDaoVE.getAll()
//    }

    override fun get(id: Int): Contacto = contactoDaoVE.get(id)

//    override fun get(id: Int): ContactoVE {
//        return contactoDaoVE.get(id)
//    }

    override fun save(entity: Contacto) {
        contactoDaoVE.save(entity)
    }

    override fun delete(entity: Contacto) {
        contactoDaoVE.delete(entity)
    }

    override fun update(entity: Contacto) {
        contactoDaoVE.update(entity)
    }

//    override fun getAll(): MutableList<ContactoVE> {
//        TODO("Not yet implemented")
//    }

//    override fun get(id: Int): ContactoVE {
//        TODO("Not yet implemented")
//    }

//    override fun save(entity: ContactoVE) {
//        TODO("Not yet implemented")
//    }
//
//    override fun delete(entity: ContactoVE) {
//        TODO("Not yet implemented")
//    }
//
//    override fun update(entity: ContactoVE) {
//        TODO("Not yet implemented")
//    }
}