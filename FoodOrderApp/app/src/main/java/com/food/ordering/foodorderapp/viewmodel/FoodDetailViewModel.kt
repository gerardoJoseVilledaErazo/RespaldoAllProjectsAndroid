package com.food.ordering.foodorderapp.viewmodel

import androidx.lifecycle.ViewModel
import com.food.ordering.foodorderapp.repository.FoodBasketDaoRepository

class FoodDetailViewModel : ViewModel() {
    val foodBasketDaoRepository = FoodBasketDaoRepository()

    fun addFoodsToBasket(
        foodNameBasket: String,
        foodImageNameBasket: String,
        foodPriceBasket: Int,
        foodAmountBasket: Int,
        usernameBasket: String
    ) {
        foodBasketDaoRepository.addFoodsToBasket(
            foodNameBasket,
            foodImageNameBasket,
            foodPriceBasket,
            foodAmountBasket,
            usernameBasket
        )
    }
}