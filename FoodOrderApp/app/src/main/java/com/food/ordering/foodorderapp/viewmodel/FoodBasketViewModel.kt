package com.food.ordering.foodorderapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.food.ordering.foodorderapp.model.foodbasket.FoodBasket
import com.food.ordering.foodorderapp.repository.FoodBasketDaoRepository

class FoodBasketViewModel : ViewModel() {
    val foodBasketDaoRepository = FoodBasketDaoRepository()
    var foodBasketList = MutableLiveData<List<FoodBasket>>()

    init {
        loadFoodsFromBasket("e_inan")
        foodBasketList = foodBasketDaoRepository.getFoodsBasket()
    }

    fun loadFoodsFromBasket(usernameBasket: String) {
        foodBasketDaoRepository.getAllFoodsFromBasket(usernameBasket)
    }

    fun deleteFoodFromBasket(foodIdBasket: Int, usernameBasket: String) {
        foodBasketDaoRepository.deleteFoodFromBasket(foodIdBasket, usernameBasket)
    }
}