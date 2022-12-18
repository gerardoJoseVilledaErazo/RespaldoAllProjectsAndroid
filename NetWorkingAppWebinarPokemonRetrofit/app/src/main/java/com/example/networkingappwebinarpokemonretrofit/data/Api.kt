package com.example.networkingappwebinarpokemonretrofit.data

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object Api {

    private val builder: Retrofit.Builder = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())

    interface RemoteService {
        //        @GET("pokemon?limit=151")
        @GET("pokemon")
        fun loadPokemon(@Query("limit") limit: Int): Call<PokemonResponse>
//        @GET("pokemon")
//        fun savePokemon(@Query("limit") limit: Int): Call<PokemonResponse>
    }

    fun build(): RemoteService {
        return builder.build().create(RemoteService::class.java)
    }
}