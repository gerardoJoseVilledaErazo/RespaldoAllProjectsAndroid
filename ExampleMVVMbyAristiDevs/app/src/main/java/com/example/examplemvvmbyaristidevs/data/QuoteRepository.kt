package com.example.examplemvvmbyaristidevs.data

import com.example.examplemvvmbyaristidevs.data.database.dao.QuoteDao
import com.example.examplemvvmbyaristidevs.data.database.entities.QuoteEntity
import com.example.examplemvvmbyaristidevs.data.model.QuoteModel
import com.example.examplemvvmbyaristidevs.data.model.QuoteProvider
import com.example.examplemvvmbyaristidevs.data.network.QuoteService
import com.example.examplemvvmbyaristidevs.domain.model.Quote
import com.example.examplemvvmbyaristidevs.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
//    private val quoteProvider: QuoteProvider
) {

//    suspend fun getAllQuotes(): List<QuoteModel> {
//        val response: List<QuoteModel> = api.getQuotes()
//        quoteProvider.quotes = response
//        return response
//    }

    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote> {
        val response: List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>) {
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes() {
        quoteDao.deleteAllQuotes()
    }
}