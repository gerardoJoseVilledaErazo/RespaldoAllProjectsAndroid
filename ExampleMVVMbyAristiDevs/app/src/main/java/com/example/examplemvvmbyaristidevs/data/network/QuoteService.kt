package com.example.examplemvvmbyaristidevs.data.network

import com.example.examplemvvmbyaristidevs.core.RetrofitHelper
import com.example.examplemvvmbyaristidevs.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class QuoteService @Inject constructor(private val api: QuoteApiClient) {

//    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
//            val response = api.getAllQuotes()
            val response: Response<List<QuoteModel>> = api.getAllQuotes()
//              retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}