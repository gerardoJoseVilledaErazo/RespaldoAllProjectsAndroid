package com.example.examplemvvmbyaristidevs.domain

import com.example.examplemvvmbyaristidevs.data.QuoteRepository
import com.example.examplemvvmbyaristidevs.data.model.QuoteModel
import com.example.examplemvvmbyaristidevs.data.model.QuoteProvider
import com.example.examplemvvmbyaristidevs.domain.model.Quote
import javax.inject.Inject

//class GetRandomQuoteUseCase @Inject constructor(private val quoteProvider: QuoteProvider) {
class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository) {

//    private val repository = QuoteRepository()

    //    suspend operator fun invoke(): QuoteModel? {
    suspend operator fun invoke(): Quote? {
//        val quotes: List<QuoteModel> = quoteProvider.quotes
        val quotes = repository.getAllQuotesFromDatabase()
        if (!quotes.isNullOrEmpty()) {
//            val randomNumber = (0..quotes.size -1).random()
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}