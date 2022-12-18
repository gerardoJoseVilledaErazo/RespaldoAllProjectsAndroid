package com.example.appclientes.data

import com.example.appclientes.model.Cliente

class Data {
    companion object{
        var lista=ArrayList<Cliente>()
        var clienteList = mutableListOf<Cliente>(
            Cliente(1,"Juan Perez","San Salvador","/01"),
            Cliente(2,"Maria Lopez","San Salvador","/01"),
            Cliente(3,"Jose Perez","San Salvador","/01")
        )
    }
}