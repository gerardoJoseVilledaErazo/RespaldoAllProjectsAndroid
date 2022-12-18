package com.example.examplemvvmbyaristidevs.domain

import com.example.examplemvvmbyaristidevs.data.QuoteRepository
import com.example.examplemvvmbyaristidevs.data.database.entities.toDatabase
import com.example.examplemvvmbyaristidevs.data.model.QuoteModel
import com.example.examplemvvmbyaristidevs.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {

//    private val repository = QuoteRepository()

    //    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()
    suspend operator fun invoke(): List<Quote> {
        val quotes = repository.getAllQuotesFromApi()

        return if (quotes.isNotEmpty()) {
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        } else {
            repository.getAllQuotesFromDatabase()
        }
    }
}