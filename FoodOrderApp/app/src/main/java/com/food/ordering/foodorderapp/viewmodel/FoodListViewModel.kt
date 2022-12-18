package com.food.ordering.foodorderapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.food.ordering.foodorderapp.model.food.Food
import com.food.ordering.foodorderapp.repository.FoodDaoRepository

class FoodListViewModel : ViewModel() {
    val foodDaoRepository = FoodDaoRepository()
    var foodList = MutableLiveData<List<Food>>()

    init {
        loadFoods()
        foodList = foodDaoRepository.getFoods()
    }

    fun loadFoods() {
        foodDaoRepository.getAllFoods()
    }
}