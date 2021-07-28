package com.example.deliveryapp.apis

import com.example.deliveryapp.models.foods.ComplexResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IApi {

    @GET("complexSearch?")
    fun getFoodInformations(
        @Query("query") query: String,
        @Query("offset") offset: String,
        @Query("apiKey") apiKey: String
    ): Call<ComplexResponse>

}