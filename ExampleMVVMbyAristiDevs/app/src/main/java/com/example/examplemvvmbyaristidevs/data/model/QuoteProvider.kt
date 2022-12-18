package com.example.examplemvvmbyaristidevs.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuoteProvider @Inject constructor() {

    var quotes: List<QuoteModel> = emptyList()

    /*companion object {

        fun random(): QuoteModel {
            val position = (0..10).random()
            return quote[position]
        }

        private val quote = listOf<QuoteModel>(
            QuoteModel("hola1", "Anonymous"),
            QuoteModel("hola2", "Anonymous"),
            QuoteModel("hola3", "Anonymous"),
            QuoteModel("hola4", "Anonymous"),
            QuoteModel("hola5", "Anonymous"),
            QuoteModel("hola6", "Anonymous"),
            QuoteModel("hola7", "Anonymous"),
            QuoteModel("hola8", "Anonymous"),
            QuoteModel("hola9", "Anonymous"),
            QuoteModel("hola10", "Anonymous")
        )
    }*/
}