package com.example.examplemvvmbyaristidevs.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examplemvvmbyaristidevs.data.model.QuoteModel
import com.example.examplemvvmbyaristidevs.data.model.QuoteProvider
import com.example.examplemvvmbyaristidevs.domain.GetQuotesUseCase
import com.example.examplemvvmbyaristidevs.domain.GetRandomQuoteUseCase
import com.example.examplemvvmbyaristidevs.domain.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase: GetQuotesUseCase,
    private val getRandomQuoteUseCase: GetRandomQuoteUseCase
) : ViewModel() {

    //    val quoteModel = MutableLiveData<QuoteModel>()
    val quoteModel = MutableLiveData<Quote>()
    var isLoading = MutableLiveData<Boolean>()

//    var getQuotesUseCase = GetQuotesUseCase()
//    var getRandomQuoteUseCase = GetRandomQuoteUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
//            val result: List<QuoteModel>? = getQuotesUseCase()
            val result = getQuotesUseCase()

            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val quote = getRandomQuoteUseCase()
            if (quote != null) {
                quoteModel.postValue(quote)
            }
//        val currentQuote: QuoteModel = QuoteProvider.random()
//        quoteModel.postValue(currentQuote)
            isLoading.postValue(false)
        }
    }

//    fun randomQuote() {
//        isLoading.postValue(true)
//        val quote: QuoteModel? = getRandomQuoteUseCase()
//        if (quote != null) {
//            quoteModel.postValue(quote)
//        }
////        val currentQuote: QuoteModel = QuoteProvider.random()
////        quoteModel.postValue(currentQuote)
//        isLoading.postValue(false)
//    }
}