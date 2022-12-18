package com.example.examplemvvmbyaristidevs.data.network

import com.example.examplemvvmbyaristidevs.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}