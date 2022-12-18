package com.example.examplemvvmbyaristidevs.domain.model

import com.example.examplemvvmbyaristidevs.data.database.entities.QuoteEntity
import com.example.examplemvvmbyaristidevs.data.model.QuoteModel

data class Quote(val quote: String, val author: String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)