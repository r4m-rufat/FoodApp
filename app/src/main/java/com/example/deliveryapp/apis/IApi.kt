package com.example.deliveryapp.apis

import com.example.deliveryapp.models.foods.ComplexResponse
import com.example.deliveryapp.models.receipes.ReciepeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IApi {

    @GET("complexSearch?")
    fun getFoodInformations(
        @Query("query") query: String,
        @Query("offset") offset: String,
        @Query("apiKey") apiKey: String
    ): Call<ComplexResponse>

    @GET("{id}information?")
    fun getRecipeInformation(
        @Path("id") id: String,
        @Query("includeNutrition") boolean: Boolean,
        @Query("apiKey") apiKey: String
    ): Call<ReciepeResponse>

}