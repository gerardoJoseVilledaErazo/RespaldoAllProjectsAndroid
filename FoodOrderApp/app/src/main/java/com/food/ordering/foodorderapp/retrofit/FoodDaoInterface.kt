package com.food.ordering.foodorderapp.retrofit

import com.food.ordering.foodorderapp.model.food.FoodResponse
import retrofit2.Call
import retrofit2.http.GET

interface FoodDaoInterface {
    @GET("yemekler/tumYemekleriGetir.php")
    fun allFoods(): Call<FoodResponse>
}